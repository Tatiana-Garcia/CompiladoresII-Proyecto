import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class semanticVisitor extends MiniCBaseVisitor<varType> {

    private varType currentTypeDeclaration;
    symbolTable symbolTable = new symbolTable();

    public semanticVisitor() {
        funcSymbol printStr = new funcSymbol("print_str", varType.VOID);
        printStr.addParam(varType.STRING);
        symbolTable.insert(printStr);

        funcSymbol printInt = new funcSymbol("print_int", varType.VOID);
        printInt.addParam(varType.INT);
        symbolTable.insert(printInt);

        symbolTable.insert(new funcSymbol("print", varType.VOID));
        symbolTable.insert(new funcSymbol("println", varType.VOID));
    }

    public void error(String msg, int line, int col) {
        System.err.println("Error Semantico (" + line + ":" + col + "): " + msg);
    }

    @Override
    public varType visitProgram(MiniCParser.ProgramContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public varType visitDeclaration(MiniCParser.DeclarationContext ctx) {
        varType declarationType = searchType(ctx.typeSpecifier().getText());
        this.currentTypeDeclaration = declarationType;

        visit(ctx.declaratorList());
        return null;
    }

    @Override
    public varType visitDeclarator(MiniCParser.DeclaratorContext ctx) {
        String varName = ctx.Identifier().getText();

        boolean isArray = !ctx.IntegerConst().isEmpty();
        int totalSize = 1;
        List<Integer> dims = new ArrayList<>();

        if (isArray) {
            for (TerminalNode node : ctx.IntegerConst()) {
                int arrDim = Integer.parseInt(node.getText());
                if (arrDim <= 0) {
                    error("El tamaño del arreglo '" + varName + "' debe ser mayor a 0.",
                            ctx.start.getLine(), ctx.start.getCharPositionInLine());
                }
                totalSize *= arrDim;
                dims.add(arrDim);
            }
        }

        try {
            varSymbol v = new varSymbol(varName, currentTypeDeclaration, isArray, totalSize);
            if (isArray) {
                v.setDimentions(dims);
            }
            symbolTable.insert(v);

            if (isArray) {
                System.out.println("Arreglo declarado: " + varName + " (Tamaño total: " + totalSize + ")");
            } else {
                System.out.println("Variable declarada: " + varName);
            }
        } catch (RuntimeException e) {
            error(e.getMessage(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }

        if (ctx.expr() != null) {
            if (isArray) {
                error("No se permite inicializacion directa de arreglos en Mini-C (int a[5] = ...)",
                        ctx.start.getLine(), ctx.start.getCharPositionInLine());
            } else {
                varType exprType = visit(ctx.expr());
                // Lógica de promoción char -> int ....(currentTypeDeclaration == varType.INT && exprType == varType.CHAR);
                //boolean compatible = (exprType == currentTypeDeclaration) ||
                if (exprType != currentTypeDeclaration) {
                    error("Tipos incompatibles en inicialización de " + varName, ctx.start.getLine(), 0);
                }
            }
        }

        return null;
    }

    @Override
    public varType visitFuncDef(MiniCParser.FuncDefContext ctx) {
        String funcName = ctx.Identifier().getText();
        varType returnType = searchType(ctx.typeSpecifier().getText());

        funcSymbol funcSym = new funcSymbol(funcName, returnType);

        try {
            symbolTable.insert(funcSym);
        } catch (RuntimeException e) {
            error("Funcion ya definida: " + funcName, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }

        symbolTable.enterScope();

        if (ctx.params() != null) {
            for (MiniCParser.ParamContext param : ctx.params().param()) {

                varType pType = visit(param);
                funcSym.addParam(pType);
            }
        }

        visit(ctx.compoundStmt());

        symbolTable.exitScope();

        return null;
    }

    @Override
    public varType visitParam(MiniCParser.ParamContext ctx) {
        varType paramType = searchType(ctx.typeSpecifier().getText());
        String name = ctx.declarator().Identifier().getText();

        boolean isArray = !ctx.declarator().IntegerConst().isEmpty();
        List<Integer> dims = new ArrayList<>();

        if (isArray) {
            for (TerminalNode node : ctx.declarator().IntegerConst()) {
                int d = Integer.parseInt(node.getText());
                dims.add(d);
            }
        }

        try {
            varSymbol p = new varSymbol(name, paramType, isArray, 4);
            if (isArray) {
                p.setDimentions(dims);
            }
            symbolTable.insert(p);
        } catch (RuntimeException e) {
            error("Parámetro duplicado: " + name, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }

        return paramType;
    }

    @Override
    public varType visitCompoundStmt(MiniCParser.CompoundStmtContext ctx) {
        symbolTable.enterScope();
        visitChildren(ctx);
        symbolTable.exitScope();
        return null;
    }

    @Override
    public varType visitCall(MiniCParser.CallContext ctx) {
        String name = ctx.Identifier().getText();
        Symbol sym = symbolTable.lookup(name);

        if (sym == null) {
            error("Función no definida: " + name, ctx.start.getLine(), ctx.start.getCharPositionInLine());
            return varType.ERROR;
        }

        if (!(sym instanceof funcSymbol)) {
            error("El identificador '" + name + "' no es una funcion.", ctx.start.getLine(), ctx.start.getCharPositionInLine());
            return varType.ERROR;
        }

        funcSymbol func = (funcSymbol) sym;
        List<varType> expectedParams = func.getParams();
        List<MiniCParser.ExprContext> givenParams = ctx.expr();

        if (givenParams.size() != expectedParams.size()) {
            error("La función '" + name + "' espera " + expectedParams.size() +
                            " argumentos, pero recibió " + givenParams.size(),
                    ctx.start.getLine(), ctx.start.getCharPositionInLine());
            return varType.ERROR;
        }

        for (int i = 0; i < givenParams.size(); i++) {
            varType givenType = visit(givenParams.get(i));
            varType expectedType = expectedParams.get(i);

            boolean compatible = (givenType == expectedType);

            // Caso especial: char se puede promover a int (según PDF)
//            if (expectedType == varType.INT && givenType == varType.CHAR) {
//                compatible = true;
//            }

            if (!compatible) {
                error("Argumento " + (i+1) + " de '" + name + "' es incorrecto. Se esperaba " +
                                expectedType + " pero se encontró " + givenType,
                        givenParams.get(i).start.getLine(),
                        givenParams.get(i).start.getCharPositionInLine());
            }
        }

        return func.getType();
    }

    @Override
    public varType visitAssignStmt(MiniCParser.AssignStmtContext ctx) {
        varType leftType = visit(ctx.lvalue());
        varType rightType = visit(ctx.expr());

        if (leftType != varType.ERROR && rightType != varType.ERROR) {
            if (leftType != rightType) {
                error("No se puede asignar " + rightType + " a una variable de tipo " + leftType,
                        ctx.start.getLine(), ctx.start.getCharPositionInLine());
            }
        }
        return null;
    }

    @Override
    public varType visitPrimary(MiniCParser.PrimaryContext ctx) {
        if (ctx.IntegerConst() != null) {
            return varType.INT;
        }
        if (ctx.CharConst() != null) {
            return varType.CHAR;
        }
        if (ctx.StringLiteral() != null) {
            return varType.STRING;
        }
        if (ctx.getText().equals("true") || ctx.getText().equals("false")) {
            return varType.BOOL;
        }
        if (ctx.expr() != null) {
            return visit(ctx.expr());
        }
        if (ctx.lvalue() != null) {
            return visit(ctx.lvalue());
        }
        if (ctx.call() != null) {
            return visit(ctx.call());
        }

        return varType.ERROR;
    }

    @Override
    public varType visitUnaryExpr(MiniCParser.UnaryExprContext ctx) {
        if (ctx.primary() != null) {
            return visit(ctx.primary());
        }

        // Operador: ! (Not) o - (Menos unario)
        varType type = visit(ctx.unaryExpr());
        String op = ctx.getChild(0).getText();

        if (op.equals("!") && type != varType.BOOL) {
            error("Operador '!' espera BOOL", ctx.start.getLine(), 0);
            return varType.ERROR;
        }
        if ((op.equals("-") || op.equals("+")) && type != varType.INT) {
            error("Operador unario espera INT", ctx.start.getLine(), 0);
            return varType.ERROR;
        }
        return type;
    }
    @Override
    public varType visitLvalue(MiniCParser.LvalueContext ctx) {
        String name = ctx.Identifier().getText();
        Symbol sym = symbolTable.lookup(name);

        if (sym == null) {
            error("Variable no definida: " + name, ctx.start.getLine(), ctx.start.getCharPositionInLine());
            return varType.ERROR;
        }
        if (!(sym instanceof varSymbol)) {
            return sym.getType();
        }

        varSymbol varSym = (varSymbol) sym;


        boolean isArray = varSym.isArray();
        int dims = isArray ? varSym.getDimentions().size() : 0;


        int usedDims = ctx.expr().size();

        //Validaciones
        if (!isArray && usedDims > 0) {
            error("La variable '" + name + "' no es un arreglo, no puede usar corchetes [].",
                    ctx.start.getLine(), ctx.start.getCharPositionInLine());
            return varType.ERROR;
        }
        if (isArray && usedDims > dims) {
            error("La variable '" + name + "' tiene " + dims + " dimensiones, pero se intentó acceder con " + usedDims + ".",
                    ctx.start.getLine(), ctx.start.getCharPositionInLine());
            return varType.ERROR;
        }
        for (MiniCParser.ExprContext expr : ctx.expr()) {
            varType indexType = visit(expr);
            if (indexType != varType.INT) {
                error("El índice del arreglo debe ser INT. Encontrado: " + indexType,
                        expr.start.getLine(), expr.start.getCharPositionInLine());
                return varType.ERROR;
            }
        }
        if (usedDims < dims) {
            error("Uso incorrecto del arreglo '" + name + "'. Debe acceder a todos sus elementos (" + dims + " dimensiones).",
                    ctx.start.getLine(), ctx.start.getCharPositionInLine());
            return varType.ERROR;
        }
        return varSym.getType();
    }

    @Override
    public varType visitAdditiveExpr(MiniCParser.AdditiveExprContext ctx) {

        if (ctx.multiplicativeExpr().size() == 1) {
            return visit(ctx.multiplicativeExpr(0));
        }

        varType currentType = visit(ctx.multiplicativeExpr(0));


        for (int i = 1; i < ctx.multiplicativeExpr().size(); i++) {
            varType nextType = visit(ctx.multiplicativeExpr(i));


            if (currentType != varType.INT || nextType != varType.INT) {
                error("Operaciones aritméticas (+, -) requieren INT. Encontrado: " + currentType + " op " + nextType,
                        ctx.start.getLine(), ctx.start.getCharPositionInLine());
                return varType.ERROR;
            }

            currentType = varType.INT;
        }

        return currentType;
    }

    @Override
    public varType visitMultiplicativeExpr(MiniCParser.MultiplicativeExprContext ctx) {

        if (ctx.unaryExpr().size() == 1) {
            return visit(ctx.unaryExpr(0));
        }


        varType currentType = visit(ctx.unaryExpr(0));

        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            varType nextType = visit(ctx.unaryExpr(i));

            if (currentType != varType.INT || nextType != varType.INT) {
                error("Multiplicación/División requiere INT.",
                        ctx.start.getLine(), ctx.start.getCharPositionInLine());
                return varType.ERROR;
            }
            currentType = varType.INT;
        }
        return currentType;
    }

    private varType searchType(String s) {
        switch (s) {
            case "int": return varType.INT;
            case "char": return varType.CHAR;
            case "bool": return varType.BOOL;
            case "void": return varType.VOID;
            case "string": return varType.STRING;
            case "null":return varType.NULL;
            default: return varType.ERROR;
        }
    }
}

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class semanticVisitor extends MiniCBaseVisitor<varType> {

    private int errorCount = 0;

    private varType currentTypeDeclaration;
    private varType currentFuncReturnType;

    // Contadores para contexto
    private int loopDepth = 0;
    private int globalOffset = 0;
    private int localOffset = 0;

    symbolTable symbolTable = new symbolTable();

    public semanticVisitor() {
        funcSymbol printStr = new funcSymbol("print_str", varType.VOID);
        printStr.addParam(varType.STRING);
        symbolTable.insert(printStr);

        funcSymbol printInt = new funcSymbol("print_int", varType.VOID);
        printInt.addParam(varType.INT);
        symbolTable.insert(printInt);

        funcSymbol printBool = new funcSymbol("print_bool", varType.VOID);
        printBool.addParam(varType.BOOL);
        symbolTable.insert(printBool);

        symbolTable.insert(new funcSymbol("print_char", varType.VOID));
        symbolTable.insert(new funcSymbol("print", varType.VOID));
        symbolTable.insert(new funcSymbol("println", varType.VOID));
    }
    public symbolTable getSymbolTable() {
        return this.symbolTable;
    }

    private boolean checkCompatibility(varType expected, varType actual) {
        if (expected == actual) return true;
        if (expected == varType.INT && actual == varType.CHAR) return true; // Promoción
        return false;
    }

    private int getTypeSize(varType type) {
        return 4;//MIPS, 4bytes in stack
    }

    private boolean checkIsLValue(MiniCParser.UnaryExprContext ctx) {
        if (ctx.primary() != null) {
            if (ctx.primary().lvalue() != null) return true; // Es variable o array
            if (ctx.primary().getText().startsWith("(")) return true;
            return false; // Literales no son LValue
        }
        // Unario->'*' (desreferencia) genera un LValue
        String op = ctx.getChild(0).getText();
        return op.equals("*");
    }


    public void error(String msg, int line, int col) {
        System.err.println("Error Semantico (" + line + ":" + col + "): " + msg);
        errorCount++;
    }
    public boolean hasErrors() {
        return errorCount > 0;
    }

    @Override
    public varType visitProgram(MiniCParser.ProgramContext ctx) {
        globalOffset = 0;
        visitChildren(ctx);
        Symbol mainSym = symbolTable.lookup("main");
        if (mainSym == null) {
            error("Error Semántico: Falta función 'main'.", 0, 0);
        }
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
        MiniCParser.DeclaratorContext id = ctx;
        boolean isPointer = false;

        while (id.declarator() != null) {
            isPointer = true; // busca *
            id = id.declarator();
        }
        String varName = id.Identifier().getText();

        boolean isArray = !id.IntegerConst().isEmpty();
        int totalElements = 1;
        List<Integer> dims = new ArrayList<>();

        if (isArray) {
            for (TerminalNode node : id.IntegerConst()) {
                int d = Integer.parseInt(node.getText());
                if (d <= 0) error("La dimension del arreglo debe ser > 0", ctx.start.getLine(), 0);
                totalElements *= d;
                dims.add(d);
            }
        }

        //Pointer Logic
        int unitSize = isPointer ? 4 : getTypeSize(currentTypeDeclaration);
        int totalBytes = totalElements * unitSize;

        boolean isGlobal = symbolTable.isGlobalScope();
        int currentOffset;

        if (isGlobal) {
            currentOffset = globalOffset;
            globalOffset += totalBytes;
        } else {
            localOffset += totalBytes;
            // Alinear a 4 bytes
            while(localOffset % 4 != 0) localOffset++;
            currentOffset = localOffset;
        }

        try {
            varSymbol v = new varSymbol(varName, currentTypeDeclaration, isArray,
                    totalBytes, currentOffset, isGlobal);
            if (isArray) {
                v.setDimentions(dims);
            }
            symbolTable.insert(v);
        } catch (RuntimeException e) {
            error(e.getMessage(), ctx.start.getLine(), 0);
        }

        if (id.expr() != null) {
            if (isArray) {
                error("Inicializacion de arreglos no soportada",
                        ctx.start.getLine(), 0);
            } else {
                varType exprType = visit(id.expr());
                if (!checkCompatibility(currentTypeDeclaration, exprType)) {
                    error("Tipo incompatible al inicializar " + varName, ctx.start.getLine(), 0);
                }
            }
        }

        return null;
    }

    @Override
    public varType visitFuncDef(MiniCParser.FuncDefContext ctx) {
        String funcName = ctx.Identifier().getText();
        varType returnType = searchType(ctx.typeSpecifier().getText());

        currentFuncReturnType = returnType;
        localOffset = 0;

        funcSymbol funcSym = new funcSymbol(funcName, returnType);

        try {
            symbolTable.insert(funcSym);
        } catch (RuntimeException e) {
            error("Funcion ya definida: " + funcName, ctx.start.getLine(), 0);
        }

        symbolTable.enterScope(ctx);

        if (ctx.params() != null) {
            for (MiniCParser.ParamContext param : ctx.params().param()) {
                varType pType = visit(param);
                funcSym.addParam(pType);
            }
        }

        visit(ctx.compoundStmt());
        funcSym.setStackSize(localOffset);
        symbolTable.exitScope();
        return null;
    }

    @Override
    public varType visitParam(MiniCParser.ParamContext ctx) {
        varType paramType = searchType(ctx.typeSpecifier().getText());
        MiniCParser.DeclaratorContext id = ctx.declarator();
        int size = 4;
        int currentOffset = localOffset;
        localOffset += size;

        while (id.declarator() != null) {
            id = id.declarator();
        }

        String name = id.Identifier().getText();

        boolean isArray = !id.IntegerConst().isEmpty();
        List<Integer> dims = new ArrayList<>();

        if (isArray) {
            for (TerminalNode node : id.IntegerConst()) {
                int d = Integer.parseInt(node.getText());
                dims.add(d);
            }
        }

        try {
            varSymbol p = new varSymbol(name, paramType, isArray, size, currentOffset, false);
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
        symbolTable.enterScope(ctx);
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

            if (!checkCompatibility(expectedType, givenType)) {
                error("Argumento " + (i+1) + " de '" + name + "' es incorrecto. Se esperaba " +
                                expectedType + " pero se encontro " + givenType,
                        givenParams.get(i).start.getLine(),0);
            }
        }

        return func.getType();
    }

    @Override
    public varType visitWhileStmt(MiniCParser.WhileStmtContext ctx) {
        varType cond = visit(ctx.expr());
        if (cond != varType.BOOL && cond != varType.INT) error("Condición inválida", ctx.start.getLine(), 0);
        loopDepth++;
        visit(ctx.statement());
        loopDepth--;
        return null;
    }
    @Override public varType visitForStmt(MiniCParser.ForStmtContext ctx) {
        loopDepth++;
        visitChildren(ctx);
        loopDepth--;
        return null;
    }

    @Override
    public varType visitAssignStmt(MiniCParser.AssignStmtContext ctx) {
        if (!checkIsLValue(ctx.unaryExpr())) {
            error("Lado izquierdo no es asignable (no es variable ni puntero)", ctx.start.getLine(), 0);
        }

        varType leftType = visit(ctx.unaryExpr());
        varType rightType = visit(ctx.expr());

        if (leftType != varType.ERROR && rightType != varType.ERROR) {
            if (!checkCompatibility(leftType, rightType)) {
                error("No se puede asignar " + rightType + " a " + leftType, ctx.start.getLine(), 0);
            }
        }
        return null;
    }

    @Override
    public varType visitBreakStmt(MiniCParser.BreakStmtContext ctx) {
        if (loopDepth <= 0) error("Break fuera de ciclo", ctx.start.getLine(), 0);
        return null;
    }

    @Override
    public varType visitContinueStmt(MiniCParser.ContinueStmtContext ctx) {
        if (loopDepth <= 0) error("Continue fuera de ciclo", ctx.start.getLine(), 0);
        return null;
    }

    @Override
    public varType visitRelationalExpr(MiniCParser.RelationalExprContext ctx) {
        if (ctx.additiveExpr().size() == 1) return visit(ctx.additiveExpr(0));

        // Validar: int < int (o char < int)
        for (MiniCParser.AdditiveExprContext expr : ctx.additiveExpr()) {
            varType t = visit(expr);
            if (t != varType.INT && t != varType.CHAR) {
                error("Operadores relacionales (<, >, etc) requieren INT/CHAR.", ctx.start.getLine(), 0);
                return varType.ERROR;
            }
        }
        return varType.BOOL;
    }

    @Override
    public varType visitEqualityExpr(MiniCParser.EqualityExprContext ctx) {
        if (ctx.relationalExpr().size() == 1) return visit(ctx.relationalExpr(0));

        varType t1 = visit(ctx.relationalExpr(0));
        for (int i = 1; i < ctx.relationalExpr().size(); i++) {
            varType t2 = visit(ctx.relationalExpr(i));
            if (!checkCompatibility(t1, t2) && !checkCompatibility(t2, t1)) {
                error("Tipos incompatibles en igualdad (==, !=).", ctx.start.getLine(), 0);
            }
        }
        return varType.BOOL;
    }

    @Override
    public varType visitLogicalAndExpr(MiniCParser.LogicalAndExprContext ctx) {
        if (ctx.equalityExpr().size() == 1) return visit(ctx.equalityExpr(0));

        for (MiniCParser.EqualityExprContext expr : ctx.equalityExpr()) {
            varType t = visit(expr);
            if (t != varType.BOOL && t != varType.INT) { // C permite int como lógico
                error("Operador && requiere BOOL o INT.", ctx.start.getLine(), 0);
            }
        }
        return varType.BOOL;
    }

    @Override
    public varType visitLogicalOrExpr(MiniCParser.LogicalOrExprContext ctx) {
        if (ctx.logicalAndExpr().size() == 1) return visit(ctx.logicalAndExpr(0));

        for (MiniCParser.LogicalAndExprContext expr : ctx.logicalAndExpr()) {
            varType t = visit(expr);
            if (t != varType.BOOL && t != varType.INT) {
                error("Operador || requiere BOOL o INT.", ctx.start.getLine(), 0);
            }
        }
        return varType.BOOL;
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

        varType type = visit(ctx.unaryExpr());
        String op = ctx.getChild(0).getText();

        if (op.equals("*")) {
            return type;
        } else if (op.equals("&")) {
            if (!checkIsLValue(ctx.unaryExpr())) error("& requiere variable", ctx.start.getLine(), 0);
            return type;
        } else if (op.equals("-")) {
            if (type != varType.INT) error("- requiere int", ctx.start.getLine(), 0);
            return varType.INT;
        } else if (op.equals("!")) {
            if (type != varType.BOOL && type != varType.INT) error("! requiere bool/int", ctx.start.getLine(), 0);
            return varType.BOOL;
        }
        return varType.ERROR;
    }
    @Override
    public varType visitLvalue(MiniCParser.LvalueContext ctx) {
        String name = ctx.Identifier().getText();
        Symbol sym = symbolTable.lookup(name);

        if (sym == null) {
            error("Variable no definida: " + name, ctx.start.getLine(), 0);
            return varType.ERROR;
        }
        if (!(sym instanceof varSymbol)) {
            error("El identificador '" + name + "' no es una variable.", ctx.start.getLine(), 0);
            return varType.ERROR;
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
        if (varSym.isArray() && ctx.expr().size() != varSym.getDimentions().size()) {
            error("Dimensiones incorrectas para " + name, ctx.start.getLine(), 0);
        }

        return sym.getType();
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
        return switch (s) {
            case "int" -> varType.INT;
            case "char" -> varType.CHAR;
            case "bool" -> varType.BOOL;
            case "void" -> varType.VOID;
            case "string" -> varType.STRING;
            case "pointer" -> varType.POINTER;
            case "null" -> varType.NULL;
            default -> varType.ERROR;
        };
    }
}

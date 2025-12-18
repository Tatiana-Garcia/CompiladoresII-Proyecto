import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IR extends MiniCBaseVisitor<String>{
    public List<Quadruple> code = new ArrayList<>();
    private symbolTable symbolTable;

    private int tempCount = 0;
    private int labelCount = 0;
    private int currentParamIndex = 0;

    private Stack<String> breakStack = new Stack<>();
    private Stack<String> continueStack = new Stack<>();

    public void setSymbolTable(symbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
    private String newTemp() {
        return "t" + (tempCount++);
    }

    private String newLabel() {
        return "L" + (labelCount++);
    }

    private String calculateArrayOffset(MiniCParser.LvalueContext ctx, String name) {
        Symbol sym = symbolTable.lookup(name);
        varSymbol arrSym = (varSymbol) sym;

        // 1D: index * 4
        if (arrSym.getDimentions().size() == 1) {
            String idx = visit(ctx.expr(0));
            String t = newTemp();
            code.add(new Quadruple(TACOp.MULT, idx, "4", t));
            return t;
        }
        // 2D: (row * cols + col) * 4
        else {
            String row = visit(ctx.expr(0));
            String col = visit(ctx.expr(1));
            int numCols = arrSym.getDimentions().get(1);

            String t1 = newTemp();
            code.add(new Quadruple(TACOp.MULT, row, String.valueOf(numCols), t1));

            String t2 = newTemp();
            code.add(new Quadruple(TACOp.ADD, t1, col, t2));

            String t3 = newTemp();
            code.add(new Quadruple(TACOp.MULT, t2, "4", t3));
            return t3;
        }
    }

    private void processAssignment(MiniCParser.UnaryExprContext target, String val) {
        // puntero
        if (target.getChildCount() == 2 && target.getChild(0).getText().equals("*")) {
            String ptrAddr = visit(target.unaryExpr());
            code.add(new Quadruple(TACOp.PTR_STORE, val, null, ptrAddr));
        }
        // variable o arreglo
        else if (target.primary() != null && target.primary().lvalue() != null) {
            MiniCParser.LvalueContext lval = target.primary().lvalue();
            String name = lval.Identifier().getText();

            if (!lval.expr().isEmpty()) {
                // arreglo
                String offset = calculateArrayOffset(lval, name);
                code.add(new Quadruple(TACOp.ARR_STORE, val, offset, name));
            } else {
                code.add(new Quadruple(TACOp.ASSIGN, val, null, name));
            }
        }
    }

    @Override
    public String visitDeclarator(MiniCParser.DeclaratorContext ctx) {
        MiniCParser.DeclaratorContext id = ctx;
        while(id.declarator() != null) id = id.declarator();

        if (id.expr() != null) {
            String name = id.Identifier().getText();
            String val = visit(id.expr());

            code.add(new Quadruple(TACOp.ASSIGN, val, null, name));
        }
        return null;
    }

    @Override
    public String visitFuncDef(MiniCParser.FuncDefContext ctx) {
        String funcName = ctx.Identifier().getText();
        code.add(new Quadruple(TACOp.FUNC_BEGIN, null, null, funcName));
        code.add(new Quadruple(TACOp.LABEL, null, null, funcName));

        currentParamIndex = 0;
        symbolTable.pushScope(ctx);
        if (ctx.params() != null) {
            for(MiniCParser.ParamContext p : ctx.params().param()) {
                visit(p);
            }
        }
        visit(ctx.compoundStmt());
        symbolTable.exitScope();

        code.add(new Quadruple(TACOp.RETURN, null, null, null));
        code.add(new Quadruple(TACOp.FUNC_END, null, null, funcName));

        return null;
    }

    @Override
    public String visitParam(MiniCParser.ParamContext ctx) {
        MiniCParser.DeclaratorContext id = ctx.declarator();
        while (id.declarator() != null) id = id.declarator();
        String name = id.Identifier().getText();

        code.add(new Quadruple(TACOp.ARG_STORE, String.valueOf(currentParamIndex), null, name));

        currentParamIndex++;
        return null;
    }

    @Override
    public String visitReturnStmt(MiniCParser.ReturnStmtContext ctx) {
        String retVal = null;
        if (ctx.expr() != null) {
            retVal = visit(ctx.expr());
        }
        code.add(new Quadruple(TACOp.RETURN, retVal, null, null));
        return null;
    }

    @Override
    public String visitIfStmt(MiniCParser.IfStmtContext ctx) {
        String L_false = newLabel();
        String L_next = newLabel();

        String cond = visit(ctx.expr());

        // Salto condicional
        code.add(new Quadruple(TACOp.IF_FALSE, cond, null, L_false));

        // True (S1.code)
        visit(ctx.statement(0));

        // Salto
        code.add(new Quadruple(TACOp.GOTO, null, null, L_next));

        // False
        code.add(new Quadruple(TACOp.LABEL, null, null, L_false));

        // False (S2.code)
        if (ctx.statement().size() > 1) {
            visit(ctx.statement(1));
        }

        //Final
        code.add(new Quadruple(TACOp.LABEL, null, null, L_next));

        return null;
    }

    @Override
    public String visitWhileStmt(MiniCParser.WhileStmtContext ctx) {
        String L_begin = newLabel();
        String L_end = newLabel();

        continueStack.push(L_begin);
        breakStack.push(L_end);

        // Inicio
        code.add(new Quadruple(TACOp.LABEL, null, null, L_begin));

        //Condicion
        String cond = visit(ctx.expr());

        //Salir
        code.add(new Quadruple(TACOp.IF_FALSE, cond, null, L_end));


        visit(ctx.statement());

        //Inicio
        code.add(new Quadruple(TACOp.GOTO, null, null, L_begin));

        //Fin
        code.add(new Quadruple(TACOp.LABEL, null, null, L_end));

        continueStack.pop();
        breakStack.pop();
        return null;
    }

    @Override
    public String visitForStmt(MiniCParser.ForStmtContext ctx) {
        String L_cond = newLabel();
        String L_step = newLabel();
        String L_end = newLabel();

        // Init
        if (ctx.forInit() != null) visit(ctx.forInit());

        // Cond
        code.add(new Quadruple(TACOp.LABEL, null, null, L_cond));

        if (ctx.forCondition() != null) {
            String cond = visit(ctx.forCondition());
            code.add(new Quadruple(TACOp.IF_FALSE, cond, null, L_end));
        }

        continueStack.push(L_step);
        breakStack.push(L_end);

        // Instrucciones
        visit(ctx.statement());

        code.add(new Quadruple(TACOp.LABEL, null, null, L_step));

        // Step
        if (ctx.forAcum() != null) visit(ctx.forAcum());


        code.add(new Quadruple(TACOp.GOTO, null, null, L_cond));


        code.add(new Quadruple(TACOp.LABEL, null, null, L_end));

        continueStack.pop();
        breakStack.pop();
        return null;
    }

    @Override public String visitForInit(MiniCParser.ForInitContext ctx) {
        return visit(ctx.getChild(0));
    }
    @Override public String visitForCondition(MiniCParser.ForConditionContext ctx) {
        return visit(ctx.getChild(0));
    }
    @Override public String visitForAcum(MiniCParser.ForAcumContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override public String visitBreakStmt(MiniCParser.BreakStmtContext ctx) {
        if(!breakStack.isEmpty()) code.add(new Quadruple(TACOp.GOTO, null, null, breakStack.peek()));
        return null;
    }

    @Override public String visitContinueStmt(MiniCParser.ContinueStmtContext ctx) {
        if(!continueStack.isEmpty()) code.add(new Quadruple(TACOp.GOTO, null, null, continueStack.peek()));
        return null;
    }

    @Override
    public String visitAssignStmt(MiniCParser.AssignStmtContext ctx) {
        String val = visit(ctx.expr());
        processAssignment(ctx.unaryExpr(), val);
        return null;
    }

    @Override
    public String visitAssignExpr(MiniCParser.AssignExprContext ctx) {
        if (ctx.unaryExpr() != null) {
            String val = visit(ctx.assignExpr());
            processAssignment(ctx.unaryExpr(), val);
            return val;
        }
        return visit(ctx.logicalOrExpr());
    }

    @Override
    public String visitAdditiveExpr(MiniCParser.AdditiveExprContext ctx) {
        String left = visit(ctx.multiplicativeExpr(0));

        for (int i = 1; i < ctx.multiplicativeExpr().size(); i++) {
            String right = visit(ctx.multiplicativeExpr(i));
            String temp = newTemp();

            String opStr = ctx.getChild(2 * i - 1).getText();
            TACOp op = opStr.equals("+") ? TACOp.ADD : TACOp.SUB;

            // t1 = a + b
            code.add(new Quadruple(op, left, right, temp));
            left = temp;
        }
        return left;
    }

    @Override
    public String visitMultiplicativeExpr(MiniCParser.MultiplicativeExprContext ctx) {

        String left = visit(ctx.unaryExpr(0));

        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            String right = visit(ctx.unaryExpr(i));
            String temp = newTemp();

            // Obtener el operador (*, /, %)
            String opStr = ctx.getChild(2 * i - 1).getText();

            TACOp op;
            if (opStr.equals("*")) op = TACOp.MULT;
            else if (opStr.equals("/")) op = TACOp.DIV;
            else op = TACOp.MOD; // Importante para el %


            code.add(new Quadruple(op, left, right, temp));

            left = temp;
        }
        return left;
    }

    @Override
    public String visitRelationalExpr(MiniCParser.RelationalExprContext ctx) {

        String left = visit(ctx.additiveExpr(0));

        if (ctx.additiveExpr().size() > 1) {
            String right = visit(ctx.additiveExpr(1));
            String temp = newTemp();
            String op = ctx.getChild(1).getText();

            TACOp tacOp = switch(op) {
                case "<" -> TACOp.LT;
                case ">" -> TACOp.GT;
                case "<=" -> TACOp.LTE;
                case ">=" -> TACOp.GTE;
                //case "!=" -> TACOp.NEQ;
                default -> TACOp.EQ;
            };

            code.add(new Quadruple(tacOp, left, right, temp));
            return temp;
        }
        return left;
    }

    @Override
    public String visitEqualityExpr(MiniCParser.EqualityExprContext ctx) {
        String left = visit(ctx.relationalExpr(0));

        if (ctx.relationalExpr().size() > 1) {
            String right = visit(ctx.relationalExpr(1));
            String op = ctx.getChild(1).getText();
            String temp = newTemp();

            TACOp tacOp = op.equals("==") ? TACOp.EQ : TACOp.NEQ;


            code.add(new Quadruple(tacOp, left, right, temp));
            return temp;
        }
        return left;
    }

    @Override public String visitLogicalAndExpr(MiniCParser.LogicalAndExprContext ctx) {
        String left = visit(ctx.equalityExpr(0));
        for(int i=1; i<ctx.equalityExpr().size(); i++) {
            String right = visit(ctx.equalityExpr(i));
            String temp = newTemp();
            code.add(new Quadruple(TACOp.AND, left, right, temp));
            left = temp;
        }
        return left;
    }

    @Override public String visitLogicalOrExpr(MiniCParser.LogicalOrExprContext ctx) {
        String left = visit(ctx.logicalAndExpr(0));
        for(int i=1; i<ctx.logicalAndExpr().size(); i++) {
            String right = visit(ctx.logicalAndExpr(i));
            String temp = newTemp();
            code.add(new Quadruple(TACOp.OR, left, right, temp));
            left = temp;
        }
        return left;
    }

    @Override
    public String visitUnaryExpr(MiniCParser.UnaryExprContext ctx) {
        if (ctx.primary() != null) return visit(ctx.primary());

        String op = ctx.getChild(0).getText();
        String operand = visit(ctx.unaryExpr());
        String temp = newTemp();

        if (op.equals("-")) code.add(new Quadruple(TACOp.UMINUS, operand, null, temp));
        else if (op.equals("!")) code.add(new Quadruple(TACOp.NOT, operand, null, temp));
        else if (op.equals("&")) code.add(new Quadruple(TACOp.ADDR, operand, null, temp));
        else if (op.equals("*")) code.add(new Quadruple(TACOp.PTR_LOAD, operand, null, temp));

        return temp;
    }

    @Override
    public String visitPrimary(MiniCParser.PrimaryContext ctx) {
        if (ctx.IntegerConst() != null) return ctx.IntegerConst().getText();

        if (ctx.CharConst() != null) {
            String c = ctx.CharConst().getText();
            char val = (c.length() >= 3 && c.charAt(1) == '\\') ? c.charAt(2) : c.charAt(1);
            return String.valueOf((int)val);
        }

        if (ctx.lvalue() != null)  {
            String name = ctx.lvalue().Identifier().getText();
            if (!ctx.lvalue().expr().isEmpty()) {
                String offset = calculateArrayOffset(ctx.lvalue(), name);
                String temp = newTemp();
                code.add(new Quadruple(TACOp.ARR_LOAD, name, offset, temp));
                return temp;
            }
            return name;
        }
        if (ctx.call() != null) return visit(ctx.call());

        if (ctx.expr() != null) return visit(ctx.expr());

        if (ctx.StringLiteral() != null) return ctx.StringLiteral().getText();
        return "0";
    }
    @Override
    public String visitCall(MiniCParser.CallContext ctx) {
        String funcName = ctx.Identifier().getText();
        List<String> args = new ArrayList<>();
        // 1. Generar Params
        if (ctx.expr() != null) {
            for (MiniCParser.ExprContext arg : ctx.expr()) {
                args.add(visit(arg));
            }
        }
        for(String arg : args) {
            code.add(new Quadruple(TACOp.PARAM, arg, null, null));
        }

        String resultTemp = newTemp();

        code.add(new Quadruple(TACOp.CALL, funcName, String.valueOf(args.size()), resultTemp));

        return resultTemp;
    }

}

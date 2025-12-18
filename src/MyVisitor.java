import org.antlr.v4.runtime.tree.TerminalNode;

public class MyVisitor extends MiniCBaseVisitor<Object> {
    int tab = 0;
    String s = "";

    public void TabStructure(String s){
        System.out.println("\t".repeat(tab)+s);
    }

    @Override public Object visitProgram(MiniCParser.ProgramContext ctx) {
        System.out.println("PROGRAMA");
        tab++;
        visitChildren(ctx);
        tab--;
        return null;
    }

    @Override public Object visitDeclaration(MiniCParser.DeclarationContext ctx) {
        s = "Declaration ("+ctx.typeSpecifier().getText()+")";
        TabStructure(s);
        tab++;
        visitChildren(ctx.declaratorList());
        tab--;
        return null;
    }

    @Override public Object visitDeclaratorList(MiniCParser.DeclaratorListContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitDeclarator(MiniCParser.DeclaratorContext ctx) {
        String prefix = "";
        MiniCParser.DeclaratorContext current = ctx;
        while (current.declarator() != null) {
            prefix += "*";
            current = current.declarator();
        }
        String arrDim = "";
        if (!current.IntegerConst().isEmpty()) {
            for (TerminalNode node : current.IntegerConst()) {
                arrDim += "[" + node.getText() + "]";//[10][5]
            }
        }
        s = "Variable: "+prefix+current.Identifier().getText()+arrDim;//m[10][5]
        TabStructure(s);

        if (ctx.expr() != null) {
            tab++;
            TabStructure("Value:");
            tab++;
            visit(ctx.expr());
            tab-=2;
        }
        return null;
    }

    @Override public Object visitTypeSpecifier(MiniCParser.TypeSpecifierContext ctx) {
        s = "Type:"+ctx.getText();
        TabStructure(s);
        return null;
    }

    @Override public Object visitFuncDef(MiniCParser.FuncDefContext ctx) {
        s = "Function "+ctx.Identifier().getText()+"("+ctx.typeSpecifier().getText()+")";
        TabStructure(s);
        tab++;
        if (ctx.params() != null){
            TabStructure("Params:");
            tab++;
            visit(ctx.params());
            tab--;
        }
        TabStructure("Body:");
        tab++;
        visit(ctx.compoundStmt());
        tab--;
        tab--;
        return null;
    }

    @Override public Object visitParams(MiniCParser.ParamsContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitParam(MiniCParser.ParamContext ctx) {
        String name = ctx.declarator().Identifier().getText();
        String extra = ctx.declarator().getChildCount() > 1 ? ctx.declarator().getText().substring(name.length()) : "";
        s = "Arg: "+name+extra+ " ("+ctx.typeSpecifier().getText()+")";
        TabStructure(s);

        return null;
    }

    @Override public Object visitCompoundStmt(MiniCParser.CompoundStmtContext ctx) {
        return visitChildren(ctx);
    }
    @Override public Object visitStatement(MiniCParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitIfStmt(MiniCParser.IfStmtContext ctx) {
        TabStructure("If:");
        tab++;
        TabStructure("Condition:");
        tab++;
        visit(ctx.expr());
        tab--;
        TabStructure("Then:");
        tab++;
        visit(ctx.statement(0));
        tab--;
        if (ctx.statement().size() > 1) {
            TabStructure("Else:");
            tab++;
            visit(ctx.statement(1));
            tab--;
        }
        tab--;
        return null;
    }

    @Override public Object visitWhileStmt(MiniCParser.WhileStmtContext ctx) {
        TabStructure("While:");
        tab++;
        TabStructure("Condition:");
        tab++;
        visit(ctx.expr());
        tab--;
        TabStructure("Do:");
        tab++;
        visit(ctx.statement());
        tab-=2;
        return null;
    }

    @Override public Object visitForStmt(MiniCParser.ForStmtContext ctx) {
        TabStructure("For:");
        tab++;
        if (ctx.forInit() != null) {
            TabStructure("Init:");
            tab++; visit(ctx.forInit()); tab--;
        }
        if (ctx.forCondition() != null) {
            TabStructure("Condition:");
            tab++; visit(ctx.forCondition()); tab--;
        }
        if (ctx.forAcum() != null) {
            TabStructure("Step:");
            tab++; visit(ctx.forAcum()); tab--;
        }
        TabStructure("Do: ");
        tab++; visit(ctx.statement());
        tab-=2;
        return null;
    }

    @Override public Object visitBreakStmt(MiniCParser.BreakStmtContext ctx) {
        TabStructure("break");
        return null;
    }

    @Override public Object visitContinueStmt(MiniCParser.ContinueStmtContext ctx) {
        TabStructure("continue");
        return null;
    }

    @Override public Object visitAssignStmt(MiniCParser.AssignStmtContext ctx) {

        TabStructure("Assign (=)");
        tab++;
        TabStructure("Target:");
        tab++;
        visit(ctx.unaryExpr());
        tab--;
        TabStructure("Value:");
        tab++;
        visit(ctx.expr());
        tab-=2;
        return null;
    }

    @Override public Object visitReturnStmt(MiniCParser.ReturnStmtContext ctx) {
        s = "Return" ;
        TabStructure(s);
        if (ctx.expr() != null) {
            tab++;
            visit(ctx.expr());
            tab--;
        }
        return null;
    }
    @Override public Object visitExprStmt(MiniCParser.ExprStmtContext ctx) {
        if (ctx.expr() != null) {
            visit(ctx.expr());
        }
        return null;
    }
    @Override public Object visitForInit(MiniCParser.ForInitContext ctx) {
        return visitChildren(ctx);
    }
    @Override public Object visitForCondition(MiniCParser.ForConditionContext ctx) {
        return visitChildren(ctx); }
    @Override public Object visitForAcum(MiniCParser.ForAcumContext ctx) {
        return visitChildren(ctx); }
    @Override public Object visitExpr(MiniCParser.ExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitAssignExpr(MiniCParser.AssignExprContext ctx) {
        if (ctx.unaryExpr() != null) {
            TabStructure("Assign (=): ");
            tab++;
            visit(ctx.unaryExpr());//antes lvalue
            visit(ctx.assignExpr());
            tab--;
            return null;
        }
        return visitChildren(ctx);
    }

    @Override public Object visitLogicalOrExpr(MiniCParser.LogicalOrExprContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount >1) {
            for (int i=1; i<childCount; i+=2) {
                String op = ctx.getChild(i).getText();
                TabStructure("Op: "+op);
                tab++;

                if (i == 1) visit(ctx.getChild(0));
                visit(ctx.getChild(i+1));
                tab--;
            }
        } else {
            visitChildren(ctx);
        }
        return null;
    }

    @Override public Object visitLogicalAndExpr(MiniCParser.LogicalAndExprContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount >1) {
            for (int i=1; i<childCount; i+=2) {
                String op = ctx.getChild(i).getText();
                TabStructure("Op: "+op);
                tab++;

                if (i == 1) visit(ctx.getChild(0));
                visit(ctx.getChild(i+1));
                tab--;
            }
        } else {
            visitChildren(ctx);
        }
        return null;
//        if (ctx.equalityExpr().size() > 1)
//            TabStructure("Logical AND (&&)");
//        return visitChildren(ctx);
    }

    @Override public Object visitEqualityExpr(MiniCParser.EqualityExprContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount >1) {
            for (int i=1; i<childCount; i+=2) {
                String op = ctx.getChild(i).getText();
                TabStructure("Op: "+op);
                tab++;

                if (i == 1) visit(ctx.getChild(0));
                visit(ctx.getChild(i+1));
                tab--;
            }
        } else {
            visitChildren(ctx);
        }
        return null;

//        if (ctx.relationalExpr().size() > 1)
//            TabStructure("EqualityExpr (" + ctx.getText() + ")");
//        return visitChildren(ctx);
    }

    @Override public Object visitRelationalExpr(MiniCParser.RelationalExprContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount >1) {
            for (int i=1; i<childCount; i+=2) {
                String op = ctx.getChild(i).getText();
                TabStructure("Op: "+op);
                tab++;

                if (i == 1) visit(ctx.getChild(0));
                visit(ctx.getChild(i+1));
                tab--;
            }
        } else {
            visitChildren(ctx);
        }
        return null;


//        if (ctx.additiveExpr().size() > 1)
//            TabStructure("RelationalExpr (" + ctx.getText() + ")");
//        return visitChildren(ctx);
    }

    @Override public Object visitAdditiveExpr(MiniCParser.AdditiveExprContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount >1) {
            for (int i=1; i<childCount; i+=2) {
                String op = ctx.getChild(i).getText();
                TabStructure("Op: "+op);
                tab++;

                if (i == 1) visit(ctx.getChild(0));
                visit(ctx.getChild(i+1));
                tab--;
            }
        } else {
            visitChildren(ctx);
        }
        return null;


//        if (ctx.multiplicativeExpr().size() > 1)
//            TabStructure("AdditiveExpr (" + ctx.getText() + ")");
//        return visitChildren(ctx);
    }

    @Override public Object visitMultiplicativeExpr(MiniCParser.MultiplicativeExprContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount >1) {
            for (int i=1; i<childCount; i+=2) {
                String op = ctx.getChild(i).getText();
                TabStructure("Op: "+op);
                tab++;

                if (i == 1) visit(ctx.getChild(0));
                visit(ctx.getChild(i+1));
                tab--;
            }
        } else {
            visitChildren(ctx);
        }
        return null;

//        if (ctx.unaryExpr().size() > 1)
//            TabStructure("MultiplicativeExpr (" + ctx.getText() + ")");
//        return visitChildren(ctx);
    }

    @Override public Object visitUnaryExpr(MiniCParser.UnaryExprContext ctx) {
        if (ctx.getChildCount() >= 2) {
            String op = ctx.getChild(0).getText();
            TabStructure("Unary Op: " + op);
            tab++;
            visit(ctx.unaryExpr());
            tab--;
            return null;
        }
        return visitChildren(ctx);
    }

    @Override public Object visitPrimary(MiniCParser.PrimaryContext ctx) {
        if (ctx.IntegerConst() != null)
            TabStructure("Int: " + ctx.IntegerConst().getText());
        else if (ctx.CharConst() != null)
            TabStructure("Char: " + ctx.CharConst().getText());
        else if (ctx.StringLiteral() != null)
            TabStructure("String: " + ctx.StringLiteral().getText());
        else if (ctx.getText().equals("true") || ctx.getText().equals("false"))
            TabStructure("Bool: " + ctx.getText());
        else if (ctx.call() != null)
            visit(ctx.call());
        else if (ctx.lvalue() != null)
            visit(ctx.lvalue());
        else if (ctx.expr() != null)
            visit(ctx.expr());
        return null;
    }

    @Override public Object visitCall(MiniCParser.CallContext ctx) {
        s = "Call: " + ctx.Identifier().getText() + " ";
        TabStructure(s);
        if (ctx.expr() != null && !ctx.expr().isEmpty()) {
            tab++;
            for (MiniCParser.ExprContext arg : ctx.expr()) {
                visit(arg);
            }
            tab--;
        }
        return null;
    }

    @Override public Object visitLvalue(MiniCParser.LvalueContext ctx) {

        if (!ctx.expr().isEmpty()) {
            s = ctx.Identifier().getText();
            TabStructure("Array: "+s);
            tab++;
            for (MiniCParser.ExprContext e : ctx.expr()) {
                TabStructure("Index:");
                tab++; visit(e); tab--;
            }
            tab--;
        }else {
            s = ctx.Identifier().getText();
            TabStructure("ID: "+s);
        }
        return null;
    }

    @Override public Object visitDoWhileStmt(MiniCParser.DoWhileStmtContext ctx) {
        s = "Do-While:";
        TabStructure(s);
        tab++;
        visit(ctx.statement());
        s = "Condition:";
        TabStructure(s);
        tab++;
        visit(ctx.expr());
        tab--;
        tab--;
        return null;
    }

}

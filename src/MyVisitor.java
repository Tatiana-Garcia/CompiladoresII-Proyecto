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
        s = "Declarators ("+ctx.typeSpecifier().getText()+")";
        TabStructure(s);
        tab++;
        visitChildren(ctx);
        tab--;
        return null;
    }

    @Override public Object visitDeclaratorList(MiniCParser.DeclaratorListContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitDeclarator(MiniCParser.DeclaratorContext ctx) {
        s = "("+ctx.Identifier()+")";
        TabStructure(s);
        tab++;
        visitChildren(ctx);
        tab--;
        return null;
    }

    @Override public Object visitTypeSpecifier(MiniCParser.TypeSpecifierContext ctx) {
        s = "Type:"+ctx.getText();
        TabStructure(s);
        tab++;
        visitChildren(ctx);
        tab--;
        return null;
    }

    @Override public Object visitFuncDef(MiniCParser.FuncDefContext ctx) {
        s = "Function ("+ctx.Identifier().getText()+")";
        TabStructure(s);
        tab++;
        visitChildren(ctx);
        tab--;
        return null;
        //return visit(ctx.compoundStmt());
    }

    @Override public Object visitParams(MiniCParser.ParamsContext ctx) {
        s = "Params";
        TabStructure(s);
        tab++;
        visitChildren(ctx);
        tab--;
        return null;
    }

    @Override public Object visitParam(MiniCParser.ParamContext ctx) {
        s = "Param ("+ctx.declarator().Identifier().getText()+")";
        TabStructure(s);
        tab++;
        visitChildren(ctx);
        tab--;
        return null;
    }

    @Override public Object visitCompoundStmt(MiniCParser.CompoundStmtContext ctx) {
        s = "Body: ";
        TabStructure(s);
        tab++;
        visitChildren(ctx);
        tab--;
        return null;
    }

    @Override public Object visitStatement(MiniCParser.StatementContext ctx) {
        s = "Instrucciones: ";
        TabStructure(s);
        tab++;
        visitChildren(ctx);
        tab--;
        return null;
    }

    @Override public Object visitIfStmt(MiniCParser.IfStmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitWhileStmt(MiniCParser.WhileStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitForStmt(MiniCParser.ForStmtContext ctx) {
        s = "For Statement: ";
        TabStructure(s);
        tab++;
        visitChildren(ctx);
        tab--;
        return null;
    }

    @Override public Object visitDoWhileStmt(MiniCParser.DoWhileStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitAssignStmt(MiniCParser.AssignStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitReturnStmt(MiniCParser.ReturnStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitExprStmt(MiniCParser.ExprStmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitForInit(MiniCParser.ForInitContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitForCondition(MiniCParser.ForConditionContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitForAcum(MiniCParser.ForAcumContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitExpr(MiniCParser.ExprContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitAssignExpr(MiniCParser.AssignExprContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitLogicalOrExpr(MiniCParser.LogicalOrExprContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitLogicalAndExpr(MiniCParser.LogicalAndExprContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitEqualityExpr(MiniCParser.EqualityExprContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitRelationalExpr(MiniCParser.RelationalExprContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitAdditiveExpr(MiniCParser.AdditiveExprContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitMultiplicativeExpr(MiniCParser.MultiplicativeExprContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitUnaryExpr(MiniCParser.UnaryExprContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitPrimary(MiniCParser.PrimaryContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitCall(MiniCParser.CallContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitLvalue(MiniCParser.LvalueContext ctx) {
        return visitChildren(ctx); }


}

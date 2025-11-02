public class MyVisitor extends MiniCBaseVisitor<Object> {
    @Override public Object visitProgram(MiniCParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitDeclaration(MiniCParser.DeclarationContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitDeclaratorList(MiniCParser.DeclaratorListContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitDeclarator(MiniCParser.DeclaratorContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitTypeSpecifier(MiniCParser.TypeSpecifierContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitFuncDef(MiniCParser.FuncDefContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitParams(MiniCParser.ParamsContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitParam(MiniCParser.ParamContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitCompoundStmt(MiniCParser.CompoundStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitStatement(MiniCParser.StatementContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitIfStmt(MiniCParser.IfStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitWhileStmt(MiniCParser.WhileStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitForStmt(MiniCParser.ForStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitDoWhileStmt(MiniCParser.DoWhileStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitAssignStmt(MiniCParser.AssignStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitReturnStmt(MiniCParser.ReturnStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitExprStmt(MiniCParser.ExprStmtContext ctx) {
        return visitChildren(ctx); }

    @Override public Object visitExpr(MiniCParser.ExprContext ctx) {
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

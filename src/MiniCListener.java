// Generated from C:/Users/tatig/Documents/Unitec 2025/Q3/Operativos I/CompiladoresII-Proyecto/MiniC.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniCParser}.
 */
public interface MiniCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MiniCParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MiniCParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#declaratorList}.
	 * @param ctx the parse tree
	 */
	void enterDeclaratorList(MiniCParser.DeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#declaratorList}.
	 * @param ctx the parse tree
	 */
	void exitDeclaratorList(MiniCParser.DeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(MiniCParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(MiniCParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(MiniCParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(MiniCParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MiniCParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MiniCParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(MiniCParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(MiniCParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(MiniCParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(MiniCParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#compoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStmt(MiniCParser.CompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#compoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStmt(MiniCParser.CompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MiniCParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MiniCParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MiniCParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MiniCParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(MiniCParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(MiniCParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStmt(MiniCParser.DoWhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStmt(MiniCParser.DoWhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(MiniCParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(MiniCParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(MiniCParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(MiniCParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(MiniCParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(MiniCParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MiniCParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MiniCParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpr(MiniCParser.LogicalOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpr(MiniCParser.LogicalOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpr(MiniCParser.LogicalAndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpr(MiniCParser.LogicalAndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(MiniCParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(MiniCParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(MiniCParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(MiniCParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(MiniCParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(MiniCParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(MiniCParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(MiniCParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(MiniCParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(MiniCParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MiniCParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MiniCParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(MiniCParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(MiniCParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(MiniCParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(MiniCParser.LvalueContext ctx);
}
// Generated from C:/Users/tatig/Documents/Unitec 2025/Q3/Operativos I/CompiladoresII-Proyecto/MiniC.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniCParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MiniCParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MiniCParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#declaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaratorList(MiniCParser.DeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(MiniCParser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(MiniCParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MiniCParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(MiniCParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(MiniCParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#compoundStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStmt(MiniCParser.CompoundStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniCParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MiniCParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MiniCParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(MiniCParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#doWhileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStmt(MiniCParser.DoWhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(MiniCParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MiniCParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(MiniCParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(MiniCParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition(MiniCParser.ForConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#forAcum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAcum(MiniCParser.ForAcumContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MiniCParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#assignExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(MiniCParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpr(MiniCParser.LogicalOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpr(MiniCParser.LogicalAndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(MiniCParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(MiniCParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(MiniCParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(MiniCParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(MiniCParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MiniCParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(MiniCParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniCParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(MiniCParser.LvalueContext ctx);
}
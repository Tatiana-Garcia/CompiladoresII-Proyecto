// Generated from C:/Users/tatig/Documents/Unitec 2025/Q3/Operativos I/CompiladoresII-Proyecto/MiniC.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, Identifier=38, 
		IntegerConst=39, CharConst=40, StringLiteral=41, WS=42, LINE_COMMENT=43, 
		BLOCK_COMMENT=44;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_declaratorList = 2, RULE_declarator = 3, 
		RULE_typeSpecifier = 4, RULE_funcDef = 5, RULE_params = 6, RULE_param = 7, 
		RULE_compoundStmt = 8, RULE_statement = 9, RULE_ifStmt = 10, RULE_whileStmt = 11, 
		RULE_forStmt = 12, RULE_doWhileStmt = 13, RULE_assignStmt = 14, RULE_returnStmt = 15, 
		RULE_exprStmt = 16, RULE_forInit = 17, RULE_forCondition = 18, RULE_forAcum = 19, 
		RULE_expr = 20, RULE_assignExpr = 21, RULE_logicalOrExpr = 22, RULE_logicalAndExpr = 23, 
		RULE_equalityExpr = 24, RULE_relationalExpr = 25, RULE_additiveExpr = 26, 
		RULE_multiplicativeExpr = 27, RULE_unaryExpr = 28, RULE_primary = 29, 
		RULE_call = 30, RULE_lvalue = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "declaratorList", "declarator", "typeSpecifier", 
			"funcDef", "params", "param", "compoundStmt", "statement", "ifStmt", 
			"whileStmt", "forStmt", "doWhileStmt", "assignStmt", "returnStmt", "exprStmt", 
			"forInit", "forCondition", "forAcum", "expr", "assignExpr", "logicalOrExpr", 
			"logicalAndExpr", "equalityExpr", "relationalExpr", "additiveExpr", "multiplicativeExpr", 
			"unaryExpr", "primary", "call", "lvalue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "','", "'['", "']'", "'='", "'*'", "'int'", "'char'", "'bool'", 
			"'void'", "'string'", "'('", "')'", "'{'", "'}'", "'if'", "'else'", "'while'", 
			"'for'", "'do'", "'return'", "'||'", "'&&'", "'=='", "'!='", "'<'", "'>'", 
			"'<='", "'>='", "'+'", "'-'", "'/'", "'%'", "'!'", "'&'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "Identifier", "IntegerConst", "CharConst", "StringLiteral", 
			"WS", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniCParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3968L) != 0)) {
				{
				setState(66);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(64);
					declaration();
					}
					break;
				case 2:
					{
					setState(65);
					funcDef();
					}
					break;
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public DeclaratorListContext declaratorList() {
			return getRuleContext(DeclaratorListContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			typeSpecifier();
			setState(74);
			declaratorList();
			setState(75);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorListContext extends ParserRuleContext {
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public DeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitDeclaratorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitDeclaratorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorListContext declaratorList() throws RecognitionException {
		DeclaratorListContext _localctx = new DeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			declarator();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(78);
				match(T__1);
				setState(79);
				declarator();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniCParser.Identifier, 0); }
		public List<TerminalNode> IntegerConst() { return getTokens(MiniCParser.IntegerConst); }
		public TerminalNode IntegerConst(int i) {
			return getToken(MiniCParser.IntegerConst, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declarator);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(Identifier);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(86);
					match(T__2);
					setState(87);
					match(IntegerConst);
					setState(88);
					match(T__3);
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(94);
					match(T__4);
					setState(95);
					expr();
					}
				}

				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(T__5);
				setState(99);
				declarator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecifierContext extends ParserRuleContext {
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3968L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniCParser.Identifier, 0); }
		public CompoundStmtContext compoundStmt() {
			return getRuleContext(CompoundStmtContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			typeSpecifier();
			setState(105);
			match(Identifier);
			setState(106);
			match(T__11);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3968L) != 0)) {
				{
				setState(107);
				params();
				}
			}

			setState(110);
			match(T__12);
			setState(111);
			compoundStmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			param();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(114);
				match(T__1);
				setState(115);
				param();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			typeSpecifier();
			setState(122);
			declarator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStmtContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CompoundStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterCompoundStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitCompoundStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitCompoundStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStmtContext compoundStmt() throws RecognitionException {
		CompoundStmtContext _localctx = new CompoundStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compoundStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__13);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4383018147778L) != 0)) {
				{
				setState(127);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
					{
					setState(125);
					declaration();
					}
					break;
				case T__0:
				case T__5:
				case T__11:
				case T__13:
				case T__15:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__30:
				case T__33:
				case T__34:
				case T__35:
				case T__36:
				case Identifier:
				case IntegerConst:
				case CharConst:
				case StringLiteral:
					{
					setState(126);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public CompoundStmtContext compoundStmt() {
			return getRuleContext(CompoundStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public DoWhileStmtContext doWhileStmt() {
			return getRuleContext(DoWhileStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				compoundStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				ifStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(137);
				forStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(138);
				doWhileStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(139);
				assignStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(140);
				returnStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(141);
				exprStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__15);
			setState(145);
			match(T__11);
			setState(146);
			expr();
			setState(147);
			match(T__12);
			setState(148);
			statement();
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(149);
				match(T__16);
				setState(150);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__17);
			setState(154);
			match(T__11);
			setState(155);
			expr();
			setState(156);
			match(T__12);
			setState(157);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public ForAcumContext forAcum() {
			return getRuleContext(ForAcumContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__18);
			setState(160);
			match(T__11);
			setState(161);
			forInit();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4383014129728L) != 0)) {
				{
				setState(162);
				forCondition();
				}
			}

			setState(165);
			match(T__0);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4383014129728L) != 0)) {
				{
				setState(166);
				forAcum();
				}
			}

			setState(169);
			match(T__12);
			setState(170);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStmtContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DoWhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterDoWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitDoWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitDoWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStmtContext doWhileStmt() throws RecognitionException {
		DoWhileStmtContext _localctx = new DoWhileStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_doWhileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__19);
			setState(173);
			statement();
			setState(174);
			match(T__17);
			setState(175);
			match(T__11);
			setState(176);
			expr();
			setState(177);
			match(T__12);
			setState(178);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStmtContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			lvalue();
			setState(181);
			match(T__4);
			setState(182);
			expr();
			setState(183);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__20);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4383014129728L) != 0)) {
				{
				setState(186);
				expr();
				}
			}

			setState(189);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExprStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exprStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4383014129728L) != 0)) {
				{
				setState(191);
				expr();
				}
			}

			setState(194);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			exprStmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForConditionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterForCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitForCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitForCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForAcumContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForAcumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forAcum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterForAcum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitForAcum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitForAcum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForAcumContext forAcum() throws RecognitionException {
		ForAcumContext _localctx = new ForAcumContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_forAcum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public AssignExprContext assignExpr() {
			return getRuleContext(AssignExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			assignExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignExprContext extends ParserRuleContext {
		public LogicalOrExprContext logicalOrExpr() {
			return getRuleContext(LogicalOrExprContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public AssignExprContext assignExpr() {
			return getRuleContext(AssignExprContext.class,0);
		}
		public AssignExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignExprContext assignExpr() throws RecognitionException {
		AssignExprContext _localctx = new AssignExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignExpr);
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				logicalOrExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				lvalue();
				setState(206);
				match(T__4);
				setState(207);
				assignExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrExprContext extends ParserRuleContext {
		public List<LogicalAndExprContext> logicalAndExpr() {
			return getRuleContexts(LogicalAndExprContext.class);
		}
		public LogicalAndExprContext logicalAndExpr(int i) {
			return getRuleContext(LogicalAndExprContext.class,i);
		}
		public LogicalOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterLogicalOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitLogicalOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitLogicalOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOrExprContext logicalOrExpr() throws RecognitionException {
		LogicalOrExprContext _localctx = new LogicalOrExprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_logicalOrExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			logicalAndExpr();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(212);
				match(T__21);
				setState(213);
				logicalAndExpr();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndExprContext extends ParserRuleContext {
		public List<EqualityExprContext> equalityExpr() {
			return getRuleContexts(EqualityExprContext.class);
		}
		public EqualityExprContext equalityExpr(int i) {
			return getRuleContext(EqualityExprContext.class,i);
		}
		public LogicalAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterLogicalAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitLogicalAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitLogicalAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalAndExprContext logicalAndExpr() throws RecognitionException {
		LogicalAndExprContext _localctx = new LogicalAndExprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_logicalAndExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			equalityExpr();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(220);
				match(T__22);
				setState(221);
				equalityExpr();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ParserRuleContext {
		public List<RelationalExprContext> relationalExpr() {
			return getRuleContexts(RelationalExprContext.class);
		}
		public RelationalExprContext relationalExpr(int i) {
			return getRuleContext(RelationalExprContext.class,i);
		}
		public EqualityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitEqualityExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExprContext equalityExpr() throws RecognitionException {
		EqualityExprContext _localctx = new EqualityExprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_equalityExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			relationalExpr();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23 || _la==T__24) {
				{
				{
				setState(228);
				_la = _input.LA(1);
				if ( !(_la==T__23 || _la==T__24) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(229);
				relationalExpr();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ParserRuleContext {
		public List<AdditiveExprContext> additiveExpr() {
			return getRuleContexts(AdditiveExprContext.class);
		}
		public AdditiveExprContext additiveExpr(int i) {
			return getRuleContext(AdditiveExprContext.class,i);
		}
		public RelationalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitRelationalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExprContext relationalExpr() throws RecognitionException {
		RelationalExprContext _localctx = new RelationalExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_relationalExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			additiveExpr();
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1006632960L) != 0)) {
				{
				{
				setState(236);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1006632960L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(237);
				additiveExpr();
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExprContext extends ParserRuleContext {
		public List<MultiplicativeExprContext> multiplicativeExpr() {
			return getRuleContexts(MultiplicativeExprContext.class);
		}
		public MultiplicativeExprContext multiplicativeExpr(int i) {
			return getRuleContext(MultiplicativeExprContext.class,i);
		}
		public AdditiveExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitAdditiveExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExprContext additiveExpr() throws RecognitionException {
		AdditiveExprContext _localctx = new AdditiveExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_additiveExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			multiplicativeExpr();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29 || _la==T__30) {
				{
				{
				setState(244);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(245);
				multiplicativeExpr();
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public MultiplicativeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterMultiplicativeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitMultiplicativeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitMultiplicativeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExprContext multiplicativeExpr() throws RecognitionException {
		MultiplicativeExprContext _localctx = new MultiplicativeExprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_multiplicativeExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			unaryExpr();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12884901952L) != 0)) {
				{
				{
				setState(252);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 12884901952L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(253);
				unaryExpr();
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_unaryExpr);
		int _la;
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__30:
			case T__33:
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 53687091264L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(260);
				unaryExpr();
				}
				break;
			case T__11:
			case T__35:
			case T__36:
			case Identifier:
			case IntegerConst:
			case CharConst:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode IntegerConst() { return getToken(MiniCParser.IntegerConst, 0); }
		public TerminalNode CharConst() { return getToken(MiniCParser.CharConst, 0); }
		public TerminalNode StringLiteral() { return getToken(MiniCParser.StringLiteral, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_primary);
		try {
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(IntegerConst);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				match(CharConst);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(266);
				match(StringLiteral);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(267);
				match(T__35);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(268);
				match(T__36);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(269);
				match(T__11);
				setState(270);
				expr();
				setState(271);
				match(T__12);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(273);
				lvalue();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(274);
				call();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniCParser.Identifier, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(Identifier);
			setState(278);
			match(T__11);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4383014129728L) != 0)) {
				{
				setState(279);
				expr();
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(280);
					match(T__1);
					setState(281);
					expr();
					}
					}
					setState(286);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(289);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LvalueContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniCParser.Identifier, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitLvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitLvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_lvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(Identifier);
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(292);
				match(T__2);
				setState(293);
				expr();
				setState(294);
				match(T__3);
				}
				}
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u012e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0005\u0000C\b\u0000"+
		"\n\u0000\f\u0000F\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"Q\b\u0002\n\u0002\f\u0002T\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003Z\b\u0003\n\u0003\f\u0003]\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003a\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"e\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005m\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006u\b\u0006\n\u0006\f\u0006"+
		"x\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0005\b\u0080\b\b\n\b\f\b\u0083\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u008f\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0098\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00a4\b\f\u0001\f\u0001\f\u0003\f\u00a8\b\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00bc\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0003\u0010\u00c1\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u00d2\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u00d7\b\u0016\n\u0016\f\u0016\u00da\t\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u00df\b\u0017\n\u0017\f\u0017\u00e2\t\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u00e7\b\u0018\n\u0018\f\u0018"+
		"\u00ea\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u00ef\b"+
		"\u0019\n\u0019\f\u0019\u00f2\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0005\u001a\u00f7\b\u001a\n\u001a\f\u001a\u00fa\t\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0005\u001b\u00ff\b\u001b\n\u001b\f\u001b\u0102\t\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0107\b\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0114\b\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e"+
		"\u011b\b\u001e\n\u001e\f\u001e\u011e\t\u001e\u0003\u001e\u0120\b\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0005\u001f\u0129\b\u001f\n\u001f\f\u001f\u012c\t\u001f\u0001"+
		"\u001f\u0000\u0000 \u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>\u0000\u0006\u0001\u0000"+
		"\u0007\u000b\u0001\u0000\u0018\u0019\u0001\u0000\u001a\u001d\u0001\u0000"+
		"\u001e\u001f\u0002\u0000\u0006\u0006 !\u0003\u0000\u0006\u0006\u001f\u001f"+
		"\"#\u0135\u0000D\u0001\u0000\u0000\u0000\u0002I\u0001\u0000\u0000\u0000"+
		"\u0004M\u0001\u0000\u0000\u0000\u0006d\u0001\u0000\u0000\u0000\bf\u0001"+
		"\u0000\u0000\u0000\nh\u0001\u0000\u0000\u0000\fq\u0001\u0000\u0000\u0000"+
		"\u000ey\u0001\u0000\u0000\u0000\u0010|\u0001\u0000\u0000\u0000\u0012\u008e"+
		"\u0001\u0000\u0000\u0000\u0014\u0090\u0001\u0000\u0000\u0000\u0016\u0099"+
		"\u0001\u0000\u0000\u0000\u0018\u009f\u0001\u0000\u0000\u0000\u001a\u00ac"+
		"\u0001\u0000\u0000\u0000\u001c\u00b4\u0001\u0000\u0000\u0000\u001e\u00b9"+
		"\u0001\u0000\u0000\u0000 \u00c0\u0001\u0000\u0000\u0000\"\u00c4\u0001"+
		"\u0000\u0000\u0000$\u00c6\u0001\u0000\u0000\u0000&\u00c8\u0001\u0000\u0000"+
		"\u0000(\u00ca\u0001\u0000\u0000\u0000*\u00d1\u0001\u0000\u0000\u0000,"+
		"\u00d3\u0001\u0000\u0000\u0000.\u00db\u0001\u0000\u0000\u00000\u00e3\u0001"+
		"\u0000\u0000\u00002\u00eb\u0001\u0000\u0000\u00004\u00f3\u0001\u0000\u0000"+
		"\u00006\u00fb\u0001\u0000\u0000\u00008\u0106\u0001\u0000\u0000\u0000:"+
		"\u0113\u0001\u0000\u0000\u0000<\u0115\u0001\u0000\u0000\u0000>\u0123\u0001"+
		"\u0000\u0000\u0000@C\u0003\u0002\u0001\u0000AC\u0003\n\u0005\u0000B@\u0001"+
		"\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000GH\u0005\u0000\u0000\u0001H\u0001\u0001"+
		"\u0000\u0000\u0000IJ\u0003\b\u0004\u0000JK\u0003\u0004\u0002\u0000KL\u0005"+
		"\u0001\u0000\u0000L\u0003\u0001\u0000\u0000\u0000MR\u0003\u0006\u0003"+
		"\u0000NO\u0005\u0002\u0000\u0000OQ\u0003\u0006\u0003\u0000PN\u0001\u0000"+
		"\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000S\u0005\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000U[\u0005&\u0000\u0000VW\u0005\u0003\u0000\u0000WX\u0005\'\u0000"+
		"\u0000XZ\u0005\u0004\u0000\u0000YV\u0001\u0000\u0000\u0000Z]\u0001\u0000"+
		"\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\`\u0001"+
		"\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005\u0005\u0000\u0000"+
		"_a\u0003(\u0014\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000"+
		"ae\u0001\u0000\u0000\u0000bc\u0005\u0006\u0000\u0000ce\u0003\u0006\u0003"+
		"\u0000dU\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000e\u0007\u0001"+
		"\u0000\u0000\u0000fg\u0007\u0000\u0000\u0000g\t\u0001\u0000\u0000\u0000"+
		"hi\u0003\b\u0004\u0000ij\u0005&\u0000\u0000jl\u0005\f\u0000\u0000km\u0003"+
		"\f\u0006\u0000lk\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0001"+
		"\u0000\u0000\u0000no\u0005\r\u0000\u0000op\u0003\u0010\b\u0000p\u000b"+
		"\u0001\u0000\u0000\u0000qv\u0003\u000e\u0007\u0000rs\u0005\u0002\u0000"+
		"\u0000su\u0003\u000e\u0007\u0000tr\u0001\u0000\u0000\u0000ux\u0001\u0000"+
		"\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w\r\u0001"+
		"\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000yz\u0003\b\u0004\u0000z{\u0003"+
		"\u0006\u0003\u0000{\u000f\u0001\u0000\u0000\u0000|\u0081\u0005\u000e\u0000"+
		"\u0000}\u0080\u0003\u0002\u0001\u0000~\u0080\u0003\u0012\t\u0000\u007f"+
		"}\u0001\u0000\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0083\u0001"+
		"\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001"+
		"\u0000\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u0081\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005\u000f\u0000\u0000\u0085\u0011\u0001"+
		"\u0000\u0000\u0000\u0086\u008f\u0003\u0010\b\u0000\u0087\u008f\u0003\u0014"+
		"\n\u0000\u0088\u008f\u0003\u0016\u000b\u0000\u0089\u008f\u0003\u0018\f"+
		"\u0000\u008a\u008f\u0003\u001a\r\u0000\u008b\u008f\u0003\u001c\u000e\u0000"+
		"\u008c\u008f\u0003\u001e\u000f\u0000\u008d\u008f\u0003 \u0010\u0000\u008e"+
		"\u0086\u0001\u0000\u0000\u0000\u008e\u0087\u0001\u0000\u0000\u0000\u008e"+
		"\u0088\u0001\u0000\u0000\u0000\u008e\u0089\u0001\u0000\u0000\u0000\u008e"+
		"\u008a\u0001\u0000\u0000\u0000\u008e\u008b\u0001\u0000\u0000\u0000\u008e"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0013\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u0010\u0000\u0000\u0091"+
		"\u0092\u0005\f\u0000\u0000\u0092\u0093\u0003(\u0014\u0000\u0093\u0094"+
		"\u0005\r\u0000\u0000\u0094\u0097\u0003\u0012\t\u0000\u0095\u0096\u0005"+
		"\u0011\u0000\u0000\u0096\u0098\u0003\u0012\t\u0000\u0097\u0095\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0015\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0005\u0012\u0000\u0000\u009a\u009b\u0005\f\u0000"+
		"\u0000\u009b\u009c\u0003(\u0014\u0000\u009c\u009d\u0005\r\u0000\u0000"+
		"\u009d\u009e\u0003\u0012\t\u0000\u009e\u0017\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0005\u0013\u0000\u0000\u00a0\u00a1\u0005\f\u0000\u0000\u00a1\u00a3"+
		"\u0003\"\u0011\u0000\u00a2\u00a4\u0003$\u0012\u0000\u00a3\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a7\u0005\u0001\u0000\u0000\u00a6\u00a8\u0003"+
		"&\u0013\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\r\u0000"+
		"\u0000\u00aa\u00ab\u0003\u0012\t\u0000\u00ab\u0019\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0005\u0014\u0000\u0000\u00ad\u00ae\u0003\u0012\t\u0000\u00ae"+
		"\u00af\u0005\u0012\u0000\u0000\u00af\u00b0\u0005\f\u0000\u0000\u00b0\u00b1"+
		"\u0003(\u0014\u0000\u00b1\u00b2\u0005\r\u0000\u0000\u00b2\u00b3\u0005"+
		"\u0001\u0000\u0000\u00b3\u001b\u0001\u0000\u0000\u0000\u00b4\u00b5\u0003"+
		">\u001f\u0000\u00b5\u00b6\u0005\u0005\u0000\u0000\u00b6\u00b7\u0003(\u0014"+
		"\u0000\u00b7\u00b8\u0005\u0001\u0000\u0000\u00b8\u001d\u0001\u0000\u0000"+
		"\u0000\u00b9\u00bb\u0005\u0015\u0000\u0000\u00ba\u00bc\u0003(\u0014\u0000"+
		"\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0005\u0001\u0000\u0000"+
		"\u00be\u001f\u0001\u0000\u0000\u0000\u00bf\u00c1\u0003(\u0014\u0000\u00c0"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u0001\u0000\u0000\u00c3"+
		"!\u0001\u0000\u0000\u0000\u00c4\u00c5\u0003 \u0010\u0000\u00c5#\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0003(\u0014\u0000\u00c7%\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0003(\u0014\u0000\u00c9\'\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u0003*\u0015\u0000\u00cb)\u0001\u0000\u0000\u0000\u00cc\u00d2"+
		"\u0003,\u0016\u0000\u00cd\u00ce\u0003>\u001f\u0000\u00ce\u00cf\u0005\u0005"+
		"\u0000\u0000\u00cf\u00d0\u0003*\u0015\u0000\u00d0\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d1\u00cc\u0001\u0000\u0000\u0000\u00d1\u00cd\u0001\u0000\u0000"+
		"\u0000\u00d2+\u0001\u0000\u0000\u0000\u00d3\u00d8\u0003.\u0017\u0000\u00d4"+
		"\u00d5\u0005\u0016\u0000\u0000\u00d5\u00d7\u0003.\u0017\u0000\u00d6\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9-\u0001"+
		"\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00e0\u0003"+
		"0\u0018\u0000\u00dc\u00dd\u0005\u0017\u0000\u0000\u00dd\u00df\u00030\u0018"+
		"\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e1/\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e8\u00032\u0019\u0000\u00e4\u00e5\u0007\u0001\u0000\u0000\u00e5"+
		"\u00e7\u00032\u0019\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e7\u00ea"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e91\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001"+
		"\u0000\u0000\u0000\u00eb\u00f0\u00034\u001a\u0000\u00ec\u00ed\u0007\u0002"+
		"\u0000\u0000\u00ed\u00ef\u00034\u001a\u0000\u00ee\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f13\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f8\u00036\u001b\u0000\u00f4"+
		"\u00f5\u0007\u0003\u0000\u0000\u00f5\u00f7\u00036\u001b\u0000\u00f6\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f95\u0001"+
		"\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u0100\u0003"+
		"8\u001c\u0000\u00fc\u00fd\u0007\u0004\u0000\u0000\u00fd\u00ff\u00038\u001c"+
		"\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00ff\u0102\u0001\u0000\u0000"+
		"\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000"+
		"\u0000\u01017\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0007\u0005\u0000\u0000\u0104\u0107\u00038\u001c\u0000\u0105"+
		"\u0107\u0003:\u001d\u0000\u0106\u0103\u0001\u0000\u0000\u0000\u0106\u0105"+
		"\u0001\u0000\u0000\u0000\u01079\u0001\u0000\u0000\u0000\u0108\u0114\u0005"+
		"\'\u0000\u0000\u0109\u0114\u0005(\u0000\u0000\u010a\u0114\u0005)\u0000"+
		"\u0000\u010b\u0114\u0005$\u0000\u0000\u010c\u0114\u0005%\u0000\u0000\u010d"+
		"\u010e\u0005\f\u0000\u0000\u010e\u010f\u0003(\u0014\u0000\u010f\u0110"+
		"\u0005\r\u0000\u0000\u0110\u0114\u0001\u0000\u0000\u0000\u0111\u0114\u0003"+
		">\u001f\u0000\u0112\u0114\u0003<\u001e\u0000\u0113\u0108\u0001\u0000\u0000"+
		"\u0000\u0113\u0109\u0001\u0000\u0000\u0000\u0113\u010a\u0001\u0000\u0000"+
		"\u0000\u0113\u010b\u0001\u0000\u0000\u0000\u0113\u010c\u0001\u0000\u0000"+
		"\u0000\u0113\u010d\u0001\u0000\u0000\u0000\u0113\u0111\u0001\u0000\u0000"+
		"\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114;\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0005&\u0000\u0000\u0116\u011f\u0005\f\u0000\u0000\u0117"+
		"\u011c\u0003(\u0014\u0000\u0118\u0119\u0005\u0002\u0000\u0000\u0119\u011b"+
		"\u0003(\u0014\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b\u011e\u0001"+
		"\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001"+
		"\u0000\u0000\u0000\u011d\u0120\u0001\u0000\u0000\u0000\u011e\u011c\u0001"+
		"\u0000\u0000\u0000\u011f\u0117\u0001\u0000\u0000\u0000\u011f\u0120\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0005"+
		"\r\u0000\u0000\u0122=\u0001\u0000\u0000\u0000\u0123\u012a\u0005&\u0000"+
		"\u0000\u0124\u0125\u0005\u0003\u0000\u0000\u0125\u0126\u0003(\u0014\u0000"+
		"\u0126\u0127\u0005\u0004\u0000\u0000\u0127\u0129\u0001\u0000\u0000\u0000"+
		"\u0128\u0124\u0001\u0000\u0000\u0000\u0129\u012c\u0001\u0000\u0000\u0000"+
		"\u012a\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000"+
		"\u012b?\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u001c"+
		"BDR[`dlv\u007f\u0081\u008e\u0097\u00a3\u00a7\u00bb\u00c0\u00d1\u00d8\u00e0"+
		"\u00e8\u00f0\u00f8\u0100\u0106\u0113\u011c\u011f\u012a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
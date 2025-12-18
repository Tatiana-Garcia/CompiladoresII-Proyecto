grammar MiniC;

program       : (declaration | funcDef)* EOF ;

declaration   : typeSpecifier declaratorList ';' ;

declaratorList: declarator (',' declarator)* ;

declarator    : Identifier ('[' IntegerConst ']')* ('=' expr)?
              | '*' declarator ;

typeSpecifier : 'int' | 'char' | 'bool' | 'void' | 'string' ;

funcDef       : typeSpecifier Identifier '(' params? ')' compoundStmt ;
params        : param (',' param)* ;
param         : typeSpecifier declarator ;

compoundStmt  : '{' (declaration | statement)* '}' ;
statement     : compoundStmt
              | ifStmt | whileStmt | forStmt | doWhileStmt
              | assignStmt | returnStmt | exprStmt
              | breakStmt | continueStmt;

ifStmt        : 'if' '(' expr ')' statement ('else' statement)? ;
whileStmt     : 'while' '(' expr ')' statement ;
forStmt       : 'for' '(' forInit? ';' forCondition? ';' forAcum? ')' statement ;
doWhileStmt   : 'do' statement 'while' '(' expr ')' ';' ;

assignStmt    : unaryExpr '=' expr ';' ;//cambio lvalue -> unaryExpr ... *p =10

returnStmt    : 'return' expr? ';' ;
exprStmt      : expr? ';' ;
breakStmt     : 'break' ';' ;
continueStmt  : 'continue' ';' ;

forInit       : expr;// exprStmt | assignStmt ;
forCondition  : expr;
forAcum       : expr;// | assignExpr ;

expr          : assignExpr;

assignExpr    : logicalOrExpr | unaryExpr '=' assignExpr;//cambio lvalue -> unaryExpr ... *p =10

logicalOrExpr : logicalAndExpr ('||' logicalAndExpr)* ;
logicalAndExpr: equalityExpr ('&&' equalityExpr)* ;
equalityExpr  : relationalExpr (('==' | '!=') relationalExpr)* ;
relationalExpr: additiveExpr (('<'|'>'|'<='|'>=') additiveExpr)* ;
additiveExpr  : multiplicativeExpr (('+'|'-') multiplicativeExpr)* ;
multiplicativeExpr
              : unaryExpr (('*'|'/'|'%') unaryExpr)* ;
unaryExpr     : ('!'|'-'|'*'|'&') unaryExpr | primary ;
primary       : IntegerConst | CharConst | StringLiteral | 'true' | 'false'
              | '(' expr ')' | lvalue | call ;
call          : Identifier '(' (expr (',' expr)*)? ')' ;
lvalue        : Identifier ('[' expr ']')* ;

// Léxico clave (incompleto)
Identifier    : [A-Za-z_] [A-Za-z0-9_]* ;
IntegerConst  : [0-9]+ ;

// Literales robustos
CharConst     : '\'' ('\\' . | ~['\\] ) '\'';
StringLiteral : '"' ('\\' . | ~['"\\] )* '"';

WS            : [ \t\r\n]+ -> skip ;
LINE_COMMENT  : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;


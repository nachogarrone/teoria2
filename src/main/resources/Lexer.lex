package examples.while_ut1.parser;

import java_cup.runtime.Symbol;

%%

%unicode
%line
%column
%public
%class Lexer
%cupsym Tokens
%cup
%implements Tokens

%{
	/* Embedded lexer class code */
%}

%%
// Tokens.

/*[0-9]+	{ return new Symbol(NUM, Double.parseDouble(yytext())); }*/

[a-z][a-zA-Z0-9_]*
	{ String $1 = yytext(); String $0;
	  $0 = $1;
	  return new Symbol(ID, yyline, yycolumn, $0); }

"="	{ return new Symbol(EQUALS_SIGN, yyline, yycolumn, yytext()); }

";" { return new Symbol(SEMICOLON, yyline, yycolumn, yytext()); }
[a-zA-Z_][a-zA-Z0-9_]*
	{ String $1 = yytext(); String $0;
	  $0 = $1;
	  return new Symbol(ID, yyline, yycolumn, $0); }
[a-z][a-zA-Z0-9_]*
	{ String $1 = yytext(); String $0;
	  $0 = $1;
	  return new Symbol(PRED, yyline, yycolumn, $0); }

,		{ return new Symbol(COMMA); }
\~		{ return new Symbol(NEG); }
\/\\	{ return new Symbol(AND); }
\\\/	{ return new Symbol(OR); }
-\>		{ return new Symbol(COND); }
\<-\>	{ return new Symbol(BICOND); }
\(		{ return new Symbol(LPAREN); }
\)		{ return new Symbol(RPAREN); }
T		{ return new Symbol(TRUE); }
F		{ return new Symbol(FALSE); }


.	{ /* Fallback */
		return new Symbol(error, "Unexpected input <"+ yytext() +">!");
	}

[ \t\r\n\f]+ {}
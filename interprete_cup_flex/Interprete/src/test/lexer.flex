package test;

import java_cup.runtime.Symbol;

%%

%{

%}

%line
%char

%cup

%%

[0-9]+ { return new Symbol( sym.TOKEN_NUMBER , yytext() ); }
"push" { return new Symbol( sym.TOKEN_PUSH , yytext() ); }
"add" { return new Symbol( sym.TOKEN_ADD , yytext() ); }
"sub" { return new Symbol( sym.TOKEN_SUB , yytext() ); }
"div" { return new Symbol( sym.TOKEN_DIV , yytext() ); }
"mult" { return new Symbol( sym.TOKEN_MULT , yytext() ); }
"print" { return new Symbol( sym.TOKEN_PRINT , yytext() ); }

[\n\r\t ]+ {  }

. { System.out.println( "Caracter no Esperado, ERROR LEXICO " + yytext() ); }
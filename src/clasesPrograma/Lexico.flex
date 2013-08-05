/* primera parte: no hace falta poner nada */
package clasesPrograma;
import java_cup.runtime.Symbol;
%%
/* segunda parte: declaramos las directivas y los macros */
%class AnalizadorLexico
%public
%full
%unicode
%line
%column
%char
%cup

LineTerminator = \r|\n|\r\n|\n\r
WhiteSpace = {LineTerminator} | [ \t\f]
ValorEntero = 0|[1-9][0-9]*
Comentario = [//] [a-z][a-z]*[0-9]*

%%
/* OPERADORES Y SIGNOS */
"</" {return new Symbol(sym.PCOMA, new token(yycolumn, yyline, yytext()));}
"," {return new Symbol(sym.COMA, new token(yycolumn, yyline, yytext()));}
"(" {return new Symbol(sym.ABRIRPAR, new token(yycolumn, yyline, yytext()));}
")" {return new Symbol(sym.CERRARPAR, new token(yycolumn, yyline, yytext()));}

/* PALABRAS RESERVADAS */
"<XML>" {return new Symbol(sym.INICIO, new token(yycolumn, yyline, yytext()));}
"</XML>" {return new Symbol(sym.FIN, new token(yycolumn, yyline, yytext()));}
"<circulo>" {return new Symbol(sym.CIRCULO, new token(yycolumn, yyline, yytext()));}
"<linea>" {return new Symbol(sym.LINEA, new token(yycolumn, yyline, yytext()));}
"<rectangulo>" {return new Symbol(sym.RECTANGULO, new token(yycolumn, yyline, yytext()));}
"<color>" {return new Symbol(sym.COLOR, new token(yycolumn, yyline, yytext()));}

/* EXPRESIONES */
{ValorEntero} {return new Symbol(sym.VALINT, new token(yycolumn, yyline, yytext()));}
{LineTerminator} {return new Symbol(sym.ENTER, new token(yycolumn, yyline, yytext()));}
{WhiteSpace} {/* ignorar */}
. {System.err.println("caracter invalido" + yytext() + "["+ yyline + ":"+ yycolumn + "]");}
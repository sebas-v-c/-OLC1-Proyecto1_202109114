// package and imports
package gt.edu.usac.ingenieria.analyzer;
import java_cup.runtime.Symbol;
import java.util.ArrayList;

%%
%{
%}

%class Scanner
%cup
%public

REVALUAR = "Evaluar"

%%

<YYINITIAL> {REVALUAR} {    return new Symbol(sym.REVALUAR, yyline, yycolumn, yytext());  }

// package and imports
package gt.edu.usac.ingenieria.analyzer;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import gt.edu.usac.ingenieria.analyzer.errors.ErrorStp;

%%
// java code: Error Array list
%{
    private ArrayList<ErrorStp> errors = new ArrayList<>();
    private void addError(int line, int column, String character){
        errors.add(new ErrorStp(line, column, character));
    }

    public ArrayList<ErrorStp> getErrors(){
        return errors;
    }
%}

// directives
%class Scanner
%public
%cupsym SYM
%cup 
%char
%column
%full
%line
%unicode
%ignorecase

// contructor
%init{
    yyline = 1;
    yychar = 1;
%init}

//regular expressions
DISCARTED=[ \r\t]+
TEXT=([^\n\"\\]|\\.)
ID=(\_)*[a-zA-Z][a-zA-Z0-9\_]*
STRING=\"({TEXT}*)\"
CHAR=\'({TEXT})\'
INTEGER=[0-9]+
DOUBLE=[0-9]+\.[0-9]+
COMMENT="//"([^\r\n]*)?
COMMENTML=[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]

%%

<YYINITIAL> {REVALUAR} {    return new Symbol(sym.REVALUAR, yyline, yycolumn, yytext());  }

// package and imports
package gt.edu.usac.ingenieria.analyzer.json;
import java_cup.runtime.*;
import java_cup.sym;
import java.util.ArrayList;
import gt.edu.usac.ingenieria.analyzer.errors.ErrorStpL;

%%
// java code: Error Array list
%{
    private ArrayList<ErrorStpL> errors = new ArrayList<>();
    private void addError(String value){
        errors.add(new ErrorStpL(yyline, yycolumn, value));
    }

    public ArrayList<ErrorStpL> getErrors(){
        return errors;
    }

    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
%}


// directives
%public
%class JsonLexer
%cup
%char
%column
%full
%line
%ignorecase

// contructor
%init{
    yyline = 1;
%init}

//regular expressions
DISCARTED=[ \r\t]+
TEXT=([^\n\"\\]|\\.)
STRING=\"({TEXT}*)\"
INTEGER=[0-9]+
DOUBLE=[0-9]+\.[0-9]+
COMMENT="//"([^\r\n]*)?
COMMENTML=[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]

%%
// tokens
// Reserved Key Words
<YYINITIAL> {
    "{"             {return symbol(SYM.TK_LBRC,           yytext());}
    "}"             {return symbol(SYM.TK_RBRC,           yytext());}
    ":"             {return symbol(SYM.TK_COLON,          yytext());}
    ","             {return symbol(SYM.TK_COMA,           yytext());}
    "-"             {return symbol(SYM.TK_MINUS,          yytext());}

    {STRING}        {return symbol(SYM.TK_STRING,         yytext());}
    {INTEGER}       {return symbol(SYM.TK_INT,            yytext());}
    {DOUBLE}        {return symbol(SYM.TK_DOUBLE,         yytext());}
    // vars

    \n              {yycolumn = 0;}
    {DISCARTED}     {}
    {COMMENT}       {}
    {COMMENTML}     {}
    .               {addError(yytext());}
}
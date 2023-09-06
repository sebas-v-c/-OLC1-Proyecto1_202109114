// package and imports
package gt.edu.usac.ingenieria.analyzer.statpy;
import gt.edu.usac.ingenieria.analyzer.errors.LexError;import java_cup.runtime.*;
import java_cup.sym;
import java.util.ArrayList;
import gt.edu.usac.ingenieria.analyzer.errors.LexError;

%%
// java code: Error Array list
%{
    private ArrayList<LexError> errors = new ArrayList<>();
        private void addError(String value){
            errors.add(new LexError(yyline, yycolumn, value));
        }

        public ArrayList<LexError> getErrors(){
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
%class STPLexer
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
ID=(\_)*[a-zA-ZñÑ][a-zA-Z0-9ñÑ\_]*
STRING=\"({TEXT}*)\"
CHAR=\'({TEXT})\'
INTEGER=[0-9]+
DOUBLE=[0-9]+\.[0-9]+
COMMENT="//"([^\r\n]*)?
COMMENTML=[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]

%%
// tokens
// Reserved Key words
<YYINITIAL> {
    "void"            {return symbol(SYM.KW_VOID,         yytext());}
    "main"            {return symbol(SYM.KW_MAIN,         yytext());}
    "int"             {return symbol(SYM.KW_INT,          yytext());}
    "double"          {return symbol(SYM.KW_DOUBLE,       yytext());}
    "char"            {return symbol(SYM.KW_CHAR,         yytext());}
    "bool"            {return symbol(SYM.KW_BOOL,         yytext());}
    "string"          {return symbol(SYM.KW_STRING,       yytext());}
    "if"              {return symbol(SYM.KW_IF,           yytext());}
    "else"            {return symbol(SYM.KW_ELSE,         yytext());}
    "switch"          {return symbol(SYM.KW_SWITCH,       yytext());}
    "case"            {return symbol(SYM.KW_CASE,         yytext());}
    "default"         {return symbol(SYM.KW_DEFAULT,      yytext());}
    "break"           {return symbol(SYM.KW_BREAK,        yytext());}
    "for"             {return symbol(SYM.KW_FOR,          yytext());}
    "do"              {return symbol(SYM.KW_DO,           yytext());}
    "while"           {return symbol(SYM.KW_WHILE,        yytext());}
    "continue"        {return symbol(SYM.KW_CONTINUE,     yytext());}
    "return"          {return symbol(SYM.KW_RETURN,       yytext());}
    "true"            {return symbol(SYM.KW_TRUE,         yytext());}
    "false"           {return symbol(SYM.KW_FALSE,        yytext());}
    "DefinirGlobales" {return symbol(SYM.KW_DEFGLB,       yytext());}
    "GraficaBarras"   {return symbol(SYM.KW_BARGRPH,      yytext());}
    "GraficaPie"      {return symbol(SYM.KW_PIEGRPH,      yytext());}
    "Titulo"          {return symbol(SYM.KW_TITLE,        yytext());}
    "EjeX"            {return symbol(SYM.KW_XAXIS,        yytext());}
    "TituloX"         {return symbol(SYM.KW_TITLEX,       yytext());}
    "TituloY"         {return symbol(SYM.KW_TITLEY,       yytext());}
    "Valores"         {return symbol(SYM.KW_VALUES,       yytext());}
    "Console.Write"   {return symbol(SYM.KW_PRINT,        yytext());}
    // values
    {STRING}          {return symbol(SYM.TK_STRING,       yytext());}
    {CHAR}            {return symbol(SYM.TK_CHAR,         yytext());}
    {INTEGER}         {return symbol(SYM.TK_INT,          yytext());}
    {DOUBLE}          {return symbol(SYM.TK_DOUBLE,       yytext());}
    // vars
    {ID}              {return symbol(SYM.TK_ID,           yytext());}
    // Increment decrement
    "++"              {return symbol(SYM.TK_INC,          yytext());}
    "--"              {return symbol(SYM.TK_DEC,          yytext());}
    // aritmetics
    "+"               {return symbol(SYM.TK_PLUS,         yytext());}
    "-"               {return symbol(SYM.TK_MINUS,        yytext());}
    "*"               {return symbol(SYM.TK_MULT,         yytext());}
    "/"               {return symbol(SYM.TK_DIV,          yytext());}
    // comparisson
    ">="              {return symbol(SYM.TK_GEQ,          yytext());}
    "<="              {return symbol(SYM.TK_LEQ,          yytext());}
    "=="              {return symbol(SYM.TK_EQEQ,         yytext());}
    "!="              {return symbol(SYM.TK_NOTEQ,        yytext());}
    ">"               {return symbol(SYM.TK_GREATER,      yytext());}
    "<"               {return symbol(SYM.TK_LESS,         yytext());}
    "&&"              {return symbol(SYM.TK_AND,          yytext());}
    "||"              {return symbol(SYM.TK_OR,           yytext());}
    "!"               {return symbol(SYM.TK_NOT,          yytext());}
    // groups
    "("               {return symbol(SYM.TK_LPAR,         yytext());}
    ")"               {return symbol(SYM.TK_RPAR,         yytext());}
    "{"               {return symbol(SYM.TK_LBRC,         yytext());}
    "}"               {return symbol(SYM.TK_RBRC,         yytext());}
    "["               {return symbol(SYM.TK_LBRK,         yytext());}
    "]"               {return symbol(SYM.TK_RBRK,         yytext());}
    // assign
    "="               {return symbol(SYM.TK_EQ,           yytext());}
    // punctuation
    ","               {return symbol(SYM.TK_COMA,         yytext());}
    ";"               {return symbol(SYM.TK_SCOLON,       yytext());}
    ":"               {return symbol(SYM.TK_COLON,        yytext());}
    // especial symbols
    "$"               {return symbol(SYM.TK_DOLL,         yytext());}
    // reset char count
    \n                {yycolumn = 0;}
    {DISCARTED}       {}
    {COMMENT}         {}
    {COMMENTML}       {}
    .                 {addError(yytext());}
}
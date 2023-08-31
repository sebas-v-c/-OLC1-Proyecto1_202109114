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
%class StatPyLexer
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
// tokens
// Reserved Key words
"void"      {return new Symbol(SYM.KW_VOID,         yyline, yychar, yytext());}
"main"      {return new Symbol(SYM.KW_MAIN,         yyline, yychar, yytext());}
"int"       {return new Symbol(SYM.KW_INT,          yyline, yychar, yytext());}
"double"    {return new Symbol(SYM.KW_DOUBLE,       yyline, yychar, yytext());}
"char"      {return new Symbol(SYM.KW_CHAR,         yyline, yychar, yytext());}
"bool"      {return new Symbol(SYM.KW_BOOL,         yyline, yychar, yytext());}
"string"    {return new Symbol(SYM.KW_STRING,       yyline, yychar, yytext());}
"if"        {return new Symbol(SYM.KW_IF,           yyline, yychar, yytext());}
"else"      {return new Symbol(SYM.KW_ELSE,         yyline, yychar, yytext());}
"switch"    {return new Symbol(SYM.KW_SWITCH,       yyline, yychar, yytext());}
"case"      {return new Symbol(SYM.KW_CASE,         yyline, yychar, yytext());}
"default"   {return new Symbol(SYM.KW_DEFAULT,      yyline, yychar, yytext());}
"break"     {return new Symbol(SYM.KW_BREAK,        yyline, yychar, yytext());}
"for"       {return new Symbol(SYM.KW_FOR,          yyline, yychar, yytext());}
"do"        {return new Symbol(SYM.KW_DO,           yyline, yychar, yytext());}
"while"     {return new Symbol(SYM.KW_WHILE,        yyline, yychar, yytext());}
"continue"  {return new Symbol(SYM.KW_CONTINUE,     yyline, yychar, yytext());}
"return"    {return new Symbol(SYM.KW_RETURN,       yyline, yychar, yytext());}
// values
{STRING}    {return new Symbol(SYM.TK_STRING,       yyline, yychar, yytext());}
{CHAR}      {return new Symbol(SYM.TK_CHAR,         yyline, yychar, yytext());}
{INTEGER}   {return new Symbol(SYM.TK_INT,          yyline, yychar, yytext());}
{DOUBLE}    {return new Symbol(SYM.TK_DOUBLE,       yyline, yychar, yytext());}
// vars
{ID}        {return new Symbol(SYM.TK_ID,           yyline, yychar, yytext());}
// aritmetics
"+"         {return new Symbol(SYM.TK_PLUS,         yyline, yychar, yytext());}
"-"         {return new Symbol(SYM.TK_MINUS,        yyline, yychar, yytext());}
"*"         {return new Symbol(SYM.TK_MULT,         yyline, yychar, yytext());}
"/"         {return new Symbol(SYM.TK_DIV,          yyline, yychar, yytext());}
// comparisson
">="        {return new Symbol(SYM.TK_GEQ,          yyline, yychar, yytext());}
"<="        {return new Symbol(SYM.TK_LEQ,          yyline, yychar, yytext());}
"=="        {return new Symbol(SYM.TK_EQEQ,         yyline, yychar, yytext());}
"!="        {return new Symbol(SYM.TK_NEQ,          yyline, yychar, yytext());}
">"         {return new Symbol(SYM.TK_GREATER,      yyline, yychar, yytext());}
"<"         {return new Symbol(SYM.TK_LESS,         yyline, yychar, yytext());}
"&&"        {return new Symbol(SYM.TK_AND,          yyline, yychar, yytext());}
"||"        {return new Symbol(SYM.TK_OR,           yyline, yychar, yytext());}
"!"         {return new Symbol(SYM.TK_NOT,          yyline, yychar, yytext());}
// groups
"("         {return new Sybmol(SYM.TK_LPAR,         yyline, yychar, yytext());}
")"         {return new Sybmol(SYM.TK_RPAR,         yyline, yychar, yytext());}
"{"         {return new Sybmol(SYM.TK_LBR,          yyline, yychar, yytext());}
"}"         {return new Sybmol(SYM.TK_RBR,          yyline, yychar, yytext());}
"["         {return new Sybmol(SYM.TK_LBRK,         yyline, yychar, yytext());}
"]"         {return new Sybmol(SYM.TK_RBRK,         yyline, yychar, yytext());}
// assign
"="         {return new Symbol(SYM.TK_EQ,           yyline, yychar, yytext());}
// punctuation
","         {return new Symbol(SYM.TK_COMA          yyline, yychar, yytext());}
";"         {return new Symbol(SYM.TK_SCOLON        yyline, yychar, yytext());}
// reset char count
\n          {yychar = 1;}
{DISCARTED} {}
{COMMENT}   {}
{COMMENTML} {}
.           {addError(yyline, yychar, yytext());}

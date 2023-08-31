package gt.edu.usac.ingenieria.analyzer.errors;

public class ErrorStpL {
    int line;
    int column;
    String character;

    public ErrorStpL(int line, int column, String character){
        this.line = line;
        this.column = column;
        this.character = character;
    }

    public void print(){
        System.out.println("Unrecognized character\"" + character + "\" at: line-" + line + " - column-" + column);
    }
}

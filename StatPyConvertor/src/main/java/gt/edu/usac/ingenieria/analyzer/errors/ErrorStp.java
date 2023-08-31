package gt.edu.usac.ingenieria.analyzer.errors;

public class ErrorStp {
    int line;
    int column;
    String character;

    public ErrorStp(int line, int column, String character){
        this.line = line;
        this.column = column;
        this.character = character;
    }
}

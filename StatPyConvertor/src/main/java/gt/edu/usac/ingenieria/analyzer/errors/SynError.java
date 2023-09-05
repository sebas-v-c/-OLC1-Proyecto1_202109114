package gt.edu.usac.ingenieria.analyzer.errors;

import java.util.Objects;

public class SynError {
    String message;
    int line;
    int column;
    Object object;
    String type;

    public SynError(int line, int column, Object object, String type){
        this.line = line;
        this.column = column;
        this.object = object;
        this.type = type;
    }

    public SynError(String message){
        this.message = message;
    }

    public void print(){
        System.out.println(
                Objects.requireNonNullElseGet(
                        message, () ->
                                "Syntax error at: line-" + line + " column-" + column + ". Component: " + type + " = " + object + "."
                )
        );
    }
}

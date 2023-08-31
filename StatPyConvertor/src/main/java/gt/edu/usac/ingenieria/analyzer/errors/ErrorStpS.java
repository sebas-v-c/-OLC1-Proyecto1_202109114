package gt.edu.usac.ingenieria.analyzer.errors;

public class ErrorStpS {
    String message;
    int line;
    int column;
    Object object;
    String type;

    public ErrorStpS(int line, int column, Object object, String type){
        this.line = line;
        this.column = column;
        this.object = object;
        this.type = type;
    }

    public ErrorStpS(String message){
        this.message = message;
    }

    public void print(){
        if (message == null) {
            System.out.println(
                    "Syntax error at: line-" + line + " column-" + column + ". Component: " + type + " = " + object + "."
            );
        } else {
            System.out.println("Syntax error, impossible to recover");
        }
    }
}

package gt.edu.usac.ingenieria.lang.json;


public class Value {
    int line;
    int column;
    public Object obj;
    public Type type;
    public Value(int line, int column, Object obj, Type type){
        this.line = line;
        this.column = column;
        this.obj = obj;
        this.type = type;
    }
}

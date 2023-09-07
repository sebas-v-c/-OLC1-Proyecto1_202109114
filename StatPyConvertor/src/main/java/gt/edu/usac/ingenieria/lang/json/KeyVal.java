package gt.edu.usac.ingenieria.lang.json;

public class KeyVal {
    int line;
    int column;
    String id;
    Value val;
    public KeyVal(int line, int column, String id, Value val){
        this.line = line;
        this.column = column;
        this.id = id;
        this.val = val;
    }
}

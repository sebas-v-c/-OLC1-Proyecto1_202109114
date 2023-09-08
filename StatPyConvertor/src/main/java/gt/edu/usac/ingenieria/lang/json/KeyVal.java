package gt.edu.usac.ingenieria.lang.json;

public class KeyVal {
    int line;
    int column;
    public String id;
    private Value val;
    public KeyVal(int line, int column, String id, Value val){
        this.line = line;
        this.column = column;
        this.val = val;

        this.id = id.substring(1, id.length()-1);
    }

    public Object getVal(){
        return switch (val.type){
            case DOUBLE -> Double.valueOf((String) val.obj);
            case INT -> Integer.valueOf((String) val.obj);
            case STRING -> (String) val.obj;
        };
    }
}

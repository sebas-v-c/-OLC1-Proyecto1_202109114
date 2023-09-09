package gt.edu.usac.ingenieria.lang.json;


import gt.edu.usac.ingenieria.lang.statpy.PrimitiveType;

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

        if (type == Type.STRING){
            this.obj = ((String) obj).substring(1, ((String) obj).length()-1);
        }
    }
}

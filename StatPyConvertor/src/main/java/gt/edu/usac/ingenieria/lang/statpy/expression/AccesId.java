package gt.edu.usac.ingenieria.lang.statpy.expression;

import gt.edu.usac.ingenieria.Variables;
import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.PrimitiveType;

public class AccesId extends Expression{
    String id;
    public AccesId(int line, int column, String id) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.ACCES_ID);
        this.id = id;
    }

    @Override
    public String toPython() {
        return id;
    }

    @Override
    public Value evaluate() {
        Object obj = Variables.getInstance().graphVars.findVar(id);
        if (obj instanceof Double){
            return new Value((Double) obj, PrimitiveType.DOUBLE);
        }
        if (obj instanceof String){
            return new Value((String) obj, PrimitiveType.STRING);
        }
        if (obj instanceof Integer){
            return new Value((Integer) obj, PrimitiveType.STRING);
        }

        throw new IllegalStateException("Not declared type");
    }
}

package gt.edu.usac.ingenieria.lang.statpy.expression;

import gt.edu.usac.ingenieria.Variables;
import gt.edu.usac.ingenieria.lang.statpy.PrimitiveType;

import java.util.ArrayList;

public class CallJson extends Expression{
    Expression file;
    Expression key;
    Object jsonConten;

    public CallJson(int line, int column, Expression file, Expression key) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.CALLJSON);
        this.file = file;
        this.key = key;
    }

    @Override
    public String toPython() {
        return null;
    }

    @Override
    public Value evaluate() {
        //System.out.println((String) file.evaluate().value());
        Object obj = Variables.getInstance().jsonVars.get((String) file.evaluate().value()).getValue((String) key.evaluate().value());
        //System.out.println(key.evaluate().value());
        //System.out.println(Variables.getInstance().jsonVars.get(((String) file.evaluate().value())));
        if (obj instanceof String){
            return new Value((String) obj, PrimitiveType.STRING);
        } else {
            return new Value((Double) obj, PrimitiveType.DOUBLE);
        }
    }
}

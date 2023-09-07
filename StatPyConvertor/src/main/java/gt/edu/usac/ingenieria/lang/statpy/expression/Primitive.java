package gt.edu.usac.ingenieria.lang.statpy.expression;

import gt.edu.usac.ingenieria.lang.statpy.PrimitiveType;

public class Primitive extends Expression{
    PrimitiveType primitiveType;
    public Object object;
    public Primitive(int line, int column, Object object, PrimitiveType primitiveType) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.PRIMITIVE);
        this.primitiveType = primitiveType;
        this.object = object;
    }

    @Override
    public String toPython() {
        return switch (primitiveType){
            case INT -> (String) object;
            case DOUBLE -> (String) object;
            case BOOLEAN -> ((String) object).equals("true") ? "True" : "False";
            case CHAR -> (String) object;
            case STRING -> ((String) object);
            default -> "";
        };
    }
}

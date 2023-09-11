package gt.edu.usac.ingenieria.lang.statpy.expression;

import gt.edu.usac.ingenieria.lang.statpy.PrimitiveType;

public class Primitive extends Expression{
    PrimitiveType primitiveType;
    public Object object;
    public Primitive(int line, int column, Object object, PrimitiveType primitiveType) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.PRIMITIVE);
        this.primitiveType = primitiveType;
        this.object = object;

        if (primitiveType == PrimitiveType.STRING){
            this.object = ((String) object).substring(1, ((String) object).length()-1);
        }
    }

    @Override
    public String toPython() {
        return switch (primitiveType){
            case INT -> (String) object;
            case DOUBLE -> (String) object;
            case BOOLEAN -> ((String) object).equalsIgnoreCase("true") ? "True" : "False";
            case CHAR -> "'"+(String) object+"'";
            case STRING -> "\""+((String) object)+"\"";
            default -> "";
        };
    }

    @Override
    public Value evaluate() {
        return new Value(
                switch (primitiveType){
                    case INT -> Integer.valueOf((String) object);
                    case DOUBLE -> Double.valueOf((String) object);
                    case BOOLEAN -> Boolean.valueOf((String) object);
                    case CHAR -> (Character) object;
                    //case STRING -> ((String) object).substring(1,((String) object).length() -1);
                    case STRING -> ((String) object);
                }, primitiveType);
    }
}

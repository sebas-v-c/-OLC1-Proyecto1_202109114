package gt.edu.usac.ingenieria.lang.statpy.expression;

import gt.edu.usac.ingenieria.lang.statpy.PrimitiveType;

import java.util.Objects;

public class Math extends Expression{
    String sign;
    Expression left;
    Expression right;
    public Math(int line, int column, Expression left, String sign, Expression right) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.MATH);
        this.sign = sign;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toPython() {
        StringBuilder str = new StringBuilder();
        try {
            str.append(left.toPython()).append(" ");
        } catch (Exception ignored){}
        str.append(sign).append(" ").append(right.toPython());

        return str.toString();
    }

    @Override
    public Value evaluate() {
        Value leftVal = left.evaluate();
        Value rightval = right.evaluate();
        if ((leftVal.value() instanceof Number) && (rightval.value() instanceof Number)){
            Double n = processNum((Number) leftVal.value(), (Number) rightval.value());
            if ((leftVal.type() == PrimitiveType.DOUBLE) || (rightval.type() == PrimitiveType.DOUBLE)){
                return new Value(n, PrimitiveType.DOUBLE);
            } else {
                return new Value(n.intValue(), PrimitiveType.INT);
            }
        }
        if ((leftVal.type() == PrimitiveType.STRING) || (rightval.type() == PrimitiveType.STRING)){
            if (sign.equals("+")){
                String s = String.valueOf(leftVal.value()) + String.valueOf(rightval.value());
                return new Value(s, PrimitiveType.STRING);
            } else {
                throw new IllegalArgumentException("Cant operate a String like that");
            }
        }

        throw new IllegalArgumentException("Cant do math");
    }

    private Double processNum(Number n1, Number n2){
        Double db1 = Double.valueOf((Double) n1);
        Double db2 = Double.valueOf((Double) n2);
        return switch (sign){
            case "+" -> db1 + db2;
            case "-" -> db1 - db2;
            case "*" -> db1 * db2;
            case "/" -> db1 / db2;
            default -> throw new IllegalStateException("Unexpected value: " + sign);
        };
    }
}

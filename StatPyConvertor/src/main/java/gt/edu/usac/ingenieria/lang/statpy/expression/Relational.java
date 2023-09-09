package gt.edu.usac.ingenieria.lang.statpy.expression;

import gt.edu.usac.ingenieria.lang.statpy.PrimitiveType;

import java.util.Objects;

public class Relational extends Expression{
    String sign;
    public Expression left;
    public Expression right;
    public RelType relType;
    public Relational(int line, int column, Expression left, String sign, Expression right) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.RELATIONAL);
        this.sign = sign;
        this.left = left;
        this.right = right;
        switch (sign) {
            case "<=" -> relType = RelType.LEQ;
            case ">=" -> relType = RelType.GEQ;
            case "==" -> relType = RelType.EQEQ;
            case "!=" -> relType = RelType.NOTEQ;
            case "<" -> relType = RelType.LESS;
            case ">" -> relType = RelType.GREATER;
        }
    }

    @Override
    public String toPython() {
        StringBuilder str = new StringBuilder();

        str.append(left.toPython()).append(" ").append(sign).append(" ").append(right.toPython());

        return str.toString();
    }

    @Override
    public Value evaluate() {
        Value leftVal = left.evaluate();
        Value rightval = right.evaluate();
        if (leftVal.type() != rightval.type()){
            throw new IllegalArgumentException("Objects aren't the same type");
        }

        return new Value(
                switch (leftVal.type()){
                    case INT -> compareValues((Integer) leftVal.value(), (Integer) rightval.value());
                    case DOUBLE -> compareValues((Double) leftVal.value(), (Double) rightval.value());
                    case BOOLEAN -> compareBool((Boolean) leftVal.value(), (Boolean) rightval.value());
                    case CHAR -> compareChar((char) leftVal.value(), (char) rightval.value());
                    case STRING -> compareString((String) leftVal.value(), (String) rightval.value());
                    },
                PrimitiveType.BOOLEAN
        );
    }

    private boolean compareString(String b1, String b2){
        return switch (relType){
            case EQEQ -> Objects.equals(b1, b2);
            case NOTEQ -> !Objects.equals(b1, b2);
            default -> throw new IllegalArgumentException("Cant do that opperation");
        };
    }
    private boolean compareChar(char b1, char b2){
        return switch (relType){
            case EQEQ -> b1 == b2;
            case NOTEQ -> b1 != b2;
            default -> throw new IllegalArgumentException("Cant do that opperation");
        };
    }
    private boolean compareBool(Boolean b1, Boolean b2){
        return switch (relType){
            case EQEQ -> b1 == b2;
            case NOTEQ -> b1 != b2;
            default -> throw new IllegalArgumentException("Cant do that opperation");
        };
    }

    private boolean compareValues(Integer num1, Integer num2){
        return switch (relType){
            case GEQ -> num1 >= num2;
            case LEQ -> num1 <= num2;
            case EQEQ -> Objects.equals(num1, num2);
            case NOTEQ -> !Objects.equals(num1, num2);
            case GREATER -> num1 > num2;
            case LESS -> num1 < num2;
        };

    }

    private boolean compareValues(Double num1, Double num2){
        return switch (relType){
            case GEQ -> num1 >= num2;
            case LEQ -> num1 <= num2;
            case EQEQ -> Objects.equals(num1, num2);
            case NOTEQ -> !Objects.equals(num1, num2);
            case GREATER -> num1 > num2;
            case LESS -> num1 < num2;
        };

    }
}

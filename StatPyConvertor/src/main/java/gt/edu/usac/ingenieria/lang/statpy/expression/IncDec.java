package gt.edu.usac.ingenieria.lang.statpy.expression;

import gt.edu.usac.ingenieria.Variables;

public class IncDec extends Expression{
    public String sign;
    String id;
    public IncDec(int line, int column, String sign, String id) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.INCDEC);
        this.sign = sign;
        this.id = id;
    }

    @Override
    public String toPython() {
        return switch (sign) {
            case "++" -> id + " += " + "1";
            case "--" -> id + " -= " + "1";
            default -> "";
        };
    }

    @Override
    public Value evaluate() {
        return null;
    }
}

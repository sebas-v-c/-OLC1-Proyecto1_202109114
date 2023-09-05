package gt.edu.usac.ingenieria.lang.statpy.expression;

public class IncDec extends Expression{
    String sign;
    String id;
    public IncDec(int line, int column, String sign, String id) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.INCDEC);
        this.sign = sign;
        this.id = id;
    }
}

package gt.edu.usac.ingenieria.lang.statpy.expression;

public class Logic extends Expression{
    String sign;
    Expression left;
    Expression right;
    public Logic(int line, int column, Expression left, String sign, Expression right) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.LOGIC);
        this.sign = sign;
        this.left = left;
        this.right = right;
    }
    public Logic(int line, int column, String sign, Expression right) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.LOGIC);
        this.sign = sign;
        this.right = right;
    }

    @Override
    public String toPython() {
        return null;
    }
}

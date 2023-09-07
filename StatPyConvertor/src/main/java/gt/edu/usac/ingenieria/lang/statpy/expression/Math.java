package gt.edu.usac.ingenieria.lang.statpy.expression;

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
        return null;
    }
}
package gt.edu.usac.ingenieria.lang.statpy.expression;

public class Relational extends Expression{
    String sign;
    Expression left;
    Expression right;
    public Relational(int line, int column, String sign, Expression left, Expression right) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.RELATIONAL);
        this.sign = sign;
        this.left = left;
        this.right = right;
    }
}

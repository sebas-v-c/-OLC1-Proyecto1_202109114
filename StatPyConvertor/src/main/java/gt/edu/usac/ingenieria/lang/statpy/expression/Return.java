package gt.edu.usac.ingenieria.lang.statpy.expression;

public class Return extends Expression{
    Expression exp;
    public Return(int line, int column, Expression exp) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.RETURN);
        this.exp = exp;
    }

    @Override
    public String toPython() {
        return null;
    }
}

package gt.edu.usac.ingenieria.lang.statpy.expression;

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
    public void execute() {
        // TODO
    }

}

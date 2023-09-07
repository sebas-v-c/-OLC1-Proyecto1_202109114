package gt.edu.usac.ingenieria.lang.statpy.expression;

public class AccesId extends Expression{
    String id;
    public AccesId(int line, int column, String id) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.ACCES_ID);
        this.id = id;
    }

    @Override
    public String toPython() {
        return null;
    }
}

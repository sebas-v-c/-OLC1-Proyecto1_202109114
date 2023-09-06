package gt.edu.usac.ingenieria.lang.statpy.sentence;

import gt.edu.usac.ingenieria.lang.statpy.expression.ExpType;
import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;

public class ReasignId extends Sentence{
    public String id;
    Expression exp;

    public ReasignId(int line, int column, String id, Expression exp) {
        super(line, column, SentType.REASIGN_ID);
        this.id = id;
        this.exp = exp;
    }

    @Override
    public String toPython() {
        return null;
    }
}

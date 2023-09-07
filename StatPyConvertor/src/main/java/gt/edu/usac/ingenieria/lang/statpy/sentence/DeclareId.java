package gt.edu.usac.ingenieria.lang.statpy.sentence;

import gt.edu.usac.ingenieria.lang.statpy.expression.ExpType;
import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;

public class DeclareId extends Sentence{
    public String id;
    public Expression expression;
    public DeclareId(int line, int column, String id, Expression expression) {
        super(line, column, SentType.DECLARE_ID);
        this.id = id;
        this.expression = expression;
    }

    @Override
    public String toPython() {
        StringBuilder str = new StringBuilder();
        str.append(id).append(" = ");
        if (expression != null){
            str.append(expression.toPython());
        } else {
            str.append("None");
        }
        return  str.toString();
    }
}

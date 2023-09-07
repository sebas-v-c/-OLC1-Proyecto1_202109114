package gt.edu.usac.ingenieria.lang.statpy.sentence;

import gt.edu.usac.ingenieria.Variables;
import gt.edu.usac.ingenieria.classes.Environment;
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
        return id + " = " + exp.toPython();
    }

    @Override
    public void execute() {
        try {
            Variables.getInstance().graphVars.updateVar(id, exp.evaluate());
        } catch (Environment.IDNotFoundException e) {
            System.out.println("Variable not yet declared");
            System.out.println(e);
        }
    }
}

package gt.edu.usac.ingenieria.lang.statpy.sentence;

import gt.edu.usac.ingenieria.Variables;
import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;

import java.util.ArrayList;

public class DeclareArr extends Sentence{
    public String id;
    ArrayList<Expression> expressions;
    public ArrayList<Object> arrVals;
    public DeclareArr(int line, int column, String id, ArrayList<Expression> expressions) {
        super(line, column, SentType.DECLARE_ARR);
        this.id = id;
        this.expressions = expressions;
    }

    @Override
    public String toPython() {
        return null;
    }

    @Override
    public void execute() {
        for (Expression exp : expressions){
            arrVals.add(exp.evaluate());
        }
    }
}

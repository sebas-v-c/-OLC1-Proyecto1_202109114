package gt.edu.usac.ingenieria.lang.statpy.sentence;

import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;

import java.util.ArrayList;

public class DeclareArr extends Sentence{
    String id;
    ArrayList<Expression> expressions;
    public DeclareArr(int line, int column, String id, ArrayList<Expression> expressions) {
        super(line, column, SentType.DECLARE_ARR);
        this.id = id;
        this.expressions = expressions;
    }

    @Override
    public String toPython() {
        return null;
    }
}

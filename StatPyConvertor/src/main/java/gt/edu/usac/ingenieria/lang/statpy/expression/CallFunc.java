package gt.edu.usac.ingenieria.lang.statpy.expression;

import java.util.ArrayList;

public class CallFunc extends Expression{
    String id;
    ArrayList<Expression> args;
    public CallFunc(int line, int column, String id, ArrayList<Expression> args) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.CALLFUNC);
        this.id = id;
        this.args = args;
    }

    @Override
    public String toPython() {
        return null;
    }
}

package gt.edu.usac.ingenieria.lang.statpy.expression;

import java.util.ArrayList;

public class CallJson extends Expression{
    ArrayList<Expression> args;

    public CallJson(int line, int column, ArrayList<Expression> args) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.CALLJSON);
        this.args = args;
    }
}

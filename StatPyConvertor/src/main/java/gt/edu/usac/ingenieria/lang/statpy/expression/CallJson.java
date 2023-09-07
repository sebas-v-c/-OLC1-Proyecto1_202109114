package gt.edu.usac.ingenieria.lang.statpy.expression;

import java.util.ArrayList;

public class CallJson extends Expression{
    Expression file;
    Expression key;

    public CallJson(int line, int column, Expression file, Expression key) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.CALLJSON);
        this.file = file;
        this.key = key;
    }

    @Override
    public String toPython() {
        return null;
    }
}

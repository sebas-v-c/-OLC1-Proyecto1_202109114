package gt.edu.usac.ingenieria.lang.statpy.expression;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.Type;

public abstract class Expression extends Instruction {
    ExpType ExpType;

    public Expression(int line, int column, ExpType expType) {
        super(line, column, Type.EXPRESSION);
        this.ExpType = expType;
    }
}

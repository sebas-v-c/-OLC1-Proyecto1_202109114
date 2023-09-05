package gt.edu.usac.ingenieria.lang.statpy.instructions.expression;

import gt.edu.usac.ingenieria.lang.statpy.instructions.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.instructions.Type;

public class Expression extends Instruction {
    ExpType ExpType;

    public Expression(int line, int column, ExpType expType) {
        super(line, column, Type.EXPRESSION);
        this.ExpType = expType;
    }
}

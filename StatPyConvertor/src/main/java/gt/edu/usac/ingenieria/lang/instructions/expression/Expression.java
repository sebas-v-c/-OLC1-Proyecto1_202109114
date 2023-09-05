package gt.edu.usac.ingenieria.lang.instructions.expression;

import gt.edu.usac.ingenieria.lang.instructions.Instruction;
import gt.edu.usac.ingenieria.lang.instructions.Type;

public class Expression extends Instruction {
    ExpType ExpType;

    public Expression(int line, int column, ExpType expType) {
        super(line, column, Type.EXPRESSION);
        this.ExpType = expType;
    }
}

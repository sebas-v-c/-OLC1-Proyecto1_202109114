package gt.edu.usac.ingenieria.lang.instruction.expression;

import gt.edu.usac.ingenieria.lang.instruction.Instruction;
import gt.edu.usac.ingenieria.lang.instruction.Type;

public class Expression extends Instruction {
    ExpType ExpType;

    public Expression(int line, int column, ExpType expType) {
        super(line, column, Type.EXPRESSION);
        this.ExpType = expType;
    }
}

package gt.edu.usac.ingenieria.lang.instruction.structure;

import gt.edu.usac.ingenieria.lang.instruction.Instruction;
import gt.edu.usac.ingenieria.lang.instruction.Type;

public class Structure extends Instruction {
    StructType structType;
    public Structure(int line, int column, StructType structType) {
        super(line, column, Type.EXPRESSION);
        this.structType = structType;
    }
}

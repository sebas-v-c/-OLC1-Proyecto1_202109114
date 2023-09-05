package gt.edu.usac.ingenieria.lang.instructions.structure;

import gt.edu.usac.ingenieria.lang.instructions.Instruction;
import gt.edu.usac.ingenieria.lang.instructions.Type;

public class Structure extends Instruction {
    StructType structType;
    public Structure(int line, int column, StructType structType) {
        super(line, column, Type.EXPRESSION);
        this.structType = structType;
    }
}

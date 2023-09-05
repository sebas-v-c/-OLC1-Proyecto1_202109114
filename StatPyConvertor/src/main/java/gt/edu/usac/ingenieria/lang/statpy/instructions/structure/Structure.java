package gt.edu.usac.ingenieria.lang.statpy.instructions.structure;

import gt.edu.usac.ingenieria.lang.statpy.instructions.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.instructions.Type;

public class Structure extends Instruction {
    StructType structType;
    public Structure(int line, int column, StructType structType) {
        super(line, column, Type.EXPRESSION);
        this.structType = structType;
    }
}

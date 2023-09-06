package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.Type;

public abstract class Structure extends Instruction {
    StructType structType;
    public Structure(int line, int column, StructType structType) {
        super(line, column, Type.EXPRESSION);
        this.structType = structType;
    }

    public abstract String toPython();
}

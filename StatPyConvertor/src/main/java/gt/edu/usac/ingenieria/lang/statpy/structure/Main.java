package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;

import java.util.ArrayList;

public class Main extends Structure{
    ArrayList<Instruction> instructions;
    public Main(int line, int column, ArrayList<Instruction> instruction) {
        super(line, column, StructType.MAIN);
        this.instructions = instruction;
    }

    @Override
    public String toPython() {
        return null;
    }
}

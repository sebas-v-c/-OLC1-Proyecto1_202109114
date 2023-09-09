package gt.edu.usac.ingenieria.lang.statpy.graph;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;

import java.util.ArrayList;

public class Pie extends Graph{
    public ArrayList<Instruction> instructions;
    public Pie(int line, int column, ArrayList<Instruction> instructions) {
        super(line, column, GraphType.PIE);
        this.instructions = instructions;
    }

    @Override
    public void execute() {
        for (Instruction inst : instructions){
            inst.execute();
        }
    }
}

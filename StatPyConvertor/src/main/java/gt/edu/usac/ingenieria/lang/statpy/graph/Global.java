package gt.edu.usac.ingenieria.lang.statpy.graph;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;

import java.util.ArrayList;

public class Global extends Graph{
    public ArrayList<Instruction> instructions;
    public Global(int line, int column, ArrayList<Instruction> instructions) {
        super(line, column, GraphType.GLOBAL);
        this.instructions = instructions;
    }

    @Override
    public void execute() {
        //TODO
        for (Instruction inst : instructions){
            inst.execute();
        }
    }
}

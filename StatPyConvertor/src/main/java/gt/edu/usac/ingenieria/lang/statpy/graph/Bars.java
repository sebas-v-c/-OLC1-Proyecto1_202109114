package gt.edu.usac.ingenieria.lang.statpy.graph;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;

import java.util.ArrayList;

public class Bars extends Graph{
    ArrayList<Instruction> instructions;
    public Bars(int line, int column, ArrayList<Instruction> instructions) {
        super(line, column, GraphType.BARS);
        this.instructions = instructions;
    }

    @Override
    public void execute() {
        for (Instruction inst : instructions){
            inst.execute();
        }
    }
}

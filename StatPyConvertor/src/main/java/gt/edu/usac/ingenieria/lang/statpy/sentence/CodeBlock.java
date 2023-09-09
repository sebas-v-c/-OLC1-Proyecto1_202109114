package gt.edu.usac.ingenieria.lang.statpy.sentence;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;

import java.util.ArrayList;

public class CodeBlock extends Sentence{
    public ArrayList<Instruction> instructions;
    public CodeBlock(int line, int column, ArrayList<Instruction> instructions) {
        super(line, column, SentType.CODE_BLOCK);
        this.instructions = instructions;
    }

    @Override
    public String toPython() {
        StringBuilder str= new StringBuilder();

        for (Instruction inst : instructions){
            str.append(inst.toPython()).append("\n");
        }
        return str.toString();
    }

    @Override
    public void execute() {
        /*
        for (Instruction inst : instructions){
            inst.execute();
        }
         */
    }
}

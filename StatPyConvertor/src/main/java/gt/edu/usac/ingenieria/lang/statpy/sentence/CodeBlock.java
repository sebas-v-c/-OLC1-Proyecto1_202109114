package gt.edu.usac.ingenieria.lang.statpy.sentence;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;

import java.util.ArrayList;

public class CodeBlock extends Sentence{
    ArrayList<Instruction> instructions;
    public CodeBlock(int line, int column, ArrayList<Instruction> instructions) {
        super(line, column, SentType.CODE_BLOCK);
        this.instructions = instructions;
    }
}

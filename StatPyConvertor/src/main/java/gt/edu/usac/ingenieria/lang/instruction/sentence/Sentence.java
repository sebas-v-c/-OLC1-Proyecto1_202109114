package gt.edu.usac.ingenieria.lang.instruction.sentence;

import gt.edu.usac.ingenieria.lang.instruction.Instruction;
import gt.edu.usac.ingenieria.lang.instruction.Type;

public class Sentence extends Instruction {
    SentType sentType;
    public Sentence(int line, int column, SentType sentType) {
        super(line, column, Type.SENTENCE);
        this.sentType = sentType;
    }
}

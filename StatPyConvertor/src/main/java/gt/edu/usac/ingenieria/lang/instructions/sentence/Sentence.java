package gt.edu.usac.ingenieria.lang.instructions.sentence;

import gt.edu.usac.ingenieria.lang.instructions.Instruction;
import gt.edu.usac.ingenieria.lang.instructions.Type;

public class Sentence extends Instruction {
    SentType sentType;
    public Sentence(int line, int column, SentType sentType) {
        super(line, column, Type.SENTENCE);
        this.sentType = sentType;
    }
}

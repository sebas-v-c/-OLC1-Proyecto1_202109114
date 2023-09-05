package gt.edu.usac.ingenieria.lang.statpy.instructions.sentence;

import gt.edu.usac.ingenieria.lang.statpy.instructions.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.instructions.Type;

public class Sentence extends Instruction {
    SentType sentType;
    public Sentence(int line, int column, SentType sentType) {
        super(line, column, Type.SENTENCE);
        this.sentType = sentType;
    }
}

package gt.edu.usac.ingenieria.lang.statpy.sentence;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.Type;

public abstract class Sentence extends Instruction {
    SentType sentType;
    public Sentence(int line, int column, SentType sentType) {
        super(line, column, Type.SENTENCE);
        this.sentType = sentType;
    }

    public abstract String toPython();
}

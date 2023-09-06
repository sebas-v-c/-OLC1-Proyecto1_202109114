package gt.edu.usac.ingenieria.lang.statpy.sentence;

public class ControlRW extends Sentence{
    public ControlRW(int line, int column) {
        super(line, column, SentType.CONTROL_RW);
    }

    @Override
    public String toPython() {
        return null;
    }
}

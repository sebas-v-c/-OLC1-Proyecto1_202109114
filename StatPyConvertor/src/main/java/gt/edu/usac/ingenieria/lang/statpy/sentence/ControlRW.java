package gt.edu.usac.ingenieria.lang.statpy.sentence;

public class ControlRW extends Sentence{
    String crw;
    public ControlRW(int line, int column, String crw) {
        super(line, column, SentType.CONTROL_RW);
        this.crw = crw;
    }

    @Override
    public String toPython() {
        return null;
    }
}

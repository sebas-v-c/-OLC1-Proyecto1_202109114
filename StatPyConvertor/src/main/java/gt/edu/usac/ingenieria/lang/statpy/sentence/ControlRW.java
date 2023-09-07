package gt.edu.usac.ingenieria.lang.statpy.sentence;

public class ControlRW extends Sentence{
    public String crw;
    public ControlRW(int line, int column, String crw) {
        super(line, column, SentType.CONTROL_RW);
        this.crw = crw;
    }

    @Override
    public String toPython() {
        return crw;
    }

    @Override
    public void execute() {

    }
}

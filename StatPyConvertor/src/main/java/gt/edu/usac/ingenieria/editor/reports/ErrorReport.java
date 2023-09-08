package gt.edu.usac.ingenieria.editor.reports;

import gt.edu.usac.ingenieria.analyzer.errors.LexError;
import gt.edu.usac.ingenieria.analyzer.errors.SynError;

import java.util.ArrayList;

public class ErrorReport extends Report{

    private final ArrayList<LexError> lexErrors;
    private final ArrayList<SynError> synErrors;
    public ErrorReport(ArrayList<LexError> lexErrors, ArrayList<SynError> synErrors) {
        this.lexErrors = lexErrors;
        this.synErrors = synErrors;
    }

    @Override
    public void generateReport() throws Exception {

    }
}

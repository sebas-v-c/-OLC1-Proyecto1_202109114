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
        StringBuilder htmlTable = new StringBuilder();

        // table headlines
        htmlTable.append("<table border='1'>\n");
        htmlTable.append("<tr><th>Lexema</th><th>Descripción</th><th>Linea</th><th>Columna</th></tr>\n");

        // data from the list
        for (LexError lexeme : lexErrors) {
            htmlTable.append("<tr>");
            htmlTable.append("<td>").append(lexeme.getCharacter()).append("</td>");
            htmlTable.append("<td>").append("Error Léxico").append("</td>");
            htmlTable.append("<td>").append(lexeme.getLine()).append("</td>");
            htmlTable.append("<td>").append(lexeme.getColumn()).append("</td>");
            htmlTable.append("</tr>\n");
        }

        // close table
        htmlTable.append("</table>");

        saveReport(htmlTable.toString());
        openHTMLFile(filePath);
    }
}

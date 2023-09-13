package gt.edu.usac.ingenieria.editor.reports;

import gt.edu.usac.ingenieria.analyzer.errors.LexError;
import gt.edu.usac.ingenieria.analyzer.errors.SynError;

import java.util.ArrayList;
import java.util.Map;

public class ErrorReport extends Report{

    private ArrayList<LexError> lexErrors;
    private ArrayList<SynError> synErrors;
    private StringBuilder htmlTable = new StringBuilder();
    public String filename;
    public ErrorReport(){
        super();
    }
    public ErrorReport(ArrayList<LexError> lexErrors, ArrayList<SynError> synErrors){
        super();
        this.lexErrors = lexErrors;
        this.synErrors = synErrors;
    }

    @Override
    public void buildReport(String reportName) {
        if (filename != null){
            htmlTable.append("<H2>").append(filename).append("</H2>");
        }

        // table headlines
        htmlTable.append("<table border='1'>\n");
        htmlTable.append("<tr><th>Lexema</th><th>Descripción</th><th>Linea</th><th>Columna</th></tr>\n");

        // data from the list
        try {
            for (LexError lexeme : lexErrors) {
                htmlTable.append("<tr>");
                htmlTable.append("<td>").append(lexeme.getCharacter()).append("</td>");
                htmlTable.append("<td>").append("Error Léxico").append("</td>");
                htmlTable.append("<td>").append(lexeme.getLine()).append("</td>");
                htmlTable.append("<td>").append(lexeme.getColumn()).append("</td>");
                htmlTable.append("</tr>\n");
            }
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Error generando reporte de errros");
        }
        // close table
        htmlTable.append("</table>");
    }

    public void loadTables(String reportName){
        super.reports.put(reportName, htmlTable.toString());
        filename = null;
        htmlTable = new StringBuilder();
    }

    public void setErrors(ArrayList<LexError> lexErrors, ArrayList<SynError> synErrors){
        this.lexErrors = lexErrors;
        this.synErrors = synErrors;
    }

}

package gt.edu.usac.ingenieria.editor.reports;

import gt.edu.usac.ingenieria.editor.Mode;
import java_cup.runtime.Symbol;

import java.util.ArrayList;
import java.util.HashMap;

public class TokenReport extends Report{
    private ArrayList<Symbol> symbols;
    public String filename;
    private StringBuilder htmlTable = new StringBuilder();
    public Mode mode;
    public TokenReport(ArrayList<Symbol> symbols, Mode mode) {
        super();
        this.symbols = symbols;
        this.mode = mode;
    }

    public TokenReport(ArrayList<Symbol> symbols, String filename,Mode mode){
        super();
        this.symbols = symbols;
        this.filename = filename;
        this.mode = mode;
    }


    public TokenReport(Mode mode) {
        super();
        this.mode = mode;
    }

    @Override
    public void buildReport(String reportName) {


        if ((filename != null) && (mode == Mode.JSON)){
            htmlTable.append("<H2>").append(filename).append("</H2>");
        }

        // Encabezados de la tabla
        htmlTable.append("<table border='1'>\n");
        htmlTable.append("<tr><th>Lexema</th><th>Token</th><th>Linea</th><th>Columna</th></tr>\n");

        // Datos de la lista
        try {

            for (Symbol token : symbols) {
                if(token.value == null){
                    break;
                }
                htmlTable.append("<tr>");
                htmlTable.append("<td>").append(token.value).append("</td>");
                if (mode == Mode.JSON){
                    htmlTable.append("<td>").append(gt.edu.usac.ingenieria.analyzer.json.SYM.terminalNames[token.sym]).append("</td>");
                } else {
                    htmlTable.append("<td>").append(gt.edu.usac.ingenieria.analyzer.statpy.SYM.terminalNames[token.sym]).append("</td>");
                }


                htmlTable.append("<td>").append(token.left).append("</td>");
                htmlTable.append("<td>").append(token.right).append("</td>");
                htmlTable.append("</tr>\n");
            }
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Error generando reporte de errros");
        }

        // Cierre de la tabla
        htmlTable.append("</table>");

    }
    public void loadTables(String reportName){
        super.reports.put(reportName, htmlTable.toString());
        htmlTable = new StringBuilder();
    }

    public void setSymbols(ArrayList<Symbol> symbols){
        this.symbols = symbols;
    }
}

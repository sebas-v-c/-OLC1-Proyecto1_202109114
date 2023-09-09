package gt.edu.usac.ingenieria.editor.reports;

import java_cup.runtime.Symbol;

import java.util.ArrayList;
import java.util.HashMap;

public class TokenReport extends Report{
    private ArrayList<Symbol> symbols;
    public TokenReport(ArrayList<Symbol> symbols) {
        super();
        this.symbols = symbols;
    }

    public TokenReport() {
        super();
    }

    @Override
    public void buildReport(String reportName) {

        StringBuilder htmlTable = new StringBuilder();

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
                htmlTable.append("<td>").append(gt.edu.usac.ingenieria.analyzer.json.SYM.terminalNames[token.sym]).append("</td>");
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

        super.reports.put(reportName, htmlTable.toString());
    }

    public void setSymbols(ArrayList<Symbol> symbols){
        this.symbols = symbols;
    }
}

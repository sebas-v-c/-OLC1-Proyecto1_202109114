package gt.edu.usac.ingenieria.editor.reports;

import java_cup.runtime.Symbol;

import java.util.ArrayList;

public class TokenReport extends Report{
    private ArrayList<Symbol> symbols;
    public TokenReport(ArrayList<Symbol> symbols) {
        super();
        this.symbols = symbols;
    }

    @Override
    public void generateReport() throws Exception {
        StringBuilder htmlTable = new StringBuilder();

        // Encabezados de la tabla
        htmlTable.append("<table border='1'>\n");
        htmlTable.append("<tr><th>Lexema</th><th>Token</th><th>Linea</th><th>Columna</th></tr>\n");

        // Datos de la lista
        for (Symbol token : symbols) {
            htmlTable.append("<tr>");
            htmlTable.append("<td>").append(token.value).append("</td>");
            htmlTable.append("<td>").append(gt.edu.usac.ingenieria.analyzer.statpy.SYM.terminalNames[token.sym]).append("</td>");
            htmlTable.append("<td>").append(token.left).append("</td>");
            htmlTable.append("<td>").append(token.right).append("</td>");
            htmlTable.append("</tr>\n");
        }

        // Cierre de la tabla
        htmlTable.append("</table>");
        saveReport(htmlTable.toString());
        openHTMLFile(filePath);
    }
}

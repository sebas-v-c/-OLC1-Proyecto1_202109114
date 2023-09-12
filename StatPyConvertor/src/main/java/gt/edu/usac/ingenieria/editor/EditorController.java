package gt.edu.usac.ingenieria.editor;

import gt.edu.usac.ingenieria.Variables;
import gt.edu.usac.ingenieria.analyzer.errors.LexError;
import gt.edu.usac.ingenieria.analyzer.errors.SynError;
import gt.edu.usac.ingenieria.analyzer.json.JsonLexer;
import gt.edu.usac.ingenieria.analyzer.json.JsonParser;
import gt.edu.usac.ingenieria.analyzer.statpy.STPLexer;
import gt.edu.usac.ingenieria.analyzer.statpy.STPParser;
import gt.edu.usac.ingenieria.classes.Json;
import gt.edu.usac.ingenieria.editor.chart.ChartFrame;
import gt.edu.usac.ingenieria.editor.listeners.ExecuteListener;
import gt.edu.usac.ingenieria.editor.listeners.SaveListener;
import gt.edu.usac.ingenieria.editor.reports.ErrorReport;
import gt.edu.usac.ingenieria.editor.reports.TokenReport;
import gt.edu.usac.ingenieria.lang.json.KeyVal;
import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.Type;
import gt.edu.usac.ingenieria.lang.statpy.expression.Value;
import gt.edu.usac.ingenieria.lang.statpy.graph.*;
import gt.edu.usac.ingenieria.lang.statpy.sentence.DeclareArr;
import gt.edu.usac.ingenieria.lang.statpy.sentence.DeclareId;
import gt.edu.usac.ingenieria.lang.statpy.sentence.SentType;
import gt.edu.usac.ingenieria.lang.statpy.sentence.Sentence;
import gt.edu.usac.ingenieria.lang.statpy.structure.StructType;
import gt.edu.usac.ingenieria.lang.statpy.structure.Structure;
import java_cup.runtime.Symbol;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EditorController {
    public final EditorView view;
    public Mode analyzer = Mode.STATPY;
    public String filePath;
    public String currentStatpyS = "";
    public ArrayList<LexError> lexJsonErrors = new ArrayList<>();
    public ArrayList<LexError> lexStpErrors = new ArrayList<>();
    public ArrayList<SynError> synJsonErrors = new ArrayList<>();
    public ArrayList<SynError> synStpErrors = new ArrayList<>();
    public ArrayList<Symbol> stpSymbols = new ArrayList<>();
    public ArrayList<Symbol> jsonSymbols = new ArrayList<>();
    public EditorController(EditorView view) {
        this.view = view;

        view.addMOpenListener(new OpenFileListener());
        view.addMSaveListener(new SaveListener.SaveFileListener(this));
        view.addMSaveAsListener(new SaveListener.SaveAsFileListener(this));
        view.addExecButtonListener(new ExecuteListener(this));
        view.addMReportErrorsListener(new ReportErrorsListener());
        view.addMReportTokensListener(new ReportTokensListener());
        view.addCleaButtonListener(new ClearListener());
        view.addMStatPyListener(e -> {
            if (analyzer != Mode.STATPY){
                view.cleanTextAreas();
            }
            analyzer = Mode.STATPY;
            view.setEntryTextArea(currentStatpyS);
            view.setExecButtonText("Ejecutar");
            view.setAnalysisLabelText("StatPy");
        });
        view.addMJsonListener(e -> {
            if (analyzer != Mode.JSON){
                view.cleanTextAreas();
            }
            view.setExecButtonText("Cargar");
            analyzer = Mode.JSON;
            view.setAnalysisLabelText("JSON");
        });
    }

    private class OpenFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // JFileChooser configuration
            UIManager.put("FileChooser.readOnly", Boolean.TRUE);
            String currentDir = System.getProperty("user.dir");
            JFileChooser chooser = getjFileChooser(currentDir);

            int returnval = chooser.showOpenDialog(null);
            if (returnval == JFileChooser.APPROVE_OPTION){
                String filepath = chooser.getSelectedFile().getPath();
                filePath = filepath;
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filepath));
                    String line;
                    view.cleanTextAreas();
                    //StringBuilder str = new StringBuilder();
                    while ((line = br.readLine()) != null){
                        view.appendEntryTextArea(line + "\n");
                        //str.append(line).append("\n");
                    }
                    //currentStatpyS = str.toString();
                    br.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }

        private JFileChooser getjFileChooser(String currentDir) {
            JFileChooser chooser = new JFileChooser(currentDir);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter filter;

            switch (analyzer){
                case STATPY -> filter = new FileNameExtensionFilter("Archivos StatPy (*.stp)", "sp");
                case JSON -> filter = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");
                default -> throw new IllegalStateException("Unexpected value: " + analyzer);
            }
            chooser.setFileFilter(filter);
            return chooser;
        }
    }

    private class ReportErrorsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ErrorReport report = new ErrorReport(lexJsonErrors, synJsonErrors);
            report.buildReport("Json Errors");
            report.setErrors(lexStpErrors, synStpErrors);
            report.buildReport("StatPy Errors");

            report.generateReport();
        }
    }
    private class ReportTokensListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TokenReport report = new TokenReport(jsonSymbols, Mode.JSON);
            report.buildReport("Json Tokens");
            report.setSymbols(stpSymbols);
            report.mode = Mode.STATPY;
            report.buildReport("StatPy Tokens");

            report.generateReport();
        }
    }

    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Variables.getInstance().graphVars.clearEnv();
            view.setSelectedStatPy(false);
            synJsonErrors.clear();
            synStpErrors.clear();
            lexJsonErrors.clear();
            lexStpErrors.clear();
            Variables.getInstance().jsonVars = new HashMap<>();
            view.setLoadedJsonsText(String.valueOf(0));
            currentStatpyS = "";
            view.showOkMessagedialog("Archivos Eliminados");
        }
    }
}

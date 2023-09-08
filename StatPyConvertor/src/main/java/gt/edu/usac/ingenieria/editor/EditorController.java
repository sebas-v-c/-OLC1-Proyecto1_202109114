package gt.edu.usac.ingenieria.editor;

import gt.edu.usac.ingenieria.Variables;
import gt.edu.usac.ingenieria.analyzer.errors.LexError;
import gt.edu.usac.ingenieria.analyzer.errors.SynError;
import gt.edu.usac.ingenieria.analyzer.json.JsonLexer;
import gt.edu.usac.ingenieria.analyzer.json.JsonParser;
import gt.edu.usac.ingenieria.analyzer.statpy.STPLexer;
import gt.edu.usac.ingenieria.analyzer.statpy.STPParser;
import gt.edu.usac.ingenieria.classes.Json;
import gt.edu.usac.ingenieria.lang.json.KeyVal;
import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.Type;
import gt.edu.usac.ingenieria.lang.statpy.graph.*;
import gt.edu.usac.ingenieria.lang.statpy.sentence.DeclareArr;
import gt.edu.usac.ingenieria.lang.statpy.sentence.DeclareId;
import gt.edu.usac.ingenieria.lang.statpy.sentence.SentType;
import gt.edu.usac.ingenieria.lang.statpy.sentence.Sentence;
import gt.edu.usac.ingenieria.lang.statpy.structure.Main;
import gt.edu.usac.ingenieria.lang.statpy.structure.StructType;
import gt.edu.usac.ingenieria.lang.statpy.structure.Structure;
import java_cup.runtime.Symbol;
import junit.framework.Assert;

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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EditorController {
    private final EditorView view;
    private Mode analyzer = Mode.STATPY;
    private String filePath;
    private String currentStatpyS = "";
    private ArrayList<LexError> lexJsonErrors;
    private ArrayList<LexError> lexStpErrors;
    private ArrayList<SynError> synJsonErrors;
    private ArrayList<SynError> synStpErrors;
    public EditorController(EditorView view) {
        this.view = view;

        view.addMOpenListener(new OpenFileListener());
        view.addMSaveListener(new SaveFileListener());
        view.addMSaveAsListener(new SaveAsFileListener());
        view.addExecButtonListener(new ExecuteListener());
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

    private class SaveFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (filePath == null){
                SaveAsFileListener savadfile = new SaveAsFileListener();
                savadfile.actionPerformed(e);
                return;
            }
            String extension;
            switch (analyzer){
                case STATPY -> extension = ".sp";
                case JSON -> extension = ".json";
                default -> throw new IllegalStateException("Unexpected value: " + analyzer);
            }

            try {
                if (!filePath.endsWith(extension)){
                    filePath += extension;
                }

                Path path = Path.of(filePath);
                Files.write(path, view.getEntryTextArea().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private class SaveAsFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // JFileChooser configuration
            UIManager.put("FileChooser.openButtonText", "Save");
            String currentDir = System.getProperty("user.dir");
            JFileChooser chooser = new JFileChooser(currentDir);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter filter;
            String extension;

            filter = switch (analyzer) {
                case STATPY -> {
                    extension = "sp";
                    yield new FileNameExtensionFilter("Archivos StatPy (*.stp)", extension);
                }
                case JSON -> {
                    extension = "json";
                    yield new FileNameExtensionFilter("Archivos JSON (*.json)", extension);
                }
                default -> throw new IllegalStateException("Unexpected value: " + analyzer);
            };
            chooser.setFileFilter(filter);

            int returnval = chooser.showOpenDialog(null);
            if (returnval == JFileChooser.APPROVE_OPTION){
                File file = chooser.getSelectedFile();
                String filepath = chooser.getSelectedFile().getAbsolutePath();
                filePath = filepath;
                if (!filepath.endsWith("." + extension)){
                    filepath += "." + extension;
                    file = new File(filepath);
                }

                try {
                    Path path = Path.of(filepath);
                    Files.write(path, view.getEntryTextArea().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }

    // TODO create execute method
    // the execute either traduce or analyze only
    private class ExecuteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (analyzer) {
                case STATPY -> {
                    executeStatPy();
                    view.setSelectedStatPy(true);
                }
                case JSON -> {
                    loadJson();
                    view.setLoadedJsonsText(String.valueOf(Variables.getInstance().jsonVars.size()));
                }
            }

        }

        // This should thow an exception
        private void executeStatPy() {
            STPLexer scannerstp = null;
            STPParser parserstp = null;
            Symbol parseSymbolstp = null;
            currentStatpyS = view.getEntryTextArea();
            try {
                BufferedReader br = new BufferedReader(new StringReader(view.getEntryTextArea()));
                scannerstp = new STPLexer(br);
                parserstp = new STPParser(scannerstp);
                //parseSymbol = parser.debug_parse();
                parseSymbolstp = parserstp.parse();
                /*
                CODE TO TRADUCE TO PYTHON
                 */
                for (Instruction inst: parserstp.inst) {
                    try{
                        if (((Structure) inst).structType == StructType.MAIN){
                            view.setOutTextArea(inst.toPython());
                        }
                    } catch (Exception e){
                        // TODO display an error message
                    }
                }
                /*
                CODE TO LOAD A GRAPH
                 */
                for (Graph graph: parserstp.graphs){
                    try {
                        switch (graph.graphType){
                            case GLOBAL -> traverseGlobalMethod(((Global) graph).instructions);
                            case BARS -> traverseBarsMethod(((Bars) graph).instructions);
                            case PIE -> traversePieMethod(((Pie) graph).instructions);
                        }
                    } catch (Exception e){
                        // TODO display an error message
                    }
                }
            } catch (IOException e){
            } catch (Exception e) {
            }

            if (!parserstp.getErrors().isEmpty()) {
                synStpErrors = parserstp.getErrors();
            }
            if (!scannerstp.getErrors().isEmpty()) {
                lexJsonErrors = scannerstp.getErrors();
            }
        }

        private void traverseGlobalMethod(ArrayList<Instruction> instructions){
            for (Instruction ins: instructions){
                ins.execute();
                if (ins.type == Type.SENTENCE){
                    if (((Sentence) ins).sentType == SentType.DECLARE_ID){
                        DeclareId dcId = ((DeclareId) ins);
                        Variables.getInstance().graphVars.updateGlobalsValue(dcId.id, dcId.varVal);
                    } else if (((Sentence) ins).sentType == SentType.DECLARE_ARR) {
                        DeclareArr dcArr = ((DeclareArr) ins);
                        Variables.getInstance().graphVars.updateGlobalsValue(dcArr.id, dcArr.arrVals);
                    }
                }
            }
        }

        private void traverseBarsMethod(ArrayList<Instruction> instructions){
            for (Instruction ins: instructions){
                ins.execute();
                if (ins.type == Type.SENTENCE){
                    if (((Sentence) ins).sentType == SentType.DECLARE_ID){
                        DeclareId dcId = ((DeclareId) ins);
                        Variables.getInstance().graphVars.updateBarsValue(dcId.id, dcId.varVal);
                    } else if (((Sentence) ins).sentType == SentType.DECLARE_ARR) {
                        DeclareArr dcArr = ((DeclareArr) ins);
                        Variables.getInstance().graphVars.updateBarsValue(dcArr.id, dcArr.arrVals);
                    }
                }
            }
        }

        private void traversePieMethod(ArrayList<Instruction> instructions){
            for (Instruction ins: instructions){
                ins.execute();
                if (ins.type == Type.SENTENCE){
                    if (((Sentence) ins).sentType == SentType.DECLARE_ID){
                        DeclareId dcId = ((DeclareId) ins);
                        Variables.getInstance().graphVars.updatePieValue(dcId.id, dcId.varVal);
                    } else if (((Sentence) ins).sentType == SentType.DECLARE_ARR) {
                        DeclareArr dcArr = ((DeclareArr) ins);
                        Variables.getInstance().graphVars.updatePieValue(dcArr.id, dcArr.arrVals);
                    }
                }
            }
        }



        // This should thow an exception
        private void loadJson() {
            JsonLexer scanner;
            JsonParser parser = null;
            Symbol parseSymbol = null;
            try {
                String fileName = Path.of(filePath).getFileName().toString();
                BufferedReader br = new BufferedReader(new StringReader(view.getEntryTextArea()));
                scanner = new JsonLexer(br);
                parser = new JsonParser(scanner);
                parseSymbol = parser.parse();
                Variables.getInstance().jsonVars.put(fileName, new Json());
                for (KeyVal cont : parser.content) {
                    Variables.getInstance().jsonVars.get(fileName).addKeyValue(cont.id, cont.getVal());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (!parser.getErrors().isEmpty()) {
                synJsonErrors = parser.getErrors();
            }
            if (!scanner.getErrors().isEmpty()) {
                lexJsonErrors = scanner.getErrors();
            }
        }
    }

    // TODO generate errors report
    private class ReportErrorsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    // TODO generate tokens report
    private class ReportTokensListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Variables.getInstance().graphVars.clearEnv();
            view.setSelectedStatPy(false);
            Variables.getInstance().jsonVars = new HashMap<>();
            view.setLoadedJsonsText(String.valueOf(0));
            currentStatpyS = "";
        }
    }
}

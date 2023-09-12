package gt.edu.usac.ingenieria.editor.listeners;

import gt.edu.usac.ingenieria.Variables;
import gt.edu.usac.ingenieria.analyzer.json.JsonLexer;
import gt.edu.usac.ingenieria.analyzer.json.JsonParser;
import gt.edu.usac.ingenieria.analyzer.statpy.STPLexer;
import gt.edu.usac.ingenieria.analyzer.statpy.STPParser;
import gt.edu.usac.ingenieria.classes.Json;
import gt.edu.usac.ingenieria.editor.EditorController;
import gt.edu.usac.ingenieria.editor.chart.ChartFrame;
import gt.edu.usac.ingenieria.lang.json.KeyVal;
import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.Type;
import gt.edu.usac.ingenieria.lang.statpy.expression.Value;
import gt.edu.usac.ingenieria.lang.statpy.graph.Bars;
import gt.edu.usac.ingenieria.lang.statpy.graph.Global;
import gt.edu.usac.ingenieria.lang.statpy.graph.Graph;
import gt.edu.usac.ingenieria.lang.statpy.graph.Pie;
import gt.edu.usac.ingenieria.lang.statpy.sentence.DeclareArr;
import gt.edu.usac.ingenieria.lang.statpy.sentence.DeclareId;
import gt.edu.usac.ingenieria.lang.statpy.sentence.SentType;
import gt.edu.usac.ingenieria.lang.statpy.sentence.Sentence;
import gt.edu.usac.ingenieria.lang.statpy.structure.StructType;
import gt.edu.usac.ingenieria.lang.statpy.structure.Structure;
import java_cup.runtime.Symbol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.StringReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class ExecuteListener implements ActionListener {
    private EditorController controller;
    public ExecuteListener(EditorController controller){
        this.controller = controller;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (controller.analyzer) {
            case STATPY -> {
                controller.lexStpErrors.clear(); controller.synStpErrors.clear();
                scanStatPy();
                executeStatPy();
                Variables.getInstance().graphVars.clearEnv();
                controller.view.setSelectedStatPy(true);
            }
            case JSON -> {
                controller.lexJsonErrors.clear(); controller.synJsonErrors.clear();
                scanJson();
                loadJson();
                controller.view.setLoadedJsonsText(String.valueOf(Variables.getInstance().jsonVars.size()));
            }
        }

    }
    private void scanJson(){
        JsonLexer scanner = null;
        Symbol parseSymbol = null;
        try{
            BufferedReader br = new BufferedReader(new StringReader(controller.view.getEntryTextArea()));
            scanner = new JsonLexer(br);
            do {
                parseSymbol = scanner.next_token();
                controller.jsonSymbols.add(parseSymbol);
            } while (parseSymbol.value != null);
        } catch (Exception e) {}
    }
    private void scanStatPy(){
        STPLexer scanner = null;
        Symbol parseSymbol = null;
        try{
            BufferedReader br = new BufferedReader(new StringReader(controller.view.getEntryTextArea()));
            scanner = new STPLexer(br);
            do {
                parseSymbol = scanner.next_token();
                controller.stpSymbols.add(parseSymbol);
            } while (parseSymbol.value != null);
        } catch (Exception e) {}
    }

    // This should thow an exception
    private void executeStatPy() {
        STPLexer scannerstp = null;
        STPParser parserstp = null;
        Symbol parseSymbolstp = null;
        controller.currentStatpyS = controller.view.getEntryTextArea();
        try {
            BufferedReader br = new BufferedReader(new StringReader(controller.view.getEntryTextArea()));
            scannerstp = new STPLexer(br);
            parserstp = new STPParser(scannerstp);
            parseSymbolstp = parserstp.parse();
                /*
                CODE TO TRADUCE TO PYTHON
                 */
            for (Instruction inst: parserstp.inst) {
                try{
                    if (((Structure) inst).structType == StructType.MAIN){
                        controller.view.setOutTextArea(inst.toPython());
                    }
                } catch (Exception e){
                    controller.view.showErrorMessage("Ha habido un error traduciendo el archivo");
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
                } catch (Exception e){}
            }
        } catch (Exception e) {
            controller.view.showErrorMessage("Ha ocurrido un error");
        }

        generateCharts();

        if (!parserstp.getErrors().isEmpty()) {
            controller.synStpErrors = parserstp.getErrors();
            controller.view.showWarningMessage("Existen Errores Sintacticos");
        }
        if (!scannerstp.getErrors().isEmpty()) {
            controller.lexStpErrors = scannerstp.getErrors();
            controller.view.showWarningMessage("Existen Errores Lexicos");
        }
    }

    private void generateCharts(){
        try {
            for (HashMap<String, Object> hs : Variables.getInstance().graphVars.getBars()) {
                ArrayList<Value> tempArr = (ArrayList<Value>) hs.get("ejex");
                String[] xAxisArr = new String[tempArr.size()];
                for (int i = 0; i < tempArr.size(); i++) {
                    xAxisArr[i] = (String) tempArr.get(i).value();

                }
                tempArr = (ArrayList<Value>) hs.get("valores");
                Double[] values = new Double[tempArr.size()];
                for (int i = 0; i < tempArr.size(); i++) {
                    values[i] = (Double) tempArr.get(i).value();
                }

                ChartFrame chartFrame = new ChartFrame(
                        (String) ((Value) hs.get("titulo")).value(),
                        xAxisArr,
                        values,
                        (String) ((Value) hs.get("titulox")).value(),
                        (String) ((Value) hs.get("tituloy")).value()
                );
                chartFrame.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chartFrame.dispose();
                    }
                });
            }
        } catch (Exception e){
            controller.view.showErrorMessage("No se pudo generar la grafica de Barras");
        }

        try {
            for (HashMap<String, Object> hs : Variables.getInstance().graphVars.getPie()) {
                ArrayList<Value> tempArr = (ArrayList<Value>) hs.get("ejex");
                String[] xAxisArr = new String[tempArr.size()];
                for (int i = 0; i < tempArr.size(); i++) {
                    xAxisArr[i] = (String) tempArr.get(i).value();

                }

                tempArr = (ArrayList<Value>) hs.get("valores");
                Double[] values = new Double[tempArr.size()];
                for (int i = 0; i < tempArr.size(); i++) {
                    values[i] = (Double) tempArr.get(i).value();
                }

                ChartFrame ch = new ChartFrame(
                        (String) ((Value) hs.get("titulo")).value(),
                        xAxisArr,
                        values
                );
                ch.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ch.dispose();
                    }
                });
            }
        } catch (Exception e){
            controller.view.showErrorMessage("No se pudo generar la grafica de Pie");
        }
    }

    private void traverseGlobalMethod(ArrayList<Instruction> instructions){
        for (Instruction ins: instructions){
            ins.execute();
            if (ins.type == Type.SENTENCE){
                if (((Sentence) ins).sentType == SentType.DECLARE_ID){
                    DeclareId dcId = ((DeclareId) ins);
                    Variables.getInstance().graphVars.updateGlobalsValue(dcId.id.toLowerCase(), dcId.varVal);
                } else if (((Sentence) ins).sentType == SentType.DECLARE_ARR) {
                    DeclareArr dcArr = ((DeclareArr) ins);
                    Variables.getInstance().graphVars.updateGlobalsValue(dcArr.id.toLowerCase(), dcArr.arrVals);
                }
            }
        }
    }

    private void traverseBarsMethod(ArrayList<Instruction> instructions){
        Variables.getInstance().graphVars.addNewBars();
        for (Instruction ins: instructions){
            ins.execute();
            if (ins.type == Type.SENTENCE){
                if (((Sentence) ins).sentType == SentType.DECLARE_ID){
                    DeclareId dcId = ((DeclareId) ins);
                    Variables.getInstance().graphVars.updateBarsValue(dcId.id.toLowerCase(), dcId.varVal);
                } else if (((Sentence) ins).sentType == SentType.DECLARE_ARR) {
                    DeclareArr dcArr = ((DeclareArr) ins);
                    Variables.getInstance().graphVars.updateBarsValue(dcArr.id.toLowerCase(), dcArr.arrVals);
                }
            }
        }
    }

    private void traversePieMethod(ArrayList<Instruction> instructions){
        Variables.getInstance().graphVars.addNewPie();
        for (Instruction ins: instructions){
            ins.execute();
            if (ins.type == Type.SENTENCE){
                if (((Sentence) ins).sentType == SentType.DECLARE_ID){
                    DeclareId dcId = ((DeclareId) ins);
                    Variables.getInstance().graphVars.updatePieValue(dcId.id.toLowerCase(), dcId.varVal);
                } else if (((Sentence) ins).sentType == SentType.DECLARE_ARR) {
                    DeclareArr dcArr = ((DeclareArr) ins);
                    Variables.getInstance().graphVars.updatePieValue(dcArr.id.toLowerCase(), dcArr.arrVals);
                }
            }
        }
    }

    private void loadJson() {
        JsonLexer scanner;
        JsonParser parser = null;
        Symbol parseSymbol = null;
        try {
            String fileName = Path.of(controller.filePath).getFileName().toString();
            BufferedReader br = new BufferedReader(new StringReader(controller.view.getEntryTextArea()));
            scanner = new JsonLexer(br);
            parser = new JsonParser(scanner);
            parseSymbol = parser.parse();
            Variables.getInstance().jsonVars.put(fileName, new Json());
            for (int i = 0; i < parser.content.size(); i++){
                try{
                    KeyVal keyVal = parser.content.get(i);
                    Variables.getInstance().jsonVars.get(fileName).addKeyValue(keyVal.id, keyVal.getVal());
                } catch (Exception e){}
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!parser.getErrors().isEmpty()) {
            controller.synJsonErrors = parser.getErrors();
            controller.view.showWarningMessage("Existen Errores Sintacticos");
        }
        if (!scanner.getErrors().isEmpty()) {
            controller.lexJsonErrors = scanner.getErrors();
            controller.view.showWarningMessage("Existen Errores Lexicos");
        }

        controller.view.showMessageDialog("Archivo Json Cargado");
    }
}

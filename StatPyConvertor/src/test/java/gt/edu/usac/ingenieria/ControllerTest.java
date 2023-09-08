package gt.edu.usac.ingenieria;

import gt.edu.usac.ingenieria.analyzer.errors.SynError;
import gt.edu.usac.ingenieria.analyzer.json.JsonLexer;
import gt.edu.usac.ingenieria.analyzer.json.JsonParser;
import gt.edu.usac.ingenieria.analyzer.statpy.SPTParserTest;
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
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerTest {
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Test
    public void TestController(){
        // switch for test file
        String fileName = "src/main/resources/ejemploJSON.json";
        String file = "ejemplo.json";

        JsonLexer scanner;
        JsonParser parser = null;
        Symbol parseSymbol = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            scanner = new JsonLexer(br);
            parser = new JsonParser(scanner);
            //parseSymbol = parser.debug_parse();
            parseSymbol = parser.parse();
            System.out.println("------------------------------------------------------");
            System.out.println("       I N S T R U C T I O N S  I N  F I L E");
            System.out.println("------------------------------------------------------");

            Variables.getInstance().jsonVars.put(file, new Json());
            for (KeyVal cont: parser.content) {
                Variables.getInstance().jsonVars.get(file).addKeyValue(cont.id, cont.getVal());
            }
        } catch (Exception e){
            Logger.getLogger(ControllerTest.class.getName()).log(Level.SEVERE, null, e);
        }
        if (!parser.getErrors().isEmpty()){
            logger.log(Level.INFO, "Errors founded in the parser");
            for (SynError error : parser.getErrors()) {
                error.print();
            }
            Assert.assertFalse(true);
        }

        if (parseSymbol == null){
            Assert.assertFalse(true);
        } else {
            Assert.assertEquals(0, parseSymbol.sym);
        }

        boolean testFile = false;
        fileName = "src/main/resources/" + (testFile ? "dummy" : "ejemplo") + ".sp";

        STPLexer scannerstp;
        STPParser parserstp = null;
        Symbol parseSymbolstp = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            scannerstp = new STPLexer(br);
            parserstp = new STPParser(scannerstp);
            //parseSymbol = parser.debug_parse();
            parseSymbolstp = parserstp.parse();
            int i = 1;
            for (Instruction inst: parserstp.inst) {
                try{
                    if (((Structure) inst).structType == StructType.MAIN){
                        System.out.println("Aun no hay errores 1");
                        String result = inst.toPython();
                        for (Instruction in: ((Main) inst).instructions){
                            System.out.println("Aun no hay errores 2");
                            if (in.type == Type.GRAPH){
                                System.out.println("Aun no hay errores 3");
                                if (((Graph) in).graphType == GraphType.GLOBAL){
                                    System.out.println("Aun no hay errores 4");
                                    traverseGlobalMethod(((Global) in).instructions);
                                } else if (((Graph) in).graphType == GraphType.BARS){
                                    System.out.println("Aun no hay errores 5");
                                    traverseBarsMethod(((Bars) in).instructions);
                                } else if (((Graph) in).graphType == GraphType.PIE){
                                    System.out.println("Aun no hay errores 6");
                                    traversePieMethod(((Pie) in).instructions);
                                }
                            }
                        }
                    }
                } catch (Exception e){
                    System.out.println(e);
                    System.out.println("Un error qlerisimo we");
                    //Assert.assertFalse(true);
                }
            }

            System.out.println("VARIABLES GLOBALES");
            for (Map.Entry<String, Object> entry: Variables.getInstance().graphVars.globals.entrySet()){
                System.out.println("KEY: "+ entry.getKey() + " Value: " + entry.getValue().toString());
            }
            System.out.println("VARIABLES DE BARRAS");
            for (Map.Entry<String, Object> entry: Variables.getInstance().graphVars.bars.entrySet()){
                System.out.println("KEY: "+ entry.getKey() + " Value: " + entry.getValue().toString());
            }
            System.out.println("VARIABLES DE PIE");
            for (Map.Entry<String, Object> entry: Variables.getInstance().graphVars.pie.entrySet()){
                System.out.println("KEY: "+ entry.getKey() + " Value: " + entry.getValue().toString());
            }

            System.out.println("------------------------------------------------------");
            System.out.println("                  F I N I S H E D");
            System.out.println("------------------------------------------------------");

        } catch (IOException e){
            logger.log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(ControllerTest.class.getName()).log(Level.SEVERE, null, e);
        }

        if (!parserstp.getErrors().isEmpty()){
            logger.log(Level.INFO, "Errors founded in the parser");
            for (SynError error : parserstp.getErrors()) {
                error.print();
            }
            Assert.assertFalse(true);
        }

        if (parseSymbolstp == null){
            Assert.assertFalse(true);
        } else {
            Assert.assertEquals(0, parseSymbolstp.sym);
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
        int i = 0;
        for (Instruction ins: instructions){
            ins.execute();
            i++;
            System.out.println("Error en la instruccion " + i);
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
}

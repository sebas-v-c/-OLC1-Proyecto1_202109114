package gt.edu.usac.ingenieria;

import gt.edu.usac.ingenieria.analyzer.errors.SynError;
import gt.edu.usac.ingenieria.analyzer.statpy.SPTParserTest;
import gt.edu.usac.ingenieria.analyzer.statpy.STPLexer;
import gt.edu.usac.ingenieria.analyzer.statpy.STPParser;
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
        STPLexer scanner;
        STPParser parser = null;
        Symbol parseSymbol = null;
        // switch for test file
        boolean testFile = false;
        String fileName = "src/main/resources/" + (testFile ? "dummy" : "ejemplo") + ".sp";

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            scanner = new STPLexer(br);
            parser = new STPParser(scanner);
            //parseSymbol = parser.debug_parse();
            parseSymbol = parser.parse();
            System.out.println("------------------------------------------------------");
            System.out.println("       I N S T R U C T I O N S  I N  F I L E");
            System.out.println("------------------------------------------------------");

            for (Instruction inst: parser.inst) {
                try{
                    if (((Structure) inst).structType == StructType.MAIN){
                        String result = inst.toPython();
                        for (Instruction in: ((Main) inst).instructions){
                            if (in.type == Type.GRAPH){
                                if (((Graph) in).graphType == GraphType.GLOBAL){
                                    traverseGlobalMethod(((Global) in).instructions);
                                } else if (((Graph) in).graphType == GraphType.BARS){
                                    traverseBarsMethod(((Bars) in).instructions);
                                } else if (((Graph) in).graphType == GraphType.PIE){
                                    traversePieMethod(((Pie) in).instructions);
                                }
                            }
                        }
                    }
                } catch (Exception e){
                    System.out.println(e);
                    System.out.println("Un error qlerisimo we");
                }
            }

            for (Map.Entry<String, Object> entry: Variables.getInstance().graphVars.globals.entrySet()){
                System.out.println("KEY: "+ entry.getKey() + " Value: " + entry.getValue());
            }

            System.out.println("------------------------------------------------------");
            System.out.println("                  F I N I S H E D");
            System.out.println("------------------------------------------------------");

        } catch (IOException e){
            logger.log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(SPTParserTest.class.getName()).log(Level.SEVERE, null, e);
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
}

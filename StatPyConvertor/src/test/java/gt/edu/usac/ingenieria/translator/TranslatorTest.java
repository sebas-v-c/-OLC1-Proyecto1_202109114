package gt.edu.usac.ingenieria.translator;

import gt.edu.usac.ingenieria.Variables;
import gt.edu.usac.ingenieria.analyzer.errors.SynError;
import gt.edu.usac.ingenieria.analyzer.statpy.SPTParserTest;
import gt.edu.usac.ingenieria.analyzer.statpy.STPLexer;
import gt.edu.usac.ingenieria.analyzer.statpy.STPParser;
import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.structure.StructType;
import gt.edu.usac.ingenieria.lang.statpy.*;
import gt.edu.usac.ingenieria.lang.statpy.expression.*;
import gt.edu.usac.ingenieria.lang.statpy.graph.*;
import gt.edu.usac.ingenieria.lang.statpy.sentence.*;
import gt.edu.usac.ingenieria.lang.statpy.structure.*;
import java_cup.runtime.Symbol;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TranslatorTest {

    Logger logger = Logger.getLogger(this.getClass().getName());
    @Test
    public void TestPythonTranslator(){
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
            /*
            System.out.println("------------------------------------------------------");
            System.out.println("       I N S T R U C T I O N S  I N  F I L E");
            System.out.println("------------------------------------------------------");
             */

            for (Instruction inst: parser.inst) {
                try{
                    if (((Structure) inst).structType == StructType.MAIN){
                        /*
                        System.out.print(inst.toPython());
                         */
                    }
                    /*
                    for (Instruction instruction : ((Main) inst).instructions){
                        logger.log(Level.OFF, instruction.toString());
                    }
                     */
                } catch (Exception e){
                    System.out.println(e);
                    System.out.println("Un error qlerisimo we");
                }
            }

            /*
            for (Map.Entry<String, Object> entry: Variables.getInstance().graphVars.globals.entrySet()){
                System.out.println("KEY: "+ entry.getKey() + " Value: " + entry.getValue());
            }

             */

            /*
            System.out.println("------------------------------------------------------");
            System.out.println("                  F I N I S H E D");
            System.out.println("------------------------------------------------------");
             */

        } catch (IOException e){
            logger.log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(TranslatorTest.class.getName()).log(Level.SEVERE, null, e);
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
}

package gt.edu.usac.ingenieria.analyzer.json;

import gt.edu.usac.ingenieria.analyzer.errors.SynError;
import gt.edu.usac.ingenieria.analyzer.statpy.SPTParserTest;
import gt.edu.usac.ingenieria.analyzer.statpy.STPLexer;
import gt.edu.usac.ingenieria.analyzer.statpy.STPParser;
import gt.edu.usac.ingenieria.lang.json.KeyVal;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonObjectTest {

    Logger logger = Logger.getLogger(this.getClass().getName());
    @Test
    public void TestPythonTranslator(){
        JsonLexer scanner;
        JsonParser parser = null;
        Symbol parseSymbol = null;
        String fileName = "src/main/resources/ejemploJSON.json";

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            scanner = new JsonLexer(br);
            parser = new JsonParser(scanner);
            //parseSymbol = parser.debug_parse();
            parseSymbol = parser.parse();
            /*
            System.out.println("------------------------------------------------------");
            System.out.println("       I N S T R U C T I O N S  I N  F I L E");
            System.out.println("------------------------------------------------------");

            for (KeyVal cont: parser.content) {
                    System.out.println(cont.getVal());
            }
            System.out.println("------------------------------------------------------");
            System.out.println("                  F I N I S H E D");
            System.out.println("------------------------------------------------------");
             */
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
}

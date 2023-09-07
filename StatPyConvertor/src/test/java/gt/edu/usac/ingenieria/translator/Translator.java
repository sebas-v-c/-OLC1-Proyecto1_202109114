package gt.edu.usac.ingenieria.translator;

import gt.edu.usac.ingenieria.analyzer.errors.SynError;
import gt.edu.usac.ingenieria.analyzer.statpy.SPTParserTest;
import gt.edu.usac.ingenieria.analyzer.statpy.STPLexer;
import gt.edu.usac.ingenieria.analyzer.statpy.STPParser;
import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import java_cup.runtime.Symbol;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Translator {

    Logger logger = Logger.getLogger(this.getClass().getName());
    @Test
    public void TestPythonTranslator(){
        STPLexer scanner;
        STPParser parser = null;
        Symbol parseSymbol = null;
        // switch for test file
        boolean testFile = true;
        String fileName = "src/main/resources/" + (testFile ? "dummy" : "ejemplo") + ".sp";

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            scanner = new STPLexer(br);
            parser = new STPParser(scanner);
            //parseSymbol = parser.debug_parse();
            parseSymbol = parser.parse();
            System.out.println("INSTRUCTIONS IN FILE");
            for (Instruction inst: parser.inst) {
                System.out.println();
            }
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

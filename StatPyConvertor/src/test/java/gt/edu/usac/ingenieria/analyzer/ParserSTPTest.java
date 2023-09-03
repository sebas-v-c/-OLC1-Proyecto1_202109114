package gt.edu.usac.ingenieria.analyzer;

import gt.edu.usac.ingenieria.analyzer.statpy.STPLexer;
import gt.edu.usac.ingenieria.analyzer.statpy.STPParser;
import java_cup.runtime.Symbol;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ParserSTPTest {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Test
    public void testInputFile(){
        STPLexer scanner;
        STPParser parser = null;
        Symbol parseSymbol = null;
        String fileName = "dummy";

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + fileName + ".sp"));
            scanner = new STPLexer(br);
            parser = new STPParser(scanner);
            parseSymbol = parser.debug_parse();
            //parseSymbol = parser.parse();
        } catch (FileNotFoundException e){
            logger.log(Level.SEVERE, null, e);
        } catch (IOException e){
            logger.log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(ParserSTPTest.class.getName()).log(Level.SEVERE, null, e);
        }

        if (parseSymbol == null){
            Assert.assertFalse(true);
        } else {
            Assert.assertEquals(0, parseSymbol.sym);
        }
    }
}

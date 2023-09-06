package gt.edu.usac.ingenieria.analyzer.json;

import gt.edu.usac.ingenieria.analyzer.errors.SynError;
import gt.edu.usac.ingenieria.analyzer.statpy.SPTParserTest;
import java_cup.runtime.Symbol;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonParserTest {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Test
    public void testInputFile(){
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

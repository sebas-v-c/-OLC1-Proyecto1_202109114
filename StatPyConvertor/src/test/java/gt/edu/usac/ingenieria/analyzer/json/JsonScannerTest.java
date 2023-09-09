package gt.edu.usac.ingenieria.analyzer.json;

import gt.edu.usac.ingenieria.analyzer.errors.LexError;
import gt.edu.usac.ingenieria.analyzer.statpy.SPTParserTest;
import java_cup.runtime.Symbol;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonScannerTest {

    Logger logger = Logger.getLogger(this.getClass().getName());
    @Test
    public void testInputFile() {
        JsonLexer scanner = null;
        JsonParser parser = null;
        Symbol parseSymbol = null;
        String fileName = "src/main/resources/ejemploJSON.json";

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            scanner = new JsonLexer(br);
            /*
            System.out.println(
                    "TOKEN" + " ".repeat(25 - "TOKEN".length()) +
                            "LINE" + " ".repeat(6 - "LINE".length()) +
                            "COLUMN" + " ".repeat(8 - "COLUMN".length()) +
                            "TYPE"
            );
             */

            do {
                parseSymbol = scanner.next_token();
                /*
                System.out.println(
                        parseSymbol.value + " ".repeat(25 - String.valueOf(parseSymbol.value).length()) +
                                parseSymbol.left + " ".repeat(6 - String.valueOf(parseSymbol.left).length()) +
                                parseSymbol.right + " ".repeat(8 - String.valueOf(parseSymbol.right).length()) +
                                gt.edu.usac.ingenieria.analyzer.json.SYM.terminalNames[parseSymbol.sym]
                );

                 */
            } while (parseSymbol.value != null);

            if (scanner.getErrors().size() > 0) {
                logger.log(Level.INFO, "Errors founded in the scanner");
                for (LexError error : scanner.getErrors()) {
                    error.print();
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(SPTParserTest.class.getName()).log(Level.SEVERE, null, e);
        }

        if (!scanner.getErrors().isEmpty()) {
            logger.log(Level.SEVERE, "Error founded in the scanner");
            for (LexError error : scanner.getErrors()) {
                error.print();
            }
            Assert.assertFalse(true);
        }

        if (parseSymbol == null) {
            Assert.assertFalse(true);
        } else {
            Assert.assertEquals(0, parseSymbol.sym);
        }
    }
}

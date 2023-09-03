package gt.edu.usac.ingenieria;

import gt.edu.usac.ingenieria.analyzer.statpy.Parser;
import gt.edu.usac.ingenieria.analyzer.statpy.StatPyLexer;
import org.junit.jupiter.api.Test;

import java.io.StringReader;


public class ParserSTPTest {

    @Test
    public void parserAnalysis() throws Exception{
        String expression = "2*4+(6*3)$adfalksd; lfasn ";
        StatPyLexer lexer = new StatPyLexer(new StringReader(expression));
        Parser p = new Parser(lexer);
        p.error
    }
}

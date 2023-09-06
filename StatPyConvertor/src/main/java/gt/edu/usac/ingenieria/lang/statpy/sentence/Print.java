package gt.edu.usac.ingenieria.lang.statpy.sentence;

import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;

public class Print extends Sentence {
    Expression exp;
    public Print(int line, int column, Expression exp) {
        super(line, column, SentType.PRINT);
        this.exp = exp;
    }
}

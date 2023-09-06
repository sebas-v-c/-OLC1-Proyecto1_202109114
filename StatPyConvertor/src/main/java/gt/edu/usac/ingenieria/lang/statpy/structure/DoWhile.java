package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;
import gt.edu.usac.ingenieria.lang.statpy.sentence.CodeBlock;

public class DoWhile extends Structure{
    CodeBlock block;
    Expression exp;
    public DoWhile(int line, int column, CodeBlock block, Expression exp) {
        super(line, column, StructType.DOWHILE);
        this.block = block;
        this.exp = exp;
    }
}

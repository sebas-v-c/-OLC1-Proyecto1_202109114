package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;
import gt.edu.usac.ingenieria.lang.statpy.sentence.CodeBlock;

public class Case extends Structure{
    Expression exp;
    CodeBlock block;

    public Case(int line, int column, Expression exp, CodeBlock block) {
        super(line, column, StructType.IF);
        this.exp = exp;
        this.block = block;
    }
}

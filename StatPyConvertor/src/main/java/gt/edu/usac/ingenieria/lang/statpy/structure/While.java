package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.Type;
import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;
import gt.edu.usac.ingenieria.lang.statpy.sentence.CodeBlock;

public class While extends Structure{
    Expression exp;
    CodeBlock block;
    public While(int line, int column, Expression exp, CodeBlock block) {
        super(line, column, StructType.WHILE);
        this.exp = exp;
        this.block = block;
    }

    @Override
    public String toPython() {
        return null;
    }
}

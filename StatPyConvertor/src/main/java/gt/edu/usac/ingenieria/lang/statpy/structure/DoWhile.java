package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.TranslateUtils;
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

    @Override
    public String toPython() {
        StringBuilder str = new StringBuilder();

        str.append("while True:");
        str.append(TranslateUtils.tabulate(block.toPython())).append("\n");
        str.append("\tif ").append(exp.toPython()).append(":\n");
        str.append("\t\tbreak");

        return str.toString();
    }

    @Override
    public void execute() {

    }
}

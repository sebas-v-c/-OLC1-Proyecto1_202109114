package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;
import gt.edu.usac.ingenieria.lang.statpy.sentence.CodeBlock;
import org.jfree.chart.block.Block;

public class If extends Structure{
    Expression exp;
    CodeBlock block;
    Instruction else_;
    public If(int line, int column, Expression exp, CodeBlock block, Instruction else_) {
        super(line, column, StructType.IF);
        this.exp = exp;
        this.block = block;
        this.else_ = else_;
    }
}

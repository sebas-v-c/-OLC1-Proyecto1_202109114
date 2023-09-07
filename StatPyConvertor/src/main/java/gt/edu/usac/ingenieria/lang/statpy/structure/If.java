package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.TranslateUtils;
import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;
import gt.edu.usac.ingenieria.lang.statpy.sentence.CodeBlock;
import gt.edu.usac.ingenieria.lang.statpy.sentence.SentType;
import gt.edu.usac.ingenieria.lang.statpy.sentence.Sentence;
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

    @Override
    public String toPython() {
        StringBuilder str = new StringBuilder();

        str.append("if ").append(exp.toPython()).append(":");
        str.append(TranslateUtils.tabulate(block.toPython()));
        if (else_ != null){
            try {
                if (((Structure) else_).structType == StructType.IF){
                    str.append("\nel").append(else_.toPython());
                }
            } catch (Exception ignored){}

            try {
                if (((Sentence) else_).sentType == SentType.CODE_BLOCK){
                    str.append("\nelse:").append(TranslateUtils.tabulate(else_.toPython()));
                }
            } catch (Exception ignored){}
        }

        return str.toString();
    }
}

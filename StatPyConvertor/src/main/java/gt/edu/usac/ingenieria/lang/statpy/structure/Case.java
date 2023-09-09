package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.TranslateUtils;
import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;
import gt.edu.usac.ingenieria.lang.statpy.sentence.CodeBlock;
import gt.edu.usac.ingenieria.lang.statpy.sentence.ControlRW;
import gt.edu.usac.ingenieria.lang.statpy.sentence.SentType;
import gt.edu.usac.ingenieria.lang.statpy.sentence.Sentence;

import java.util.ArrayList;

public class Case extends Structure{
    Expression exp;
    CodeBlock block;

    public Case(int line, int column, Expression exp, CodeBlock block) {
        super(line, column, StructType.SWITCH);
        this.exp = exp;
        this.block = block;
    }

    @Override
    public String toPython() {
        StringBuilder str = new StringBuilder();
        str.append(exp.toPython());
        cleanBlock();
        str.append(TranslateUtils.tabulate(block.toPython()));
        return str.toString();
    }

    @Override
    public void execute() {

    }

    public void cleanBlock(){
        ArrayList<Instruction> toEliminate = new ArrayList<Instruction>();
        for(Instruction instruction : this.block.instructions){
            try {
                if (((Sentence) instruction).sentType == SentType.CONTROL_RW){
                    if (((ControlRW) instruction).crw.equals("break")){
                        toEliminate.add(instruction);
                    }
                }
            } catch (Exception ignored){}
        }
        for (Instruction instruction : toEliminate){
            this.block.instructions.remove(instruction);
        }
    }
}

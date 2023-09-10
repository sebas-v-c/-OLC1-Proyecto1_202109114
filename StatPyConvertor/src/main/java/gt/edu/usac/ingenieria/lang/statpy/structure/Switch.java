package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.TranslateUtils;
import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;
import gt.edu.usac.ingenieria.lang.statpy.sentence.CodeBlock;

import java.util.ArrayList;
import java.util.Arrays;

public class Switch extends Structure {
    Expression exp;
    ArrayList<Case> cases;
    CodeBlock deft;
    public Switch(int line, int column, Expression exp, ArrayList<Case> cases, CodeBlock deft) {
        super(line, column, StructType.SWITCH);
        this.exp = exp;
        this.cases = cases;
        this.deft = deft;
    }

    @Override
    public String toPython() {
        StringBuilder str = new StringBuilder();
        str.append("\nmatch ").append(exp.toPython()).append(" :");
        for(Case case_ : cases){
            str.append(TranslateUtils.tabulate(case_.toPython()));
        }
        if (deft != null){
            str.append(TranslateUtils.tabulate("case _ :"));
            for (Instruction inst : deft.instructions){
                str.append("\n\t\t").append(inst.toPython());
            }
        }

        return str.append("\n\n").toString();
    }

    @Override
    public void execute() {

    }
}

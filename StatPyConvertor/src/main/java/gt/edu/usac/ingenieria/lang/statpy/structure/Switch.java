package gt.edu.usac.ingenieria.lang.statpy.structure;

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
        Case firstCase = cases.remove(0);
        str.append("\nif ").append(firstCase.exp.toPython()).append(":");
        firstCase.cleanBlock();
        str.append(TranslateUtils.tabulate(firstCase.block.toPython()));
        for(Case case_ : cases){
            str.append(case_.toPython());
        }
        if (deft != null){
            str.append("\ndefault:");
            str.append("\t").append(TranslateUtils.tabulate(deft.toPython()));
        }

        return str.append("\n\n").toString();
    }

    @Override
    public void execute() {

    }
}

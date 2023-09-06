package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;
import gt.edu.usac.ingenieria.lang.statpy.sentence.CodeBlock;

import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;

public class Switch extends Structure {
    public Switch(int line, int column, Expression exp, ArrayList<Case> cases, CodeBlock deft) {
        super(line, column, StructType.SWITCH);
    }
}

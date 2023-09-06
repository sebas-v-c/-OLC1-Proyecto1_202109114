package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;

public class For extends Structure{
    String id;
    Expression exp1;
    Expression exp2;
    public For(int line, int column, String id, Expression exp1, Expression exp2) {
        super(line, column, StructType.FOR);
        this.id = id;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
}

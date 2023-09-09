package gt.edu.usac.ingenieria.lang.statpy.expression;

import java.util.ArrayList;

public class CallFunc extends Expression{
    String id;
    ArrayList<Expression> args;
    public CallFunc(int line, int column, String id, ArrayList<Expression> args) {
        super(line, column, gt.edu.usac.ingenieria.lang.statpy.expression.ExpType.CALLFUNC);
        this.id = id;
        this.args = args;
    }

    @Override
    public String toPython() {
        StringBuilder str = new StringBuilder();

        str.append(id).append("(");
        try{
            for (int i = 0; i < args.size(); i++) {
                str.append(args.get(i));
                if (i < args.size() - 1) {
                    str.append(", ");
                }
            }
        } catch (Exception ignored){}

        str.append(")");

        return str.toString();
    }

    @Override
    public Value evaluate() {
        return null;
    }


}

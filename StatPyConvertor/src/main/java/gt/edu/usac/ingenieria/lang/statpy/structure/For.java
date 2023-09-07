package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.TranslateUtils;
import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;
import gt.edu.usac.ingenieria.lang.statpy.expression.IncDec;
import gt.edu.usac.ingenieria.lang.statpy.expression.Primitive;
import gt.edu.usac.ingenieria.lang.statpy.expression.Relational;
import gt.edu.usac.ingenieria.lang.statpy.sentence.CodeBlock;
import gt.edu.usac.ingenieria.lang.statpy.sentence.DeclareId;
import gt.edu.usac.ingenieria.lang.statpy.sentence.ReasignId;
import gt.edu.usac.ingenieria.lang.statpy.sentence.Sentence;

public class For extends Structure{
    String id;
    String val;
    Sentence decid;
    Expression exp1;
    Expression exp2;
    CodeBlock block;
    public For(int line, int column, Sentence decid, Expression exp1, Expression exp2, CodeBlock block) {
        super(line, column, StructType.FOR);
        try{
            this.id = ((ReasignId) decid).id;
        } catch (Exception e){
            System.out.println(e);
        }

        try{
            this.id = ((DeclareId) decid).id;
        } catch (Exception e){
            System.out.println(e);
        }
        this.decid = decid;
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.block = block;
    }

    @Override
    public String toPython() {
        StringBuilder str = new StringBuilder();
        str.append("for ").append(((DeclareId) decid).id).append(" in range(").append(((DeclareId) decid).expression.toPython()).append(", ");
        Relational rel = (Relational) exp1;
        System.out.println(Integer.valueOf((String)((Primitive)rel.right).object) + 1);
        switch (rel.relType){
            case LEQ -> str.append(Integer.parseInt(((String)(((Primitive)rel.right).object)))+1);
            case GEQ -> str.append(Integer.parseInt(((String)(((Primitive)rel.right).object)))-1);
            case GREATER, LESS -> str.append((((Primitive)rel.right).object));
        }
        switch (((IncDec) exp2).sign) {
            case "++" -> str.append(", 1):");
            case "--" -> str.append(", -1):");
        }

        str.append(TranslateUtils.tabulate(block.toPython()));

        return str.append("\n\n").toString();
    }
}

package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.expression.Expression;
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
    public For(int line, int column, Sentence id, Expression exp1, Expression exp2, CodeBlock block) {
        super(line, column, StructType.FOR);
        try{
            this.id = ((ReasignId) id).id;
        } catch (Exception e){
            System.out.println(e);
        }

        try{
            this.id = ((DeclareId) id).id;
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
        return null;
    }
}

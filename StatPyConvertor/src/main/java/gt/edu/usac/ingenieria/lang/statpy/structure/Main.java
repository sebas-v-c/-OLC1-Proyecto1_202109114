package gt.edu.usac.ingenieria.lang.statpy.structure;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.TranslateUtils;

import java.util.ArrayList;

public class Main extends Structure{
    public ArrayList<Instruction> instructions;
    public Main(int line, int column, ArrayList<Instruction> instruction) {
        super(line, column, StructType.MAIN);
        this.instructions = instruction;
    }

    @Override
    public String toPython() {
        StringBuilder str = new StringBuilder();

        str.append("def main():");
        try{
            for (Instruction inst : instructions){
                str.append(TranslateUtils.tabulate(inst.toPython()));
            }
        } catch (Exception e){
            System.out.println(e);
            str.append(TranslateUtils.tabulate("pass")).append("\n");
        }

        str.append("\nif __name__ = \"__main__\":").append("\n").append(TranslateUtils.tabulate("main()"));

        return str.toString();
    }
}

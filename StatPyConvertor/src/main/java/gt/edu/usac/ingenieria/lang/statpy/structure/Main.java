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
                if (inst == null){
                    continue;
                }
                str.append(TranslateUtils.tabulate(inst.toPython()));
            }
        } catch (Exception e){
            System.out.println(e);
            str.append(TranslateUtils.tabulate("pass"));
        }
        str.append("\n\n");

        str.append("\nif __name__ = \"__main__\":").append(TranslateUtils.tabulate("main()\n"));

        return str.toString();
    }

    @Override
    public void execute() {

    }
}

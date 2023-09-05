package gt.edu.usac.ingenieria.lang.instruction;

public class Instruction {
    public int line;
    public int column;
    public Type type;

    public Instruction(int line, int column, Type type){
        this.line = line;
        this.column = column;
        this.type = type;
    }
}

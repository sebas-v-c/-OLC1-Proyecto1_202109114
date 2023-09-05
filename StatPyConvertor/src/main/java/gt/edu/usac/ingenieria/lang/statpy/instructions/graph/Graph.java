package gt.edu.usac.ingenieria.lang.statpy.instructions.graph;

import gt.edu.usac.ingenieria.lang.statpy.instructions.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.instructions.Type;

public class Graph extends Instruction {
    GraphType graphType;
    public Graph(int line, int column, GraphType graphType) {
        super(line, column, Type.GRAPH);
        this.graphType = graphType;
    }
}

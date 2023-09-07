package gt.edu.usac.ingenieria.lang.statpy.graph;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.Type;

public class Graph extends Instruction {
    GraphType graphType;
    public Graph(int line, int column, GraphType graphType) {
        super(line, column, Type.GRAPH);
        this.graphType = graphType;
    }

    @Override
    public String toPython() {
        return null;
    }
}

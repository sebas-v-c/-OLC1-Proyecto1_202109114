package gt.edu.usac.ingenieria.lang.statpy.graph;

import gt.edu.usac.ingenieria.lang.statpy.Instruction;
import gt.edu.usac.ingenieria.lang.statpy.Type;

public abstract class Graph extends Instruction {
    public GraphType graphType;
    public Graph(int line, int column, GraphType graphType) {
        super(line, column, Type.GRAPH);
        this.graphType = graphType;
    }

    @Override
    public String toPython() {
        return "";
    }
}

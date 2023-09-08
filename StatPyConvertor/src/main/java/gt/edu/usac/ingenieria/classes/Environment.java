package gt.edu.usac.ingenieria.classes;

import gt.edu.usac.ingenieria.lang.statpy.expression.Value;

import java.util.ArrayList;
import java.util.HashMap;

public class Environment {
    private HashMap<String, Object> globals;
    private ArrayList<HashMap<String, Object>> pie = new ArrayList<>();

    public ArrayList<HashMap<String, Object>> getPie() {
        return pie;
    }

    public ArrayList<HashMap<String, Object>> getBars() {
        return bars;
    }

    private ArrayList<HashMap<String, Object>> bars = new ArrayList<>();

    public Environment(){
        globals = new HashMap<>();
    }

    public void clearEnv(){
        globals = new HashMap<>();
        pie.clear();
        bars.clear();
    }
    public void updateVar(String id, Object val) throws IDNotFoundException {
        Object glob = getGlobalsValue(id);
        if (glob != null) {
            updateGlobalsValue(id, val);
        }
        Object pie = getPieValue(id, this.pie.size()-1);
        if (pie != null){
            updatePieValue(id, val);
        }
        Object bars = getBarsValue(id, this.bars.size()-1);
        if (bars != null){
            updateBarsValue(id, val);
        }
        throw new IDNotFoundException();

    }

    public static class IDNotFoundException extends Exception{
        public IDNotFoundException(){
            super("ID not found in the scope");
        }
    }

    public Object findVar(String id) {
        id = id.toLowerCase();
        Object glob = ((Value)getGlobalsValue(id)).value();
        if (glob != null) {
            return glob;
        }
        Object pie = ((Value)getPieValue(id, this.pie.size()-1)).value();
        if (pie != null){
            return pie;
        }
        Object bars = ((Value)getBarsValue(id, this.bars.size()-1)).value();
        if (bars != null){
            return bars;
        }

        return null;
    }

    public Object getGlobalsValue(String id){
        id = id.toLowerCase();
        return globals.get(id);
    }

    public void updateGlobalsValue(String id, Object val){
        id = id.toLowerCase();
        globals.put(id, val);
    }

    public Object getPieValue(String id, int pos){
        id = id.toLowerCase();
        return pie.get(pos).get(id);
    }

    public void updatePieValue(String id, Object val){
        id = id.toLowerCase();
        updateGraphs(id, val, pie);
    }

    private void updateGraphs(String id, Object val, ArrayList<HashMap<String, Object>> graph) {
        id = id.toLowerCase();
        if (graph.isEmpty()){
            graph.add(new HashMap<>());
            graph.get(0).put(id, val);
            return;
        }
        HashMap<String, Object> current = graph.get(graph.size()-1);
        current.put(id, val);
    }

    public void addNewPie(){
        pie.add(new HashMap<>());
    }

    public Object getBarsValue(String id, int pos){
        id = id.toLowerCase();
        return bars.get(pos).get(id);
    }

    public void updateBarsValue(String id, Object val){
        id = id.toLowerCase();
        updateGraphs(id, val, bars);
    }

    public void addNewBars(){
        bars.add(new HashMap<>());
    }

}

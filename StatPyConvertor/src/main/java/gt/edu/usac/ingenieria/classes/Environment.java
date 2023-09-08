package gt.edu.usac.ingenieria.classes;

import gt.edu.usac.ingenieria.lang.statpy.expression.Value;

import java.util.ArrayList;
import java.util.HashMap;

public class Environment {
    private HashMap<String, Object> globals;
    private ArrayList<HashMap<String, Object>> pie = new ArrayList<>();
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
        System.out.println(id);
        Object glob = ((Value)getGlobalsValue(id)).value();
        if (glob != null) {
            return glob;
        }
        Object pie = ((Value)getPieValue(id, this.pie.size()-1)).value();
        if (pie != null){
            return pie;
        }
        Object bars = ((Value)getBarsValue(id, this.pie.size()-1)).value();
        if (bars != null){
            return bars;
        }

        return null;
    }

    public Object getGlobalsValue(String id){
        return globals.get(id);
    }

    public void updateGlobalsValue(String id, Object val){
        globals.put(id, val);
    }

    public Object getPieValue(String id, int pos){
        return pie.get(pos).get(id);
    }

    public void updatePieValue(String id, Object val){
        updateGraphs(id, val, pie);
    }

    private void updateGraphs(String id, Object val, ArrayList<HashMap<String, Object>> graph) {
        if (pie.isEmpty()){
            pie.add(new HashMap<>());
            pie.get(0).put(id, val);
            return;
        }
        HashMap<String, Object> current = pie.get(pie.size()-1);
        current.put(id, val);
    }

    public void addNewPie(){
        pie.add(new HashMap<>());
    }

    public Object getBarsValue(String id, int pos){

        return bars.get(pos).get(id);
    }

    public void updateBarsValue(String id, Object val){
        updateGraphs(id, val, bars);
    }

    public void addNewBars(){
        bars.add(new HashMap<>());
    }
}

package gt.edu.usac.ingenieria.classes;

import gt.edu.usac.ingenieria.lang.statpy.expression.Value;

import java.util.HashMap;

public class Environment {
    private HashMap<String, Object> globals;
    private HashMap<String, Object> pie;
    private HashMap<String, Object> bars;

    public Environment(){
        globals = new HashMap<>();
        pie = new HashMap<>();
        bars = new HashMap<>();
    }

    public void clearEnv(){
        globals = new HashMap<>();
        pie = new HashMap<>();
        bars = new HashMap<>();
    }
    public void updateVar(String id, Object val) throws IDNotFoundException {
        Object glob = getGlobalsValue(id);
        if (glob != null) {
            updateGlobalsValue(id, val);
        }
        Object pie = getPieValue(id);
        if (pie != null){
            updatePieValue(id, val);
        }
        Object bars = getBarsValue(id);
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
        Object pie = ((Value)getPieValue(id)).value();
        if (pie != null){
            return pie;
        }
        Object bars = ((Value)getBarsValue(id)).value();
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

    public Object getPieValue(String id){
        return pie.get(id);
    }

    public void updatePieValue(String id, Object val){
        pie.put(id, val);
    }

    public Object getBarsValue(String id){
        return bars.get(id);
    }

    public void updateBarsValue(String id, Object val){
        bars.put(id, val);
    }
}

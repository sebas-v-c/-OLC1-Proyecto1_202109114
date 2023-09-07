package gt.edu.usac.ingenieria.classes;

import java.util.HashMap;

public class Environment {
    HashMap<String, Object> globals;
    HashMap<String, Object> pie;
    HashMap<String, Object> bars;

    public Environment(){
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
        Object glob = getGlobalsValue(id);
        if (glob != null) {
            return glob;
        }
        Object pie = getPieValue(id);
        if (pie != null){
            return pie;
        }
        Object bars = getBarsValue(id);
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

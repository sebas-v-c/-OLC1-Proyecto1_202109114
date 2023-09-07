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

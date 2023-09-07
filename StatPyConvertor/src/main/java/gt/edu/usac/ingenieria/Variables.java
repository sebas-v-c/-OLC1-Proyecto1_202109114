package gt.edu.usac.ingenieria;

import java.util.HashMap;

public class Variables {
    private static Variables instance = new Variables();
    public HashMap<String, HashMap<String, Object>> jsonVars = new HashMap<>();
    public HashMap<String, Object> graphVars = new HashMap<>();
    private Variables(){
        if (instance != null){
            throw new IllegalStateException("Singleton already initialized");
        }
    }

    public static Variables getInstance(){
        return instance;
    }
}

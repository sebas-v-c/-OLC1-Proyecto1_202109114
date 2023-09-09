package gt.edu.usac.ingenieria;

import gt.edu.usac.ingenieria.classes.Environment;
import gt.edu.usac.ingenieria.classes.Json;

import java.util.HashMap;

public class Variables {
    private static Variables instance = new Variables();
    public HashMap<String, Json> jsonVars = new HashMap<>();
    public Environment graphVars = new Environment();
    private Variables(){
        if (instance != null){
            throw new IllegalStateException("Singleton already initialized");
        }
    }

    public static Variables getInstance(){
        return instance;
    }
}

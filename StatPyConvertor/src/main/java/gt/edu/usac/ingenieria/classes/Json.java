package gt.edu.usac.ingenieria.classes;

import gt.edu.usac.ingenieria.lang.json.KeyVal;

import java.util.ArrayList;
import java.util.HashMap;

public class Json {
    private final HashMap<String, Object> content;

    public Json(){
        content = new HashMap<>();
    }

    public Json(String key, Object value){
        content = new HashMap<>();
        content.put(key, value);
    }

    public void addKeyValue(String key, Object object){
        content.put(key, object);
    }

    public Object getValue(String key){
        return content.get(key);
    }

    public ArrayList<String> getKeys(){
        return new ArrayList<String>(content.keySet());
    }

    public ArrayList<Object> getValues(){
        return new ArrayList<Object>(content.values());
    }



}

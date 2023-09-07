package gt.edu.usac.ingenieria.lang.statpy;

import java.util.List;

public class TranslateUtils {
    public static String tabulate(String s){
        StringBuilder str = new StringBuilder();
        Object[] lines = s.lines().toArray();
        for (Object line: lines){
            str.append("\t").append((String) line).append("\n");
        }

        return str.toString();
    }
}

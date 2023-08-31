package gt.edu.usac.ingenieria.analyzer.generators;

import java.io.File;

public class GStatPySc {
    public static void main(String[] args) {
        jflex.Main.generate(
                new File(
                        "src/main/java/gt/edu/usac/ingenieria/analyzer/StatPy.jflex"
                )
        );
    }
}

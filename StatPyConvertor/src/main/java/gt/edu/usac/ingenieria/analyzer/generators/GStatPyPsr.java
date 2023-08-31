package gt.edu.usac.ingenieria.analyzer.generators;

public class GStatPyPsr {
    public static void main(String[] args) {
        try {
            java_cup.Main.main(
                    new String[] {
                            "-destdir",
                            "src/main/java/gt/edu/usac/ingenieria/analyzer/",
                            "-symbols",
                            "SYM",
                            "-parser",
                            "Parser",
                            "src/main/java/gt/edu/usac/ingenieria/analyzer/StatPy.cup"
                    });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

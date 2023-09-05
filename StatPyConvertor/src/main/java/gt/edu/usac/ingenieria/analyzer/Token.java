package gt.edu.usac.ingenieria.analyzer;

public record Token(Object token, int line, int column, String type) {
}

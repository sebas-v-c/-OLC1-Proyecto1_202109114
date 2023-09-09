package gt.edu.usac.ingenieria.analyzer.errors;

public class LexError {
    private long line;
    private long column;
    private String character;

    public LexError(long line, long column, String character){
        this.line = line;
        this.column = column;
        this.character = character;
    }


    public long getLine() {
        return line;
    }

    public long getColumn() {
        return column;
    }

    public String getCharacter() {
        return character;
    }

    public void print(){
        System.out.println("Unrecognized character \"" + character + "\" at: line-" + line + " - column-" + column);
    }
}

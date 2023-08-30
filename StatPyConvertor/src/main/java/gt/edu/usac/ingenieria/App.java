package gt.edu.usac.ingenieria;

import gt.edu.usac.ingenieria.editor.EditorController;
import gt.edu.usac.ingenieria.editor.EditorView;

import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("es"));

        EditorView editor = new EditorView();
        EditorController controller = new EditorController(editor);
    }
}

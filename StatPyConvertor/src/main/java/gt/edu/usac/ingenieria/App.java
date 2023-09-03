package gt.edu.usac.ingenieria;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import gt.edu.usac.ingenieria.editor.EditorController;
import gt.edu.usac.ingenieria.editor.EditorView;

import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("es"));

        FlatIntelliJLaf.setup();

        EditorView editor = new EditorView();
        EditorController controller = new EditorController(editor);
    }
}

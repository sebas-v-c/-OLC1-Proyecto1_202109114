package gt.edu.usac.ingenieria.editor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EditorController {
    private static final String STATPY = "StatPy";
    private static final String JSON = "JSON";
    private EditorView view;
    private String analyzer = STATPY;
    public EditorController(EditorView view) {
        this.view = view;

        view.addMOpenListener(new OpenFileListener());
        view.addMSaveListener(new SaveFileListener());
        view.addMSaveAsListener(new SaveAsFileListener());
        view.addMStatPyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzer = STATPY;
                view.setAnalysisLabelText(STATPY);
            }
        });
        view.addMJsonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzer = JSON;
                view.setAnalysisLabelText(JSON);
            }
        });

        view.addExecButtonListener(new ExecuteListener());
    }

    // TODO Open file
    private class OpenFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // JFileChooser configuration
            UIManager.put("FileChooser.readOnly", Boolean.TRUE);
            String currentDir = System.getProperty("user.dir");
            JFileChooser chooser = new JFileChooser(currentDir);
            FileNameExtensionFilter filter;

            switch (analyzer){
                case STATPY -> filter = new FileNameExtensionFilter("Archivos StatPy", "sp");
                case JSON -> filter = new FileNameExtensionFilter("Archivos JSON", "json");
                default -> throw new IllegalStateException("Unexpected value: " + analyzer);
            }

            chooser.setFileFilter(filter);
            int returnval = chooser.showOpenDialog(null);

            if (returnval == JFileChooser.APPROVE_OPTION){
                String filepath = chooser.getSelectedFile().getPath();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filepath));
                    String line;
                    while ((line = br.readLine()) != null){
                    }
                } catch (FileNotFoundException ex) {
                    // TODO show alert
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    // TODO show alert
                    throw new RuntimeException(ex);
                }
            }

        }
    }

    // TODO save file
    private class SaveFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    // TODO save as file
    private class SaveAsFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    // TODO create execute method
    // the execute either traduce or analyze only
    private class ExecuteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}

package gt.edu.usac.ingenieria.editor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;


public class EditorController {
    private static final String STATPY = "StatPy";
    private static final String JSON = "JSON";
    private EditorView view;
    private String analyzer = STATPY;
    private String filePath;
    public EditorController(EditorView view) {
        this.view = view;

        view.addMOpenListener(new OpenFileListener());
        view.addMSaveListener(new SaveFileListener());
        view.addMSaveAsListener(new SaveAsFileListener());
        view.addMStatPyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(analyzer, STATPY)){
                    view.cleanTextAreas();
                }
                analyzer = STATPY;
                view.setAnalysisLabelText(STATPY);
            }
        });
        view.addMJsonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(analyzer, JSON)){
                    view.cleanTextAreas();
                }
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
                case STATPY -> filter = new FileNameExtensionFilter("Archivos StatPy (*.stp)", "sp");
                case JSON -> filter = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");
                default -> throw new IllegalStateException("Unexpected value: " + analyzer);
            }
            chooser.setFileFilter(filter);

            int returnval = chooser.showOpenDialog(null);
            if (returnval == JFileChooser.APPROVE_OPTION){
                String filepath = chooser.getSelectedFile().getPath();
                filePath = filepath;
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filepath));
                    String line;
                    view.cleanTextAreas();
                    while ((line = br.readLine()) != null){
                        view.appendEntryTextArea(line + "\n");
                    }
                    br.close();
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

    private class SaveFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (filePath == null){
                SaveAsFileListener savadfile = new SaveAsFileListener();
                savadfile.actionPerformed(e);
                return;
            }
            String extension;
            switch (analyzer){
                case STATPY -> extension = ".sp";
                case JSON -> extension = ".json";
                default -> throw new IllegalStateException("Unexpected value: " + analyzer);
            }

            try {
                if (!filePath.endsWith(extension)){
                    filePath += extension;
                }

                Path path = Path.of(filePath);
                Files.write(path, view.getEntryTextArea().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private class SaveAsFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // JFileChooser configuration
            String currentDir = System.getProperty("user.dir");
            JFileChooser chooser = new JFileChooser(currentDir);
            FileNameExtensionFilter filter;
            String extension;

            switch (analyzer){
                case STATPY:
                    extension = "sp";
                    filter = new FileNameExtensionFilter("Archivos StatPy (*.stp)", extension);
                    break;
                case JSON:
                    extension = "json";
                    filter = new FileNameExtensionFilter("Archivos JSON (*.json)", extension);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + analyzer);
            }
            chooser.setFileFilter(filter);

            int returnval = chooser.showOpenDialog(null);
            if (returnval == JFileChooser.APPROVE_OPTION){
                File file = chooser.getSelectedFile();
                String filepath = chooser.getSelectedFile().getAbsolutePath();
                filePath = filepath;
                if (!filepath.endsWith("." + extension)){
                    filepath += "." + extension;
                    file = new File(filepath);
                }

                try {
                    Path path = Path.of(filepath);
                    Files.write(path, view.getEntryTextArea().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
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

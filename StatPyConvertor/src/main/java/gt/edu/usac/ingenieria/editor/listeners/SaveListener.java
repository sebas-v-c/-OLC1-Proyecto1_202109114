package gt.edu.usac.ingenieria.editor.listeners;

import gt.edu.usac.ingenieria.editor.EditorController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class SaveListener {

    public static class SaveFileListener implements ActionListener {
        EditorController controller;
        public SaveFileListener(EditorController controller){
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (controller.filePath == null){
                SaveAsFileListener savadfile = new SaveAsFileListener(controller);
                savadfile.actionPerformed(e);
                return;
            }
            String extension;
            switch (controller.analyzer){
                case STATPY -> extension = ".sp";
                case JSON -> extension = ".json";
                default -> throw new IllegalStateException("Unexpected value: " + controller.analyzer);
            }

            try {
                if (!controller.filePath.endsWith(extension)){
                    controller.filePath += extension;
                }

                Path path = Path.of(controller.filePath);
                Files.write(path, controller.view.getEntryTextArea().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static class SaveAsFileListener implements ActionListener{

        EditorController controller;
        public SaveAsFileListener(EditorController controller){
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            UIManager.put("FileChooser.openButtonText", "Save");
            String currentDir = System.getProperty("user.dir");
            JFileChooser chooser = new JFileChooser(currentDir);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter filter;
            String extension;

            filter = switch (controller.analyzer) {
                case STATPY -> {
                    extension = "sp";
                    yield new FileNameExtensionFilter("Archivos StatPy (*.stp)", extension);
                }
                case JSON -> {
                    extension = "json";
                    yield new FileNameExtensionFilter("Archivos JSON (*.json)", extension);
                }
                default -> throw new IllegalStateException("Unexpected value: " + controller.analyzer);
            };
            chooser.setFileFilter(filter);

            int returnval = chooser.showOpenDialog(null);
            if (returnval == JFileChooser.APPROVE_OPTION){
                File file = chooser.getSelectedFile();
                String filepath = chooser.getSelectedFile().getAbsolutePath();
                controller.filePath = filepath;
                if (!filepath.endsWith("." + extension)){
                    filepath += "." + extension;
                    file = new File(filepath);
                }

                try {
                    Path path = Path.of(filepath);
                    Files.write(path, controller.view.getEntryTextArea().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }
}

package gt.edu.usac.ingenieria.editor.reports;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public abstract class Report {
    protected String filePath;
    public abstract void generateReport() throws Exception;

    protected void saveReport(String s){
        UIManager.put("FileChooser.openButtonText", "Save");
        String currentDir = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(currentDir);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter;
        String extension = "html";
        filter = new FileNameExtensionFilter("Archivos StatPy (*.stp)", extension);

        chooser.setFileFilter(filter);

        int returnval = chooser.showOpenDialog(null);
        if (returnval == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            String filepath = chooser.getSelectedFile().getAbsolutePath();
            this.filePath = filepath;
            if (!filepath.endsWith("." + extension)){
                filepath += "." + extension;
                file = new File(filepath);
            }

            try {
                Path path = Path.of(filepath);
                Files.write(path, s.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void openHTMLFile(String filePath){
        File htmlFile = new File(filePath);
        if (Desktop.isDesktopSupported() && htmlFile.exists()) {
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

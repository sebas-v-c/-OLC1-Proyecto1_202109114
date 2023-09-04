package gt.edu.usac.ingenieria.editor;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class EditorView extends JFrame{
    private JPanel mainPanel;
    private JMenuBar MenuBar;
    private JMenu FileMenu;
    private JMenu AnalMenu;
    private JMenu ReportMenu;
    private JMenuItem mOpen;
    private JMenuItem mSave;
    private JMenuItem mSaveAs;
    private JMenuItem mStatPy;
    private JMenuItem mJson;
    private JButton execButton;
    private JMenuItem mReportTokens;
    private JMenuItem mReportErrors;
    private JLabel analLabel;
    private JTextArea entryTextArea;
    private JTextArea outTextArea;
    private JButton cleanButton;
    private JLabel loadedJsonsLabel;
    private JRadioButton statPyRadioButton;

    public EditorView() {
        super("StatPy");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    }

    public void setLoadedJsonsText(String text){
        loadedJsonsLabel.setText(text);
    }
    public int getLoadedJsonsNum(){
        return Integer.parseInt(loadedJsonsLabel.getText());
    }
    public void setExecButtonText(String text){
        execButton.setText(text);
    }
    public void cleanTextAreas(){
        entryTextArea.setText("");
        outTextArea.setText("");
    }
    public void setAnalysisLabelText(String text){
        analLabel.setText(text);
    }
    public String getEntryTextArea(){
        return entryTextArea.getText();
    }
    public void setEntryTextArea(String text){
        entryTextArea.setText(text);
    }
    public void appendEntryTextArea(String line){
        entryTextArea.append(line);
    }
    public String getOutTextArea(){
        return outTextArea.getText();
    }
    public void setOutTextArea(String text){
        outTextArea.setText(text);
    }


    // button listeners
    public void addMOpenListener(ActionListener listener){
        mOpen.addActionListener(listener);
    }
    public void addMSaveListener(ActionListener listener){
        mSave.addActionListener(listener);
    }
    public void addMSaveAsListener(ActionListener listener){
        mSaveAs.addActionListener(listener);
    }
    public void addMStatPyListener(ActionListener listener){
        mStatPy.addActionListener(listener);
    }
    public void addMJsonListener(ActionListener listener){
        mJson.addActionListener(listener);
    }
    public void addExecButtonListener(ActionListener listener){
        execButton.addActionListener(listener);
    }
    public void addMReportTokensListener(ActionListener listener){
        mReportTokens.addActionListener(listener);
    }
    public void addMReportErrorsListener(ActionListener listener){
        mReportErrors.addActionListener(listener);
    }
    public void addCleaButtonListener(ActionListener listener){
        cleanButton.addActionListener(listener);
    }

    public void setSelectedStatPy(boolean selected){
        statPyRadioButton.setSelected(selected);
    }

    private ImageIcon loadImageFromResources(String imageName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(imageName);

            if (inputStream != null) {
                byte[] bytes = inputStream.readAllBytes();
                inputStream.close();
                return new ImageIcon(bytes);
            } else {
                System.err.println("Resource not found: " + imageName);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private void createUIComponents() {
        statPyRadioButton = new JRadioButton();
        statPyRadioButton.setDisabledSelectedIcon(loadImageFromResources("check-mark.png"));
        statPyRadioButton.setDisabledIcon(loadImageFromResources("not-mark.png"));
        statPyRadioButton.setSelectedIcon(loadImageFromResources("check-mark.png"));
        statPyRadioButton.setIcon(loadImageFromResources("not-mark.png"));
    }

}

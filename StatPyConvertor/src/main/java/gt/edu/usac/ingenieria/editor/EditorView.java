package gt.edu.usac.ingenieria.editor;

import javax.swing.*;
import java.awt.event.ActionListener;

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

    public EditorView() {
        super("StatPy");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
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
}

package gt.edu.usac.ingenieria.editor;

import javax.swing.*;

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

    private void createUIComponents() {
    }
}

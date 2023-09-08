package gt.edu.usac.ingenieria.editor.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class ChartPanel extends JFrame {
    private JPanel mainPanel = new JPanel();
    public ChartPanel(String windowTitle) {
        super(title);
        this.title = title;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    public void buildBarChart(String title, String[] xAxis, Double[] values, String xTitle, String yTitle){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (int i = 0; i < values.length; i++){
            dataSet.setValue(values[i], xTitle, xAxis[i]);
        }

        //JFreeChart jchart = ChartFactory.createXYBarChart(title, xTitle, true, yTitle, dataSet);
        JFreeChart jFreeChart = ChartFactory.createBarChart(title, xTitle, yTitle, dataSet);
    }
}

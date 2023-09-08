package gt.edu.usac.ingenieria.editor.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryToPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChartFrame extends JFrame{
    private JPanel mainPanel;
    private JPanel chartJPanel;
    private JButton closeButton;
    String windowTitle;

    public ChartFrame(String windowTitle, String[] xAxis, Double[] values, String xTitle, String yTitle) {
        super(windowTitle);
        this.windowTitle = windowTitle;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);

        buildBarChart(windowTitle, xAxis, values, xTitle, yTitle);
    }

    public ChartFrame(String windowTitle, String[] xAxis, Double[] values){
        super(windowTitle);
        this.windowTitle = windowTitle;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);

        buildPieChart(windowTitle, xAxis, values);
    }


    private void buildPieChart(String title, String[] xAxis, Double[] values) {
        //PieDataset data = new Pi
        DefaultPieDataset dataSet = new DefaultPieDataset();
        for (int i = 0; i < values.length; i++){
            dataSet.setValue(xAxis[i], values[i]);
        }

        //JFreeChart jchart = ChartFactory.createXYBarChart(title, xTitle, true, yTitle, dataSet);
        JFreeChart jChart = ChartFactory.createPieChart(title, dataSet);

        ChartPanel chartPanel = new ChartPanel(
                jChart, 800, 450, 500,
                450, 900, 450,
                true, true, true, true, true, true
        );
        //chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        chartJPanel.revalidate();
        chartJPanel.repaint();
        chartJPanel.updateUI();

        chartJPanel.add(chartPanel);
    }

    private void buildBarChart(String title, String[] xAxis, Double[] values, String xTitle, String yTitle){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (int i = 0; i < values.length; i++){
            dataSet.setValue(values[i], xTitle, xAxis[i]);
        }

        JFreeChart jChart = ChartFactory.createBarChart(
                title, xTitle, yTitle, dataSet, PlotOrientation.VERTICAL, false, true, false
        );

        ChartPanel chartPanel = new ChartPanel(
                jChart, 800, 450, 500,
                450, 900, 450,
                true, true, true, true, true, true
        );
        chartPanel.setBackground(Color.white);

        chartJPanel.revalidate();
        chartJPanel.repaint();
        chartJPanel.updateUI();

        chartJPanel.add(chartPanel);
    }

    /*
    private void createUIComponents() {
        chartJPanel = new JPanel();
        chartJPanel.setLayout(new BoxLayout(chartJPanel, BoxLayout.Y_AXIS));
    }

     */

    public void addActionListener(ActionListener l ){
        closeButton.addActionListener(l);
    }
}

package gt.edu.usac.ingenieria.editor.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class ChartFrame extends JFrame{
    private JPanel mainPanel;
    private String windowTitle;

    public ChartFrame(String windowTitle) {
        super(windowTitle);
        this.windowTitle = windowTitle;
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
        JFreeChart jChart = ChartFactory.createBarChart(
                title, xTitle, yTitle, dataSet, PlotOrientation.VERTICAL, false, true, false
        );

        ChartPanel chartPanel = new ChartPanel(
                jChart, this.getWidth(), 450, 500,
                450, this.getWidth(), 450,
                true, true, true, true, true, true
        );
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        mainPanel.add(chartPanel);
        mainPanel.revalidate();
    }
}

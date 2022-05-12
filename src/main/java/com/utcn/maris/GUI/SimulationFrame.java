package com.utcn.maris.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SimulationFrame {
    private JFrame frame ;
    private JPanel contentPane;
    private JPanel panel;
    private JTextField minArrivalTimeTextField;
    private JTextField maxArrivalTimeTextField;
    private JTextField minServiceTimeTextField;
    private JTextField maxServiceTimeTextField;
    private JTextField numberOfTaskstextField;
    private JTextField numberOfServersTextField;
    private JTextField timeTextField;
    private JLabel minArrivalTimeLabel ;
    private JLabel maxArrivalTimeLabel ;
    private JLabel minServiceTimeLabel ;
    private JLabel maxServiceTimeLabel ;
    private JLabel numberOfTasksLabel ;
    private JLabel numberOfServersLabel ;
    private JLabel timeLabel ;
    private JScrollPane scrollPane ;
    private JTextArea finalTextArea;
    private JTextArea runTextArea;
    private JButton simulationBtn;


    public SimulationFrame() {

        initComponents();
        editComponents();

        frame.setBounds(100, 100, 655, 416);
        frame.setVisible(true);
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initComponents() {
        frame = new JFrame() ;
        contentPane = new JPanel();
        panel = new JPanel();
        minArrivalTimeTextField = new JTextField();;
        maxArrivalTimeTextField = new JTextField();;
        minServiceTimeTextField =new JTextField();;
        maxServiceTimeTextField = new JTextField();;
        numberOfTaskstextField = new JTextField();;
        numberOfServersTextField = new JTextField();;
        timeTextField = new JTextField();;
        minArrivalTimeLabel = new JLabel("minArrivalTime");;
        maxArrivalTimeLabel = new JLabel("maxArrivalTime");
        minServiceTimeLabel = new JLabel("minServiceTime");
        maxServiceTimeLabel = new JLabel("maxServiceTime");
        numberOfTasksLabel = new JLabel("nrOfTasks");
        numberOfServersLabel = new JLabel("nrOfServers");
        timeLabel = new JLabel("time");
        finalTextArea = new JTextArea();
        runTextArea = new JTextArea();
        simulationBtn = new JButton("Start Simulation");
        scrollPane = new JScrollPane();

    }

    public void editComponents() {


        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        panel.setBounds(10, 10, 621, 359);
        contentPane.add(panel);
        panel.setLayout(null);

        minArrivalTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        minArrivalTimeLabel.setBounds(38, 10, 112, 27);
        panel.add(minArrivalTimeLabel);

        maxArrivalTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        maxArrivalTimeLabel.setBounds(355, 10, 112, 27);
        panel.add(maxArrivalTimeLabel);

        minArrivalTimeTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        minArrivalTimeTextField.setBounds(140, 16, 136, 19);
        panel.add(minArrivalTimeTextField);
        minArrivalTimeTextField.setColumns(10);

        maxArrivalTimeTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        maxArrivalTimeTextField.setColumns(10);
        maxArrivalTimeTextField.setBounds(460, 16, 112, 19);
        panel.add(maxArrivalTimeTextField);


        minServiceTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        minServiceTimeLabel.setBounds(38, 69, 112, 27);
        panel.add(minServiceTimeLabel);

        maxServiceTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        maxServiceTimeLabel.setBounds(320, 69, 112, 27);
        panel.add(maxServiceTimeLabel);

        minServiceTimeTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        minServiceTimeTextField.setColumns(10);
        minServiceTimeTextField.setBounds(150, 75, 136, 19);
        panel.add(minServiceTimeTextField);

        maxServiceTimeTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        maxServiceTimeTextField.setColumns(10);
        maxServiceTimeTextField.setBounds(430, 75, 112, 19);
        panel.add(maxServiceTimeTextField);

        numberOfTasksLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        numberOfTasksLabel.setBounds(38, 118, 112, 27);
        panel.add(numberOfTasksLabel);

        numberOfServersLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        numberOfServersLabel.setBounds(286, 118, 112, 27);
        panel.add(numberOfServersLabel);

        timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        timeLabel.setBounds(38, 155, 52, 27);
        panel.add(timeLabel);

        numberOfTaskstextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        numberOfTaskstextField.setColumns(10);
        numberOfTaskstextField.setBounds(140, 122, 136, 19);
        panel.add(numberOfTaskstextField);

        numberOfServersTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        numberOfServersTextField.setColumns(10);
        numberOfServersTextField.setBounds(375, 122, 112, 19);
        panel.add(numberOfServersTextField);

        timeTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        timeTextField.setColumns(10);
        timeTextField.setBounds(98, 159, 62, 19);
        panel.add(timeTextField);

        scrollPane = new JScrollPane(finalTextArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(38, 204, 534, 134);
        panel.add(scrollPane);

        runTextArea.setText("SIMULATION RUNNING");
        scrollPane.setColumnHeaderView(runTextArea);

        simulationBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        simulationBtn.setBounds(223, 155, 201, 27);
        panel.add(simulationBtn);

    }

    public void addSimulationButtonListener(ActionListener al) {
        simulationBtn.addActionListener(al);
    }

    public String getminAT() {
        return minArrivalTimeTextField.getText();
    }
    public String getmaxAT() {
        return maxArrivalTimeTextField.getText();
    }
    public String getminST() {
        return minServiceTimeTextField.getText();
    }
    public String getmaxST() {
        return maxServiceTimeTextField.getText();
    }
    public String getNoOfTasks() {
        return numberOfTaskstextField.getText();
    }
    public String getNoOfServers() {
        return numberOfServersTextField.getText();
    }
    public String getTimeLimit() {
        return timeTextField.getText();
    }
    public void updateTextArea(String s) {
        finalTextArea.setText(s);
    }

}


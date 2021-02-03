package com.rfrediere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitsConverter {

    static String[] units = {"m", "cm","mm","km","miles","feet","inch","yards"};
    static String[][] coeff = {{"m","1"},{"cm","0.01"},{"mm","0.001"},{"km","1000"},{"miles","1609.34"},{"feet","0.3048"},{"inch","0.0254"},{"yards","0.9144"}};

    public static void main(String[] args){

        gui();

    }

    public static void gui(){
        JFrame frame = new JFrame();
        frame.setSize(500  ,240);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
        panel.setLayout(null);

        JLabel title = new JLabel("Units Converter");
        title.setBounds(0,10,panel.getWidth(),50);
        title.setFont(new Font("Bebas Neue",Font.ITALIC,50));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);

        JTextField val1 = new JTextField();
        val1.setBounds(10,70,90,30);

        JComboBox<String> units1 = new JComboBox<String>(units);
        units1.setBounds(110,70,90,30);

        JLabel in = new JLabel("in");
        in.setBounds(230,70,40,30);
        in.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel equals = new JLabel("=");
        equals.setBounds(150,110,20,30);
        equals.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel val2 = new JLabel();
        val2.setBounds(180,110,180,30);


        JComboBox<String> units2 = new JComboBox<String>(units);
        units2.setBounds(300,70,170,30);

        JButton valid = new JButton("Valid");
        valid.setBounds(110,150,280,30);
        valid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(val1.getText());
                val2.setText(convert(value,(String) units1.getSelectedItem(),(String) units2.getSelectedItem()));



            }
        });
        panel.add(title);
        panel.add(val1);
        panel.add(val2);
        panel.add(units1);
        panel.add(units2);
        panel.add(in);
        panel.add(equals);
        panel.add(valid);

        frame.add(panel);

        frame.setVisible(true);
    }

    public static String convert(double value, String unit1, String unit2){
        double multiplier = 0;
        double diviser = 0;


        for(int i = 0; i < coeff.length; i++){
            if(coeff[i][0] == unit1){
                multiplier = Double.parseDouble(coeff[i][1]);
            }
            if(coeff[i][0] == unit2){
                diviser = Double.parseDouble(coeff[i][1]);
            }
        }

        String result = String.valueOf(value*multiplier/diviser);

        return result;
    }

}

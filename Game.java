package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame {
    private static int MilanScore = 0;
    private static int RealScore = 0;
    private static int c;

    private JTextField field = new JTextField();
    private JButton button1 = new JButton("End game");
    private JButton button2 = new JButton ("AC Milan");
    private JButton button3 = new JButton ("Real Madrid");
    private JButton button4 = new JButton ("Rematch");
    private JLabel label1 = new JLabel("Result: 0x0");
    private JLabel label2 = new JLabel("Last Scorer: N/A ");
    private JLabel label3 = new JLabel("Winner: DRAW");
    private JLabel label4 = new JLabel();

    public Game() {
        super ("Football match");
        setSize (400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout (10, 3, 10, 10));

        field.setEditable(false);

        button1.addActionListener(new CloseProg());
        button2.addActionListener (new MScore());
        button3.addActionListener (new RScore());
        button4.addActionListener (new Rematch());

        container.add(field);
        container.add(button1);
        container.add(button2);
        container.add(button3);
        container.add(button4);
    }

    class CloseProg implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String message = "";
            if (c == 1)
                label4.setText("Last Scorer: " + "AC Milan");
            else
                label4.setText("Last Scorer: " + "Real Madrid");
            if (MilanScore == 0 && RealScore == 0) {
                message +=  label3.getText() + "\n" + label2.getText() + "\n" + label1.getText() + "\n";
            }
            if (MilanScore > RealScore){
                message += "AC Milan win!\n" + field.getText() + "\n" + label4.getText() + "\nEnd game!";
            }
            if (MilanScore < RealScore) {
                message += "Real Madrid win!\n" + field.getText() + "\n" + label4.getText() + "\nEnd game!";
            }
            if (MilanScore == RealScore && MilanScore != 0){
                message += label3.getText() + "\n" + field.getText() + "\n" + label4.getText() + "\nEnd game!";
            }
            JOptionPane.showMessageDialog(null, message,
                    "End game",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    class MScore implements ActionListener{
        public void actionPerformed (ActionEvent e){
            MilanScore += 1;
            c = 1;
            field.setText("Result: " + MilanScore + "x" + RealScore);
        }
    }

    class RScore implements ActionListener{
        public void actionPerformed (ActionEvent e){
            RealScore += 1;
            c = 0;
            field.setText("Result: " + MilanScore + "x" + RealScore);
        }
    }
    class Rematch implements ActionListener{
        public void actionPerformed (ActionEvent e){
            MilanScore = 0;
            RealScore = 0;
            field.setText("Result: " + MilanScore + "x" + RealScore);
        }
    }
}
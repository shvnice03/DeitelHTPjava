/**
 * 
 * 13.27 (Pie Chart) Write a program that inputs four numbers and graphs them as a pie chart. 
 * Use class Arc2D.Double and method fill of class Graphics2D to perform the drawing. 
 * Draw each piece of the pie in a separate color. 
 * arc = kreissektor
 * 
*/

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class Ex1327V2{
    public static void main(String[] args){
        PieChart pc = new PieChart();
        pc.setSize(500,200);
        pc.setVisible(true);
        pc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class PieChart extends JFrame{

    private final JPanel hold;
    private final JLabel instructions;
    private final GridBagLayout layout;
    private GridBagConstraints cell;
    private final JTextField input;
    private drawPie drpc;
    private int number;
    private int[] numberHolder;
    private int count;

    public PieChart(){

        super("Drawing Piechart");
        hold = new JPanel();
        instructions = new JLabel("Enter four numbers. The program will then display a pie chart according to the numbers."); 
        input = new JTextField();
        cell = new GridBagConstraints();
        layout = new GridBagLayout();
        drpc = new drawPie();
        hold.setLayout(layout);
        numberHolder = new int[3];
        number = 0;
        count = 0;


        // organize layout 
        // add instructions
        cell.gridx = 0;
        cell.gridy = 0;
        cell.gridwidth = 4;
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.fill = GridBagConstraints.HORIZONTAL;
        hold.add(instructions, cell);
        // add input
        cell.gridx = 0;
        cell.gridy = 1;
        cell.gridwidth = 2;
        cell.fill = GridBagConstraints.HORIZONTAL;
        hold.add(input, cell);
        // add drpc
        drpc.setPreferredSize(new Dimension(60, 60));
        drpc.setBackground(Color.BLACK);
        cell.gridx = 5;
        cell.gridy = 0;
        cell.gridheight = 5;
        cell.gridwidth = 3;
        cell.fill = GridBagConstraints.BOTH;
        hold.add(drpc, cell);
        add(hold);

        Handling handler = new Handling();

        input.addActionListener(handler);

    }

    private class Handling implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            while(count < numberHolder.length){

                numberHolder[count] = Integer.parseInt(event.getActionCommand());
                count++;

            }
        }
    }

    private class drawPie extends JPanel{
        @Override

        public void paintComponent(Graphics g){

            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GREEN);
            int zähler = numberHolder[0] + numberHolder[1] + numberHolder[2] + numberHolder[3];
            int startAngle = 0;
            Color[] colors = {Color.GREEN , Color.MAGENTA, Color.BLUE, Color.RED};

            for(int i = 0; i < 4; i++){

                int angleCalculated = numberHolder[i]/zähler * 360;
                g2d.setColor(colors[i]);
                g2d.draw(new Arc2D.Double(50, 50, 10, 10, startAngle, angleCalculated, Arc2D.PIE));
                startAngle = startAngle + angleCalculated;

            }

        }
    }
}
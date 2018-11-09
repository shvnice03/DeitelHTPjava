// Exercise 13.17: Let user draw circle with prompted radius; output diameter, circumreference and area; Version2

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;


public class Ex1317V2{
    public static void main(String[] args){

        InputAndUser i = new InputAndUser();
        i.setSize(500, 600);
        i.setVisible(true);
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
}


class InputAndUser extends JFrame{
    
    // Declare GUI-Components
    private final JPanel HoldAll;  // holds all components
    private GridBagLayout layoutHoldAll;  // layout used in JPanel: HoldAll
    private GridBagConstraints cell;  // GridBagConstraint for layout
    private final JLabel instructions;  // displays the instructions for the user 
    private JTextField inputRadius;  // JTextField: to input radius
    private JTextField inputX;  // JTextField: to input x-coordinate
    private JTextField inputY;  // JTextField: to input y-coordinate
    private JTextArea output;  // JTextArea: to output all results
    private final JLabel askRadius;  // JLabel: to ask for radius:
    private final JLabel askX;  // JLabel: to ask for X:
    private final JLabel askY;  // JLabel: to aks for Y: 
    private double storeRadius;  // to store radius for other classes to use
    private final JButton paint; // JButton: to paint with refreshed values
    private double storeX; // Variable to store x-coordinate
    private double storeY; // Variable to store y-coordinate
    DrawComponent component; // Object of type DrawComponent which draws circle

    // Constructor
    public InputAndUser(){
        
        super("Paint Circle");
        HoldAll = new JPanel();
        layoutHoldAll = new GridBagLayout();
        cell = new GridBagConstraints();
        instructions = new JLabel("Input radius & coordinates of the circle. Press enter after each input");
        inputRadius = new JTextField(10);
        inputX = new JTextField(10);
        inputY = new JTextField(10);
        output = new JTextArea();
        askRadius = new JLabel("radius:");
        askX = new JLabel("x:");
        askY = new JLabel("y:");
        storeRadius = 0.0;
        storeX = 50.0;
        storeY = 50.0;
        paint = new JButton("Paint");
        component = new DrawComponent();       

        // Organize the layout
        HoldAll.setLayout(layoutHoldAll);
        // Add JLabel: instructions
        cell.gridx = 0;
        cell.gridy = 0;
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.gridwidth = 5;
        cell.insets = new Insets(2,3,2,2);
        cell.fill = GridBagConstraints.HORIZONTAL;
        HoldAll.add(instructions, cell);
        // Add JLabel: askRadius
        cell.gridx = 0;
        cell.gridy = 1;
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.gridwidth = 1;
        cell.insets = new Insets(2,3,2,2);
        cell.fill = GridBagConstraints.HORIZONTAL;
        HoldAll.add(askRadius, cell);
        // Add JTextField: inputRadius
        cell.gridx = 1;
        cell.gridy = 1;
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.insets = new Insets(2,3,2,2);
        HoldAll.add(inputRadius, cell);
        // Add JLabel: askX
        cell.gridwidth = 1;
        cell.fill = GridBagConstraints.HORIZONTAL;
        cell.gridx = 0;
        cell.gridy = 2; 
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.insets = new Insets(2,3,2,2);
        HoldAll.add(askX, cell);
        // Add JTextField: inputX
        cell.gridx = 1;
        cell.gridy = 2;
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.insets = new Insets(2,3,2,2);
        HoldAll.add(inputX, cell);
        // Add JLabel: askY
        cell.gridwidth = 1;
        cell.fill = GridBagConstraints.HORIZONTAL;
        cell.gridx = 0;
        cell.gridy = 3;
        cell.weightx = 0.5;
        cell.insets = new Insets(2,3,2,2);
        cell.weighty = 0.5;
        HoldAll.add(askY, cell);
        // Add JTextField: inputY
        cell.gridx = 1;
        cell.gridy= 3;
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        HoldAll.add(inputY, cell);
        cell.insets = new Insets(2,3,2,2);
        // Add JTextArea: output
        cell.gridx = 0;
        cell.gridy = 10;
        cell.gridheight = 5;
        cell.gridwidth = 5;
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.insets = new Insets(2,3,2,2);
        cell.fill = GridBagConstraints.HORIZONTAL;
        cell.ipady = 50;
        HoldAll.add(output, cell);
        // Add JButton: paint
        cell.gridx = 0;
        cell.gridy = 30;
        cell.gridwidth = 5;
        cell.gridheight = 1;
        cell.ipady = 30;
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.insets = new Insets(2,3,2,2);
        cell.fill = GridBagConstraints.HORIZONTAL;
        HoldAll.add(paint, cell);
        // Add drawingpanel to second panel
        cell.gridx = 0;
        cell.gridy = 100;
        cell.gridwidth = 5;
        cell.fill = GridBagConstraints.HORIZONTAL;
        cell.ipady = 0;
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.insets = new Insets(2,3,2,2);
        component.setVisible(true);
        component.setOpaque(true);
        component.setBackground(Color.BLACK);
        component.setPreferredSize(new Dimension(200,200));
        HoldAll.add(component, cell); 
        // Add JPanel to Frame
        add(HoldAll);

        // Create&Add handlers
        TextFieldHandler tfh = new TextFieldHandler();
        inputRadius.addActionListener(tfh);
        inputX.addActionListener(tfh);
        inputY.addActionListener(tfh);
        paint.addActionListener(tfh);
    
    }

    // Setter&Getter
    public void setRadius(double r){
        storeRadius = r;
    }

    public double getRadius(){
        return storeRadius;
    }

    public void setXC(double xcoo){
        storeX = xcoo;
    }

    public double getXC(){
        return storeX;
    }

    public void setYC(double ycoo){
        storeY = ycoo;
    }

    public double getYC(){
        return storeY;
    }

    // private class for Textfieldhandling
    private class TextFieldHandler implements ActionListener{
        String textOutput;
        String x;
        String y;

    
        public void setTextOutput(String in){
            textOutput = in;
        }

        public String getTextOutput(){
            return textOutput;
        }

        @Override
        public void actionPerformed(ActionEvent event){



            if(event.getSource() == inputRadius){

                double circumReference;
                double diameter;
                double area;
                double radius = Double.valueOf(event.getActionCommand());        
    
                circumReference = 2 * Math.PI* Double.valueOf(event.getActionCommand());
                diameter = Double.valueOf(event.getActionCommand()) * 2;
                area = Math.PI * Double.valueOf(event.getActionCommand()) * Double.valueOf(event.getActionCommand());
                
    
                setTextOutput(String.format("%nCircle radius: %s%nCircle Diameter: %.2f%nCircle Circumreference: %.2f%nCircle Area: %.2f%n" 
                ,event.getActionCommand(), diameter, circumReference, area));

                setRadius(radius);

            }

            if(event.getSource() == inputX){

                x = event.getActionCommand();
                setXC(Double.valueOf(x));

            }

            if(event.getSource() == inputY){

                y = event.getActionCommand();
                setYC(Double.valueOf(y));

            }

            if(event.getSource()== paint){

                component.repaint();

            }

            output.setText(String.format("%s%nCoordinates:(%.0f|%.0f)%n", getTextOutput(), getXC(), getYC()));
    }
}

    private class DrawComponent extends JPanel{
    

        @Override
         public void paintComponent(Graphics g){

            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GREEN);
            g2d.draw(new Ellipse2D.Double(getXC(), getYC(), getRadius(), getRadius()));

        }            
    }
}





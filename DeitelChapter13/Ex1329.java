/**
 
 13.29 (Random Colors) Modify Exercise 13.28 to draw each of the 20 randomly sized shapes in a randomly selected color. 
 Use all 13 predefined Color objects in an array of Colors.

*/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;

public class Ex1329{
    public static void main(String[] args){
        RandColSelectingShape drawShapes = new RandColSelectingShape();
        drawShapes.setVisible(true);
        drawShapes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawShapes.setSize(1000, 300);
    }
}

class RandColSelectingShape extends JFrame{

    private Random random;  // output random numbers to draw shapes in random locations and sizes 
    private JComboBox<String> chooseShape;  // JComboBox: chooseShape to choose the shape 
    private JTextField instructions; // to output what user has to do
    private String[] shapes = {"Rectangle" , "Circle"};  // shapes array to store the names displayed in the JComboBox
    private int chosenShape;  
    private GridBagLayout layout;
    private final JPanel holder;
    private GridBagConstraints cell;
    private ShapeDrawer drawing;

    public RandColSelectingShape(){

        random = new Random();
        chooseShape = new JComboBox<String>(shapes);
        chosenShape = 0;
        layout = new GridBagLayout();
        cell = new GridBagConstraints();
        holder = new JPanel();
        drawing = new ShapeDrawer();
        EventHandler ehm = new EventHandler();
        holder.setLayout(layout);
        instructions = new JTextField("Choose a shape from the list below. It will be drawn twenty times at different locations & in different dimensions");
        chooseShape.addItemListener(ehm);
        instructions.setEditable(false);

        // organize GUI
        cell.gridx = 0;
        cell.gridy = 0;
        cell.gridwidth = 2;
        cell.fill = GridBagConstraints.HORIZONTAL;
        holder.add(instructions, cell);
        cell.gridx = 0;
        cell.gridy = 2;
        cell.gridwidth = 2;
        cell.fill = GridBagConstraints.HORIZONTAL;
        holder.add(chooseShape, cell);
        drawing.setVisible(true);
        drawing.setOpaque(true);
        drawing.setBackground(Color.BLACK);
        drawing.setPreferredSize(new Dimension(200,200));
        cell.gridwidth = 4;
        cell.gridheight = 4;
        cell.fill = GridBagConstraints.HORIZONTAL;
        cell.fill = GridBagConstraints.VERTICAL;
        cell.gridx = 4;
        cell.gridy = 0;
        holder.add(drawing, cell);

        add(holder);
    }

    public void setChosenShape(int index){
        chosenShape = index;
    }

    public int getChosenShape(){
        return chosenShape;
    }

    // private class for event-handling
    private class EventHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){

                setChosenShape(chooseShape.getSelectedIndex());
                repaint();
            }
        }

    }

    // private class for drawing the chosen shape
    private class ShapeDrawer extends JPanel{

        @Override
        public void paintComponent(Graphics g){

            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int color = random.nextInt(12);
            Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN , Color.DARK_GRAY, Color.GRAY , Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE};
            g2d.setColor(colors[color]);

            if(shapes[getChosenShape()] == "Rectangle"){

                for(int i = 0; i < 20; i++){
                    
                    int locationX = 20 + random.nextInt(100);
                    int locationY = 20 + random.nextInt(120);
                    int width = 10 + random.nextInt(100);
                    int height = 10 + random.nextInt(100);
                    g2d.draw(new Rectangle2D.Double(locationX, locationY, width, height));

                }

            }

            if(shapes[getChosenShape()] == "Circle"){

                for(int i = 0; i < 20; i++){

                    int locationX = 1 + random.nextInt(100);
                    int locationY = 1 + random.nextInt(120);
                    int width = 10 + random.nextInt(100);
                    int height = width;
                    g2d.draw(new Ellipse2D.Double(locationX, locationY, width, height));

                }
            }

        }

    }
}
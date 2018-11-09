
/**
 
Turtle graphics exercise: same exercise as Exercise 7.21 just with implemented GUI
---------------------------------------------------------------------------------------------------------------------------------------------

7.21 (Turtle Graphics) The Logo language made the concept of turtle graphics famous. 
Imagine a mechanical turtle that walks around the room under the control of a Java application. 
The turtle holds a pen in one of two positions, up or down. While the pen is down, the turtle traces out shapes as it moves, 
and while the pen is up, the turtle moves about freely without writing anything. 
In this problem, you’ll simulate the operation of the turtle and create a computerized sketchpad.
Use a 20-by-20 array floor that’s initialized to zeros. Read commands from an array that con- tains them. 
Keep track of the current position of the turtle at all times and whether the pen is cur- rently up or down. Assume that the turtle always 
starts at position (0, 0) of the floor with its pen up. The set of turtle commands your application must process are shown in Fig. 7.29

Suppose that the turtle is somewhere near the center of the floor. The following “program”
would draw and display a 12-by-12 square, leaving the pen in the up position:

        2
        5,12
        3
        5,12
        3
        5,12
        3
        5,12
        1
        6
        9

As the turtle moves with the pen down, set the appropriate elements of array floor to 1s. 
When the 6 command (display the array) is given, wherever there’s a 1 in the array, display an asterisk or any character you choose. 
Wherever there’s a 0, display a blank. Write an application to implement the turtle graphics capabilities discussed here. 
Write several turtle graphics programs to draw interesting shapes. Add other commands to increase the power of your turtle graphics language.

Commands:
Command   Meaning

1         Pen up
2         Pen down
3         Turn right
4         Turn left
5,10      Move forward 10 spaces (replace 10 for a different number of spaces)
6         Display the 20-by-20 array // We dont need an array anymore because the JPanel deals with all the drawing
9         End of data (sentinel) // JButton does that for us 

----------------------------------------------------------------------------------------------------------------------------------------------
[NOTE: the turtle is facing south with the pen up at the beginning]
*/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.event.*;

public class TurtleGraphics{
    public static void main(String[] args){
        Game game = new Game();
        game.setSize(600,600);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// class that represents the whole game
class Game extends JFrame{

    private JTextField inputCommand; // JTextField to input all commands; always sets back the textfield to empty 
    private BoardPaintLine board; // the board to output everything the turtle draws
    private int[] xArrayForDrawing; // array for holding all xcoordinates for generalpath
    private int[] yArrayForDrawing;  // array for holding all ycoordinates for generalpath
    private JButton draw; // button that terminates the input process instead of sentinel
    private JTextArea displayCommands; // display all commands to the user
    private boolean penState; // true = penDown ; false = penUp
    String commands;
    private GridBagLayout layout1;
    private GridBagConstraints cell;
    private final JPanel panel1;
    private boolean faceSouth;
    private boolean faceNorth;
    private boolean faceEast;
    private boolean faceWest;
    private int count;
    private int x;
    private int y;
    private int realcommand;


    public Game(){

        commands = 
        (String.format(
        "Use this commands to draw press button to see what you have drawn.%n%n1     Pen up%n2     Pen down%n3     Turn right%n4     Turn left%n5,10  Move forward 10 spaces (replace 10 for a different number of spaces)"));
        displayCommands = new JTextArea(commands);
        displayCommands.setEditable(false);
        add(displayCommands);  
        inputCommand = new JTextField();
        board = new BoardPaintLine();
        board.setBackground(Color.BLACK);
        board.setSize(new Dimension(200,200));
        xArrayForDrawing = new int[100];
        yArrayForDrawing = new int[100];
        xArrayForDrawing[0] = 0;
        yArrayForDrawing[0] = 0;
        draw = new JButton("DRAW");
        penState = false;
        cell = new GridBagConstraints();
        layout1 = new GridBagLayout();
        panel1 = new JPanel();
        panel1.setLayout(layout1);
        faceSouth = true;
        faceEast = false;
        faceNorth = false;
        faceWest = false;
        x = 0;
        y = 0;
        count = 1;
        
        // Add all components to frame with GridBagLayout
        // Add displayCommands to panel1
        cell.gridx = 0;
        cell.gridy = 0;
        cell.gridwidth = 5;
        cell.fill = GridBagConstraints.HORIZONTAL;
        cell.insets = new Insets(1, 1, 1, 1);
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        panel1.add(displayCommands, cell);
        // Add inputCommand to panel1
        cell.gridx = 0;
        cell.gridy = 1;
        cell.gridwidth = 5;
        cell.fill = GridBagConstraints.HORIZONTAL;
        cell.insets = new Insets(1, 1, 1, 1);        
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        panel1.add(inputCommand, cell);
        // Add draw button to panel1
        cell.gridx = 0;
        cell.gridy = 11;
        cell.gridwidth = 5;
        cell.fill = GridBagConstraints.HORIZONTAL;
        cell.insets = new Insets(1, 1, 1, 1);        
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.ipady = 20;
        panel1.add(draw, cell);
        // Add board to panel1
        cell.gridx = 7;
        cell.gridy = 0;
        cell.insets = new Insets(1, 1, 1, 1);
        cell.weightx = 0.5;
        cell.weighty = 0.5;
        cell.gridheight = 7;
        cell.fill = GridBagConstraints.BOTH;
        board.setVisible(true);
        board.setOpaque(true);
        panel1.add(board, cell);
        add(panel1);

        TBHandler handler = new TBHandler();
        inputCommand.addActionListener(handler);
        draw.addActionListener(handler);
        
    }

    public int getXValue(){
        return x;
    }

    public int getYValue(){
        return y;
    }

    public void setYValue(int yd){
        y = yd;
    }

    public void setXValue(int xde){
        x = xde;
    }

    public void setRealCommand(int realcommand){
        realcommand = this.realcommand;
    }

    public int getRealCommand(){
        return realcommand;
    }

    public void setCount( int c){
        count = c;
    }

    public int getCount(){
        return count;
    }

   
    
    // private class that paints the line drawn by the turtle & represents the board
    private class BoardPaintLine extends JPanel{
        @Override
        public void paintComponent(Graphics g){

            
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            GeneralPath drawing = new GeneralPath();
            g2d.setStroke(new BasicStroke(0.5f));
            g2d.setColor(Color.GREEN);

            drawing.moveTo(xArrayForDrawing[0] , yArrayForDrawing[0]);
            for(int h = 0; h < xArrayForDrawing.length; h++){
                drawing.lineTo(xArrayForDrawing[h] , yArrayForDrawing[h]);
            }

            g2d.draw(drawing);
           
            

        }
    }

    // private class for event handling
    private class TBHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){

            if(event.getSource() == inputCommand){

                // if-clause for command 1 & 2 (pen up/down);
                if(event.getActionCommand() == "1" || event.getActionCommand() == "2"){
                    if(event.getActionCommand() == "1"){
                        penState = true;
                    }

                    if(event.getActionCommand() == "2"){
                        penState = false;
                    }
                }
                // if-clause for command 3 turn left                                                   
                if(event.getActionCommand() == "3"){

                    if(faceSouth){
                        faceSouth = false;
                        faceEast = true;
                    }

                    if(faceEast){
                        faceEast = false;
                        faceNorth = true;
                    }

                    if(faceNorth){
                        faceNorth = false;
                        faceWest = true;
                    }

                    if(faceWest){
                        faceWest = false;
                        faceSouth = true;
                    }

                }
                // if-clause for command 4 turn right
                if(event.getActionCommand() == "4"){

                    if(faceNorth){
                        faceNorth = false;
                        faceEast = true;
                    }

                    if(faceEast){
                        faceEast = false;
                        faceSouth = true;
                    }

                    if(faceSouth){
                        faceSouth = false;
                        faceWest = true;
                    }

                    if(faceWest){
                        faceWest = false;
                        faceNorth = true;
                    }
                }
                // if-clause for command 5 move spaces after 5 (x)
                if(event.getActionCommand() == "5"){
                    int realcommand2 = Integer.parseInt(event.getActionCommand());
                    realcommand2 = realcommand%100;
                    int cde = count++;
                    setCount(cde);

                    if(faceEast == true|| faceWest == true){
                        setXValue(realcommand2);
                    }

                    if(faceNorth == true|| faceSouth == true){
                        setYValue(realcommand2);
                    }

                    if(xArrayForDrawing[getCount()] != xArrayForDrawing[getCount()]){
                        xArrayForDrawing[getCount()] = xArrayForDrawing[getCount() - 1] + getXValue();
                    }

                    if(yArrayForDrawing[getCount()] != yArrayForDrawing[getCount()]){
                        yArrayForDrawing[getCount()] = yArrayForDrawing[getCount() - 1] + getYValue();
                    }
                    
                    

                }
            }

            if(event.getSource() == draw){
                repaint();
            }     
        }
    }
}

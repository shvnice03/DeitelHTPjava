
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
6         Display the 20-by-20 array
9         End of data (sentinel)

----------------------------------------------------------------------------------------------------------------------------------------------
[NOTE: the turtle is facing south with the pen up at the beginning]
*/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class TurtleGraphics{
    public static void main(String[] args){

    }
}

// class that represents the whole game
class Game extends JFrame{

    private JTextField inputCommand; // JTextField to input all commands; always sets back the textfield to empty 
    private BoardPaintLine board; // the board to output everything the turtle draws


    
    // private class that paints the line drawn by the turtle & represents the board
    private class BoardPaintLine extends JPanel{
        public void paintComponent(Graphics g){

        }
    }

    // private class point that represents the turtle and where the point is at
    private class Point{
        
    }
}

// Class that represents the player
//class Player{
//
//}


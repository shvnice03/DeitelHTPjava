// Exercise 13.11: Drawing 8-by-8 Grid with method drawLine

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Ex1311{
    public static void main(String[] args){

        JFrame frame = new JFrame();
        Grid g = new Grid();
        frame.add(g);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Grid extends JPanel{

    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int y = 20;
        g.drawLine(20, 0, 20, 400);

        for(int i = 1; i <= 8; i++){
            y = y + 40;
            g.drawLine(y, 5, y, 400);
            g.drawLine(5 , y, 400, y);
            
        }
    }
}
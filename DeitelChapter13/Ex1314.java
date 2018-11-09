// Exercise 13.14:  Modify Exercise 13.13 to use class Rectangle2D.Double

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Ex1314
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        GridRect2D gr2d = new GridRect2D();
        frame.add(gr2d);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class GridRect2D extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        

        int x = 50;
        int y = 50;
        

        for(int i = 0; i < 100; i++){
            
            g2d.draw(new Rectangle2D.Double(x, y, 50, 50));            
            x = x + 50;

            if(i %10 == 0){
                x = 0;
                y = y + 50;
            }
        }
    }
}
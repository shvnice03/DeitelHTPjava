// Exercise 13.13: Draw  10-by-10-Grid using method drawRect
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Ex1313
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        GridRect gr = new GridRect();
        frame.add(gr);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class GridRect extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x = 50;
        int y = 50;
        

        for(int i = 0; i < 100; i++){
            
            g.drawRect(x, y, 50, 50);
            x = x + 50;

            if(i %10 == 0){
                x = 0;
                y = y + 50;
            }
        }
    }
}
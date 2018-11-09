// Exercise 13.12: Modify Exercise 13.11

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Ex1312{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        ModifyGrid grid = new ModifyGrid();
        frame.add(grid);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ModifyGrid extends JPanel{

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int y = 20;


        for(int i = 1; i <= 8; i++){
            y = y + 40;
            g2d.draw(new Line2D.Double(y, 5, y, 400));
            g2d.draw(new Line2D.Double(5 , y, 400, y));
        }
    }
}
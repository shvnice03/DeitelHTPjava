// Exercise 13.9: Random Triangles

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Ex139{
    public static void main(String[] args){

        JFrame frame = new JFrame();
        RandomTriangles rt = new RandomTriangles();
        frame.add(rt);
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class RandomTriangles extends JPanel{

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Random random = new Random();
        Graphics2D g2d = (Graphics2D) g;
        GeneralPath triangle = new GeneralPath();
        Random r = new Random();
        g2d.setColor(new Color(random.nextInt(256),random.nextInt(256), random.nextInt(256)));



        int xp1 = 50 + r.nextInt(250);
        int xp2 = 50 + r.nextInt(250);
        int xp3 = 50 + r.nextInt(250);
        int yp1 = 20 + r.nextInt(300);
        int yp2 = 20 + r.nextInt(300);
        int yp3 = 20 + r.nextInt(300);

        int xPoints[] = {xp1, xp2, xp3};
        int yPoints[] = {yp1, yp2 , yp3 };

        triangle.moveTo(xPoints[0] , yPoints[0]);

        for(int count = 0; count < xPoints.length; count++){
            triangle.lineTo(xPoints[count], yPoints[count]);
        }

        triangle.closePath();
        g2d.translate(150, 150);

        for(int i = 1; i <= 20; i++){

            
            g2d.setColor(new Color(random.nextInt(256),random.nextInt(256), random.nextInt(256)));
            g2d.rotate(50);
            g2d.fill(triangle);
            
        }

    }

}
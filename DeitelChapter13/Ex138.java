// Exercise 13.8: Random Lines using Line2D.Double
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Ex138 extends JPanel
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        RandomLines rl = new RandomLines();
        frame.add(rl);
        frame.setSize(400, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class RandomLines extends JPanel
{
   @Override
   public void paintComponent(Graphics g)
    {

       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       Random rand = new Random();

       Color colors[] = {Color.BLUE , Color.ORANGE , Color.RED , Color.GREEN , Color.BLACK , Color.YELLOW};


       for(int i = 0; i < 6; i++)
       {
           
           int colorSelecter = 0 + rand.nextInt(6);
           float strokeSelector = 1  + rand.nextInt(70);
           double point1x = 50 + rand.nextInt(200);
           double point1y = 50 + rand.nextInt(200);
           double point2x = 50 + rand.nextInt(200);
           double point2y = 50 + rand.nextInt(200);
           g2d.setStroke(new BasicStroke(strokeSelector));
           g2d.setColor(colors[colorSelecter]);
           g2d.draw(new Line2D.Double(point1x,point1y,point2x,point2y));

        }
    } 
}
// Exercise 13.18: Screensaver; draw 100 lines, then clear it & start again

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Ex1318 extends JPanel
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        RandomLines2 rl = new RandomLines2();
        rl.setPreferredSize(new Dimension(400, 350));
        frame.add(rl);
        frame.setSize(400, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class RandomLines2 extends JPanel
{

   @Override
   public void paintComponent(Graphics g){
    {

       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       Random rand = new Random();

       Color colors[] = {Color.BLUE , Color.ORANGE , Color.RED , Color.GREEN , Color.BLACK , Color.YELLOW};
       


       

        
        int colorSelecter = 0 + rand.nextInt(6);
        double point1x = 50 + rand.nextInt(200);
        double point1y = 50 + rand.nextInt(200);
        double point2x = 50 + rand.nextInt(200);
        double point2y = 50 + rand.nextInt(200);
        g2d.setStroke(new BasicStroke(1f));
        g2d.setColor(colors[colorSelecter]);
        g2d.draw(new Line2D.Double(point1x,point1y,point2x,point2y));
        delay(10);

       
    }
}

public void delay(int p){ 

    try { 

        Thread.sleep(p); 

    } 

    

    catch (InterruptedException e) { 

    } 

}
}
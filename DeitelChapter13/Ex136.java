 // Exercise 13.6: Concentric Circles Using Method drawArc()

import javax.swing.*;
import java.awt.*;

public class Ex136
{
    public static void main(String[] args)
    {
        JFrame display = new JFrame();
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ConcentricCircles circles = new ConcentricCircles();
        display.add(circles);
        display.setSize(450, 300);
        display.setVisible(true);
    }
}

class ConcentricCircles extends JPanel
{

    @Override
    public void paintComponent(Graphics g)
    {
        
        super.paintComponent(g);
        g.drawArc(100, 100, 10, 10, 0, 360);
        g.drawArc(95, 95, 20, 20, 0, 360);
        g.drawArc(90, 90, 30, 30, 0, 360);
        g.drawArc(85, 85, 40, 40, 0, 360);
        g.drawArc(80, 80, 50, 50, 0, 360);
        g.drawArc(75, 75, 60, 60, 0, 360);
        g.drawArc(70, 70, 70, 70, 0, 360);
        g.drawArc(65, 65, 80, 80, 0, 360);

    
    }
}
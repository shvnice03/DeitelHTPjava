
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

// Exercise 13.7: Modify Exercise 13.6 use Using class Ellipse2D.double instead of method drawArc

public class Ex137
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        ModifyConcentricCircles MCC = new ModifyConcentricCircles();
        frame.add(MCC);
        frame.setSize(500, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class ModifyConcentricCircles extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(10.0f));
        g2d.draw(new Ellipse2D.Double(300, 300, 50, 50));
        g2d.draw(new Ellipse2D.Double(280, 280, 90, 90));
        g2d.draw(new Ellipse2D.Double(260, 260, 130, 130));
        g2d.draw(new Ellipse2D.Double(240, 240, 170, 170));
        g2d.draw(new Ellipse2D.Double(220, 220, 210, 210));
        g2d.draw(new Ellipse2D.Double(200, 200, 250, 250));
        g2d.draw(new Ellipse2D.Double(180, 180, 290, 290));
        g2d.draw(new Ellipse2D.Double(160, 160, 330, 330));

    }
}
// Exercise 13.15: Drawing TetraHedrons using GeneralPath and Graphics2D

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Ex1315{
    public static void main(String[] args){
        JFrame frame = new JFrame("Drawing Tetrahedrons");
        TH th = new TH();
        frame.add(th);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
    }
}

class TH extends JPanel{

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GeneralPath tetraS1 = new GeneralPath();
        GeneralPath tetraS2 = new GeneralPath();
        GeneralPath tetraS3 = new GeneralPath();
        GeneralPath tetraS4 = new GeneralPath();
        g2d.setColor(Color.GREEN);

        int[] xPointsS1 = {50, 65, 80 };
        int[] yPointsS1 = {20, 45, 20 };

        int[] xPointsS2 = {50, 35, 50 };
        int[] yPointsS2 = {20, 15, 15 };

        tetraS1.moveTo(xPointsS1[0] , yPointsS1[0]);
        tetraS2.moveTo(xPointsS2[0] , yPointsS2[0]);



        for(int count = 0; count < xPointsS1.length; count++){
            tetraS1.lineTo(xPointsS1[count], yPointsS1[count]);
            tetraS2.lineTo(xPointsS1[count], yPointsS1[count]);

        }

        tetraS1.closePath();
        tetraS2.closePath();

        g2d.draw(tetraS1);
        g2d.draw(tetraS2);


    }
}
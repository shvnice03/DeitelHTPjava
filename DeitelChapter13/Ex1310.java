// Exercise 13.10: Random Characters

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Ex1310{
    public static void main(String[] args){

        RandomCharacters rc = new RandomCharacters();
        JFrame frame = new JFrame();
        frame.add(rc);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class RandomCharacters extends JPanel{

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Random random = new Random();
        String[] characters = {"a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" , "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z"};
        

        for(int i = 0; i < 15; i++){
        int x = 50 + random.nextInt(300);
        int y = 50 + random.nextInt(300);
        g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        g.drawString(characters[random.nextInt(characters.length)],x , y);
        g.setFont(new Font("Sans Serif" , Font.ITALIC, 40));
        }

    }
}
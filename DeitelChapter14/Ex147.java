
/**
 * 14.7 (Pig Latin) Write an application that encodes English-language phrases into pig Latin. Pig Latin is a form of coded language. 
 * There are many different ways to form pig Latin phrases. For simplicity, use the following algorithm:
 * To form a pig Latin phrase from an English-language phrase, tokenize the phrase into words with String method split. 
 * To translate each English word into a pig Latin word, place the first letter of the English word at the end of the word and add the letters “ay.” 
 * Thus, the word “jump” becomes “umpjay,” the word “the” becomes “hetay,” and the word “computer” becomes “omputer- cay.” 
 * Blanks between words remain as blanks. Assume the following: The English phrase consists of words separated by blanks, there are no 
 * punctuation marks and all words have two or more letters. Method printLatinWord should display each word. Each token is passed to method printLatin- 
 * Word to print the pig Latin word. Enable the user to input the sentence. Keep a running display of all the converted sentences in a text area.
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex147{
    public static void main(String[] args){

        PigLatinTranslator pg = new PigLatinTranslator();
        pg.setSize(670, 174);
        pg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pg.setVisible(true);

    }
}

class PigLatinTranslator extends JFrame{

    private JTextArea outputTranslation; // outputs finished translation
    private JTextField inputEnglish; // inputs the sentence that should be translated
    private JTextArea instructions; // displays the instructions & use of the program
    private GridBagLayout layout;
    private final JPanel panel;
    private GridBagConstraints cell;
    String sentence;

    public PigLatinTranslator(){
        
        outputTranslation = new JTextArea(5,10);
        inputEnglish = new JTextField(10);
        instructions = new JTextArea("Type in a english sentence. The program will then proceed to translate the sentence into pig latin.");
        layout = new GridBagLayout();
        panel = new JPanel();
        cell = new GridBagConstraints();
        panel.setLayout(layout);
        instructions.setEditable(false);

        // organize gui
        cell.gridx = 0;
        cell.gridy = 0;
        cell.gridwidth = 5;
        cell.fill = GridBagConstraints.HORIZONTAL;
        panel.add(instructions, cell);
        cell.gridx = 0;
        cell.gridy = 1;
        panel.add(inputEnglish, cell);
        cell.gridx = 0;
        cell.gridy = 3;
        panel.add(outputTranslation, cell);

        add(panel);
        TextFieldHandler tfh = new TextFieldHandler();
        inputEnglish.addActionListener(tfh);

    }

    private class TextFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){

            sentence = event.getActionCommand();
            printLatinWord();

        }
    }

    public void printLatinWord(){

        String[] tokens = sentence.split(" ");
        String text = " ";
        for(String token : tokens){

            char CharArray[] = token.toCharArray();
            char begtoend = CharArray[0];
            CharArray[0] = ' ';
            String word = new String(CharArray);
            word = word + begtoend + "ay";
            text = text + " " + word;
            outputTranslation.setText(text);

        }

    }
}

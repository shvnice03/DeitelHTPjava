/**
14.5 (Random Sentences) Write an application that uses random-number generation to create sentences. 
Use four arrays of strings called article, noun, verb and preposition. 
Create a sentence by selecting a word at random from each array in the following order: article, noun, verb, preposi- tion, article and noun. 
As each word is picked, concatenate it to the previous words in the sentence. The words should be separated by spaces.
 When the final sentence is output, it should start with a capital letter and end with a period. The application should generate and display 
 20 sentences.
The article array should contain the articles "the", "a", "one", "some" and "any"; the noun array should contain the nouns 
"boy", "girl", "dog", "town" and "car"; the verb array should contain the verbs "drove", "jumped", "ran", "walked" and "skipped"; 
the preposition array should contain the prepositions "to", "from", "over", "under" and "on".
*/

import java.security.*;
import java.util.*;

public class Ex145{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        int count = 1;
        StringBuilder buffer = new StringBuilder();
        int randomChooser1;
        int randomChooser2;
        int randomChooser3;
        int randomChooser4;

        
        // select words in arrays in order: article, noun, verb, preposition, article & noun
        String articleArray[] = {"the" , "a" , "one" , "some" , "any"};
        String nounArray[] = {"boy" , "girl" , "dog" , "town" , "car"};
        String verbArray[] = {"drove" , "jumped" , "ran" , "walked" , "skipped"};
        String prepositionArray[] = {"to" , "from" , "over" , "under" , "on"};

        for(int i = 1; i <= 20; i++){

            randomChooser1 = random.nextInt(4);
            randomChooser2 = random.nextInt(4);
            randomChooser3 = random.nextInt(4);
            randomChooser4 = random.nextInt(4);


            while(count < 7){
    
                if(count == 1 || count == 5){
    
                    buffer.append(articleArray[randomChooser1]);
                    buffer.append(" ");
    
                }
    
                if(count == 2 || count == 6){
    
                    buffer.append(nounArray[randomChooser2]);
                    
                    if(count == 2){
                        buffer.append(" ");
                    }
    
                    if(count == 6){
                        buffer.append(".");
                    }
    
                }
    
                if(count == 3){
    
                    buffer.append(verbArray[randomChooser3]);
                    buffer.append(" ");
    
                }
    
                if(count == 4){
    
                    buffer.append(prepositionArray[randomChooser4]);
                    buffer.append(" ");
    
                }

                count++;
                
            }

            System.out.println(buffer.toString());

        }
    }
}
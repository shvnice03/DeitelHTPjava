/**

14.4 (Comparing Portions of Strings) Write an application that uses String method regionMatches to compare two strings input by the user. 
The application should input the number of characters to be compared and the starting index of the comparison. 
The application should state whether the strings are equal. Ignore the case of the characters when performing the comparison.

*/

import java.util.*;

public class Ex144{
    public static void main(String[] args){

        String input;
        String input2;
        int numbOfChar;
        int startingIndex;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        input = scanner.nextLine();
        System.out.print("Enter the second string: ");
        input2 = scanner.nextLine();
        System.out.print("Enter the starting index of the comparison: ");
        startingIndex = scanner.nextInt();
        System.out.print("Enter the the number of characters to be compared: ");
        numbOfChar = scanner.nextInt();

        if(input.regionMatches(true, startingIndex, input2, startingIndex, numbOfChar)){
            System.out.println("The strings/substrings are equal.");
        }
        else{
            System.out.println("The strings/substrings are not equal.");
        }

    }
}
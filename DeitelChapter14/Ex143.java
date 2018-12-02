/**
14.3 (Comparing Strings) Write an application that uses String method compareTo to compare two strings input by the user. 
Output whether the first string is less than, equal to or greater than the second.
*/

import java.util.*;

public class Ex143{
    public static void main(String[] args){

        String input1;
        String input2;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first word: ");
        input1 = scanner.nextLine();
        System.out.println();
        System.out.print("Enter the second word: ");
        input2 = scanner.nextLine();
        System.out.println();

        if(input1.compareTo(input2) == 0){
            System.out.println("The two strings are equal.");
        }
        else if(input1.compareTo(input2) < 0){
            System.out.println(input1 + " is less than " + input2);
        }
        else if(input1.compareTo(input2) > 0){
            System.out.println(input1 + " is greater than " + input2);
        }

    }
}
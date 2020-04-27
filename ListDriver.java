package module10project;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;

/**
 * @author Dan Lewis
 * @Class: CSC205
 * @Date Written: 04/26/20
 * @Program Description: Palindrome tester using stacks and queues
 */
public class ListDriver {

	public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);    
            char userChoice = 'y';
            String input;
            
            do {
                
            System.out.println("Please enter your word or phrase: ");
            input = sc.nextLine();
            System.out.println("\nNot using Stack or Queue: ");
            isPalindrome(input);
            System.out.println("\nUsing Stack: ");
            isPalindromeStack(input);
            System.out.println("\nUsing Queue: ");
            isPalindromeQueue(input);
            
            System.out.println("\nTry again? (y for yes, any other key to exit.");
            userChoice = sc.next().charAt(0);
           
            } while(userChoice == 'y');
	}
        
        //Palindrome method NOT using Stack or Queue
        public static String isPalindrome(String inputString)    {
            
            String reverse = "";
            for(int i = inputString.length() - 1; i >= 0; i--)  {
                reverse += inputString.charAt(i);
            }
            
            boolean palindrome = true;
            for(int i = 0; i < inputString.length(); i++)   {
                if(inputString.charAt(i) != reverse.charAt(i))  {
                    palindrome = false;
                }
            }
            
            if(palindrome)  {
                System.out.println("The input String is a palindrome.");
            }
            else    {
                System.out.println("The input " + inputString + " is not a"
                        + " palindrome, it results in " + reverse);
            }
            return inputString;
        }
        
        //Palindrome method using Stack
        public static String isPalindromeStack(String inputString)    {

        Stack stack = new Stack();

        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        String reverseString = "";

        while (!stack.isEmpty()) {
            reverseString = reverseString+stack.pop();
        }

        if (inputString.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input " + inputString + " is not a"
                        + " palindrome, it results in " + reverseString);
        
        return inputString;
        }
        
        //Palindrome method using Queue
        public static String isPalindromeQueue(String inputString)  {
        
        Queue queue = new LinkedList();

        for (int i = inputString.length()-1; i >=0; i--) {
            queue.add(inputString.charAt(i));
        }

        String reverseString = "";

        while (!queue.isEmpty()) {
            reverseString = reverseString+queue.remove();
        }
        if (inputString.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input " + inputString + " is not a"
                        + " palindrome, it results in " + reverseString);
        
        return inputString;
        }
}

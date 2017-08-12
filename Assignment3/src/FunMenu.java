//=================================================================================================
// File Name: FunMenu.java
// Author: Andrew Rodriguez
// Copyright: N/A
// Description: This program is creating a fun menu.
// Revision History:
// Date              Version     Change ID          Author             Comment
// 07-23-17           1.0           1          Andrew Rodriguez     Skeleton and Print Start Message
// 07-23-17           1.1           2          Andrew Rodriguez     Get User Input     
// 07-24-17           1.2           3          Andrew Rodriguez     Leap Year and Vowels
// 07-25-17           1.3           4          Andrew Rodriguez     Integer Sum
// 07-25-17           1.4           5          Andrew Rodriguez     Code cleanup
// 07-25-17           1.5           6          Andrew Rodriguez     Extra credit
//=================================================================================================
import java.util.Scanner;

public class FunMenu
{
   public static void main(String [] args) {
      String buffer, userAnswer;
      boolean keepPlaying = true;
      Scanner inputStream = new Scanner(System.in);
      
      do{
         printStartMessage();
         // get user input
         buffer = inputStream.nextLine();
         userAnswer = buffer;

         switch(userAnswer) {
             case "s":
             case "S": naturalIntegerSum();
                      break;
             case "v":
             case "V": verifyLeapYear();
                      break;
             case "c":
             case "C": countVowels();
                      break;
             case "q":
             case "Q": exitGame();
                      break;
             case "a":
             case "A": armStrongNumber();
                      break;          
             default: printInvalidMessage(userAnswer);
                      break;
         }
      } while(keepPlaying);
   }
   
   public static void printStartMessage()
   {
      System.out.println("\t*****************************");
      System.out.println("\t*\tFUN MENU \t\t*");
      System.out.println("\t*****************************");
      System.out.println("\t\t<S>um of natural integers");
      System.out.println("\t\t<V>erify leap year");
      System.out.println("\t\t<C>ount vowels");
      System.out.println("\t\t<A>rmstrong number");
      System.out.println("\t\t<Q>uit\n");
      
      System.out.print("Please enter one of the following: 'S', 's', 'V', 'v', 'C', 'c', 'Q', 'q', 'A', 'a': ");
   }
   
   public static void printInvalidMessage(String invalidString)
   {
      System.out.println("*****************************");
      System.out.println("Error: invalid choice entered:'" + invalidString + "'.");
      System.out.println("Enter S,s or V,v or C,c or Q,q or A,a only please.");
   }
   
   
   public static void countVowels()
   {
      Scanner inputStream = new Scanner(System.in);
      String buffer, stringToCheck;
      int vowelCount = 0;
      
      // get user input
      System.out.print("Please enter a string: ");
      buffer = inputStream.nextLine();
      stringToCheck = buffer;
      
      for(int i = 0; i < stringToCheck.length(); i++ ) 
      {
         char currentCharacter = Character.toLowerCase(stringToCheck.charAt(i));
         if(currentCharacter == 'a' || currentCharacter == 'e' || currentCharacter == 'i' 
               || currentCharacter == 'o' || currentCharacter == 'u')
            vowelCount += 1;
      }

      System.out.println("The number of vowels in " + stringToCheck + " is " + vowelCount + "\n");
   }
   
   public static void verifyLeapYear()
   {
      Scanner inputStream = new Scanner(System.in);
      String buffer, resultSentence;
      int year;
      boolean result;
      
      // get user input
      System.out.print("Please enter a year: ");
      buffer = inputStream.nextLine();
      year = Integer.parseInt(buffer);
      
      result = isLeapYear(year);
      
      if(result) 
      {
         resultSentence = year + " is a leap year";
      } else 
      {
         resultSentence = year + " is not a leap year";
      }
      
      System.out.println(resultSentence + "\n");
   }
   
   public static void naturalIntegerSum()
   {
      Scanner inputStream = new Scanner(System.in);
      String buffer;
      int naturalInteger, result = 0;
      
      // get user input
      System.out.print("Please enter an integer: ");
      buffer = inputStream.nextLine();
      naturalInteger = Integer.parseInt(buffer);
      
      for(int i = 0; i < naturalInteger + 1; i++) 
      {
         result += i;
      }
      
      System.out.println("The sum of " + naturalInteger + " integers is: " + result + "\n");
   }
   
   public static boolean isLeapYear(int year) 
   {
      if (year % 4 == 0) 
      {
         if (year % 100 == 0)
         {
            if (year % 400 == 0) 
            {
               return true;
            } else
            {
               return false;
            }
         } else
         {
            return true;  
         }
      } else
      {
         return false;
      }
   }
   
   public static void armStrongNumber() 
   {
      Scanner inputStream = new Scanner(System.in);
      String resultSentence, armStrongNumberString;
      int armStrongNumber, result = 0;
      
      // get user input
      System.out.print("Please enter an integer: ");
      armStrongNumberString = inputStream.nextLine();
      armStrongNumber = Integer.parseInt(armStrongNumberString);
      
      for(int i = 0; i < armStrongNumberString.length(); i++) 
      {
         int digit =  Character.digit(armStrongNumberString.charAt(i), 10);
         
         result += (digit * digit * digit);
      }
      
      if(result == armStrongNumber) 
      {
         resultSentence = "The number you entered: " + armStrongNumber + " is an Armstrong number.";
      } else 
      {
         resultSentence = "The number you entered: " + armStrongNumber + " is not an Armstrong number.";
      }
      
      System.out.println(resultSentence + "\n");
   }
   
   public static void exitGame()
   {
      System.out.println("The fun is over. Have a nice day!!!\n");
      System.exit(0);
   }
}

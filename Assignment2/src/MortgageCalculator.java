//=================================================================================================
// File Name: MortgageCalculator.java
// Author: Andrew Rodriguez
// Copyright: N/A
// Description: This program is for calculating a mortgage for a user.
// Revision History:
// Date              Version     Change ID          Author             Comment
// 07-13-17           1.0           1          Andrew Rodriguez     Skeleton and Title
// 07-13-17           1.1           2          Andrew Rodriguez     Get User Input     
// 07-14-17           1.2           3          Andrew Rodriguez     Calculate Mortgage     
// 07-14-17           1.3           4          Andrew Rodriguez     Print Mortgage Info
// 07-14-17           1.4           5          Andrew Rodriguez     Extra Credit
// 07-14-17           1.5           6          Andrew Rodriguez     Code Cleanup
//=================================================================================================
import java.io.*;
import java.util.*;

public class MortgageCalculator
{
   public static final double PROPERTY_TAX_RATE = 1.5;
   public static int zipCode, loanPaymentYears;
   public static double annualInterestRate, principal, downPaymentPercentage;
   public static double downPayment, loanAmount, mortgageMonthlyPayment, totalPayment, monthlyPayment;
   public static String propertyFullAddress;

   public static void main(String [] args) 
   {
      getUserInput();
      loanPaymentYears = randomNumberGenerator();
      
      calculateMortageData();
      printMortgageInfo();
   }
   
   public static void calculateMortageData()
   {
      double monthlyInterestRate, propertyTaxMonthlyPayment;
      
      System.out.println("Mortgage calculator is processing your data ...  Please wait …");
      try {
         Thread.sleep(1000);   // sleep for 1 second
      }
      catch (Exception e) {
         e.printStackTrace();
         System.exit(0);
      }
      
      downPayment = principal * (downPaymentPercentage / 100);
      loanAmount = principal * ( 1 - downPaymentPercentage / 100);
      monthlyInterestRate = annualInterestRate / 1200;
      mortgageMonthlyPayment = (loanAmount * monthlyInterestRate) /
            (1 - 1 / Math.pow(1 + monthlyInterestRate,loanPaymentYears * 12));
      propertyTaxMonthlyPayment = principal * PROPERTY_TAX_RATE / 100 / 12;
      monthlyPayment = mortgageMonthlyPayment + propertyTaxMonthlyPayment;
      totalPayment = mortgageMonthlyPayment * 12 * loanPaymentYears;
   }
   
   public static void printMortgageInfo()
   {
      System.out.println("\t*****************************");
      System.out.println("\t MORTGAGE CALCULATOR RESULTS");
      System.out.println("\t*****************************");
      
      System.out.println("Property address: " + propertyFullAddress + " " + zipCode);
      System.out.format("Property value: \t\t\t\t $%9.2f%n", principal);
      System.out.format("Down payment: \t\t\t\t $%9.2f%n", downPayment);
      System.out.format("Loan amount: \t\t\t\t $%9.2f%n", loanAmount);
      System.out.format("Mortgage monthly payment: \t\t $%9.2f%n", mortgageMonthlyPayment);
      System.out.format("Monthly payment (property tax included): $%9.2f%n", monthlyPayment);
      System.out.format("Total payment: \t\t\t\t " + "$%9.2f%n", totalPayment);
   }
   
   public static int randomNumberGenerator()
   {
      // We only want 10-30 here
      Random random = new Random() ;
      return random.nextInt(20) + 10;
//      return 15;
   }
   
   public static void getUserInput()
   {
      String buffer;
      
      try (BufferedReader reader = new BufferedReader (new InputStreamReader (System.in))) {
         // get user input
         System.out.print("Enter property zip code ");
         buffer = reader.readLine( );
         zipCode = Integer.parseInt(buffer);
         
         System.out.print("Enter property address: ");
         buffer = reader.readLine( );
         propertyFullAddress = buffer;
         
         System.out.print("Enter annual interest rate (in percentage %): ");
         buffer = reader.readLine( );
         annualInterestRate = Double.parseDouble(buffer);

         System.out.print("Enter principal: ");
         buffer = reader.readLine( );
         principal = Double.parseDouble(buffer);
         
         System.out.print("Enter down payment (in percentage %): ");
         buffer = reader.readLine( );
         downPaymentPercentage = Double.parseDouble(buffer);
      }  catch (Exception e)  {
         e.printStackTrace();
         System.exit(0);
      }
   }
}

//=================================================================================================
// File Name: FruitMarket.java
// Author: Andrew Rodriguez
// Copyright: N/A
// Description: This program is to create a market where fruit can be ordered.
// Revision History:
// Date              Version     Change ID          Author             Comment
// 08-09-17           1.0           1          Andrew Rodriguez     Skeleton classes
// 08-09-17           1.1           2          Andrew Rodriguez     Add All variables   
// 08-09-17           1.2           3          Andrew Rodriguez     Add all setters and getters
// 08-10-17           1.3           4          Andrew Rodriguez     Add sorting
// 08-11-17           1.4           5          Andrew Rodriguez     Add search
// 08-11-17           1.5           6          Andrew Rodriguez     Finish implementing spec
// 08-11-17           1.6           7          Andrew Rodriguez     Cleanup
//=================================================================================================
import java.util.Random;
import javax.swing.*;

public class FruitMarket
{
   public static void main(String[] args)
   {
      OnlineSuperMarket market = null;
      market = new OnlineSuperMarket("Foothill Market", "http://foothillmarket.com");
      
      market.init();
      market.sort();
      market.run();
   }
}

class OnlineSuperMarket
{
   private static final double TAX_RATE = 0.085;
   private static final int ARRAY_SIZE = 10;
   private String marketName, webAddress;
   private Fruit[] fruits;

   public OnlineSuperMarket()
   {
      fruits = new Fruit[ARRAY_SIZE];
   }

   public OnlineSuperMarket(String marketName, String webAddress)
   {
      this.marketName = marketName;
      this.webAddress = webAddress;
      this.fruits = new Fruit[ARRAY_SIZE];
   }

   public String getMarketName()
   {
      return marketName;
   }

   public boolean setMarketName(String marketName)
   {
      this.marketName = marketName;
      return true;
   }

   public String getWebAddress()
   {
      return webAddress;
   }

   public boolean setWebAddress(String webAddress)
   {
      this.webAddress = webAddress;
      return true;
   }

   public void init()
   {
      Random generator = new Random();
      double unitPrice, weight;
      double LOW = 1.0;
      double HIGH = 20.0;
      String[] fruitNames =
      { "apple", "orange", "strawberry", "watermelon", "melon", "blueberry", "mango", "peach", "cherry", "lemon" };

      for (int i = 0; i < fruits.length; i++)
      {
         unitPrice = LOW + generator.nextDouble() * (HIGH - LOW);
         weight = LOW + generator.nextDouble() * (HIGH - LOW);
         fruits[i] = new Fruit(fruitNames[i], weight, unitPrice);
      }
   }

   public void sort()
   {
      int i, j, minIndex;
      Fruit tmp;
      int n = fruits.length;
      
      for (i = 0; i < n - 1; i++)
      {
         minIndex = i;
         for (j = i + 1; j < n; j++)
         {
            if (fruits[j].getFruitName().compareToIgnoreCase(fruits[minIndex].getFruitName()) < 0)
               minIndex = j;
         }
         if (minIndex != i)
         {
            tmp = fruits[i];
            fruits[i] = fruits[minIndex];
            fruits[minIndex] = tmp;
         }
      }
   }

   public void run()
   {
      final JPanel panel = new JPanel();
      String fruitInput, stringInTwo, intro, output;
      double lbs, cost, totalCost;
      
      intro = "Welcome to " + marketName + "\n\t" + webAddress; 
      JOptionPane.showMessageDialog( null, intro);
      
      while (true)
      {
         showFruits();
         fruitInput = JOptionPane.showInputDialog("Enter a fruit name or XXX to end ");
         if (fruitInput.equals("XXX") || fruitInput.equals("xxx"))
            quit();
         
         Fruit found = find(fruitInput);
         if (found == null)
         {
            JOptionPane.showMessageDialog(panel, "You have entered an invalid fruit", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
         }
         
         stringInTwo = JOptionPane.showInputDialog("Enter weight in lbs: ");
         lbs = Double.parseDouble(stringInTwo);
         
         cost = found.order(lbs);
         if (cost == -1)
         {
            JOptionPane.showMessageDialog(panel, "the requested purchase weight exceeds the Fruit's available weight",
                  "Error", JOptionPane.ERROR_MESSAGE);
            continue;
         }
         totalCost = cost + (cost * TAX_RATE);
         
         printPurchase(fruitInput, lbs, cost, totalCost);
      }
   }
   
   public void printPurchase(String fruitName, double lbs, double cost, double totalCost)
   {  
      String output;
      
      String formattedWeight = String.format( "%.2f", lbs);
      String formattedCost = String.format( "%.2f", cost);
      String formattedTotalCost = String.format( "%.2f", totalCost);
      
      output = "You ordered: \n Fruit: " + fruitName + "\n Weight in lbs: " +  formattedWeight + "\n Price: $" 
      + formattedCost + "\n Total cost (plus tax): $" + formattedTotalCost + "\n";
      
      JOptionPane.showMessageDialog( null, output);
   }
   
   public Fruit find(String fruitName)
   {
      {
         return binarySearch(fruitName, 0, fruits.length - 1);
      }
   }
   
   public Fruit binarySearch(String keyLast, int firstIndex, int lastIndex)
   {
      int middleIndex, result;
      
      if (firstIndex > lastIndex)
         return null;
         
      middleIndex = (firstIndex + lastIndex) / 2;
      result = keyLast.compareToIgnoreCase(fruits[middleIndex].getFruitName());
      
      if (result == 0)
         return fruits[middleIndex]; 
      else if (result < 0)
         return binarySearch(keyLast, firstIndex, middleIndex - 1);
      else
         return binarySearch(keyLast, middleIndex + 1, lastIndex); 
   }

   public void showFruits()
   {
      String output = "\tAvailable Fruits\n";

      for (Fruit fruit : fruits)
      {
         output += " " + fruit + "\n";
      }
      
      JOptionPane.showMessageDialog( null, output);
   }

   public void quit()
   {
      showFruits();
      JOptionPane.showMessageDialog( null, "Thanks for your visit and please come again");
      System.exit(0);
   }
}

class Fruit
{
   private String fruitName;
   private double weight, unitPrice;

   public Fruit()
   {
      fruitName = "?";
      weight = 0.0;
      unitPrice = 0.0;
   }

   public Fruit(String fruitName, double weight, double unitPrice)
   {
      this.fruitName = fruitName;
      this.weight = weight;
      this.unitPrice = unitPrice;
   }
   
   public double order(double fruitWeight)
   {
      if (fruitWeight > weight)
      {
         return -1;
      }
      
      weight -= fruitWeight;
      return fruitWeight * unitPrice;
   }

   public String getFruitName()
   {
      return fruitName;
   }

   public boolean setFruitName(String fruitName)
   {
      this.fruitName = fruitName;
      return true;
   }

   public double getWeight()
   {
      return weight;
   }

   public boolean setWeight(double weight)
   {
      this.weight = weight;
      return true;
   }

   public double getUnitPrice()
   {
      return unitPrice;
   }

   public boolean setUnitPrice(double unitPrice)
   {
      this.unitPrice = unitPrice;
      return true;
   }

   public String toString()
   {
      String formattedUnitPrice = String.format( "%.2f", unitPrice);
      String formattedWeight = String.format( "%.2f", weight);
      
      String fruitString = "name: " + fruitName + " price: $" + formattedUnitPrice + 
            " weight: " + formattedWeight;
      return fruitString;
   }
}
//=================================================================================================
// File Name: OrderTracker.java
// Author: Andrew Rodriguez
// Copyright: N/A
// Description: This program is for tracking orders.
// Revision History:
// Date              Version     Change ID          Author             Comment
// 08-01-17           1.0           1          Andrew Rodriguez     Skeleton classes
// 08-01-17           1.1           2          Andrew Rodriguez     Add All variables   
// 08-02-17           1.2           3          Andrew Rodriguez     Add all setters and getters
// 08-02-17           1.3           4          Andrew Rodriguez     Add init method
// 08-03-17           1.4           5          Andrew Rodriguez     Add user input
// 08-03-17           1.5           6          Andrew Rodriguez     Finish implementing spec
// 08-03-17           1.6           7          Andrew Rodriguez     Add Extra Credit GUI
//=================================================================================================
import java.util.Random;
import javax.swing.*;
 
public class OrderTracker
{
   public static void main(String[] args)
   {
      OrderProcessor ordering = new OrderProcessor("El Googs", "http://elgoogs.com");
      ordering.init();
      
      ordering.reportOrderDetails();
      
      OrderProcessor.addExtraOrders(ordering);
      
      ordering.reportOrderDetails();
   }
}

class OrderProcessor 
{
   public static final int ORDER_ARR_LENGTH = 32;
   private String companyName, companyWebsite;
   int orderCount;
   Order[] orderList;
   
   OrderProcessor()
   {
      orderCount = 0;
      orderList = new Order[ORDER_ARR_LENGTH]; 
   }
   
   OrderProcessor(String companyName, String companyWebsite)
   {
      this.companyName = companyName;
      this.companyWebsite = companyWebsite;
      orderCount = 0;
      orderList = new Order[ORDER_ARR_LENGTH];
   }
   
   public static void addExtraOrders(OrderProcessor ordering) {
      for (int count = 0; count < 3; count++) {
         ordering.addOrder();
      }
   }
   
   public void init() 
   {
      double LOW = 100.0;
      double HIGH = 1000.0;
      int quantity = 0;
      int date = 0;
      double price = 0;
     
      String [] customerNames = { "Billy Blanks", "Chuck Norris", "Tim Tebow", "A Rod", "Tom Hanks", 
                                   "Kevin Costner", "Michael Jordan", "Tom Cruise" };
      String [] productNames =  { "iPhone 7 ", "iPhone 7+", "Galaxy S8", "Galaxy2 S8+", "Galaxy Note 5", 
            "iPhone 8", "Galaxy Note 8", "LG G6" };
      Random generator = new Random ();
      for (int i=0; i < customerNames.length ; i++) { 
         quantity = generator.nextInt (10) + 1;
         date = generator.nextInt(31) + 1;                   
         price = LOW + generator.nextDouble () * (HIGH -LOW) ;        
         orderList[i] = new Order();
         orderList[i].setCustomerName(customerNames[i]);
         orderList[i].setProductName(productNames[i]);
         orderList[i].setOrderDate("03/" + date + "/2017");
         orderList[i].setQuantity(quantity);
         orderList[i].setUnitPrice(price);
         incrementOrderCount();
      }          
   }
   
   public void addOrder()
   {
      String customerName, productName, orderDate;
      int quantity;
      double unitPrice;
      
      customerName = getCustomerName();
      productName = getProductName();
      orderDate = getOrderDate();
      quantity = getQuantity();
      unitPrice = getUnitPrice();

      if (orderCount < ORDER_ARR_LENGTH) {
         orderList[orderCount - 1] = new Order(customerName, productName, orderDate, quantity, unitPrice);
         incrementOrderCount();
      } else {
         System.out.println("You have exceeded the order amount. This order has not been added.");
      }   
   }
   
   private String getCustomerName()
   {
      String stringIn;
      
      stringIn = JOptionPane.showInputDialog("What's the customer name? ");
      return stringIn;
   }
   
   private String getProductName()
   {
      String stringIn;
      
      stringIn = JOptionPane.showInputDialog("What's product name? ");
      return stringIn;
   }
   
   private String getOrderDate()
   {
      String stringIn;
      
      stringIn = JOptionPane.showInputDialog("What is the date of the order? ");
      return stringIn;
   }

   private int getQuantity()
   {
      int quantity;
      String stringIn;

      stringIn = JOptionPane.showInputDialog("How many did the customer purchase? ");
      quantity = Integer.parseInt(stringIn);
      return quantity;
   }

   private double getUnitPrice()
   {
      double price;
      String stringIn;
      
      stringIn = JOptionPane.showInputDialog("What's the cost of the of product? ");
      price = Double.parseDouble(stringIn);
      return price;
   }
   
   public String getCompanyName()
   {
      return companyName;
   }
   
   public boolean setCompanyName(String companyName)
   {
      this.companyName = companyName;
      return true;
   }
   
   public String getCompanyWebsite()
   {
      return companyWebsite;
   }
   
   public boolean setCompanyWebsite(String companyWebsite)
   {
      this.companyWebsite = companyWebsite;
      return true;
   }
   
   public int orderCount()
   {
      return orderCount;
   }
   
   private void incrementOrderCount()
   {
      orderCount++;
   }
   
   public void reportOrderDetails()
   {
      System.out.println("Customer  Product Quanity Unit Price Order Date Total cost");
      for (Order order : orderList) {
         if(order != null)
         {
            System.out.print(order.getCustomerName() + "  ");
            System.out.print(order.getProductName() + "  ");
            System.out.print(order.getQuantity() + "  ");
            System.out.format("$%6.2f", order.getUnitPrice());
            System.out.print("  " + order.getOrderDate() + "  ");
            System.out.format("$%6.2f%n", order.orderCost());
         }  
     } 
   }
}

class Order
{
   private String customerName, productName, orderDate;
   private int quantity;
   private double unitPrice;
   
   Order()
   {
      customerName = "John Doe";
      productName = "Unknown";
      unitPrice = 0.0;
      quantity = 0;
      orderDate = "03/01/2017";
   }

   Order(String customerName, String productName, String orderDate, int quantity, double unitPrice)
   {
      this.customerName = customerName;
      this.productName = productName;
      this.orderDate = orderDate;
      this.quantity = quantity;
      this.unitPrice = unitPrice;
   }
   
   public String getCustomerName()
   {
      return customerName;
   }
   
   public boolean setCustomerName(String customerName)
   {
      this.customerName = customerName;
      return true;
   }
   
   public String getProductName()
   {
      return productName;
   }
   
   public boolean setProductName(String productName)
   {
      this.productName = productName;
      return true;
   }
   
   public String getOrderDate()
   {
      return orderDate;
   }
   
   public boolean setOrderDate(String orderDate)
   {
      this.orderDate = orderDate;
      return true;
   }
   
   public int getQuantity()
   {
      return quantity;
   }
   
   public boolean setQuantity(int quantity)
   {
      this.quantity = quantity;
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
   
   public double orderCost()
   {
      return quantity * unitPrice;
   }
}
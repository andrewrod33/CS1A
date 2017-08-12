//=================================================================================================
// File Name: MovieTicket.java
// Author: Andrew Rodriguez
// Copyright: N/A
// Description: This program is to print out a movie ticket stub for Adult Admission at a movie theater.
// Revision History:
// Date              Version     Change ID          Author             Comment
// 07-04-17           1.0           1          Andrew Rodriguez     Initial creation
// 07-04-17           1.1           2          Andrew Rodriguez     Add variables     
// 07-06-17           1.2           2          Andrew Rodriguez     Add user input     
//=================================================================================================
import java.io.*;

public class MovieTicket
{
   public static void main  (String [] args ) {
      // initialize all variables with default values
      double moviePrice = 0.0;
      String movieTitle = "", movieRating = "",  theaterName = "", period = "";
      String buffer;
      int day = 0, month = 0, year = 0;
      int hours = 0, minutes = 0;
      int theaterNumber = 0;
      
      // Set values to variables using user input
      try ( BufferedReader reader = new BufferedReader (new InputStreamReader (System.in))) {   
         System.out.print ("Enter a movie price: ");
         buffer = reader.readLine ( );
         moviePrice = Double.parseDouble(buffer);
         
         System.out.print ("Enter a movie name: ");
         buffer = reader.readLine ( );
         movieTitle = buffer;
         
         System.out.print ("Enter a movie rating: ");
         buffer = reader.readLine ( );
         movieRating = buffer;
         
         System.out.print ("Enter a theater name: ");
         buffer = reader.readLine ( );
         theaterName = buffer;
         
         System.out.print ("Enter a theater number: ");
         buffer = reader.readLine ( );
         theaterNumber = Integer.parseInt(buffer);
         
         System.out.print ("Enter a period: ");
         buffer = reader.readLine ( );
         period = buffer;
         
         System.out.print ("Enter a day of the month: ");
         buffer = reader.readLine ( );
         day = Integer.parseInt(buffer);
         
         System.out.print ("Enter a month: ");
         buffer = reader.readLine ( );
         month = Integer.parseInt(buffer);
         
         System.out.print ("Enter a year: ");
         buffer = reader.readLine ( );
         year = Integer.parseInt(buffer);
         
         System.out.print ("Enter a hour of the day: ");
         buffer = reader.readLine ( );
         hours = Integer.parseInt(buffer);
         
         System.out.print ("Enter the minutes of the movie time: ");
         buffer = reader.readLine ( );
         minutes = Integer.parseInt(buffer);
      }  catch ( Exception e)  {
         e.printStackTrace ();
         System.exit (0);
      }
            
      System.out.println ("-------------------------------------------------------------------------------" +
         "-------------------------------------------------\n");
      System.out.println ("\t\t" + theaterName + "\n");
      System.out.println ("\t\t\tPresenting\n");
      System.out.println ("\t" + movieTitle + "\n");
      System.out.println ("\t" + "Show time: "+ hours + ":" + minutes + " " + period + "\t" + "Date: " 
      + month + "/" + day + "/" + year + "\n");
      System.out.println ("\t" + "Theater: " + theaterNumber + "\t\t\t" + movieRating + "\n");
      System.out.println ("\t" + "Adult Admission  $" + moviePrice + "\n");
      System.out.println ("\t" + "Don't forget to get your free small popcorn with 4 tickets or more!!!\n");
      System.out.println ("-------------------------------------------------------------------------------" +
         "-------------------------------------------------\n");
      
      System.exit (0);
   }
}

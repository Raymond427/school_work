import java.io.*;
import java.util.*;

class RandomArrayGenerator
{
   public static void main(String[] args)throws IOException
   {
      Scanner input = new Scanner(System.in);
      int size = 0;
      Random rn = new Random();
      
      System.out.print("What size array do you want? ");
      size = input.nextInt();
      int [] arr = new int[size];
      PrintWriter writer = new PrintWriter("RAG.txt", "UTF-8"); // creates and opens a file for output
      for(int i = 0; i < size; i++)
      {
         arr[i] = rn.nextInt(10); // adds random number to the array
         writer.println(arr[i]); // prints same random number to the file
      }
      writer.close(); // closes file and saves it
   }
}
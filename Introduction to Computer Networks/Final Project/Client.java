import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.*;

class Client
{
   static Socket player1, player2; //initializes the two players

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      String welcomeMessage = "";
      String message = "";
      String exitMessage = "";
      String buffer = ""; //buffer used to clear the input scanner
      int[] columnCapacity = new int[7]; //monitors the capacity of the columns
      int player1Choice = 0; //stores player 1's choice
      int player2Choice = 0; //stores player 2's choice
      try
      {
         player1 = new Socket("localhost",3000); // intitialize network gateway, listens on 3000 port
         player2 = new Socket("localhost",3000); // intitialize network gateway, listens on 3000 port
         DataInputStream reader1 = new DataInputStream(player1.getInputStream()); // creates input stream
         DataOutputStream writer1 = new DataOutputStream(player1.getOutputStream()); // creates output stream
         DataInputStream reader2 = new DataInputStream(player2.getInputStream()); // creates input stream
         DataOutputStream writer2 = new DataOutputStream(player2.getOutputStream()); // creates output stream
         welcomeMessage = reader1.readUTF(); //recieves the welcome message for player1
         welcomeMessage = reader2.readUTF(); //recieves the welcome message for player2
         System.out.print(welcomeMessage); // prints the welcome message once, just for readability
         for(int turns = 0; turns < 42; turns++) // loops until there are 42 valid inputs, filling the game board
         {
            System.out.print(reader1.readUTF()); //prints game status and instructions
            while(true) // loops until broken
            {
               try
               {
                  player1Choice = input.nextInt();// recieves input from player1
                  if ((player1Choice <= 7 && player1Choice >= 1) && !(columnCapacity[player1Choice - 1] == 6))//checks if the column chosen is full and the interger chosen is in the column range
                  {
                     columnCapacity[player1Choice - 1]++; //updates column capacity
                     writer1.writeInt(player1Choice); //sends the valid integer to the server
                     break;//breaks out of the loop
                  }
                  else
                  {
                     if (player1Choice <= 7 && player1Choice >= 1)//if the input is an integer, but not between 1 and 7
                     {
                        System.out.print("Sorry, that column is full, please enter another column: ");
                     }
                     else
                     {
                        System.out.print("Sorry, that is outside of the column range, please enter a value between 1 and 7: ");
                     }
                     buffer = input.nextLine();//clears the input
                  }
               }
               catch(InputMismatchException imme)
               {
                  System.out.print("Sorry, that input is invalid, please try again: ");
                  buffer = input.nextLine();
               }
            }
            System.out.print(reader1.readUTF());//shows the player the new status of the board after their move, and asks them to wait for player 2
            System.out.print(reader2.readUTF());// recieves input from player1
            while(true) //repeats the logic for player 2
            {
               try
               {
                  player2Choice = input.nextInt();
                  if ((player2Choice <= 7 && player2Choice >= 1) && !(columnCapacity[player2Choice - 1] == 6))
                  {
                     columnCapacity[player2Choice - 1]++;
                     writer2.writeInt(player2Choice);
                     break;
                  }
                  else
                  {
                     if (player2Choice <= 7 && player2Choice >= 1)
                     {
                        System.out.print("Sorry, that column is full, please enter another column: ");
                     }
                     else
                     {
                        System.out.print("Sorry, that is outside of the column range, please enter a value between 1 and 7: ");
                     }
                     buffer = input.nextLine();
                  }
               }
               catch(InputMismatchException imme)
               {
                  System.out.print("Sorry, that input is invalid, please try again: ");
                  buffer = input.nextLine();
               }
            }
            System.out.print(reader2.readUTF());
            buffer = input.nextLine();
         }
         exitMessage = reader1.readUTF();
         exitMessage = reader2.readUTF();
         System.out.print(exitMessage);//prints the final board after the game is over
      }
      catch(IOException IOex)
      {
         System.out.println("Sorry, There was an issue with the server. Connection Closed"); // displays when the connection closes unintentionally
      }
   }
}

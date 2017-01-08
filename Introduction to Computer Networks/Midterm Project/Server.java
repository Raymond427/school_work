import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.*;

class Server
{

   static ServerSocket server;
   static Socket client;

   public static void main(String[] args) throws IllegalArgumentException, InputMismatchException
   {
      Scanner input = new Scanner(System.in);
      char choice = 'b';
      float depositAmount = 0;
      float withdrawAmount = 0;
      float currentBalance = 0;

      try
      {
         server = new ServerSocket(3000); // creates server and sets it to the 3000 port
         client = server.accept(); // stores client that is also listening on the same port
         System.out.println("Connected to Client.");
         DataInputStream reader = new DataInputStream(client.getInputStream()); // creates input stream
         DataOutputStream writer = new DataOutputStream(client.getOutputStream());// creates output stream

         writer.writeUTF("Hello! Welcome to The Network Project Bank");
         writer.writeUTF("Enter B to view your current balance\nEnter D to deposit money into your account\nEnter W to withdraw money from your account\nEnter E to exit the application");
         while(choice != 'E' || choice != 'e')
         {
            try
            {
               choice = reader.readChar(); // recieves choice from user
               if (choice == 'B' || choice == 'b')
               {
                  writer.writeUTF("Your current balance is: $" + currentBalance);
               }
               else if (choice == 'D' || choice == 'd')
               {
                  writer.writeUTF("Please enter the amount you would like to deposit: ");
                  depositAmount = reader.readFloat();
                  currentBalance += depositAmount;
                  writer.writeUTF("$" + depositAmount + " was deposited into your account\nYou now have $" + currentBalance + " in your account");
               }
               else if (choice == 'W' || choice == 'w')
               {
                  writer.writeUTF("Please enter the amount you would like to withdraw: ");
                  withdrawAmount = reader.readFloat();
                  if (withdrawAmount > currentBalance)
                  {
                     writer.writeUTF("We're Sorry, You do not have enough funds to withdraw $" + withdrawAmount + " from your account");
                  }
                  else
                  {
                     currentBalance -= withdrawAmount;
                     writer.writeUTF("$" + withdrawAmount + " was withdrawn from your account\nYou now have $" + currentBalance + " in your account");
                  }
               }
               else if (choice == 'E' || choice == 'e')
               {
                  writer.writeUTF("Thank you for using The Network Project Bank\nGoodBye!");
                  client.close(); //closes client connection
                  server.close(); //closes server connection
                  reader.close(); //closes input data stream
                  writer.close(); //closes output data stream
                  System.out.println("Connection Closed Successfully");
                  return;
               }
               else
               {
                  throw new IllegalArgumentException("Sorry that input was invalid, Please try again"); // throws exception if something is entered other than the available choices
               }
            }
            catch (IllegalArgumentException iae)
            {
               writer.writeUTF(iae.getMessage()); //sends error message to client
            }
            catch (InputMismatchException imme)
            {
               writer.writeUTF(imme.getMessage()); //sends error message to client
            }
         }
      }
      catch(IOException IOex)
      {
         System.out.println("Sorry, There was an issue with the server. Connection Closed"); // displays when the connection closes unintentionally
      }
   }
}

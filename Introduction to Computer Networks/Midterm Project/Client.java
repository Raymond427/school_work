import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.*;

class Client
{
   static Socket client;

   public static void main(String[] args) throws IOException, InputMismatchException // possible errors that could be thrown
   {
      Scanner input = new Scanner(System.in);
      char choice = 'a';
      String welcomeMessage = "";
      String mainMenu = "";
      String message = "";
      float depositAmount = 0;
      float withdrawAmount = 0;
      String result = "";
      String exitMessage = "";

      try
      {
         client = new Socket("localhost",3000); // intitialize network gateway, listens on 3000 port
         DataInputStream reader = new DataInputStream(client.getInputStream());
         DataOutputStream writer = new DataOutputStream(client.getOutputStream());
         welcomeMessage = reader.readUTF(); // Reads welcome messge from server
         mainMenu = reader.readUTF(); // Stores menu of options
         System.out.println(welcomeMessage);
         while (choice != 'E' || choice != 'e')
         {
            System.out.println(mainMenu);
            try
            {
               choice = input.next().charAt(0);
               writer.writeChar(choice);
            }
            catch(InputMismatchException imme) //stops before writting if the input is not valid
            {
               System.out.println("Sorry, that is not a valid number input");
            }
            if (choice == 'B' || choice == 'b')
            {
               message = reader.readUTF(); // stores current balance
               System.out.println(message);
            }
            else if(choice == 'D' || choice == 'd')
            {
               try
               {
                  message = reader.readUTF();
                  System.out.println(message);
                  depositAmount = input.nextFloat();
                  writer.writeFloat(depositAmount); //sends dollar amount to be deposited
                  result = reader.readUTF(); // recieves status
                  System.out.println(result); // displays status
               }
               catch(InputMismatchException imme) // catches invalid inputs for the dollar amount
               {
                  System.out.println("Sorry, that input is invalid, please try again");
                  writer.writeFloat(0); //deposits nothing into the account
                  result = reader.readUTF();
                  System.out.println(result);//displays result
                  String buffer = input.nextLine(); //clears input for new data
               }
            }
            else if(choice == 'W' || choice == 'w')
            {
               try
               {
                  message = reader.readUTF();
                  System.out.println(message);
                  withdrawAmount = input.nextFloat();
                  writer.writeFloat(withdrawAmount); //sends dollar amount to be deposited
                  result = reader.readUTF();
                  System.out.println(result); //prints result and current balance
               }
               catch(InputMismatchException imme)
               {
                  System.out.println("Sorry, that input is invalid, please try again");
                  writer.writeFloat(0); // sends $0 to be withdrawn
                  result = reader.readUTF(); // stores status
                  System.out.println(result);
                  String buffer = input.nextLine();
               }
            }
            else if(choice == 'E' || choice == 'e')
            {
               exitMessage = reader.readUTF();
               System.out.println(exitMessage);// Says goodbye
               break;
            }
            else
            {
               result = reader.readUTF(); // reads exception message thrown from the server
               System.out.println(result);// displays exception message from the server
            }
         }
      }
      catch(IOException IOex)
      {
         System.out.println("Sorry, There was an issue with the server. Connection Closed"); // displays when the connection closes unintentionally
      }
   }
}

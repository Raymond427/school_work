import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.*;

class Server
{
   static ServerSocket server;//initializes the server
   static Socket player1, player2;//initializes the two players
   static char[][] gameBoard = new char[6][7];

   public static void main(String[] args)
   {
      int player1Choice = 0; //stores player 1's choice
      int player2Choice = 0; //stores player 2's choice
      String welcomeMessage = "Hello! Welcome to Connect Four! ";
      String endGameMessage = "The game is over! Thank you for playing!\n";
      String player1Status = "You are Player One, your piece will be X";
      String player2Status = "You are Player Two, your piece will be O";
      String instructions = "\n\nPlease select which column you would like to drop your piece in (Column 1 through 7): ";
      String player1Wait = "\n\nPlease wait for Player Two to make thier move...\n\n";
      String player2Wait = "\n\nPlease wait for Player One to make thier move...\n\n";

      clearBoard();
      try
      {
         server = new ServerSocket(3000); // creates server and sets it to the 3000 port
         player1 = server.accept(); // stores client that is also listening on the same port
         System.out.println("Connected to Player1");
         player2 = server.accept(); // stores second client that is also listening on the same port
         System.out.println("Connected to Player2");
         DataInputStream reader1 = new DataInputStream(player1.getInputStream()); // creates input stream
         DataOutputStream writer1 = new DataOutputStream(player1.getOutputStream());// creates output stream
         DataInputStream reader2 = new DataInputStream(player2.getInputStream()); // creates input stream
         DataOutputStream writer2 = new DataOutputStream(player2.getOutputStream());// creates output stream

         writer1.writeUTF(welcomeMessage); // sends welcome message to player 1
         writer2.writeUTF(welcomeMessage); // sends welcome message to player 2
         while(!boardFull()) // loops through until the game board is full
         {
            writer1.writeUTF(printBoard() + player1Status + instructions); //sending status and instructions
            player1Choice = reader1.readInt();
            insertPiece(player1Choice, 'X'); // inserts an X character into the game board
            writer1.writeUTF(printBoard() + player1Wait); //sending status and instructions
            writer2.writeUTF(printBoard() + player2Status + instructions); //sending status and instructions
            player2Choice = reader2.readInt();
            insertPiece(player2Choice, 'O'); // inserts an O character into the game board
            writer2.writeUTF(printBoard() + player2Wait); //sending status and instructions
         }
         String fullBoard = printBoard();
         writer1.writeUTF(endGameMessage + fullBoard); // sends exit message to player 1
         writer2.writeUTF(endGameMessage + fullBoard); // sends exit message to player 2
         player1.close(); //closes client connection
         player2.close(); //closes client connection
         server.close(); //closes server connection
         reader1.close(); //closes input data stream
         writer1.close(); //closes output data stream
         reader2.close(); //closes input data stream
         writer2.close(); //closes output data stream
      }
      catch(IOException IOex)
      {
         System.out.println("Sorry, There was an issue with the server. Connection Closed"); // displays when the connection closes unintentionally
      }
   }

   private static String printBoard()
   {
      String board = "\nGAME BOARD\n"; // titles the game board
      for(int row = 0; row < 6; row++) // iterates through each row
      {
         board += Arrays.toString(gameBoard[row]) + "\n"; //adds each array to the string
      }
      return board; // returns the entire string
   }

   private static boolean boardFull()
   {
      for(int column = 0; column < 7; column++) // since the columns are filled from the bottom up, only the top row needs to be checked to verify if a column is full
      {
         if (gameBoard[0][column] == ' ')
         {
            return false; // returns false if a single column is empty
         }
      }
      return true; // returns true if all columns are full
   }

   private static void insertPiece(int column, char piece)
   {
      column--; // turns column into array index
      for(int row = 5; row > -1; row--) // starts from the bottom to ensure that the board is filled from bottom to top
      {
         if(gameBoard[row][column] == ' ') // if a vacant element is found in the column
         {
            gameBoard[row][column] = piece; // the character is changed to the player's piece
            return; // the function is stopped
         }
      }
   }

   private static void clearBoard()
   {
      for (int row = 0; row < 6; row++)
      {
         for (int column = 0; column < 7; column++) // iterates through every element in the board
         {
            gameBoard[row][column] = ' '; // labels the element as an empty character
         }
      }
   }
}

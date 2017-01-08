import java.io.*;
import java.util.*;
/**
 * Class: Driver
 * Description: This class recives the input from the user and uses the files
 * and WordProcessor class accordingly.
 * 
 * @author Raymond Ferrell
 * @version (Version 1.0 October 17, 2014)
 */
public class Driver
{
    public static void main (String [ ] args)throws IOException
    {
        WordProcessor WP;  // reference to WordProcessor class
        StringTokenizer stok;  // reference to StringTokenizer class
        char choice = 'c'; // function the user wants to perform
        char again = 'y'; // allows the user to restart the program
        Scanner input; //allows the user to input text
        String inputFileName; // file name of the file to be read
        String outputFileName; // file name of the file to be written to
        String line; // a line of text from the file
        String word; // a word from the line of text
        String specWord; // the word chosen by the user to analyze
        String repWord; // word the user wants to replace specWord with
        int charCount = 0;
        int wordCount = 0;
        input = new Scanner(System.in); // creates input object
        while (again == 'y' || again == 'Y')
        {
            System.out.println("If you'd like to know how many characters are in this file, enter 'c'");
            System.out.println("If you'd like to know how many words are in this file, enter 'w'");
            System.out.println("If you'd like to know how many times a certain word appears in this file, enter 't'");
            System.out.println("If you'd like to modify all of the occurances of a certain word, enter 'm'");
            System.out.println("Enter 'Q' to quit:");
            choice = input.next().charAt(0); // User chooses function
            if (choice == 'c')
            {
                System.out.print("Please enter a path and name of a file for input: ");
                Scanner inputFile = new Scanner(System.in); //creates object for file name
                inputFileName = inputFile.nextLine(); // enters file name
                File file = new File(inputFileName); // creates an object of the given file
                if (!file.exists()) // chacks if file exists
                {
                   System.out.println("The file " + inputFileName + " does not exist.");
                   System.exit(0); // stops application
                }
                inputFile = new Scanner(file); // opens file
                WP = new WordProcessor(); // creates object of WordProcessor class
                while(inputFile.hasNext()) // runs for every line of text in the file
                {
                    line = inputFile.nextLine(); // line of text in the file
                    stok = new StringTokenizer(line); // breaks up the line by spaces into words
                    while(stok.hasMoreTokens()) // runs for every word in the line
                    {
                        word = stok.nextToken(); // lables tokens as words
                        WP.charCounter(word); // sends word to WP to count characters
                        charCount = WP.getcharCount(); // recieves result from the WP
                    }
                }
                System.out.println("The text file contains " + charCount + " characters.");
                WP.resetCount(); // resets the count to zero.
            }
            else if (choice == 'w')
            {
                System.out.print("Please enter a path and name of a file for input: ");
                Scanner inputFile = new Scanner(System.in);
                inputFileName = inputFile.nextLine();
                File file = new File(inputFileName);
                if (!file.exists())
                {
                   System.out.println("The file " + inputFileName + " does not exist.");
                   System.exit(0);
                }
                inputFile = new Scanner(file);
                WP = new WordProcessor();
                while(inputFile.hasNext())
                {
                    line = inputFile.nextLine();
                    stok = new StringTokenizer(line);
                    while(stok.hasMoreTokens())
                    {
                        word = stok.nextToken();
                        WP.wordCounter(word); // sends word to WP to count as one word
                        wordCount = WP.getwordCount(); // recieves result of WP
                    }
                }    
                System.out.println("The text file contains " + wordCount + " words.");
                WP.resetCount(); // resets the word count to zero
            }
            else if (choice == 't')
            {
                System.out.print("Please enter a path and name of a file for input: ");
                Scanner inputFile = new Scanner(System.in);
                inputFileName = inputFile.nextLine();
                File file = new File(inputFileName);
                if (!file.exists())
                {
                   System.out.println("The file " + inputFileName + " does not exist.");
                   System.exit(0);
                }
                inputFile = new Scanner(file);
                System.out.print("Please enter the word you would like to find: ");
                input = new Scanner(System.in);
                specWord = input.nextLine();
                WP = new WordProcessor();
                while(inputFile.hasNext())
                {
                    line = inputFile.nextLine();
                    stok = new StringTokenizer(line);
                    while(stok.hasMoreTokens())
                    {
                        word = stok.nextToken();
                        if (specWord.equalsIgnoreCase(word)) // if the word matches the word specified by the user
                        {
                            WP.wordCounter(word); // counts the word
                            wordCount = WP.getwordCount(); // recieves count
                        }
                    }
                }
                System.out.println("The word " + specWord + " appears " + wordCount + " times in the file.");
                WP.resetCount(); // resets word count to zero
            }
            else if (choice == 'm')
            {
                System.out.print("Please enter a path and name of a file for input: ");
                Scanner inputFile = new Scanner(System.in);
                inputFileName = inputFile.nextLine();
                File file = new File(inputFileName);
                if (!file.exists())
                {
                   System.out.println("The file " + inputFileName + " does not exist.");
                   System.exit(0);
                }
                inputFile = new Scanner(file);
                System.out.print("Please enter a name for a new file to save your modifications: ");
                Scanner outputFile = new Scanner(System.in); // creates object 
                outputFileName = outputFile.nextLine(); // assigns file name for ouput file
                System.out.println("Please enter the word you would like to change:");
                input = new Scanner(System.in);
                specWord = input.nextLine();
                System.out.println("What would you like to change the word " + specWord + " to?");
                repWord = input.nextLine();
                PrintWriter outputPrint = new PrintWriter(outputFileName); //Creates & opens File
                while(inputFile.hasNext())
                {
                    line = inputFile.nextLine();
                    stok = new StringTokenizer(line);
                    while(stok.hasMoreTokens())
                    {
                        word = stok.nextToken();
                        if (specWord.equalsIgnoreCase(word)) // if the word matches the specfied file
                        {
                            outputPrint.print(repWord + " "); // writes replacement word to output file
                        }
                        else
                        {
                            outputPrint.print(word + " "); // writes word to output file
                        }
                    }
                }
                outputPrint.close(); // closes file
                System.out.println("Your new File is complete.");
            }
            else
            {
                if (choice == 'Q' || choice == 'q')
                {
                    System.out.println("Goodbye!");
                }
                else
                {
                    System.out.println("That input is invalid");
                }
            }
            System.out.print("Enter 'Y' if you'd like to restart the word processor, enter 'Q' to quit: ");
            again = input.next().charAt(0);
        }
    }
}
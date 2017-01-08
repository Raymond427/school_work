import java.util.*;
/**
 * Class: Driver
 * Description: This class activates the ISP application, 
 * displays the cost of each package and calculates the differnce
 * between package costs in a while loop.
 * 
 * @author Raymond Ferrell 
 * @version (Version 1.0 September 21, 2014)
 */
public class ISPDriver
{
    /**
     * This method performs all of the driver's tasks
     * @param goAgain: stops the while loop if the customer enters 'n'.
     * @param hoursUsed: hours spent online
     * @param option: customer chooses thier package
     * @param choice: cost of the customer's package choice.
     * @param savingsB: money saved if the customer chose package B.
     * @param savingsC: money saved if the customer chose package C.
     */
    public static void main(String[ ] args)
    {
        Scanner input; // instance of Scanner class
        ISP myP; // instance of ISP class
        double hoursUsed;
        char option;
        char goAgain = 'Y';
        double choice;
        double savingsB;
        double savingsC;        
        while(goAgain == 'Y' || goAgain == 'y')
       {
            input = new Scanner(System.in);
            System.out.print("Please enter the number of hours you spent online: ");
            hoursUsed = input.nextDouble( );
            myP = new ISP(hoursUsed);
            System.out.print("Which internet package would you like?: ");
            option = input.next( ).charAt(0);
            choice = myP.getCost(option);
            if (option == 'A' || option == 'a')
            {
                System.out.println(hoursUsed + " hours with Package B: $" + myP.getCost('B'));
                System.out.println(hoursUsed + " hours with Package C: $" + myP.getCost('C'));
            }
            else if (option == 'B' || option == 'b')
            {
                System.out.println(hoursUsed + " hours with Package A: $" + myP.getCost('A'));
                System.out.println(hoursUsed + " hours with Package C: $" + myP.getCost('C'));
            }
            else if (option == 'C' || option == 'c') // does not display savings, since other packages are more expensive
            {
                System.out.println(hoursUsed + " hours with Package A: $" + myP.getCost('A'));
                System.out.println(hoursUsed + " hours with Package B: $" + myP.getCost('B'));
            }
            System.out.println("You're final cost is: $" + choice);
            if (option == 'A' || option == 'a')
            {
                savingsB = (choice - myP.getCost('B')); // calculates package B savings
                savingsC = (choice - myP.getCost('C')); // calculates package C savings
                if (savingsB > 0)
                {
                    System.out.println("By switching to Package B, you could have saved: $" + savingsB);
                }
                if (savingsC > 0)
                {
                    System.out.println("By switching to Package C, you could have saved: $" + savingsC);
                }
            }
            else if (option == 'B' || option == 'b')
            {
                savingsC = (choice - myP.getCost('C'));
                if (savingsC > 0)
                {
                    System.out.println("By switching to Package C, you could have saved: $" + savingsC);
                }
            }
            System.out.print("Enter a Y (or y) to restart the application: ");
            goAgain = input.next( ).charAt(0);
       }
    }
}
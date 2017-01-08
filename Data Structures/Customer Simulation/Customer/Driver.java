import java.util.Random;
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main(String[ ] args)
    {
        Queue List = new Queue();
        int AddNewCustomerChance = 0;
        Customer CustomerBeingServed;
        String TimeElapsed = "-------------------------------------------";
        int TotalCustomersServed = 0;
        int CustomersServed = 0;
        int MaximumLineLength = 0; //would be better to put in Queue class instead for scalability (adding more features later)
        int Rand;
        
        for(int minute = 0; minute < 60; minute++) // starts 60 minute simulation
        {
            AddNewCustomerChance = new Random().nextInt(4) + 1; // creates probability of adding customers
            if(AddNewCustomerChance != 4) // adds a customer if random number generates 4
            {
                System.out.println("No customers added");
            }
            else
            {
                Customer C = new Customer(); // creates new customer
                List.AddToLine(C); // adds customer to line
                System.out.println("New customer added! Queue length is now " + List.count()); // displays new length of line
                if (MaximumLineLength < List.count())
                {
                    MaximumLineLength = List.count();
                }
            }
            if(!(List.isEmpty()))
            {
                CustomerBeingServed = List.getFirst(); // sets the first customer as the one being serviced
                CustomerBeingServed.decServiceTime(); // decreases customer service time every minute
                System.out.println("Currently Servicing Customer ETA: " + CustomerBeingServed.getServiceTime() + " minutes"); // displays remaining service time
                if (CustomerBeingServed.getServiceTime() == 0)
                {
                    List.remove(); // removes currently serviced customer
                    System.out.println("Customer serviced and removed from the queue.  Queue length is now " + List.count()); // displays new length of line
                    CustomersServed++;
                }
                System.out.println(TimeElapsed); // divides minutes in display
            }
            
            else
            {
                System.out.println("Line in empty!");
                System.out.println(TimeElapsed); // divides minutes in display
            }
        }
        System.out.println("Number of customers served: " + CustomersServed);
        System.out.println("Maximum Line Length: " + MaximumLineLength);
    }
}

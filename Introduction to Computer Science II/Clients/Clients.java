/**
 * Write a description of class Clients here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clients
{
    private String last;
    private String first;
    private String address;
    private String ID ;
    private int visits;
    private double Bal;
    private int numOfPets;
    Pets [] pets = new Pets [0];
    
    /**
     * Constructor for objects of class Clients
     */
    public Clients()
    {
        last = "null";
        first = "null";
        address = "null";
        ID = "null";
        visits = 0;
        Bal = 0;
        numOfPets = 0;
    }
    
    public Clients(String inLast, String inFirst, String inAddress, String inID, int inVisits, double inBal, int inNumOfPets)
    {
        last = inLast;
        first = inFirst;
        address = inAddress;
        ID = inID;
        visits = inVisits;
        Bal = inBal;
        numOfPets = inNumOfPets;
    }
    
    public String toString()
    {
        System.out.print("First Name: " + first
        + "\nLast Name: " + last
        + "\nID: " + ID
        + "\nNumber Of Visits: " + visits
        + "\nBalance: $" + Bal
        + "\nNumber Of Pets: " + numOfPets);
        return "\n";
    }
    
    //     public int compareto(Clients other)
    //     {
    //         if (this.last > other.last)
    //         {
    //             return 1;
    //         }
    //         else if (this.last < other.last)
    //         {
    //             return -1;
    //         }
    //         else
    //         {
    //             if (this.first > other.first)
    //             {
    //                 return 1;
    //             }
    //             else if (this.first < other.first)
    //             {
    //                 return -1;
    //             }
    //         }
    //     }
    
    public boolean equals(Clients other)
    {
        return this.ID.equals(other.ID);
    }
}
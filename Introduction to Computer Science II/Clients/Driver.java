import java.io.*;
import java.util.*;
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
    /**
     * Constructor for objects of class Driver
     */
    public static void main(String args[]) throws IOException
    {
        StringTokenizer stok;
        String ClientLast;
        String ClientFirst;
        String ClientAddress;
        String ClientID;
        int ClientVisits;
        double ClientBal;
        int ClientNumOfPets = 2;
        String line;
        double totBalance = 0;
        
        String PetName;
        String PetType;
        double PetWeight;
        String DateOfShot;
        String DateOfLastVisit;
        Scanner input = new Scanner(new File("C:/clientdata.txt"));
        Clients [] people = new Clients[5];
        //line = input.nextLine();
        //stok = new StringTokenizer(line, ",");
        //while(stok.hasMoreTokens())
        //{
            for (int i = 0; i < 5; i++)
            {
                line = input.nextLine();
                stok = new StringTokenizer(line, ",");
                ClientLast = stok.nextToken();
                ClientFirst = stok.nextToken();
                ClientAddress = stok.nextToken();
                ClientID = stok.nextToken();
                ClientVisits = Integer.valueOf(stok.nextToken());
                ClientBal = Double.valueOf(stok.nextToken());
                totBalance += ClientBal;
                ClientNumOfPets = Integer.valueOf(stok.nextToken());
                people[i] = new Clients(ClientLast, ClientFirst, ClientAddress, ClientID, ClientVisits, ClientBal, ClientNumOfPets);
                Pets [] pets = new Pets[ClientNumOfPets];
                for (int k = 0; k < ClientNumOfPets; k++)
                {
                    line = input.nextLine();
                    stok = new StringTokenizer(line, ",");
                    PetName = stok.nextToken();
                    PetType = stok.nextToken();
                    PetWeight = Double.valueOf(stok.nextToken());
                    DateOfShot = stok.nextToken();
                    DateOfLastVisit = stok.nextToken();
                    pets[k] = new Pets(PetName, PetType, PetWeight, DateOfShot, DateOfLastVisit);
                }
                System.out.print(people[i].toString());
                for (int a = 0; a < ClientNumOfPets; a++)
                {
                    System.out.print(pets[a].toString());
                }
            }
        //}
        System.out.println("TOTAL BALANCE: $" + totBalance);
    }
}
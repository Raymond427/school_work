/**
 * Write a description of class Pets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pets
{
    private String name;
    private String type;
    private double weight;
    private String dateLastShot;
    private String dateLastVisit;
    
    /**
     * Constructor for objects of class Pets
     */
    public Pets()
    {
        name = "null";
        type = "null";
        weight = 0;
        dateLastShot = "null";
        dateLastVisit = "null";
    }
    
    public Pets(String inName, String inType, double inWeight, String inDateLastShot, String inDateLastVisit)
    {
        name = inName;
        type = inType;
        weight = inWeight;
        dateLastShot = inDateLastShot;
        dateLastVisit = inDateLastVisit;
    }
    
    public String toString()
    {
        System.out.println("\tName: " + name
        + "\n\tType: " + type
        + "\n\tWeight: " + weight
        + "\n\tDate Of Last Rabies Shot: " + dateLastShot
        + "\n\tDate Of Last Visit: " + dateLastVisit);
        return "\n";
    }
}
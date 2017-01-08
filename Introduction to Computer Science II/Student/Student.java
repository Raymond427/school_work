
/**
 * An class to demsonstrate the equals( ) and the
 * compareTo( ) methods,
 * 
 * @author L. Lehmann 
 * @version 5/23/2014
 */
public class Student
{
    
    private String lastName;
    private String firstName;
    private String ID;
    private double gpa;
    private int creditHours;
    private static int numStudents = 0;
   
    
    public Student()
    {
        lastName = new String("unknown");
        firstName = new String("unknown");
        ID = new String("unknown");
        gpa = 0.0;
        creditHours = 0;
        numStudents++;      
    }
    
    public Student(String inLast, String inFirst, String inID, double inGPA, int inCredits)
    {
        lastName = new String(inLast);
        firstName = new String(inFirst);
        ID = new String(inID);
        gpa = inGPA;
        creditHours = inCredits;
        numStudents++;
   
    }
    
    public String toString( )
    {   return "Total Number:  " + numStudents + "\nStudent Name: " + lastName + ", " + firstName
               + "\tID: " + ID + "\tGPA: " + gpa + "\tCredits: " + creditHours;
    }

//This is a static method- it belongs to the class and can be 
//called using the classname, Student, and not an instance of 
//class.

public static int getNumber( )
{
   return numStudents;
}
    
   
    
}

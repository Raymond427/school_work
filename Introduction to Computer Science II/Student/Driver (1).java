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
    
    public static void main(String[ ] args)throws IOException
    {
        Student myS;
        Scanner in;
        String last;
        String first;
        String id;
        double grades;
        int credits;
        
   
        in = new Scanner(new File("studentdata.txt"));
        while(in.hasNext( ))
        {
            last = in.next( );
            first = in.next( );
            id = in.next( );
            grades = in.nextDouble( );
            credits = in.nextInt( );
            in.nextLine( );
            myS = new Student(last, first, id, grades, credits);
            System.out.println(myS);
        }
        in.close( );
  }//end of main( )
}
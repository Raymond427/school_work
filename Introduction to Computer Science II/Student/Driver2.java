import java.io.*;
import java.util.*;
public class Driver2
{
    
    public static void main(String[ ] args)throws IOException
    {
        Student myS;
        Scanner in;
        String last;
        String first;
        String id;
        String line; //one line of data from the input file
        StringTokenizer stok;
        double grades;
        int credits;
        
        
   
        in = new Scanner(new File("studentdata.txt"));
        while(in.hasNext( ))
        {
            line = in.nextLine( );
            stok = new StringTokenizer(line);
            last = stok.nextToken( );
            first = stok.nextToken( );
            id = stok.nextToken( );
            grades = Double.parseDouble( stok.nextToken( ));                  
            credits = Integer.parseInt( stok.nextToken( ));
            
            myS = new Student(last, first, id, grades, credits);
            System.out.println(myS.toString( ));
        }
        in.close( );
       System.out.println("The total number of "      
           + "students is " + Student.getNumber( ) ); 
//This is how you call a static method
Sy
  }//end of main( )
}
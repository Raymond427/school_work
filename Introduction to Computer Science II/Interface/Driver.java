
/**
 * This is a test driver for your ArrayFunctions class
 * Please note how each function is called. Note the
 * parameter sent to each method and the return type of each method.
 * In some methods you are changing the original array, in other
 * methods you must create a new array to retrun to main( )
 * @author L. Lehmann
 * @version 11/23/2014
 */
public class Driver
{
   public static void main(String [ ] args)
   { 
       double [ ] testArray = {3, 6, 2, 5, 8, 4, 1, 7};
       double [ ] results;
       
       ArrayFunctions af = new ArrayFunctions( );
       
       System.out.println("This is the original array: ");
       af.printMe(testArray);
       
       System.out.println("\nThis is a test of the sortMe( ) method and the printMe( ) methods. ");
       results = af.sortMe(testArray);
       af.printMe(results);
       
       System.out.println("\nThis is a test of getMax( )");
       System.out.println("The maximum value in the array is: " +af.getMax(testArray));
       
       System.out.println("\nThis is a test of getMin( )");
       System.out.println("The minimum value in the array is: " + af.getMin(testArray));
       
       System.out.println("\nThis is a test of sumMeUp( )");
       System.out.println("The sum of the values in the array is: " +af.sumMeUp(testArray));
       
       System.out.println("\nThis is a test of reverseMe( )");
       results = af.reverseMe(testArray);
       af.printMe(results);
       
       System.out.println("\nThis is a test of whereAmI( )");
       System.out.println("The value 8 is at subscript " + af.whereAmI(testArray, 8));
       System.out.println("This is a test of when search item is not in the array: ");
       if(af.whereAmI(testArray, 505) == -1)
       {
           System.out.println("Data value is not in the array");
       }
        else
        {
            System.out.println("Data value is found at position " + af.whereAmI(testArray, 505));
        }
        
       System.out.println("\nThis is a test of doubleMySize(  )");
       testArray = af.doubleMySize(testArray);
       af.printMe(testArray);
       
       System.out.println("\nEnd of tests");
    } //end of main( )
       
}//end of Driver class

/**
 * This interface specifies several
 * methods for operations on an array of double
 * (or int) values.
 * 
 * An interface in Java 7 is made up of method headings only.
 * These are abstract methods. The interface is abstract as well but
 * because the Java compiler already "knows" this, you do not use the
 * keyword abstract in the class heading.
 * 
 * If there are any fields specified, they must be public, static, and final.
 * Because an interface is abstract, an interface cannot be instantiated.
 * 
 * An interface is used for design purposes and for allowing classes to be considered
 * various types (is-a relationship). In Java, you can only inherit 
 * from (extend)  one direct superclass, but a class can implement
 * many interfaces.
 * 
 * What a programmer does is implement an interface. This means the programmer must 
 * override every method in the interface.
 * 
 * @author Lorrie Lehmann
 * @version 11/23/2014
 */



public interface ArrayFunctionsInterface
{
	public  double [ ] sortMe(double [ ] array);///returns a new array
	public   double  getMax(double [ ] array);
 	public  double  getMin(double [ ]  array);
    public  int whereAmI(double [ ] array, double  searchValue);
    public  double sumMeUp(double [ ] array);
	public  double [ ] reverseMe(double [ ] array); //returns a new array
    public  void printMe(double [ ] array);
    public double[ ] doubleMySize(double [ ] array); //returns a new array
}
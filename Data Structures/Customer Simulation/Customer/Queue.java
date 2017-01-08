
/**
 * Write a description of class Queue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Queue
{
    // instance variables - replace the example below with your own
    private Customer FirstInLine;
    private Customer LastInLine;

    /**
     * Constructor for objects of class Queue
     */
    public Queue()
    {
        FirstInLine = null;
        LastInLine = null;
    }
    
    public Customer getFirst()
    {
        return FirstInLine; // returns the first person in line
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void AddToLine(Customer NewCustomer)
    {
        if(isEmpty()) {FirstInLine = NewCustomer;} // sets the first element as the first
        else
        {
            LastInLine.setNext(NewCustomer); // makes the current last in line point to the new last
            LastInLine = NewCustomer; // makes the new element last
        }
        LastInLine = NewCustomer;
    }
    
    public void remove()
    {
        if (!isEmpty()){FirstInLine = FirstInLine.getNext();} // points first to the second element entered (first becomes an orphan)
    }
    
    public int count()
    {
        int count = 0; // sets count to 0
        if (isEmpty())
        {return count;} // returns current count (0) as length of Queue
        else
        {
           Customer c = FirstInLine;
            while (c != null) // will run until an element points to null (the last element)
           {
               count++; // increases count by one
               c = c.getNext(); // sets c as the next element
           }
           return count; // returns the number of elements counted
        }
    }
    
    public boolean isEmpty()
    {
        return FirstInLine == null; // returns if first points to nothing
    }
}

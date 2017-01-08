
/**
 * Write a description of class PriorityQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PriorityQueue
{
    // instance variables - replace the example below with your own
    private PriorityCustomer[] heap;
    private int size;

    /**
     * Constructor for objects of class PriorityQueue
     */
    public PriorityQueue()
    {
        // initialise instance variables
        heap = new PriorityCustomer[100];
        size = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void AddToLine(PriorityCustomer newcustomer)
    {
        // put your code here
        int index = size + 1;  //where we'll add the new value
        heap[index] = newcustomer; // add new customer to that position
        while (index > 3) //while customer has parents since we dont want to swap the current customer being served, it is index > 3 instead of index > 1
        {
            int parentIndex = index/2; //get parent index 
            if (heap[parentIndex].getPriority() < newcustomer.getPriority()) // if parent value is lower
            {
                heap[index] = heap[parentIndex]; //perform swap
                heap[parentIndex] = newcustomer; //sets parent to new customer
                index = parentIndex; //update index
            }
            else
            {
                break; //no swap needed
            }
        }
        size++; //increase size
    }
    public PriorityCustomer remove()
    {
        PriorityCustomer rootCustomer = heap[1]; //store root to return when finished
        PriorityCustomer latestCustomer = heap[size]; //store last value in heap in latestCustomer
        heap[1] = latestCustomer; //take first customer and move it to latestCustomer
        heap[size] = null; //delete node at last position (b/c we moved it to latestCustomer
        int index = 1;
        while (index *2 < size) //while there is at least one child at index
        {
            int leftIndex = index*2;
            int rightIndex = leftIndex + 1;
            PriorityCustomer leftValue = heap[leftIndex];
            PriorityCustomer rightValue = new PriorityCustomer();
            if(rightIndex < size) //while there is a right child
            {
                rightValue = heap[rightIndex];
            }
            PriorityCustomer maxChild;
            int maxIndex; //find index of and value of larger child
            if(leftValue.getPriority() > rightValue.getPriority()) //put in '=' so you get FIFO (swap with left child if values are the same
            {
                maxChild = leftValue;
                maxIndex = leftIndex;
            }
            else
            {
                maxChild = rightValue;
                maxIndex = rightIndex;
            }
            if(latestCustomer.getPriority() < maxChild.getPriority()) //value is less than the larger child? swap
            {
                heap[index] = maxChild; //perform swap with larger of two children
                heap[maxIndex] = latestCustomer;
                index = maxIndex;
            }
            else
            {
                break; //value is in a valid position? stop
            }
        }
        size--;
        return rootCustomer;
    }
    public int getSize()
    {
        return size;
    }
    public PriorityCustomer getFirst()
    {
        return heap[1];
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
}

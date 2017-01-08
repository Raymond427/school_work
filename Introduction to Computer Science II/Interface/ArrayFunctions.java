/**
 * This class implements the methods named in the ArrayFunctionsInterface
 * 
 * @author Raymond Ferrell 
 * @version 11/30/2014
 */
public class ArrayFunctions implements ArrayFunctionsInterface
{
    /**
     * Description: This method creates a sorted copy of the array given to it.
     * 
     * @param doubles []: array given by the driver
     * @return sorted: an ordered copy of the given array
     */
    public double [] sortMe(double doubles[])
    {
        double temp; // a temporary placeholder for an element
        double[] sorted = new double[doubles.length]; // a new array with the same length
        for (int k = 0; k < doubles.length; k++)
        {
            sorted[k] = doubles[k]; // copies the array to sorted
        }
        for (int a = 0; a < 1000; a++)
        {
            for (int i = 0; i < (doubles.length)-1; i++)
            {
                if(sorted[i] > sorted[i+1]) // if the selected element is greater the the next
                {
                    temp = sorted[i]; // store the selected element in the temp variable
                    sorted[i] = sorted[i+1]; // replace the selected element with the new element
                    sorted[i+1] = temp; // assign the temp variable to the next element
                }
            }
        }
        return sorted; // return this sorted array
    }
    
    /**
     * Description: This method returns the element with the highest value in the array.
     * 
     * @param doubles []: array given by the driver
     * @return max: the element with the highest value
     */
    public double getMax(double doubles[])
    {
        double max = doubles[0];
        for (int k = 0; k < doubles.length; k++)
        {
            if(doubles[k] > max) // the selected element is greater than the max
            {
                max = doubles[k]; // replace the max variable with the selected element
            }
        }
        return max; // return the max element
    }
    
    /**
     * Description: This method returns the element with the lowest value in the array.
     * 
     * @param doubles []: array given by the driver
     * @return min: the element with the lowest value
     */
    public double getMin(double doubles[])
    {
        double min = doubles[0]; // set the minimum as the first element
        for (int k = 0; k < doubles.length; k++)
        {
            if(doubles[k] < min) // if the minimum is greater the the selwscted element
            {
                min = doubles[k]; // set the minimum to the selected element
            }
        }
        return min; // return the minimum value of the array
    }
    
    /**
     * Description: This method returns the the index of the element that matches the value given.
     * 
     * @param doubles []: array given by the driver
     * @param searchValue: the value to be searched for in the array
     * @return found: the index of the value, returns -1 if the value is not found.
     */
    public int whereAmI(double doubles[], double searchValue)
    {
        int found = -1; // set the found element to the error trigger
        for (int k = 0; k < doubles.length; k++)
        {
            if(doubles[k] == searchValue)
            {
                found = k; // changes the found value if the searched value is found
            }
        }
        return found; // returns the final value
    }
    
    /**
     * Description: This method returns the element with the lowest value in the array.
     * 
     * @param doubles []: array given by the driver
     * @return total: the total value of all of the elements in the array
     */
    public double sumMeUp(double doubles[])
    {
        double total = 0; // set the total to zero
        for (int k = 0; k < doubles.length; k++)
        {
            total += doubles[k]; // add the values to the total
        }
        return total; // return the total
    }
    
    /**
     * Description: This method returns a reversed copy of the array given to it.
     * 
     * @param doubles []: array given by the driver
     * @return sorted: a reversed copy of the given array
     */
    public double [] reverseMe(double doubles[])
    {
        double[] reversed = new double[doubles.length]; // a new array that is the same length as the given one
        int end = (doubles.length)-1; // assign a variable to the last index of the array
        double temp; // a temporary variable for array elements
        int a; // the number of iterations for the loop
        for (int k = 0; k < doubles.length; k++)
        {
            reversed[k] = doubles[k]; // copies the doubles variable to the reversed array
        }
        if (doubles.length%2 == 0) // if the length of the array is even
        {
            a = (doubles.length)/2; // half as many iterations as there are elements
        }
        else
        {
            a = ((doubles.length)/2)-1; // half as many elements minus one
        }
        for (int k = 0; k < a; k++)
        {
            temp = reversed[k]; // sets the temp variable to the selected element
            reversed[k] = reversed[end]; // sets the last variable to the selected
            reversed[end] = temp; // sets the selected value to the last value
            end -= 1; // moves the last index up foreward
        }
        return reversed; // returns the reversed array
    }
    
    /**
     * Description: This method displays the array
     * 
     * @param doubles []: array given by the driver
     */
    public void printMe(double doubles[])
    {
        for(int k = 0; k < doubles.length; k++)
        {
            if (doubles.length == k+1)
            {
                System.out.print(doubles[k]); // prints only the last array
            }
            else
            {
                System.out.print(doubles[k] + ", "); // prints all arrays with commas
            }
        }
    }
    
    /**
     * Description: This method doubles the length of the array given
     * 
     * @param doubles []: array given by the driver
     * @return doubleLength: the original array with twice as many elements
     */
    public double [] doubleMySize(double doubles[])
    {
        double[] doubleLength = new double[(2*doubles.length)]; // creates an array twice as long as the given one
        for (int k = 0; k < doubles.length; k++)
        {
            doubleLength[k] = doubles[k]; // copies the given array to the new one
        }
        return doubleLength; // returns the array
    }
}
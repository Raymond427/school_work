import java.util.*;
import java.io.*;

class TimeEvaluation // prints out a CSV file of the array size, and duration of each sorting algorithm
{
   private int[] array;
   private int[] tempMergArr;
   private int size = 0;
   
   public static void main (String [] args)throws IOException
   {   
      Scanner input = new Scanner(System.in);
      long startTime;
      long endTime;
      long durationB = 0;
      long durationI = 0;
      long durationM = 0;
      long durationQ = 0;
      
      Random rn = new Random();
   
      TimeEvaluation te = new TimeEvaluation(); // creates MyMergeSort object
      
      int n = 1;
      int testSize = 10;
      PrintWriter writer = new PrintWriter("EfficiencyMeasure.txt", "UTF-8");//creats and opens a log for duration times
      writer.println("Array Size,Bubble Sort,Insertion Sort,Merge Sort,QuickSort");// prints table header and moves to next line
      while (durationB < 300000000 || durationI < 300000000 || durationM < 300000000 || durationQ < 300000000) // runs until all of the sorting exceeds 0.005 minutes
      {
         int[] myarray = new int[testSize];
         for(int i = 0; i < testSize; i++)
         {myarray[i] = rn.nextInt(10);}
         te.array = myarray;
         writer.print(myarray.length + ",");//print array size
         if(durationB < 300000000) // if the duration was under 5 minutes the last iteration
         {
            durationB = te.sort(myarray, 'b'); // calls the sort algorithms
            writer.print(durationB + ","); // prints duration to file
         }
         else
         {
            writer.print(",");//prints comma
         }
         if(durationI < 300000000)
         {
            durationI = te.sort(myarray, 'i'); // calls the sort algorithms
            writer.print(durationI + ","); // prints duration to file
         }
         else
         {
            writer.print(",");//prints comma//prints comma
         }
         if(durationM < 300000000)
         {
            durationM = te.sort(myarray, 'm'); // calls the sort algorithms
            writer.print(durationM + ","); // prints duration to file
         }
         else
         {
            writer.print(",");//prints comma//prints comma
         }
         if(durationQ < 300000000)
         {
            durationQ = te.sort(myarray, 'q'); // calls the sort algorithms
            writer.print(durationQ + ","); // prints duration to file
         }
         else
         {
            writer.print(",");//prints comma
         }
         writer.println(); // goes to next row//
         testSize *= 10;// increases input size         
      }
      writer.close();// close file
   }
   
   public long sort(int[] myarray, char choice)
   {
      long duration = 0;
      this.size = myarray.length; // sets the length of the array
      if(choice == 'b')
      {
         long startTime = System.nanoTime();
         bubbleSort(myarray);
         long endTime = System.nanoTime();
         duration = endTime - startTime;
      }
      if(choice == 'i')
      {
         long startTime = System.nanoTime();
         insertionSort(myarray);
         long endTime = System.nanoTime();
         duration = endTime - startTime;
      }
      if(choice == 'm')
      {
         long startTime = System.nanoTime();
         doMergeSort(0, size - 1); // executes the merge sort
         long endTime = System.nanoTime();
         duration = endTime - startTime;
      }
      if(choice == 'q')
      {
         long startTime = System.nanoTime();
         quickSort(0, myarray.length - 1);
         long endTime = System.nanoTime();
         duration = endTime - startTime;
      }
      return duration;
   }
   
   public static void bubbleSort(int[] arr)
   {
      for (int b = 0; b < arr.length; b++)
      {
         for(int c = 0; c < arr.length - 1; c++)
         {
            if (arr[c] > arr[c+1])
            {
               int temp = arr[c];
               arr[c] = arr[c+1];
               arr[c+1] = temp;
            }
         }
      }
   }
   
   public static void insertionSort(int[] arr)
   {
      for(int d = 0; d < arr.length; d++)// iterates through whole array
      {
         for(int e = d-1; e >= 0; e--) // iterates through sorted half of array from the back
         {
            if(arr[e+1] < arr[e])//if the first element of the unsorted half is less than the last element of the sorted half
            {
               int temp = arr[e];//
               arr[e] = arr[e+1];
               arr[e+1] = temp;
            }
         }
      }
   }
      
   public void doMergeSort(int lowerIndex, int higherIndex)
   {
      if(lowerIndex < higherIndex) // base case, stops if the indexes overlap
      {
         int middle = lowerIndex + (higherIndex - lowerIndex)/2; // creates an index in the middle of the array
         doMergeSort(lowerIndex, middle); //recursively sorts upper half
         doMergeSort(middle+1, higherIndex); //recursively sorts the lower half (+1 so that the last element in the line before isn't added)
         merge(lowerIndex, middle, higherIndex); // recursively merges the two lists
      }
   }
   public void merge(int lowerIndex, int middle, int higherIndex)
   {
      int lowerMerge = lowerIndex;
      int middleMerge = middle + 1;
      int lowerOriMerge = lowerIndex;
      
      for (int i = lowerIndex; i <= higherIndex; i++)
      { // copies the elements of the array into the temporary array
            tempMergArr[i] = array[i];
      } 
      while(lowerMerge <= middle && middleMerge <= higherIndex)
      {
         if(tempMergArr[lowerMerge] <= tempMergArr[middleMerge])
         {
            array[lowerOriMerge] = tempMergArr[lowerMerge]; // replace element in original array with element in new array
            lowerMerge++;               
         }
         else
         {
            array[lowerOriMerge] = tempMergArr[middleMerge];
            middleMerge++;
         }
         lowerOriMerge++;
      }
      while(lowerMerge <= middle)
      {
         array[lowerOriMerge] = tempMergArr[lowerMerge];
         lowerOriMerge++;
         lowerMerge++;
      }
   }
   
   private void quickSort(int lowerIndex, int higherIndex)
   {  
      if(higherIndex == -1){return;} // if the array is empty, stop everything
      int partitionLower = lowerIndex; // sets the lower index for the new pivot
      int partitionHigh = higherIndex; // sets the high index for the new pivot
      int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2]; // sets pivot as the ELEMENT in the index between the partitionHigh and partitionLow
      // Divide into two arrays
      while (partitionLower <= partitionHigh) // base case, executes unless the indexes overlap
      {
          while (array[partitionLower] < pivot) // iterates until there is an elemnt that is larger than the pivot in front of the pivot
          {
              partitionLower++;
          }
          while (array[partitionHigh] > pivot) // iterates until there is an elemnt that is smaller than the pivot that is behind the pivot
          {
              partitionHigh--;
          }
          if (partitionLower <= partitionHigh) // if the lower partition index is in front of the high partition index
          {
              int temp = array[partitionLower];  //swap the elements
              array[partitionLower] = array[partitionHigh];
              array[partitionHigh] = temp;
              //move index to next position on both sides
              partitionLower++;
              partitionHigh--;
          }
      }
      // call quickSort() method recursively
      if (lowerIndex < partitionHigh) // if the element that was swapped was in a place after the last lower index
          {quickSort(lowerIndex, partitionHigh);} //set the pivot in front of the former pivot, creating a sub-array there
      if (partitionLower < higherIndex) // if the element that was swapped was in a place before the last lower index
          {quickSort(partitionLower, higherIndex);} // set the pivot behind the former pivot, creating a sub-array there
   }   
}
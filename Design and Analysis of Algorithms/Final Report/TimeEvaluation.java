import java.util.*;

class TimeEvaluation
{
   public static void main (String [] args)
   {
      Scanner input = new Scanner(System.in);
      long startTime;
      long endTime;
      long duration;
      char choice;
      Random rn = new Random();
      int size = 0;
      
      
      System.out.print("What size array would you like: ");
      size = input.nextInt();
      //input.next();
      int[] myarray = new int[size];
      for(int a = 0; a < size; a++)
      {
         myarray[a] = rn.nextInt(10);
      }
      
      System.out.println("How do you want the array sorted?: ");
      System.out.println("b for Bubble Sort");
      System.out.println("i for Insertion Sort");
      System.out.println("m for Merge Sort");
      choice = input.next().charAt(0);
      
      if (choice == 'b')
      {
         startTime = System.nanoTime();
         int[] result = bubbleSort(myarray);
         endTime = System.nanoTime();
         duration = endTime - startTime;
         toString(result, duration);
      }
      if (choice == 'i')
      {
         startTime = System.nanoTime();
         int[] result = insertionSort(myarray);
         endTime = System.nanoTime();
         duration = endTime - startTime;
         toString(result, duration);
      }
      if (choice == 'm')
      {
         startTime = System.nanoTime();
         int[] result = mergeSort(myarray);
         endTime = System.nanoTime();
         duration = endTime - startTime;
         toString(result, duration);
      }
   }
   
   public static void toString(int[] arr, long duration)
   {
      String result = "";
      for(int a = 0; a < arr.length; a++)
      {
         result += arr[a] + " ";
      }
      System.out.println(result);
      System.out.print("Finished! duration: " + duration + " nanoseconds");
   }
   
   public static int[] bubbleSort(int[] arr)
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
      return arr;
   }
   
   public static int[] insertionSort(int[] arr)
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
      return arr;
   }
   
   public static int[] mergeSort(int[] myarray) //creates an array to split and sort
   {
      int[] buffer = new int[myarray.length]; //buffer array has the same size as the current array
      split(myarray, buffer, 0, myarray.length - 1); // splits the array for sorting
      return myarray;//returns the final result
   }
   
   public static void split(int[] array, int[] buffer, int start, int end)//splits the array into halves to be sorted
   {
      if(start < end) //recurisvley reduces and sorts the array, stops when the starting index outnumbers the ending index
      {
         int middle = (start + end)/2; //sets the index where the list will split
         split(array, buffer, start, middle); //Splits first half (from frist to middle)
         split(array, buffer, middle+1, end); //Splits second half (from middle to last)
         merge(array, buffer, start, middle, end); //merges and sorts the two halves
      }
   }
   
   public static void merge(int[] array, int[] buffer, int start, int middle, int end)
   {
      for(int f = 0; f <= end; f++)//copy both halfs into the helper array
      {
         buffer[f] = array[f];
      }
      
      int bufferStart = start;
      int bufferMiddle = middle + 1;
      int current = start; // start at the beginning
      
      //Iterate through helper array, compare the left and right halves, copy back the smaller element from the two halfs into the original array
      while(bufferMiddle <= middle && bufferStart <= end)
      {
         if(buffer[bufferMiddle] <= buffer[bufferStart])
         {
            array[current] = buffer[bufferMiddle];
            bufferStart++;
         }
         else
         {
            array[current] = buffer[bufferStart];
            bufferMiddle++;
         }
         current++;
      }
      //Copy the rest of the left side of the array into the target array
      int lastElems = middle - bufferMiddle;
      for(int g = 0; g <= lastElems; g++)
      {
         array[current + g] = buffer[bufferMiddle + g];
      }
   }
}
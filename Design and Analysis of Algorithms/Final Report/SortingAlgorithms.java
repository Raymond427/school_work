import java.util.*;
import java.io.*;

class SortingAlgorithms
{
   public static void main(String [] args)throws IOException
   {
   	Scanner input = new Scanner(System.in);
   	Random rn = new Random();
      String inputFileName;
   	int size	= 0;
      char choice;
      String outputFileName;
      int fileInputInt;
      String fileOutputLine;
      
      System.out.print("Please enter a path and name of a file for input: ");
      Scanner inputFile = new Scanner(System.in); //creates object for file name
      inputFileName = inputFile.nextLine(); // enters file name
      File file = new File(inputFileName); // creates an object of the given file
      if (!file.exists()) // chacks if file exists
      {
         System.out.println("The file " + inputFileName + " does not exist.");
         System.exit(0); // stops application
      }
      inputFile = new Scanner(file); // opens file
      while(inputFile.hasNext())//determines the number of lines in the file
      {
         size++;
         fileInputInt = inputFile.nextInt();
      }
      inputFile.close();
      inputFile = new Scanner(file); // reopens file for making array
      int[] myarray = new int[size];//creates an array of those lines
      int i = 0; //iterator for adding elements to the array
      while(inputFile.hasNext())
      {
         fileInputInt = inputFile.nextInt();
         myarray[i] = fileInputInt;
         i++;
      }
      inputFile.close();
      
      System.out.println("How do you want the array sorted?: ");
      System.out.println("b for Bubble Sort");
      System.out.println("i for Insertion Sort");
      System.out.println("m for Merge Sort");
      choice = input.nextLine().charAt(0);
 

      if (choice == 'b'){toPrint(bubbleSort(myarray), inputFileName);}
      if (choice == 'i'){toPrint(insertionSort(myarray), inputFileName);}
      if (choice == 'm'){toPrint(mergeSort(myarray), inputFileName);}
   }
   
   public static void toPrint(int[] arr, String inputFileName)throws IOException
   {
      PrintWriter writer = new PrintWriter("SORTED" + inputFileName, "UTF-8");//creats and opens a sorted verion of the input file
      for(int a =	0;	a < arr.length; a++)
   	{
   		writer.println(arr[a]);
   	}
      writer.close();
      System.out.println("Finished! Check for the sorted version of your file in your folder");
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
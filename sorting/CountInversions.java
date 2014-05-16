import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CountInversions
{
	/* Counting inversions in merge sort */
	static long sort(Integer[] arr, int low, int high)
	{
		long totalInv=0;
		
		if(high > low)
		{	
			int mid = (low + high)/2;
		
			totalInv = sort(arr,low,mid);
			totalInv += sort(arr,mid+1,high);
			totalInv += mergeSort(arr, low, mid, high);
		
		}
		return totalInv;
	}
	
	public static long mergeSort(Integer array[], int lo, int mid, int n)
	{
	  long totalInv=0;
      int[] helper = new int[array.length];
      
      //Copy both halves in helper array
      for(int i=lo;i<=n;i++)
      {
    	  helper[i] = array[i];
      }
      
      int lowLeft = lo;
      int lowRight = mid+1;
      int current = lo;
      
      while(lowLeft <= mid && lowRight <=n)
      {
    	  if(helper[lowLeft] <= helper[lowRight])
    	  {
    		  array[current] = helper[lowLeft];
    		  lowLeft++;
    	  }
    	  else
    	  {
    		  array[current] = helper[lowRight];
    		  totalInv += mid-lowLeft+1;
    		  lowRight++;
    	  }
    	  
    	  current++;
      }
      
      int rem = mid-lowLeft;
      
      //Not copying last elements as they are already sorted
      for(int i=0;i<=rem;i++)
      {
    	  array[current+i] = helper[lowLeft+i];
      }
      
       return totalInv;
     }
	
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("<file-path>.<extension>"));
            ArrayList<Integer> lines = new ArrayList<Integer>();
            String line;
            
            while ((line = br.readLine()) != null) 
            {
                lines.add(Integer.parseInt(line));
            }
            br.close();
            
            Integer[] inputArray = lines.toArray(new Integer[lines.size()]);
                        
            System.out.print("Total Number of Inversions: "+sort(inputArray, 0, inputArray.length - 1));
           
            
        } 
        catch (IOException ie) 
        {
            System.out.print(ie.getMessage());
        }
	}
}

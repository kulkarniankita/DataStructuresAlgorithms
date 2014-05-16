
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MergeSort 
{
	
	static void sort(Integer[] arr, int low, int high)
	{
		if(high > low)
		{	
			int mid = (low + high)/2;
			
			sort(arr,low,mid);
			sort(arr,mid+1,high);
			mergeSort(arr, low, mid, high);
		}
	}
	
	public static void mergeSort(Integer array[], int lo, int mid, int n)
	{
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
    		  lowRight++;
    	  }
    	  current++;
      }
      int rem = mid-lowLeft;
      for(int i=0;i<=rem;i++)
      {
    	  array[current+i] = helper[lowLeft+i];
      }       
}
		
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("<file-path>.<extension>"));
            ArrayList<Integer> lines = new ArrayList<Integer>();
            String line;
            
            while ((line = br.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }
            br.close();
            
            Integer[] inputArray = lines.toArray(new Integer[lines.size()]);
            sort(inputArray, 0, inputArray.length - 1);
            
            int count=0;
            for(Integer i:inputArray)
            {
            	System.out.println(i);
            	count++;
            }
            System.out.println(count);
        } 
        catch (IOException ie) 
        {
            System.out.print(ie.getMessage());
        }
	}
}

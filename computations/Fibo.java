package computations;

public class Fibo 
{
	/*
	* Prints Fibonacci 100 numbers
	*/

	public static void fibonacciNumbers(int n)
	{
		int first = 0;
		int second = 1;
		if (n == 0) System.out.print(first + "\t");
	    if (n == 1)  System.out.print(second + "\t");
	        
      int result=0;
	  for(int i=2;i<=n;i++)
	  { 
	     result = first + second; 
	     System.out.print(result + "\t");
	     second  = first; 
	     first = result; 
	  }
	}

	public static void main(String[] args) {
		
		fibonacciNumbers(100);
	}

}

package computations;

import java.math.BigInteger;

public class Fibo 
{
	/*
	* Prints Fibonacci 100 numbers
	*/

	public static void fibonacciNumbers(int n)
	{
		BigInteger first = BigInteger.valueOf(0);
		BigInteger second = BigInteger.valueOf(1);
		
		if (n == 0) System.out.print(first + "\t");
	    if (n == 1)  System.out.print(second + "\t");
	        
	    BigInteger result;
	    
	  for(int i=2;i<=n;i++)
	  { 
	     result = first.add(second); 
	     System.out.print(result + "\t");
	     second  = first; 
	     first = result; 
	  }
	}

	public static void main(String[] args) {
		
		fibonacciNumbers(100);
	}

}

package strings;

import java.util.Hashtable;

public class FindUniqueChar 
{
	/*
	* Finds unique characters in a String
	* @findUnique Returns true or false if string found using Ascii way
	* @findHashUnique finds using Hashtable way
	*/
	
	static boolean findUnique(String str)
	{
		boolean[] hist = new boolean[256];
		for(int i=0;i<str.length();i++)
		{
			int val = str.charAt(i);
			System.out.println((char)val);
			if(hist[val])
			{
				return false;
			}
			hist[val] = true;
					
		}
		
		return true;
	}
	
	static void findHashUnique(String str)
	{
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			if(ht.containsKey(c))
			{
				ht.put(c, ht.get(c)+1);
			}
			else
			{
				ht.put(c, 1);
			}
			
		}
		System.out.print(ht);
		
	}
	public static void main(String[] args) {
		
		findUnique("ankita");
		findHashUnique("hello");
	}

}

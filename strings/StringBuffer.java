package strings;

public class StringBuffer 
{
	String str;
	StringBuffer()
	{
		
	}
	StringBuffer(String str)
	{
		this.str  = str;
	}
	
	String append(String str)
	{
		this.str += str;
		return this.str;
	}
	
	String reverse()
	{
		String newStr="";
		for(int i=str.length()-1;i >= 0;i--)
		{
			newStr += str.charAt(i);
		}
		return newStr;
	}
	
	String delete(int start,int end)
	{
		String newStr="";
		int j=0;
		for(int i=start;i<=end;i++)
		{
			if(str.charAt(j) != str.charAt(i))
			{
				newStr += str.charAt(j);
			}
			j++;
		}
		return newStr;
	}
	String substring(int start,int end)
	{
		String newStr="";
		for(int i=start;i<=end;i++)
		{
				newStr += str.charAt(i);
		}
		return newStr;
	}

}

package strings;

public class ReplaceSpace 
{
	/*
	* Replace Space in a string with %20
	*/

	static void replaceSpace(String str)
	{
		int cntSpace=0;
		int lenStr = str.length();
		for(int i=0;i<lenStr;i++)
		{
			if(str.charAt(i) == ' ')
			{
				cntSpace++;
			}
		}
		
		int newLen = lenStr+3*cntSpace;
		
		char[] arr = new char[newLen];
		
		for(int i=lenStr-1;i>=0;i--)
		{
			if(str.charAt(i) == ' ')
			{
				arr[newLen-1] = '0';
				arr[newLen-2] = '2';
				arr[newLen-3] = '%';
				newLen = newLen-3;
				
			}
			else
			{
				arr[newLen-1] = str.charAt(i);
				newLen = newLen-1;
				
			}
		}
		
		System.out.print(arr);
			
		
	}
	public static void main(String[] args) {
		
		ReplaceSpace.replaceSpace("hey there hw");
	}

}

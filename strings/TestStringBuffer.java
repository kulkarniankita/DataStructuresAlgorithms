package strings;
 
public class TestStringBuffer 
{


	public static void main(String[] args) 
	{
		
		StringBuffer s = new StringBuffer("ankita");
		String str="hey";
		
		System.out.println(s.append(str));
		System.out.println(s.reverse());
		System.out.println(s.delete(1,2));
		
		System.out.println(s.substring(3,5));
	}

}

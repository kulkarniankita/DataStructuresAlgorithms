package linkedlist;

public class LinkedList {

	/**
	 * @param args
	 */
	LinkedList next = null;
	int data;
	
	LinkedList(int d)
	{
		data = d;
	}
	
	void append(int d)
	{
		LinkedList end = new LinkedList(d);
		LinkedList n=this;
		while(n.next !=null)
		{
			n=n.next;
		}
		n.next = end;
	}
	public static void main(String[] args) 
	{
		
		LinkedList list = new LinkedList(1);
		list.append(3);
		list.append(4);
		list.append(5);
		
		
		while(list.next !=null){
			System.out.print(list.data);
			list = list.next;
		
		}
	}

}

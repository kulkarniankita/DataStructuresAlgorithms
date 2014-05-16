package linkedlist;
import linkedlist.Node;

public class LinkedMain 
{
	public static void main(String[] args) 
	{
		Node node = new Node(1);
		node.append(2);
		node.append(3);
		node.append(5);
		node.append(7);
		node.append(8);
		
		node.delete(node, 2);
		while(node.next !=null)
		{
			System.out.print(node.data);
			node = node.next;
		}
	}

}

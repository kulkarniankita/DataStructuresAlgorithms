package linkedlist;

import java.util.Hashtable;

public class Node 
{
	Node next;
	int data;
	
	Node(int d)
	{
		data = d;
	}
	
	void append(int d)
	{
		Node newNode = new Node(d);
		Node head = this;
		
		while(head.next !=null)
		{
			head = head.next;
		}
		head.next = newNode;
	}
	
	Node delete(Node n, int d)
	{
		Node head = n;
		while(head.next !=null)
		{
			if(head.next.data ==d)
			{
				head.next = head.next.next;
			}
			else
			{
			head  = head.next;
			
			}
		}
		return n;
	}
	
	void removeDups(Node n)
	{
		Node head = n;
		Hashtable ht = new Hashtable();
		Node prev = null;
		if(ht.containsKey(head.next.data))
		{
			prev.next = head.next;
		}
		else
		{
			ht.put(head.next, head.next.data);
		}
	}
	

}

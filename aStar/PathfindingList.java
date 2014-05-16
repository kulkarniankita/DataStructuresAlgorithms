package aStar;
import java.util.Collections;
import java.util.Vector;

// DO NOT EDIT THIS FILE
public class PathfindingList {
	
	/*
	 * We use this class for managing our frontier and closed list.
	 * Note that both the frontier and the closed lists underneath are
	 * just Vectors of NodeRecords with some additional functionality.
	 */

	Vector<NodeRecord> list;	
	// Constructor that constructs an empty list.
	public PathfindingList()
	{ 
		list = new Vector<NodeRecord>();
	} 
	
	// Constructor that constructs a list based on the 
	// contents of the vector passed in.
	public PathfindingList(Vector<NodeRecord> list)
	{		
		this.list = list;
	}
	
	// Return the smallest element on the list. 
	public NodeRecord smallestElement()
	{
		return Collections.min(list);
	}
	
	// Check whether the list contains a given node.
	public boolean contains(int node)
	{
		for (int i=0; i < list.size(); i++)
		{
			NodeRecord nr = list.get(i);
			if (nr.node == node) return true;
		}
		return false;
		
	}	
	// Return the NodeRecord for a given node,
	// if it exists.
	public NodeRecord find(int node)
	{
		for (int i=0; i < list.size(); i++)
		{
			NodeRecord nr = list.get(i);
			if (nr.node == node) return nr;
		}
		return null;
	}
	
	// Add NodeRecord to the list
	public void add(NodeRecord nr)
	{
		list.add(nr);
	}
	
	// Remove NodeRecord from the list
	public void remove(NodeRecord nr)
	{
		list.remove(nr);
	}
	
	// Get the size of the list.
	public int getLength()
	{
		return list.size();
	}
	
	// Return the underlying Vector.
	public Vector<NodeRecord> getList()
	{
		return list;
	}
	
	
}

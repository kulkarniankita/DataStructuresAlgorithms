package searching;


import java.util.*;

import searching.State;
public class GraphImplementation 
{
	
	public static void dfs(Node root)
	{		
		//Avoid infinite loops
		if(root == null) return;
	    System.out.print(root.getVertex() + "\t");
	    root.state = State.Visited;
	    
		for(Node n: root.getChildNodes())
		{
			//if childs state is not visited then recurse
			if(n.state == State.Unvisited)
			{
				dfs(n);
			}
		}
	}
	
	/*
	 * Breadth First Search
	 */
	public static void bfs(Node root)
	{
		//Since queue is a interface
		Queue<Node> queue = new LinkedList<Node>();
		
		if(root == null) return;
		
		root.state = State.Visited;
		 //Adds to end of queue
		queue.add(root);

		while(!queue.isEmpty())
		{
			//removes from front of queue
			Node r = queue.remove(); 
			System.out.print(r.getVertex() + "\t");
			
			//Visit child first before grandchild
			for(Node n: r.getChildNodes())
			{
				if(n.state == State.Unvisited)
				{
					queue.add(n);
					n.state = State.Visited;
				}
			}
		}
		
		
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[8];

		temp[0] = new Node("A", 3);
		temp[1] = new Node("B", 3);
		temp[2] = new Node("C", 1);
		temp[3] = new Node("D", 1);
		temp[4] = new Node("E", 1);
		temp[5] = new Node("F", 1);
		
		temp[0].addChildNode(temp[1]);
		temp[0].addChildNode(temp[2]);
		temp[0].addChildNode(temp[3]);
		
		temp[1].addChildNode(temp[0]);
		temp[1].addChildNode(temp[4]);
		temp[1].addChildNode(temp[5]);
		
		temp[2].addChildNode(temp[0]);
		temp[3].addChildNode(temp[0]);
		temp[4].addChildNode(temp[1]);
		temp[5].addChildNode(temp[1]);
		
		for (int i = 0; i < 7; i++) 
		{
			g.addNode(temp[i]);
		}
		return g;
	}

	public static void main(String[] args) {
		
		Graph gDfs = createNewGraph();
		System.out.println("--------------DFS---------------");
		dfs(gDfs.getNode()[0]);
		System.out.println();
		System.out.println();
		Graph gBfs = createNewGraph();
		System.out.println("---------------BFS---------------");
		bfs(gBfs.getNode()[0]);
		System.out.println();
		
		System.out.println("path between "+gDfs.getNode()[0].getVertex()+" and "+gDfs.getNode()[1].getVertex());
		System.out.println(search(gDfs,gDfs.getNode()[5],gDfs.getNode()[6]));
		
		
	}
	
	/*
	 * Find if there is a path between Nodes in a graph
	 */
	static boolean search(Graph g, Node start, Node end)
	{
		if(start == null || end == null) return false;
		
		start.state = State.Visited;
		
		if(start == end) return true;
		
		for(Node u: start.getChildNodes())
		{
			
			if(u.state != State.Visited)
			{
				search(g,u,end);
			}
			
			}
		return end.state == State.Visited;
	}
}

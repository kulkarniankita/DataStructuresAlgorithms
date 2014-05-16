package aStar;
public class AStarDriver
{
	public static void main(String[] args)
	{
		double[] noest = {0,0,0,0,0,0,0};
		double[][] estimates = 
		 {noest, noest, noest, noest, noest, noest, {2.6, 1.7, 1.5, 2.0, 1.0, 1.4, 0}};
		// The estimates array is a two-dimensional array where the i_th array
		// contains the distance estimates from each node to node i.
		// In this example we are only interested in the goal node (6), 
		// so all the rest are empty (zeroed out).
		// A graph is defined by its nodes and arcs.
		// Below are a few arcs. Note that each Arc is associated with a cost,
		// and connects two nodes.
		// Nodes are simply indicated by integers (there is no Node class).
		
		// e.g. the Arc between nodes 0 and 1 has a cost of 1.3
		Arc a1 = new Arc(1.3, 0, 1); // Arc(cost,fromNode, toNode)
		Arc a2 = new Arc(1.1, 0, 2);
		Arc a3 = new Arc(1.5, 1, 3);
		Arc a4 = new Arc(1.7, 1, 4);
		Arc a5 = new Arc(1.6, 2, 5);
		Arc a6 = new Arc(1.5, 2, 4);
		Arc a7 = new Arc(1.4, 4, 6);
		
		// The graph consists of nodes (just identified using integers) and 
		// an array of each node's outgoing Arcs.
		Graph graph = new Graph();
		graph.add(0, new Arc[]{a1,a2}); // graph.add(Integer, new Arc[]{a1,a2} //2-d array)
		graph.add(1, new Arc[]{a3,a4});
		graph.add(2, new Arc[]{a5,a6});
		// Some nodes have no outgoing Arcs.WITH ADMISSIBLE HEURISTICS ABOVE

		graph.add(3, new Arc[]{});
		graph.add(4, new Arc[]{a7});
		graph.add(5, new Arc[]{});
		graph.add(6, new Arc[]{});	
		
		AstarAlgorithm da = new AstarAlgorithm();	
		
		/*
		 *  We call the pathfindAStar() algorithm with our graph, a start
		 *  node, a goal node, and the heuristics estimates to our goal node.
		 *  
		 *  If a solution exists, the method will return a Vector of Arcs
		 *  representing the path to the goal.
		 */	
		System.out.println(da.pathfindAStar(graph, 0, 6, new Heuristic(6, estimates)));
		// Should print out:
		// [0 to 2, 2 to 4, 4 to 6]
	}

}


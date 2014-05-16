package aStar;
import java.util.Collections;
import java.util.Vector;

public class AstarAlgorithm {
	private NodeRecord current;
	
	/* Student 1 name: Ankita Kulkarni
	 * Student 1 number: 200105310
	 * 
	 * Student 1 name: Ralston Almeida
	 * Student 1 number: 200100294
	 * 
	 * THIS IS THE FUNCTION YOU MUST IMPLEMENT.
	 * THIS IS THE **ONLY** FUNCTION TO IMPLEMENT.
	 * Given a graph, start node, goal node, and heuristics, find a solution.
	 * Return the solution as a Vector of Arcs from start to goal.
	 */
	public Vector<Arc> pathfindAStar(Graph g, int start, int goal, Heuristic heuristic)
	{
		/*
		 * Both the frontier and the closed list
		 * contain NodeRecords, which represent a partial path
		 * using the path's end node, cost, heuristic, and the Arc
		 * to that end node.
		 *  Initially we just have the start node.
		 */
		
		NodeRecord startRecord = new NodeRecord();
		//initializes values from NodeRecord such as node, arc, costSoFar, estimatedTotalCost
		startRecord.node = start;
		startRecord.arc = null;
		startRecord.costSoFar = 0;
		startRecord.estimatedTotalCost = heuristic.estimate(start);
		/*
		 *  The frontier list contains paths (NodeRecords) that
		 *  have been seen but not fully processed.
		 */
		PathfindingList frontier = new PathfindingList(); //calls default constructor & creates a Vector list for frontier
		// Initially the frontier just contains the startRecord
		frontier.add(startRecord); //adds a start node to frontier		
		/*
		 The closed list contains paths (NodeRecords) that have
		 been seen and processed before. We keep track of the closed list because
		 we may find more than one path to a node. In those cases, we only
		 want to keep the path with the lowest cost.
		 */
		PathfindingList closed = new PathfindingList(); //calls default constructor & creates a Vector list for closed
		/*
		 * A Vector of Arcs that will be used to return the solution.
		 */
		Vector<Arc> path = new Vector<Arc>(); //creates empty arc called path
		/*
		 * The following pseudo-code steps you through the rest of the algorithm.
		/* * WHILE the frontier is not empty: */
		while((frontier.getLength() > 0))
		{
			// * current = smallest NodeRecord from the frontier.
			current = frontier.smallestElement();  
			// *     IF current.node == goal:
			// *         BREAK
			if(current.node == goal) break;
			// *     arcs = neighbours of current.node (outgoing Arcs).   
			Arc[] arcs;
			arcs = 	g.getArcs(current.node);
			int endNode;
			double endNodeCost;
			// *     FOR arc IN arcs:
			for(Arc arc: arcs)
			    {
				// endNode = end node of arc
			        endNode = arc.getToNode();
			    //  endNodeCost = current's cost so far + arc's cost   
			        endNodeCost = current.costSoFar + arc.getCost();
			       // endNodeCost  = current.arc.getCost() + startRecord.costSoFar;
			      
			    //    NodeRecord endNodeRecord;
				// double endNodeHeuristic;
			        NodeRecord endNodeRecord;
					double endNodeHeuristic;
				//  IF closed contains endNode:
					//node has been processed previously)	
					if(closed.contains(endNode))
					  {
				// endNodeRecord = get NodeRecord from closed list
						  endNodeRecord = closed.list.get(endNode);
						//  System.out.println("endNodeRecord: "+endNodeRecord);
				/*		  IF endNodeRecord.costSoFar <= endNodeCost:
				 *            (we didn't find a shorter path)
				 *                CONTINUE */
				 
						  if(endNodeRecord.costSoFar <= endNodeCost)
						  {
							  continue;
						  }
						  else
						  {
				 /*            ELSE REMOVE endNodeRecord from closed list*/
							  closed.list.remove(endNode);
							   
						  }
						  /*
							 *            // We can figure out its heuristic value based on 
							 *            // the previous costSoFar and estimatedTotalCost.
							 *            // Saves us from having to call the (possibly expensive)
							 *            // heuristic function.
							 *            endNodeHeuristic = endNodeRecord.estimatedTotalCost -
							 *                                  endNodeRecord.costSoFar
							 *            
							 */
						  endNodeHeuristic = endNodeRecord.estimatedTotalCost - endNodeRecord.costSoFar;
					  }
					/*  ELSE IF frontier contains endNode:
					 *        (node has been seen before but not processed yet)   */
					 else if(frontier.contains(endNode))
					 {
						 //  endNodeRecord = get NodeRecord from frontier
						 endNodeRecord = frontier.find(endNode);
				    /* IF endNodeRecord.costSoFar <= endNodeCost:
					 *            (we didn't find a shorter path)
					 *                CONTINUE    */
						if(endNodeRecord.costSoFar <= endNodeCost)
						 {
							continue;
						 }
					// endNodeHeuristic = endNodeRecord.estimatedTotalCost - endNodeRecord.costSoFar
						 endNodeHeuristic = endNodeRecord.estimatedTotalCost -endNodeRecord.costSoFar;
					 }
					/*                   
					 *		ELSE (we have an unvisited node):               
					 */
					 else
					 {
						 // endNodeRecord = create new NodeRecord for this node.
						 endNodeRecord = new NodeRecord();
						 /* endNodeRecord.node = endNode
						endNodeHeuristic = call heuristic function    */
						 endNodeHeuristic = heuristic.estimate(goal);
					 }	 
					
				       // We're here if we need to update the NodeRecord.
						// Update cost, estimate and Arc.    */
						 endNodeRecord.node = endNode;
						  //endNodeRecord.cost = endNodeCost
						 endNodeRecord.costSoFar = endNodeCost;
						 //endNodeRecord.connection = connection 
						 endNodeRecord.arc = arc;
						 // endNodeRecord.estimateTotalCost = endNodeCost + endNodeHeuristic
						 endNodeRecord.estimatedTotalCost = endNodeCost + endNodeHeuristic;
						 
						 // Add the new path to the frontier
						 /*		  IF frontier does NOT contain endNode:
						 *            ADD endNodeRecord to frontier           
						 *     */
						 if(!frontier.contains(endNode))
						 {
							 frontier.add(endNodeRecord);
							 
						 }
					 }
						/* // We have finished looking at Arcs for current node.
						 *    REMOVE current from frontier
						 */
					frontier.remove(current);
					// ADD current to closed list
					closed.list.add(current);
			    }
		//*END WHILE
		/* 
		 * IF current.node != goal:
		 *    return null
		 *    (the frontier is empty and we didn't find a solution)
		*/
		if(current.node != goal)
		{
			return null;
		}
		/* 
		 *  ELSE:
		 *    (we have a solution)
		 * 		Work backwards to reconstruct the path to a goal.
		 *     You will return a Vector of Arcs.
		 */
		else{
			 /*    WHILE current.node != start:   */
			while(current.node !=start)
			{
				// ADD current.arc to path
				path.add(current.arc);
				// current = closed.find(current.arc.getFromNode());
				current = closed.find(current.arc.getFromNode());
			}
		}
		//REVERSE vector (put in order from start to goal)
			Collections.reverse(path);
		// RETURN vector	
			return path;
	}
}

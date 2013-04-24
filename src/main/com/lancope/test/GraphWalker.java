/**
 * Instantiates a Graph and executes the following methods:
 * 
 * 1. walkGraph# - Returns ArrayList containing every GNode in the graph. 
 * 		each node appears in the ArrayList exactly once.
 * 2. paths# -  return a ArrayList of ArrayLists, representing all
   possible paths through the graph starting at 'node'. The ArrayList
   returned can be thought of as a ArrayList of paths, where each path
   is represented as an ArrayList of GNodes.
 */
package com.lancope.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author andrew
 *
 */
public class GraphWalker {

	/**
	 * @param args - none
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		GraphWalker graphWalker = new GraphWalker();
		
		ArrayList<GNode> walkedGraph = graphWalker.walkGraph(GraphWalker.buildGraph());
		
		for(GNode graph : walkedGraph)
		{
			System.out.println(graph.getName());
		}

	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ArrayList walkGraph(GNode node) {
		
		if (node.getChildren().length == 0) {			
			ArrayList<GNode> list = new ArrayList<GNode>();
			list.add(node);
			return list;
		} else {
			ArrayList<GNode> list = new ArrayList<GNode>();
			for(GNode child : node.getChildren())
			{
				list.addAll(walkGraph(child));
			}
			list.add(node);
			return list;
		}
	}


	/*
	 *						node-3
	 *			node-1  <
	 * trunk <				node-4
	 *			node -2
	 *
	 */
	public static GNode buildGraph()
	{
		List<GNode> emptyChildren = Collections.emptyList();
		GNode nodeTwo = new Graph("node-2", emptyChildren);			
		GNode nodeThree = new Graph("node-3", emptyChildren);
		GNode nodeFour = new Graph("node-4", emptyChildren);
		
		List<GNode> nodeOneChildren = new ArrayList<GNode>();
		nodeOneChildren.add(nodeThree);
		nodeOneChildren.add(nodeFour);
		GNode nodeOne = new Graph("node-1", nodeOneChildren);
		
		List<GNode> trunkChildren = Arrays.asList(nodeOne, nodeTwo);
		GNode trunk = new Graph("trunk", trunkChildren);
		
		return trunk;
	}

}

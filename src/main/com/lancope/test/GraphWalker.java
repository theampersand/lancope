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

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
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
		
		System.out.println("Problem 1");
		for(GNode graph : walkedGraph)
		{
			System.out.println(graph.getName());
		}
		
		System.out.println("\nProblem 2");
		ArrayList<ArrayList> paths = graphWalker.paths(GraphWalker.buildGraph());
		
		StringBuilder pathOutputString = new StringBuilder();
		pathOutputString.append("Paths: ( ");
		for (ArrayList path : paths) {
			pathOutputString.append("(");
			for (Object nodeName : path) {
				pathOutputString.append(nodeName);
				pathOutputString.append(" ");
			}
			pathOutputString.append(") ");
		}
		pathOutputString.append(" )");
		
		System.out.println(pathOutputString.toString());

	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList walkGraph(GNode node) {
		
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList paths(GNode node)
	{
		if (node.getChildren().length == 0)
		{
			ArrayList path = new ArrayList();
			ArrayList thisNode = new ArrayList();
			thisNode.add(node.getName());
			path.add(thisNode);
			return path;
		}
		else
		{
			ArrayList<ArrayList> childPathsUnderThisNode = new ArrayList();
			for (GNode child : node.getChildren()) { 
				ArrayList<ArrayList> childPaths = paths(child);
				for(ArrayList childPath : childPaths)
				{
					childPath.add(0, node.getName());
					childPathsUnderThisNode.add(childPath);
				}
			}
			return childPathsUnderThisNode;
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

/**
 * Implements graph
 */
package com.lancope.test;

import java.util.Collections;
import java.util.List;

/**
 * @author andrew
 *
 */
public class Graph implements GNode {

	private List<GNode> children = Collections.emptyList();
	private String name = new String();
	
	public Graph(String name, List<GNode> children)
	{
		if (name == null) {
			this.name = "";
		} else {
			this.name = name;
		}
		
		if (children == null || children.size() == 0) {	
			this.children = Collections.emptyList();
		} else {
			this.children = children;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lancope.test.one.GNode#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see com.lancope.test.one.GNode#getChildren()
	 */
	@Override
	public GNode[] getChildren() {
		return (GNode[]) this.children.toArray(new GNode[0]);
	}
	
	public void addChild(GNode graph)
	{
		if (isGraphEligibileToBeAdded(graph)) {
			this.children.add(graph);
		} 
	}
	
	private boolean isGraphEligibileToBeAdded(GNode graph)
	{
		if (graph != null) {
			for(GNode child : this.children)
			{
				if(graph.getName().equals(child.getName()))
				{
					return false;
				}
			}
			
			return true;
		} 
		else {
			return false;
		}
	}
	

}

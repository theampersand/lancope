/**
 * Implements graph
 */
package com.lancope.test;

import java.util.ArrayList;

/**
 * @author andrew
 *
 */
public class Graph implements GNode {

	ArrayList<Graph> children = new ArrayList<Graph>();
	
	/* (non-Javadoc)
	 * @see com.lancope.test.one.GNode#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lancope.test.one.GNode#getChildren()
	 */
	@Override
	public GNode[] getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.lancope.test;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	
	List<GNode> emptyChildrenList;
	Graph graphWithNoChildren;
	
	@Before
	public void before() {
		emptyChildrenList = Collections.emptyList();
		graphWithNoChildren = new Graph("graph", emptyChildrenList);
	}

	@Test
	public void testGetNameNotNull() {
		assertNotNull(graphWithNoChildren.getName());
		
		graphWithNoChildren = new Graph(null, null);
		assertNotNull(graphWithNoChildren.getName());
	}
	
	@Test
	public void testGetChildrenNotNull() {
		assertNotNull(graphWithNoChildren.getChildren());
		
		graphWithNoChildren = new Graph(null, null);
		assertNotNull(graphWithNoChildren.getChildren());
	}

	@Test
	public void getChildren_returnsZeroWhenGraphHasNoChildren() {
		assertTrue(graphWithNoChildren.getChildren().length == 0);
	}
	
	@Test
	public void getChildren_returnsNumberGreaterThanZeroWhenGraphHasChildren() {
		assertTrue(GraphWalker.buildGraph().getChildren().length > 0);
	}

}

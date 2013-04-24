package com.lancope.test;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class GraphTest {
	
	List<GNode> emptyChildrenList = Collections.emptyList();
	Graph graphWithNoChildren = new Graph("graph", emptyChildrenList);

	@Test
	public void testGetName() {
		assertNotNull(graphWithNoChildren.getName());
	}

	@Test
	public void getChildren_returnsZeroWhenGraphHasNoChildren() {
		assertTrue(graphWithNoChildren.getChildren().length == 0);
	}
	
	@Test
	public void getChildren_returnsNumberGreaterThanZeroWhenGraphHasChildren() {
		assertTrue(graphWithNoChildren.getChildren().length > 0);
	}

}

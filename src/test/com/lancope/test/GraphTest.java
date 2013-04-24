package com.lancope.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {
	
	Graph testGraph = new Graph();

	@Test
	public void testGetName() {
		assertNotNull(testGraph.getName());
	}

	@Test
	public void getChildren_returnsZeroWhenGraphHasNoChildren() {
		assertTrue(testGraph.getChildren().length == 0);
	}
	
	@Test
	public void getChildren_returnsNumberGreaterThanZeroWhenGraphHasChildren() {
		assertTrue(testGraph.getChildren().length > 0);
	}

}

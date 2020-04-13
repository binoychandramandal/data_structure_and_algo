package com.krishna.tree;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BSTTest {

	BST<Integer> bst;

	@Before
	public void setUp() throws Exception {
		bst = new BST<>();
	}

	@After
	public void tearDown() throws Exception {
		bst = null;
	}

	@Test
	public void testAddForSuccess() {
		populateTree();
		assertEquals(4, bst.size());
	}

	@Test
	public void testexistsElements() {
		populateTree();
		assertEquals(false, bst.contains(4));
		assertEquals(true, bst.contains(10));
		assertEquals(false, bst.contains(null));
	}

	@Test
	public void testElementsCount() {
		assertEquals(0, bst.size());
		populateTree();
		assertEquals(4, bst.size());
	}

	private void populateTree() {
		bst.add(20);
		bst.add(9);
		bst.add(25);
		bst.add(10);
	}

}

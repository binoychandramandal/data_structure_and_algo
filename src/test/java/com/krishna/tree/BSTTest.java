package com.krishna.tree;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BSTTest {
	
	BST<Integer> bst;

	@Before
	public void setUp() throws Exception {
		bst=new BST<>();
	}

	@After
	public void tearDown() throws Exception {
		bst=null;
	}

	@Test
	public void testAddForSuccess() {
		bst.add(10);
		bst.add(20);
		bst.add(9);
		bst.add(25);
		assertEquals(4, bst.size());

	}

}

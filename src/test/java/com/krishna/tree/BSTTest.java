package com.krishna.tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
	public void test_AddForSuccess() {
		populateTree();
		assertEquals(4, bst.size());
	}

	@Test
	public void test_existsElements() {
		populateTree();
		assertEquals(false, bst.contains(4));
		assertEquals(true, bst.contains(10));
		assertEquals(false, bst.contains(null));
	}

	@Test
	public void test_ElementsCount() {
		assertEquals(0, bst.size());
		populateTree();
		assertEquals(4, bst.size());
	}

	@Test
	public void test_PreOrderIterable() {
		populateTree();
		List<Integer> actualList = Arrays.asList(20, 9, 10, 25);
		List<Integer> resultList = new ArrayList<>();
		Iterator<Integer> ite = bst.iterator();
		while (ite.hasNext()) {
			resultList.add(ite.next());
		}
		assertEquals(actualList.size(), resultList.size());
		for (int i = 0; i < actualList.size(); i++) {
			assertTrue(actualList.get(i).equals(resultList.get(i)));
		}
	}

	@Test
	public void test_InOrderIterable() {
		populateTree();
		List<Integer> actualList = Arrays.asList(9, 10, 20, 25);
		List<Integer> resultList = new ArrayList<>();
		Iterator<Integer> ite = bst.dfsInOrderiterator();
		while (ite.hasNext()) {
			resultList.add(ite.next());
		}
		assertEquals(actualList.size(), resultList.size());
		for (int i = 0; i < actualList.size(); i++) {
			assertTrue(actualList.get(i).equals(resultList.get(i)));
		}
	}

	@Test
	public void test_PostOrderIterable() {
		populateTree();
		List<Integer> actualList = Arrays.asList(10, 9, 25, 20);
		List<Integer> resultList = new ArrayList<>();
		Iterator<Integer> ite = bst.dfsPostOrderiterator();
		while (ite.hasNext()) {
			resultList.add(ite.next());
		}
		assertEquals(actualList.size(), resultList.size());
		for (int i = 0; i < actualList.size(); i++) {
			assertTrue(actualList.get(i).equals(resultList.get(i)));
		}
	}

	@Test
	public void test_LevelOrderIterableForEmptyTree() {
		Iterator<Integer> ite = bst.bfsiterator();
		while (ite.hasNext()) {
			assertNull(ite.next());
		}
		assertTrue(bst.size()==0);
	}
	
	@Test
	public void test_Min() {
		populateTree();
		assertTrue(bst.min()==9);
		assertFalse(bst.min()==30);
	}
	
	@Test
	public void test_Max() {
		populateTree();
		assertTrue(bst.max()==25);
		assertFalse(bst.max()==9);
	}
	
	@Test
	public void test_Delete() {
		populateTree();
		assertTrue(bst.size()==4);
		assertFalse(bst.deleteNodeIteratively(25)==null);
	}
	
	

	private void populateTree() {
		bst.add(20);
		bst.add(9);
		bst.add(25);
		bst.add(10);
	}

}

package com.krishna.tree;


/**
 * Binary Search Tree is a node-based binary tree data structure which has the
 * following properties: The left subtree of a node contains only nodes with
 * keys lesser than the node’s key. The right subtree of a node contains only
 * nodes with keys greater than the node’s key. The left and right subtree each
 * must also be a binary search tree.
 * 
 * @author Krishna
 *
 * @param <Item>
 */
public class BST<Item extends Comparable<Item>> {

	private TreeNode<Item> root;

	private int length;

	/**
	 * Check empty or not
	 * 
	 * @return tree if it empty or else false.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Return length of tree
	 * 
	 * @return
	 */
	public int size() {
		return length;
	}

	/**
	 * Add data. Duplicate does not support
	 * 
	 * @param data
	 */
	public void add(Item data) {
		
		if(data==null)
			return;
		TreeNode<Item> newNode = new TreeNode<Item>(data);
		if (isEmpty()) {
			root = newNode;
		} else {
			TreeNode<Item> pre = null;
			TreeNode<Item> current = root;
			while (current != null) {
				pre = current;
				if (current.getData().compareTo(data) > 0) {
					current = current.getLeft();
				} else {
					current = current.getRight();
				}
			}
			if (pre.getData().compareTo(data) > 0)
				pre.setLeft(newNode);
			else
				pre.setRight(newNode);
		}
		length++;
	}

}

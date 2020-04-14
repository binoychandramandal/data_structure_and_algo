package com.krishna.tree;

/**
 * TreeNode<T> holds data and tree internal structure information.
 * 
 * @author Krishna
 *
 * @param <Item>
 */
public class TreeNode<Item extends Comparable<Item>> {
	/**
	 * Data holder for consumer use only
	 */
	private Item data;

	/**
	 * Internal structure holder for tree
	 */
	private TreeNode<Item> left;

	private TreeNode<Item> right;

	public TreeNode() {
	}

	public TreeNode(Item data) {
		this(data, null, null);
	}

	public TreeNode(TreeNode<Item> left, Item data) {
		this(data, left, null);
	}

	public TreeNode(Item data, TreeNode<Item> right) {
		this(data, null, right);
	}

	public TreeNode(Item data, TreeNode<Item> left, TreeNode<Item> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Item getData() {
		return data;
	}

	public void setData(Item data) {
		this.data = data;
	}

	public TreeNode<Item> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<Item> left) {
		this.left = left;
	}

	public TreeNode<Item> getRight() {
		return right;
	}

	public void setRight(TreeNode<Item> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return data + "";
	}

}

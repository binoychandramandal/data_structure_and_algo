package com.krishna.tree;

/**
 * TreeNode<T> holds data and tree internal structure information.
 * 
 * @author Krishna
 *
 * @param <T>
 */
public class TreeNode<T extends Comparable<T>> {
	/**
	 * Data holder for consumer use only
	 */
	private T data;

	/**
	 * Internal structure holder for tree
	 */
	private TreeNode<T> left;

	private TreeNode<T> right;

	public TreeNode() {
	}

	public TreeNode(T data) {
		this(data, null, null);
	}

	public TreeNode(TreeNode<T> left, T data) {
		this(data, left, null);
	}

	public TreeNode(T data, TreeNode<T> right) {
		this(data, null, right);
	}

	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return data + "";
	}

}

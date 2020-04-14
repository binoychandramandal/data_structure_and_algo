package com.krishna.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

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
public class BST<Item extends Comparable<Item>> implements Iterable<Item> {

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
		if (data == null)
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

	/**
	 * Find minimum value
	 * 
	 * @return
	 */
	public Item min() {
		TreeNode<Item> current = root;
		while (current.getLeft() != null)
			current = current.getLeft();
		return current == null ? null : current.getData();
	}

	/**
	 * Find maximum value
	 * 
	 * @return
	 */
	public Item max() {
		TreeNode<Item> current = root;
		while (current.getRight() != null)
			current = current.getRight();
		return current == null ? null : current.getData();
	}

	public TreeNode<Item> deleteNodeIteratively(Item value) {
		TreeNode<Item> parent = null, current = root;
		boolean hasLeft = false;

		if (current == null)
			return current;

		while (current != null) {
			if (current.getData().compareTo(value) == 0) {
				break;
			}
			parent = current;
			if (current.getData().compareTo(value) > 0) {
				hasLeft = true;
				current = current.getLeft();
			} else {
				hasLeft = false;
				current = current.getRight();
			}
		}

		if (parent == null) {
			return deleteNodeIteratively(current);
		}

		if (hasLeft) {
			parent.setLeft(deleteNodeIteratively(current));
		} else {
			parent.setRight(deleteNodeIteratively(current));
		}

		return root;
	}

	private TreeNode<Item> deleteNodeIteratively(TreeNode<Item> node) {

		if (node != null) {
			if (node.getLeft() == null && node.getRight() == null) {
				return null;
			}

			if (node.getLeft() != null && node.getRight() != null) {
				TreeNode<Item> inOrderSuccessor = deleteInOrderSuccessorDuplicate(node);
				node.setData(inOrderSuccessor.getData());
			} else if (node.getLeft() != null) {
				node = node.getLeft();
			} else {
				node = node.getRight();
			}
		}

		return node;
	}

	private TreeNode<Item> deleteInOrderSuccessorDuplicate(TreeNode<Item> node) {
		TreeNode<Item> parent = node;
		node = node.getRight();
		boolean rightChild = node.getLeft() == null;

		while (node.getLeft() != null) {
			parent = node;
			node = node.getLeft();
		}

		if (rightChild) {
			parent.setRight(node.getRight());
		} else {
			parent.setLeft(node.getRight());
		}

		node.setRight(null);
		return node;
	}

	/**
	 * exists given data or not
	 * 
	 * @param data
	 */
	public boolean contains(Item data) {
		boolean exists = false;
		if (data == null)
			return exists;
		TreeNode<Item> current = root;
		while (current != null) {
			if (current.getData().compareTo(data) == 0)
				return !exists;
			if (current.getData().compareTo(data) > 0) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return exists;
	}

	public Iterator<Item> iterator() {
		return new DepthFirstPreOrderIterator();
	}

	public Iterator<Item> dfsInOrderiterator() {
		return new DepthFirstInOrderIterator();
	}

	public Iterator<Item> dfsPostOrderiterator() {
		return new DepthFirstPostOrderIterator();
	}

	public Iterator<Item> bfsiterator() {
		return new BreadthFirstPreorderIterator();
	}

	private class DepthFirstPreOrderIterator implements Iterator<Item> {

		private Stack<TreeNode<Item>> fringe = new Stack<TreeNode<Item>>();

		private DepthFirstPreOrderIterator() {
			if (root != null) {
				fringe.push(root);
			}
		}

		public boolean hasNext() {
			return !fringe.empty();
		}

		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("tree ran out of elements");
			}
			TreeNode<Item> node = fringe.pop();
			if (node.getRight() != null) {
				fringe.push(node.getRight());
			}
			if (node.getLeft() != null) {
				fringe.push(node.getLeft());
			}
			return node.getData();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class DepthFirstInOrderIterator implements Iterator<Item> {

		private Stack<TreeNode<Item>> stack;

		private DepthFirstInOrderIterator() {
			stack = new Stack<>();
			TreeNode<Item> current = root;
			while (current != null) {
				stack.push(current);
				current = current.getLeft();
			}
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public Item next() {
			TreeNode<Item> node = stack.pop();
			Item result = node.getData();
			if (node.getRight() != null) {
				node = node.getRight();
				while (node != null) {
					stack.push(node);
					node = node.getLeft();
				}
			}
			return result;
		}
	}

	private class DepthFirstPostOrderIterator implements Iterator<Item> {

		Stack<TreeNode<Item>> stack = new Stack<>();

		/** find the first leaf in a tree rooted at cur and store intermediate nodes */
		private void findNextLeaf(TreeNode<Item> cur) {
			while (cur != null) {
				stack.push(cur);
				if (cur.getLeft() != null) {
					cur = cur.getLeft();
				} else {
					cur = cur.getRight();
				}
			}
		}

		private DepthFirstPostOrderIterator() {
			TreeNode<Item> current = root;
			findNextLeaf(current);
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("All nodes have been visited!");
			}

			TreeNode<Item> res = stack.pop();
			if (!stack.isEmpty()) {
				TreeNode<Item> top = stack.peek();
				if (res == top.getLeft()) {
					findNextLeaf(top.getRight()); // find next leaf in right sub-tree
				}
			}

			return res.getData();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("remove() is not supported.");
		}
	}

	public class BreadthFirstPreorderIterator implements Iterator<Item> {

		private Queue<TreeNode<Item>> fringe = new LinkedList<>();

		public BreadthFirstPreorderIterator() {
			if (root != null) {
				fringe.offer(root);
			}
		}

		public boolean hasNext() {
			return !fringe.isEmpty();
		}

		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("tree ran out of elements");
			}
			TreeNode<Item> node = fringe.poll();

			if (node.getLeft() != null) {
				fringe.offer(node.getLeft());
			}
			if (node.getRight() != null) {
				fringe.offer(node.getRight());
			}

			return node.getData();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}

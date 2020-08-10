package com.algo.recursion;

public class HeightOfTree {

	public static void main(String[] args) {

		Node<Integer> root=new Node<Integer>(10);
		root.left=new Node<Integer>(20);
		root.right=new Node<Integer>(30);
		root.left.left=new Node<Integer>(40);
		root.left.right=new Node<Integer>(50);
		root.right.left=new Node<Integer>(60);
		root.right.right=new Node<Integer>(70);
		root.left.left.left=new Node<Integer>(80);
		System.out.println(height(root));

	}
	
	
	public static int height(Node<Integer> tree) {
		if(tree==null) {
			return 0;
		}
		return 1+Math.max(height( tree.left), height(tree.right));
	}
	
	
	

public static class Node<T extends Comparable<T>>{
	T data;
	Node<T> left;
	Node<T> right;
	public Node(T data) {
		this.data = data;
	}
	
	
}
	

}



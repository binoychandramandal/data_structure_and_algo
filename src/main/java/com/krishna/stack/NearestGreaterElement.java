package com.krishna.stack;

import java.util.Stack;

public class NearestGreaterElement {

	public static void main(String[] args) {

		Stack<Integer> result = findNextNeaerestGreaterElement(new int[] { 5, 4, 3, 2, 1 });
		while (!result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
		System.out.println();
		result = findNextNeaerestGreaterElement(new int[] { 1, 3, 2, 4 });
		while (!result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
	}

	public static Stack<Integer> findNextNeaerestGreaterElement(int[] input) {
		Stack<Integer> result = new Stack<Integer>();
		Stack<Integer> tmp = new Stack<Integer>();
		for (int i = input.length - 1; i >= 0; i--) {
			if (tmp.isEmpty()) {
				result.push(-1);
			} else if (!tmp.isEmpty() && tmp.peek() > input[i]) {
				result.push(tmp.peek());
			} else if (!tmp.isEmpty() && tmp.peek() <= input[i]) {

				while (!tmp.isEmpty() && tmp.peek() <= input[i]) {
					tmp.pop();
				}
				if (tmp.isEmpty()) {
					result.push(-1);
				} else {
					result.push(tmp.peek());
				}

			}
			tmp.push(input[i]);

		}

		return result;

	}

}

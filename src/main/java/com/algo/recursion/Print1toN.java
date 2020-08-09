package com.algo.recursion;

public class Print1toN {

	public static void main(String[] args) {
		print1ToN(7);
		System.out.println();
		printNto1(7);
		System.out.println();
		printArray1toN(new int[] {1,2,3,4,5},4);
		System.out.println();
		printArrayNto1(new int[] {1,2,3,4,5},4);
		System.out.println();
		printString1toN("abc",2);
		System.out.println();
		printStringNto1("abc", 2);
		System.out.println();
		System.out.println(printStringNto1Withreturn("abc",2));
	}
	/**
	 * print 1 to n
	 * @param n
	 */
	public static void print1ToN(int n) {
		if(n==1) {
			System.out.print(n+" ");
			return;
		}
		print1ToN(n-1);
		System.out.print(n+" ");
	}
	
	
	/**
	 * print n to 1
	 * @param n
	 */
	public static void printNto1(int n) {
		if(n==1) {
			System.out.print(n+" ");
			return;
		}
		System.out.print(n+" ");
		printNto1(n-1);
		
	}
	
	
	/**
	 * print array o to n-1 index
	 * @param a
	 * @param n
	 */
	public static void printArray1toN(int a[],int n) {
		if(n==0) {
			System.out.print(a[n]+" ");
			return;
		}
		printArray1toN(a,n-1);
		System.out.print(a[n]+" ");
		
	}
	
	/**
	 * print array o to n-1 index
	 * @param a
	 * @param n
	 */
	public static void printArrayNto1(int a[],int n) {
		if(n==0) {
			System.out.print(a[n]+" ");
			return;
		}
		System.out.print(a[n]+" ");
		printArrayNto1(a,n-1);
	}
	
	

	/**
	 * print array o to n-1 index
	 * @param a
	 * @param n
	 */
	public static void printStringNto1(String s,int n) {
		if(n==0) {
			System.out.print(s.charAt(n)+" ");
			return;
		}
		System.out.print(s.charAt(n)+" ");
		printStringNto1(s,n-1);
	}
	
	
	/**
	 * print array o to n-1 index
	 * @param a
	 * @param n
	 */
	public static String printStringNto1Withreturn(String s,int n) {
		if(n==0) {
			return s.charAt(n)+" ";
		}
		return s.charAt(n)+" "+printStringNto1Withreturn(s,n-1);
	}
	
	/**
	 * print array n-1 to 0 index
	 * @param a
	 * @param n
	 */
	public static void printString1toN(String s,int n) {
		if(n==0) {
			System.out.print(s.charAt(n)+" ");
			return;
		}
		printString1toN(s,n-1);
		System.out.print(s.charAt(n)+" ");
	}
	
	
	

}

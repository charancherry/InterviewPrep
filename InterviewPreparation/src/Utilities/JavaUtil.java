package Utilities;

import java.util.Scanner;

public class JavaUtil {

	public static void main(String[] args) {
		

	};
	public static void print(int[] arr) {
		int len=arr.length;
		for(int i=0;i<len;i++) {
			System.out.print(arr[i]+" ");
		}	
		System.out.println();
	};
	
	public static void swap(int[]arr,int ind1,int ind2) {
		int temp=arr[ind1];
		arr[ind1]=arr[ind2];
		arr[ind2]=temp;
	}
	
	public static int[] createArray(){
		int len;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter length of array");
		len=in.nextInt();
		int[] arr = new int[len];
		System.out.println("Enter Elements");
		for(int i=0;i<len;i++) {
			arr[i]=in.nextInt();
		}
		return arr;
	}
}

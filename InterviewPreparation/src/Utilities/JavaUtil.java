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
	
	public static void charSwap(char[]arr,int ind1,int ind2) {
		char temp=arr[ind1];
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
	
	public static int[][] create2DArray(){
		int r,c;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter No of rows");
		r=in.nextInt();
		System.out.println("Enter No of columns");
		c=in.nextInt();
		int[][] arr = new int[r][c];
		System.out.println("Enter Elements");
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				arr[i][j]=in.nextInt();
			}
		}
		return arr;
	}
	
	public static int getMinEle(int[] arr) {
		int min=Integer.MAX_VALUE;
		int len=arr.length;
		for(int i=0;i<len;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		return min;
	}
	
	public static int getMaxEle(int[] arr) {
		int max=Integer.MIN_VALUE;
		int len=arr.length;
		for(int i=0;i<len;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
	
	public static boolean isPerfectNumber(int n) {
		boolean isPerfect=false;
		int sum=0;
		for(int i=n/2;i>0;i--) {
			if(n%i==0) {
				sum=sum+i;
			}
		}
		if(sum==n) {
			isPerfect=true;
		}
		return isPerfect;
	}
}

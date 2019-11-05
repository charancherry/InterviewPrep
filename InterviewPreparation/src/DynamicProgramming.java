import java.util.ArrayList;
import java.util.Scanner;

import Utilities.JavaUtil;

public class DynamicProgramming {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int[][] mine = JavaUtil.create2DArray();
		//maxGold(mine);
//		System.out.println("Enter the 2 input strings");
//		String str1=in.nextLine();
//		String str2=in.nextLine();
//		longestCommonSubsequence(str1.toCharArray(),str2.toCharArray());
//		int[] longestIncreasingSubsequence=JavaUtil.createArray();
//		longestIncreasingSubSequence(longestIncreasingSubsequence);
//		
//		int[] matrixChainMultiplication = JavaUtil.createArray();
//		matrixChainMultiplication(matrixChainMultiplication);
//		
//		ArrayList<int[]> arr= new ArrayList<int[]>();
//		int n;
//		int m;
//		System.out.println("Enter no of objects");
//		n=in.nextInt();
//		for(int i=0;i<n;i++) {
//			int[] temp=new int[2];
//			temp[0]=in.nextInt();
//			temp[1]=in.nextInt();
//			arr.add(temp);
//		}
//		System.out.println("Enter bag capacity");
//		m=in.nextInt();
//		grredyKnapsack(arr,m);
//
//
//		System.out.println("Enter profits");
//		int[] p = JavaUtil.createArray();
//		System.out.println("Enter weights");
//		int[] w = JavaUtil.createArray();
//		System.out.println("Enter bag capacity");
//		int m=in.nextInt();
//		KnapSackZeroOrOne(w,p,m);
		
		int[] maxSumWithNo2Adjacent=JavaUtil.createArray();
		maxSumWithNo2Adjacent(maxSumWithNo2Adjacent);

	}
	
	//*********************   https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/     ********************/
	public static void maxSumWithNo2Adjacent(int[] arr) {
		int incl=arr[0],excl=0,temp;
		for(int i=1;i<arr.length;i++) {
			temp=incl;
			incl=Math.max(excl+arr[i], incl);
			excl=temp;
		}
		System.out.println("Max sum with no two elements adjacent to each other "+Math.max(incl, excl));
	}
	
	
	public static void KnapSackZeroOrOne(int[] w,int[] p,int m){
		int n=w.length;
		int[][] t = new int[n+1][m+1];
		for(int i=0;i<m+1;i++) {
			t[0][i]=0;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				if(w[i-1]<=j && p[i-1]+t[i-1][j-w[i-1]]>t[i-1][j]) {
					t[i][j]=p[i-1]+t[i-1][j-w[i-1]];
				}else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		System.out.println("max profit is "+t[n][m]);
	}
	
	/*******************  https://www.geeksforgeeks.org/fractional-knapsack-problem/    **************/
	public static void grredyKnapsack(ArrayList<int[]> arr,int m) {
		int l=arr.size();
		int j,temp[];
		for(int i=1;i<l;i++) {
			j=i-1;
			temp=arr.get(i);
			while(j>=0 && (arr.get(j)[0]/arr.get(j)[1])<temp[0]/temp[1]) {
				arr.set(j+1, arr.get(j));
				j--;
			}
			arr.set(j+1, temp);
		}
//		for(int i=0;i<l;i++) {
//			System.out.println(arr.get(i)[0]+" "+arr.get(i)[1]);
//		}
		int i=0;
		int sum=0;
		while(m>=0 && arr.get(i)[1]<=m) {
			sum=sum+arr.get(i)[0];
			m=m-arr.get(i)[1];
			i++;
		}
		if(m>0) {
			sum=sum+m*(arr.get(i)[0]/arr.get(i)[1]);
		}
		System.out.println("maximum profit is"+sum);
	}
	
	
	public static void longestCommonSubsequence(char[] str1,char[] str2) {
		int l1=str1.length+1;
		int l2=str2.length+1;
		int[][] c = new int[l1][l2];
		for(int i=0;i<l1;i++) {
			for(int j=0;j<l2;j++) {
				if(i==0||j==0) {
					c[i][j]=0;
				}else {
					if(str1[i-1]==str2[j-1]) {
						System.out.println(str1[i-1]);
						c[i][j]=c[i-1][j-1]+1;
					}else {
						c[i][j]=Math.max(c[i][j-1], c[i-1][j]);
					}
				}
			}
		}
		System.out.println("Length of longest common subsequence is "+c[l1-1][l2-1]);
	}
	
	
	/***************  https://www.youtube.com/watch?v=E6us4nmXTHs    ***************/
	public static void longestIncreasingSubSequence(int[] arr) {
		int l1=arr.length;
		int[] len=new int[l1];
		int[] index=new int[l1];
		for(int i=0;i<l1;i++)
			len[i]=1;
		for(int i=1;i<l1;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					if(len[j]+1>=len[i]) {
						len[i]=len[j]+1;
						index[i]=j;
					}
				}
			}
		}
		int max=0;
		int ind=0;
		for(int i=0;i<l1;i++) {
			if(len[i]>max) {
				max=len[i];
				ind=i;
				
			}
		}
		System.out.println("Length of longest increasing sub sequence is"+max);
		System.out.println("Longest Common sub sequence is");
		System.out.print(arr[ind]+ " ");
		while(ind!=index[ind]) {
			ind=index[ind];
			System.out.print(arr[ind]+" ");
		}
		
	}
	
	public static void printParenthesis(int i,int j,int[][] b) {
		if(i==j) {
			System.out.print("A");
		}else {
			System.out.print("(");
			printParenthesis(i,b[i][j],b);
			printParenthesis(b[i][j]+1,j,b);
			System.out.print(")");
		}
	}
	
	
	/********************** https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/  **************/
	public static void matrixChainMultiplication(int[] p) {
		int n=p.length;
		int i,j,k,l,sum;
		int[][] m =new int[n][n];
		int[][] s =new int[n][n];
		for(l=2;l<n;l++) {
			for(i=1;i<n-l+1;i++) {
				j=i+l-1;
				m[i][j]=Integer.MAX_VALUE;
				for(k=i;k<=j-1;k++) {
					sum=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(sum<m[i][j]) {
						m[i][j]=sum;
						s[i][j]=k;
					}
				}
			}
		}
		System.out.println("Minimum no of scalar multiplications required is "+m[1][n-1]);
		printParenthesis(1,n-1,s);
	}
	
	/*******************  https://www.geeksforgeeks.org/gold-mine-problem/    **************/
	public static void maxGold(int[][] arr) {
		int r=arr.length-1;
		int c =arr[0].length-1;
		int right=0,rightUp=0,rightDown=0;
		int max=0;
		for(int i=0;i<r;i++) {
			if(arr[i][0]>max) {
				max=i;
			}
		}
		int count=arr[max][0];
		System.out.print("("+max+",0)->");
		for(int i=1;i<=c;i++) {
			right=0;
			rightUp=0;
			rightDown=0;
			if(max<r) {
				rightDown=arr[max+1][i];
			}
			right=arr[max][i];
			if(max!=0) {
				rightUp=arr[max-1][i];
			}
			if(rightDown>rightUp && rightDown>right) {
				max=max+1;
			}else if(rightUp>right && rightUp>rightDown) {
				max=max-1;
			}
			System.out.print("("+max+","+i+")->");
			count=count+arr[max][i];
		}
		System.out.println("max Gold that can be collected is "+count);
	}

}

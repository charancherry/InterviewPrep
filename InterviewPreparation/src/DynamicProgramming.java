import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import Utilities.JavaUtil;

public class DynamicProgramming {
	static Stack<Integer> s = new Stack<Integer>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int[][] mine = JavaUtil.create2DArray();
		//maxGold(mine);
//		System.out.println("Enter the 2 input strings");
//		String str1=in.nextLine();
//		String str2=in.nextLine();
//		longestCommonSubsequence(str1.toCharArray(),str2.toCharArray());
//	
//		System.out.println("Enter the 2 input strings");
//		String str1=in.nextLine();
//		String str2=in.nextLine();
//		longestCommonSubString(str1.toCharArray(),str2.toCharArray());
//		
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
//		
//		int[] arr = JavaUtil.createArray();
//		System.out.println("Enter sum");
//		int sum=in.nextInt();
//		subsetSum(arr,sum);
//		
//		int[] maxSumWithNo2Adjacent=JavaUtil.createArray();
//		maxSumWithNo2Adjacent(maxSumWithNo2Adjacent);
//		
//		s.push(1);
//		s.push(2);
//		s.push(3);
//		s.push(4);
//		System.out.println("Elements in stack are ");
//		System.out.println();
//		for(int i=0;i<s.size();i++) {
//			System.out.print(s.get(i)+" ");
//		}
//		reverseStackUsingRecurssion();
//		System.out.println();
//		System.out.println("Elements in stack after reverse ");
//		System.out.println();
//		for(int i=0;i<s.size();i++) {
//			System.out.print(s.get(i)+" ");
//		}
//		
//		int[] maxSumIncreasingSubSequence=JavaUtil.createArray();
//		maxSumIncreasingSubSequence(maxSumIncreasingSubSequence);
//		
//		int[] maxProductSubArray = JavaUtil.createArray();
//		maxProductSubArray(maxProductSubArray);
//
		int[] givenSumSubArrays = JavaUtil.createArray();
		System.out.println("Enter the required sum");
		int sum=in.nextInt();
		givenSumSubArrays(givenSumSubArrays,sum);
//		
//		int[] dividArrayWithEqualSum = JavaUtil.createArray();
//		dividArrayWithEqualSum(dividArrayWithEqualSum);
//		
//		System.out.println("Enter the string");
//		String str=in.next();
//		longestPalindromicSubSequence(str);
//		
//		System.out.println("Enter the string");
//		String str=in.next();
//		longestPalyndromicSubString(str);
		
//		numberOfPaths(3,3);
//		
//		int[][] matrix = {{1,0,0,1},{1,1,1,1},{1,0,1,1}};
//		numberOfPathsInMaze(matrix);
//		
//		int[] maxSumSubArray=JavaUtil.createArray();
//		int k=in.nextInt();
//		maxSumSubArray(maxSumSubArray,k);
//	
//		int[] maxInEachSubArray=JavaUtil.createArray();
//		int k=in.nextInt();
//		maxInEachSubArray(maxInEachSubArray,k);
//		
//		noOfBinaryStringWithoutConsective1(in.nextInt());
//		
//		System.out.println("Please Enter string");
//		String str=in.next();
//		System.out.println("Please Enter pattern");
//		String pattern = in.next();
//		isPatternMatching(str,pattern);
//		
//		int[] s = {1,2,3};
//		int n=5;
//		coinChange(s,s.length,n);
	}
	
	public static void insertAtBottom(int x) {
		if(s.size()==0) {
			s.push(x);
		}else {
			int top=s.pop();
			insertAtBottom(x);
			s.push(top);
		}
	}
	
	public static void reverseStackUsingRecurssion() {
		if(s.size()>0) {
			int x = s.pop();
			reverseStackUsingRecurssion();
			insertAtBottom(x);
		}
	}
	
	
	/******************  https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/  ***********/
	public static void numberOfPaths(int m,int n) {
		int[][] count=new int[m][n];
		for(int i=0;i<n;i++) {
			count[0][i]=1;
		}
		for(int i=0;i<m;i++) {
			count[i][0]=1;
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				count[i][j]=count[i-1][j]+count[i][j-1];
			}
		}
		System.out.println("No of paths are "+count[m-1][n-1]);
	}
	
	public static class pair{
		int first;
		int second;
		public pair(int f,int s) {
			first=f;
			second=s;
		}
	}

	
	/*********  https://www.geeksforgeeks.org/count-number-of-ways-to-reach-destination-in-a-maze-using-bfs/  ***/
	public static void numberOfPathsInMaze(int[][] m) {
		int r=m.length;
		int c=m[0].length;
		Queue<pair> q = new LinkedList();
		pair p=new pair(0,0);
		q.add(p);
		int count=0;
		while(!q.isEmpty()) {
			 p=q.peek();
			 q.poll();
			 if(p.first==r-1&&p.second==c-1) {
				 count++;
			 }
			if(p.first+1<r&&m[p.first+1][p.second]==1) {
				q.add(new pair(p.first+1,p.second));
			}
			if(p.second+1<c&&m[p.first][p.second+1]==1) {
				q.add(new pair(p.first,p.second+1));
			}
		}
		System.out.println("No of paths are "+count);
	}
	
	
	/*******************   https://www.youtube.com/watch?v=li9rcswj0WM   **********/
	public static void maxSumSubArray(int[] arr,int k) {
		int max_sum=0;
		int sum=0;
		int start=0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
			if(i>=k-1) {
				max_sum=Math.max(sum, max_sum);
				sum=sum-arr[start];
				start++;
			}
		}
		System.out.println(max_sum);
	}
	
	
	/**********************   https://algorithms.tutorialhorizon.com/sliding-window-algorithm-track-the-maximum-of-each-subarray-of-size-k/   ****************/
	public static void maxInEachSubArray(int[] arr,int k) {
		Deque<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<k;i++) {
			while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]) {
				q.removeLast();
			}
			q.addLast(i);
		}
		for(int i=k;i<arr.length;i++) {
			System.out.print(arr[q.peekFirst()]+" ");
			while(!q.isEmpty() && q.peekFirst()<=i-k) {
				q.pollFirst();
			}
			while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]) {
				q.removeLast();
			}
			q.addLast(i);
		}
		System.out.print(arr[q.peekFirst()]);
	}
	
	/***************   https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/   ****************/
	public static void noOfBinaryStringWithoutConsective1(int n) {
		int[] a=new int[n];
		int[] b=new int[n];
		a[0]=1;b[0]=1;
		for(int i=1;i<n;i++) {
			a[i]=a[i-1]+b[i-1];
			b[i]=a[i-1];
		}
		System.out.println("No of binary strings without consective 1's are "+(a[n-1]+b[n-1]));
	}
	
	
	/*******************   https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/WildCardMatching.java   ************/
	/*******************    https://www.youtube.com/watch?v=3ZDZ-N0EPV0    *****************/
	public static void isPatternMatching(String s,String p) {
		char[] str=s.toCharArray();
		char[] pattern=p.toCharArray();
		int index=0;
		boolean isFirst=true;
		for(int i=0;i<pattern.length;i++) {
			if(pattern[i]=='*') {
				if(isFirst) {
					pattern[index++]=pattern[i];
					isFirst=false;
				}
			}else {
				pattern[index++]=pattern[i];
				isFirst=true;
			}
		}
		boolean[][] t=new boolean[str.length+1][index+1];
		t[0][0]=true;
		for(int i=1;i<t[0].length;i++) {
			t[0][i]=false;
		}
		for(int i=1;i<t.length;i++) {
			t[i][0]=false;
		}
		if(pattern[0]=='*') {
			t[0][1]=true;
		}
		for(int i=1;i<t.length;i++) {
			for(int j=1;j<t[0].length;j++) {
				if(str[i-1]==pattern[j-1] || pattern[j-1]=='?') {
					t[i][j]=t[i-1][j-1];
				}else if(pattern[j-1]=='*') {
					t[i][j]=t[i-1][j]||t[i][j-1];
				}else {
					t[i][j]=false;
				}
			}
		}
		System.out.println("Wether given pattern matches string is "+t[str.length][index]);
	}
	
	
	
	/****************************    https://www.geeksforgeeks.org/coin-change-dp-7/     ********************/
	public static void coinChange(int[] s,int m,int n) {
		int[][] t=new int[n+1][m+1];
		for(int i=0;i<n+1;i++) {
			t[i][0]=0;
		}
		for(int i=0;i<m+1;i++) {
			t[0][i]=1;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				int incl=(i>=s[j-1])?t[i-s[j-1]][j] :0;
				int excl=t[i][j-1];
				t[i][j]=incl+excl;
			}
		}
		System.out.println("No of ways possible are "+t[n][m]);
	}
	
	
	//*********************   https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/     ********************/
	public static void maxSumWithNo2Adjacent(int[] arr) {
		int incl=arr[0],excl=0,temp;
		for(int i=1;i<arr.length;i++) {
			temp=Math.max(incl, excl);
			incl=excl+arr[i];
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
	
	
	/****************************   https://www.geeksforgeeks.org/subset-sum-problem-dp-25/     *************/
	public static void subsetSum(int[] arr,int s) {
		int n=arr.length;
		boolean[][] ss= new boolean[n+1][s+1];
		for(int i=1;i<=s;i++) {
			ss[0][i]=false;
		}
		for(int i=0;i<=n;i++) {
			ss[i][0]=true;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<s+1;j++) {
				if(arr[i-1]>j) {
					ss[i][j]=ss[i-1][j];
				}else {
					ss[i][j]=ss[i-1][j-arr[i-1]] || ss[i-1][j];
				}
			}
		}
		System.out.println("Wether Susbset with given sum is possible "+ss[n][s]);
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
	
	/****************   https://www.geeksforgeeks.org/longest-common-substring-dp-29/  **********/
	public static void longestCommonSubString(char[] str1,char[] str2) {
		int l1=str1.length+1;
		int l2=str2.length+1;
		int[][] c = new int[l1][l2];
		int res=0;
		for(int i=0;i<l1;i++) {
			for(int j=0;j<l2;j++) {
				if(i==0||j==0) {
					c[i][j]=0;
				}else {
					if(str1[i-1]==str2[j-1]) {
						c[i][j]=c[i-1][j-1]+1;
						res=Math.max(res, c[i][j]);
					}else {
						c[i][j]=0;
					}
				}
			}
		}
		System.out.println("Length of longest common substring is "+res);
	}
	
	
	/***************  https://www.youtube.com/watch?v=E6us4nmXTHs    ***************/
	public static void longestIncreasingSubSequence(int[] arr) {
		int l1=arr.length;
		int[] len=new int[l1];
		int[] index=new int[l1];
		for(int i=0;i<l1;i++)
			len[i]=1;
		for(int i=0;i<arr.length;i++) {
			index[i]=i;
		}
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
	
	
	/******************************   https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/  **********************/
	public static void maxSumIncreasingSubSequence(int[] arr) {
		int l1=arr.length;
		int[] sum=new int[arr.length];
		int[] ind = new int[arr.length];
		int max_sum=0,index=0;
		for(int i=0;i<arr.length;i++) {
			sum[i]=arr[i];
		}
		for(int i=0;i<arr.length;i++) {
			ind[i]=i;
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && sum[i]<sum[j]+arr[i]) {
					sum[i]=sum[j]+arr[i];
					ind[i]=j;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(max_sum<sum[i]) {
				max_sum=sum[i];
				index=i;
			}
		}
		System.out.println("Max sum increasing sub sequence sum is "+max_sum);
		System.out.println();
		System.out.println("Sub sequence is");
		System.out.println();
		System.out.print(arr[index]+" ");
		while(index !=ind[index]) {
			index = ind[index];
			System.out.print(arr[index]+" ");
		}
	}
	
	
	/**************************   https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/   *****************/
	public static void givenSumSubArrays(int[] arr,int reqSum) {
		int sum=0;
		HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
		ArrayList<int[]> res=new ArrayList<int[]>();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] == 0 ? -1 : 1;
		}
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
			if(sum==reqSum) {
				int[] pair=new int[2];
				pair[0]=0;
				pair[1]=i;
				res.add(pair);
			}
			if(map.containsKey(sum-reqSum)) {
				ArrayList list=map.get(sum-reqSum);
				for(int j=0;j<list.size();j++) {
					int[] pair=new int[2];
					pair[0]=(int) list.get(j)+1;
					pair[1]=i;
					res.add(pair);
				}
			}
			if(map.containsKey(sum)) {
				ArrayList list=map.get(sum);
				list.add(i);
				map.put(sum, list);
			}
			else {
				ArrayList list=new ArrayList();
				list.add(i);
				map.put(sum, list);
			}
		}
		for(int i=0;i<res.size();i++) {
			int[] pair = res.get(i);
			System.out.println("Start Index is "+pair[0]+" end index is "+pair[1]);
		}
	}
	
	
	/*********************************     https://www.geeksforgeeks.org/find-if-array-can-be-divided-into-two-subarrays-of-equal-sum/    ************/
	public static void dividArrayWithEqualSum(int[] arr) {
		int totalSum=0;
		for(int i=0;i<arr.length;i++) {
			totalSum=totalSum+arr[i];
		}
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			if(sum==totalSum-arr[i]-sum) {
				System.out.println("Array can be divided by removing element "+arr[i]+" at index "+ i);
				return;
			}
			sum=sum+arr[i];
		}
		System.out.println("Array cannot be divided");
	}
	
	public static void maxProductSubArray(int[] arr) {
		int max_end=1,min_end=1,max_so_far=1,flag=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				max_end=max_end*arr[i];
				min_end=Math.min(min_end*arr[i], 1);
				flag=1;
			}else if(arr[i]==0) {
				max_end=1;
				min_end=1;
			}else {
				int temp=max_end;
				max_end=Math.max(min_end*arr[i], 1);
				min_end=temp*arr[i];
			}
			if(max_so_far<max_end) {
				max_so_far=max_end;
			}
		}
		if(flag==0 && max_so_far==1) {
			System.out.println("Max produxt sub array is 0");
			return;
		}
		System.out.println("Max produxt sub array is "+max_so_far);
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
				for(k=i;k<j;k++) {
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
	
	/****************  https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/    ***/
	public static void longestPalindromicSubSequence(String str) {
		char[] c=str.toCharArray();
		int l=c.length;
		int[][] lps=new int[l][l];
		for(int i=0;i<l;i++) {
			lps[i][i]=1;
		}
		for(int len=2;len<=l;len++) {
			for(int i=0;i<l-len+1;i++) {
				int j=i+len-1;
				if(c[i]==c[j] && len==2) {
					lps[i][j]=2;
				}else if(c[i]==c[j]) {
					lps[i][j]=2+lps[i+1][j-1];
				}else {
					lps[i][j]=Math.max(lps[i+1][j],lps[i][j-1]);
				}
			}
		}
		System.out.println("Lnegth of longest palyndromic subsequence is "+lps[0][l-1]);
	}
	
	
	/*************  https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/   ***/
	public static void longestPalyndromicSubString(String str) {
		char[] c=str.toCharArray();
		int l=c.length;
		int[][] lps=new int[l][l];
		for(int i=0;i<l;i++) {
			lps[i][i]=1;
		}
		int res=0;
		for(int len=2;len<=l;len++) {
			for(int i=0;i<=l-len;i++) {
				int j=i+len-1;
				if(c[i]==c[j]&&len==2) {
					lps[i][j]=2;
					res=Math.max(res, lps[i][j]);
				}else if(c[i]==c[j]) {
					lps[i][j]=2+lps[i+1][j-1];
					res=Math.max(res, lps[i][j]);
				}else {
					lps[i][j]=0;
				}
			}
		}
		if(res!=0) {
			int start=-1,end=-1;
			for(int i=0;i<l;i++) {
				for(int j=l-1;j>=0;j--) {
					if(lps[i][j]==res) {
						start=i;
						end=j;
					}
				}
			}
			System.out.println("Length of Longest Substring is "+res+" and found from index "+start+" and index "+end);
		}else {
			System.out.println("Longest palyndromic substring does not exist");
		}
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

import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;

import Utilities.JavaUtil;

public class Array {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

//		int[] bubbleSortArray = JavaUtil.createArray();
//		System.out.println("Array befor Bubble Sorting is : ");
//		JavaUtil.print(bubbleSortArray);
//		bubbleSort(bubbleSortArray);
//		System.out.println("Array after Bubble Sorting is : ");
//		JavaUtil.print(bubbleSortArray);
//
//		int[] insertionSortArray =JavaUtil.createArray();
//		System.out.println("Array befor Insertin Sorting is : ");
//		JavaUtil.print(insertionSortArray);
//		insertionSort(insertionSortArray);
//		System.out.println("Array after Insertion Sort is : ");
//		JavaUtil.print(insertionSortArray);
//
//		int[] selectionSortArray =JavaUtil.createArray();
//		System.out.println("Array befor Selection Sort is : ");
//		JavaUtil.print(selectionSortArray);
//		selectionSort(selectionSortArray);
//		System.out.println("Array after Selection Sort is : ");
//		JavaUtil.print(selectionSortArray);
//
//		int[] countingSortArray =JavaUtil.createArray();
//		System.out.println("Array befor Counting Sort is : ");
//		JavaUtil.print(countingSortArray);
//		countingSort(countingSortArray);
//
//		int[] mergeSortArray =JavaUtil.createArray();
//		System.out.println("Array befor Merge Sort is : ");
//		JavaUtil.print(mergeSortArray);
//		mergeSort(mergeSortArray,0,mergeSortArray.length-1);
//		System.out.println("Array after Merge Sort is : ");
//		JavaUtil.print(mergeSortArray);		
//
//		int[] quickSortArray =JavaUtil.createArray();
//		System.out.println("Array befor Quick Sort is : ");
//		JavaUtil.print(quickSortArray);
//		quickSort(quickSortArray,0,quickSortArray.length-1);
//		System.out.println("Array after Quick Sort is : ");
//		JavaUtil.print(quickSortArray);		
//
//		int[] heapSortArray =JavaUtil.createArray();
//		System.out.println("Array befor Heap Sort is : ");
//		JavaUtil.print(heapSortArray);
//		heapSort(heapSortArray,heapSortArray.length);
//		System.out.println("Array after Merge Sort is : ");
//		JavaUtil.print(heapSortArray);		
//
//		int[] findkthSmallesstElement =JavaUtil.createArray();
//		System.out.println("Enter k value ");
//		int k = in.nextInt();
//		if(k>findkthSmallesstElement.length) {
//			System.out.println("Invalis k value");
//		}else {
//			int result=kthSmallestElement(findkthSmallesstElement,k);
//			System.out.println("kth smallest element is "+result);
//		}
//
//		int[]  findSubArrayWithGivenSum=JavaUtil.createArray();
//		int sum = in.nextInt();
//		findSubArrayWithGivenSum(findSubArrayWithGivenSum,sum);
//
//		int[]  findMaxSubArray=JavaUtil.createArray();
//		findMaxSubArray(findMaxSubArray);
//
//		int[]  findMinSubArray=JavaUtil.createArray();
//		findMinSubArray(findMinSubArray);
//
//		int[]  findMaxProductSubArray=JavaUtil.createArray();
//		findMaxProductSubArray(findMaxProductSubArray);
//
//
//		int[]  MaxSubArrayWithEqualNumberOfOneAndZero=JavaUtil.createArray();
//		MaxSubArrayWithEqualNumberOfOneAndZero(MaxSubArrayWithEqualNumberOfOneAndZero);
//
//		int[] numberOfPairsWithGivenSum = JavaUtil.createArray();
//		System.out.println("Enter the sum");
//		int sum = in.nextInt();
//		findNOOfPairsWithGivenSum(numberOfPairsWithGivenSum,sum);
//
//		int[] maxOfEachSubArrayOfSizeK=JavaUtil.createArray();
//		System.out.println("Enter K");
//		int k=in.nextInt();
//		maxOfEachSubArrayOfSizeK(maxOfEachSubArrayOfSizeK,k);
//
//		int[] rainTrappingArray = JavaUtil.createArray();
//		trapCount(rainTrappingArray);
//
//		int[] firstMissingPositiveInteger = JavaUtil.createArray();
//		firstMissingPositiveInteger(firstMissingPositiveInteger);
//		
//		medianOfTwoSortedArrays();
//		
//		insertNewInterval();
//		
//		int[] stockPrice=JavaUtil.createArray();
//		bestTimeToBuyAndSellStocks(stockPrice);
//		
//		int[] binarySearchArray = JavaUtil.createArray();
//		System.out.println("Enter the element to be searched");
//		int k=in.nextInt();
//		int index = binarySearch(binarySearchArray,0,binarySearchArray.length-1,k);
//		if(index!=-1) {
//			System.out.println("Element found at"+index);
//		}else {
//			System.out.println("Element Not found");
//		}
//
//		int[] minimumInRotatedArray = JavaUtil.createArray();
//		int index = minimumInRotatedArray(minimumInRotatedArray,0,minimumInRotatedArray.length-1);
//		if(index!=-1) {
//			System.out.println("Min Element found at"+index);
//		}else {
//			System.out.println("Min Element Not found");
//		}
//		
//		int[] numberOfPairsWithGivenSum = JavaUtil.createArray();
//		System.out.println("Enter the sum");
//		int sum = in.nextInt();
//		findNOOfPairsWithGivenSumUsingSorting(numberOfPairsWithGivenSum,sum);
		
//		int[] tripletsWithSumZero = JavaUtil.createArray();
//		printAllTripletsWithSumZero(tripletsWithSumZero);
		
//		int[] leastCommonMultiple = JavaUtil.createArray();
//		leastCommonMultiple(leastCommonMultiple);
//		
//		int[] sumOfPerfectNumbers = JavaUtil.createArray();
//		sumOfPerfectNumbers(sumOfPerfectNumbers);
		
		int[] numbers = JavaUtil.createArray();
		numbersInAscOrderContains123(numbers);

	}

	public static void bubbleSort(int[] arr) {
		int len=arr.length;
		for(int outerInd=0;outerInd<len-1;outerInd++) {
			for(int innerInd=outerInd;innerInd<len;innerInd++) {
				if(arr[outerInd]<arr[innerInd]) {
					JavaUtil.swap(arr,outerInd,innerInd);
				}
			}
		}
	}

	public static void insertionSort(int[] arr) {
		int len=arr.length;
		for(int i=1;i<len;i++) {
			int j=i-1;
			int key=arr[i];
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
	}

	public static void selectionSort(int[] arr) {
		int len=arr.length;
		for(int i=0;i<len;i++) {
			int min_index=i;
			for(int j=i+1;j<len;j++) {
				if(arr[j]<arr[min_index]) {
					min_index=j;
				}
			}
			JavaUtil.swap(arr,i,min_index);
		}
	}

	public static void countingSort(int[] arr) {
		int min=JavaUtil.getMinEle(arr);
		int max=JavaUtil.getMaxEle(arr);
		int range=max-min+1;
		int[] count=new int[range];
		int[] sorted=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			count[arr[i]-min]++;
		}
		for(int i=1;i<count.length;i++) {
			count[i]=count[i]+count[i-1];
		}
		for(int i=0;i<arr.length;i++) {
			int index=count[arr[i]-min];
			sorted[index-1]=arr[i];
			count[arr[i]-min]--;
		}
		System.out.println("Sorted array is :");
		for(int i=0;i<sorted.length;i++) {
			System.out.print(sorted[i]+" ");
		}
	}

	public static void merge(int[] arr,int l ,int m,int r) {
		int[] left = new int[m-l+1];
		int[] right = new int[r-m];
		for(int i=0;i<left.length;i++) {
			left[i]=arr[l+i];
		}
		for(int i=0;i<right.length;i++) {
			right[i]=arr[m+1+i];
		}
		int i=0,j=0,k=l;
		while(i<left.length&&j<right.length) {
			if(left[i]<right[j]) {
				arr[k]=left[i];
				i++;
				k++;
			}else {
				arr[k]=right[j];
				j++;
				k++;
			}
		}
		while(i<left.length) {
			arr[k]=left[i];
			i++;
			k++;
		}
		while(j<right.length) {
			arr[k]=right[j];
			j++;
			k++;
		}

	}

	public static void mergeSort(int[] arr,int l,int r){
		if(l<r) {
			int mid=(l+r)/2;
			mergeSort(arr,l,mid);
			mergeSort(arr,mid+1,r);
			merge(arr,l,mid,r);
		}
	}

	public static int partition(int[] arr,int l,int r) {
		int pivotVal=arr[r];
		int i=l;
		for(int j=l;j<r;j++) {
			if(arr[j]<=pivotVal) {
				JavaUtil.swap(arr,i,j);
				i++;
			}
		}
		JavaUtil.swap(arr,i,r);
		return (i);
	}

	public static void quickSort(int[] arr,int l,int r) {
		if(l<r) {
			int pivot=partition(arr,l,r);
			quickSort(arr,l,pivot-1);
			quickSort(arr,pivot+1,r);
		}
	}

	public static int modifiedQuickSort(int[] arr,int l,int r,int k) {
		if(k>0)  {
			int pivot=partition(arr,l,r);
			if(pivot == k-1) {
				return arr[pivot];
			}
			if(pivot>k-1) {
				return modifiedQuickSort(arr,l,pivot-1,k);
			}else {
				return modifiedQuickSort(arr,pivot+1,r,k);
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void heapify(int[] arr,int n,int i) {
		int max=i;
		int l=(2*i)+1;
		int r=(2*i)+2;
		if(l<n&& arr[max]<arr[l]) {
			max=l;
		}
		if(r<n && arr[max]<arr[r]) {
			max=r;
		}
		if(max!=i) {
			JavaUtil.swap(arr, i, max);
			heapify(arr,n,max);
		}
	}

	public static void heapSort(int[] arr,int len) {
		for(int i=len/2-1;i>=0;i--) {
			heapify(arr,len,i);
		}
		for(int i=len-1;i>0;i--) {
			JavaUtil.swap(arr, i, 0);
			heapify(arr,i,0);
		}

	}

	public static int kthSmallestElement(int[] arr,int k) {
		int len=arr.length;
		int smallestVal = modifiedQuickSort(arr,0,len-1,k);
		return smallestVal;

	}

	public static void findSubArrayWithGivenSum(int[]arr,int sum) {
		int cur_sum=Integer.MIN_VALUE,start_ind=0;
		for(int i=0;i<arr.length;i++) {
			while(cur_sum>sum && start_ind<i-1) {
				cur_sum=cur_sum-arr[start_ind];
				start_ind++;
			}
			if(cur_sum==sum) {
				System.out.println("Sub arry is found start Index is "+start_ind+ "and end index is " + (i-1));
				return;
			}
			cur_sum=cur_sum+arr[i];
		}
		System.out.println("No Sub array found");
	}

	public static void findMaxSubArray(int[] arr) {
		int max_sum=Integer.MIN_VALUE,cur_sum=0,start=0,end=0,s=0;
		for(int i=0;i<arr.length;i++) {
			cur_sum=cur_sum+arr[i];
			if(cur_sum>max_sum) {
				max_sum=cur_sum;
				start=s;
				end=i;
			}
			if(cur_sum<0) {
				s++;
				cur_sum=0;
			}
		}
		System.out.println("Max sum is"+max_sum +"and start index="+start+"end index="+end);
	}

	public static void findMinSubArray(int[] arr) {
		int min_sum=Integer.MAX_VALUE,cur_sum=0,start=0,end=0,s=0;
		for(int i=0;i<arr.length;i++) {
			cur_sum=cur_sum+arr[i];
			if(cur_sum<min_sum) {
				min_sum=cur_sum;
				start=s;
				end=i;
			}
			if(cur_sum>0) {
				s++;
				cur_sum=0;
			}
		}
		System.out.println("Min sum is"+min_sum +"and start index="+start+"end index="+end);
	}

	public static void MaxSubArrayWithEqualNumberOfOneAndZero(int[] arr) {
		int oneCount=0,zeroCount=0,max_length=0,k;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) {
				oneCount++;
			}else {
				zeroCount++;
			}
		}
		if(oneCount==0 || zeroCount==0) {
			System.out.println("No such array exist");
			return;
		}
		max_length=oneCount<zeroCount?oneCount:zeroCount;
		for(int i=max_length;i>0;i--) {
			oneCount=0;zeroCount=0;
			k=2*i;
			for(int j=0;j<k;j++) {
				if(arr[j]==1) {
					oneCount++;
				}else {
					zeroCount++;
				}
			}
			if(oneCount==zeroCount) {
				System.out.println("Largest array is found between 0 and "+ (k-1));
				return;
			}else {
				for(int j=k;j<arr.length;j++) {
					if(arr[j]==1) {
						oneCount++;
					}else {
						zeroCount++;
					}
					if(arr[j-k]==1) {
						oneCount--;
					}else {
						zeroCount--;
					}
					if(oneCount==zeroCount) {
						System.out.println("Largest array is found between "+ (j-k+1) +" and "+  j);
						return;
					}
				}
			}
		}
		System.out.println("No such array exist");
	}

	public static void findNOOfPairsWithGivenSum(int[] arr,int sum) {
		int noOfPairs=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i]+arr[j]==sum) {
					noOfPairs++;
				}
			}
		}
		System.out.println("No of Pairs are"+noOfPairs);
	}

	public static void maxOfEachSubArrayOfSizeK(int[] arr,int k) {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<k;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		System.out.print(max );
		for(int i=k;i<arr.length;i++) {
			if(arr[i]>=max) {
				max=arr[i];
				System.out.print(max );
			}else {
				for(int j=i-k+1;j<=k;j++) {
					if(arr[j]>max) {
						max=arr[j];
					}
				}
				System.out.print(max );
			}
		}
	}

	public static void trapCount(int[] arr) {
		int max=JavaUtil.getMaxEle(arr);
		int count=0,start;
		for(int i=1;i<=max;i++) {
			start=-1;
			for(int j=0;j<arr.length;j++) {
				if(arr[j]>=i) {
					if(start<0) {
						start=j;
					}else {
						count += j-start-1;
						start=j;
					}
				}
			}
		}
		System.out.println("Trapped water is "+count);
	}

	public static void firstMissingPositiveInteger(int[] arr) {
		JSONObject input=new JSONObject();
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(max<arr[i]){
				max=arr[i];
			}
			input.put(arr[i],true);
		}
		int i;
		for( i=1;i<max;i++) {
			if(!input.containsKey(i)) {
				System.out.println("minimum element is "+i);
				return;
			}
		}
		System.out.println("Missing element is "+(i+1));
	}

	public static void findMaxProductSubArray(int[] arr) {
		int maxProduct=Integer.MIN_VALUE,start=0,end=0,s=0,product=1;
		for(int i=0;i<arr.length;i++) {
			product=product*arr[i];
			if(maxProduct<product) {
				maxProduct=product;
				start=s;
				end=i;
			}
			if(product<0) {
				product=1;
				s++;
			}
		}
		System.out.println("max product is "+maxProduct+" start index is "+start+" end is "+end);
	}
	
	/***  There is another method which will not use xtra space and it is done by comparing medians of two arrays
	 *    https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
	 */
	public static void medianOfTwoSortedArrays() {
		int[] arr1 = JavaUtil.createArray();
		int[] arr2 = JavaUtil.createArray();
		int l1=arr1.length;
		int l2=arr2.length;
		int[] arr3=new int[l1+l2];
		int i=0,j=0,k=0;
		while(i<l1&&j<l2) {
			if(arr1[i]<arr2[j]) {
				arr3[k]=arr1[i];
				i++;
			}else {
				arr3[k]=arr2[j];
				j++;
			}
			k++;
		}
		while(i<l1) {
			arr3[k]=arr1[i];
			i++;
			k++;
		}
		while(j<l2) {
			arr3[k]=arr2[j];
			j++;
			k++;
		}
		if(k%2==0) {
			System.out.println("Median is"+((arr3[k/2])+arr3[k/2-1])/2);
		}else {
			System.out.println("Median is"+arr3[k/2]);
		}
	}
	
	public static void insertNewInterval() {
		Scanner in = new Scanner(System.in);
		int start=-1,end=-1;
		System.out.println("Enter no of intervals");
		int noOfIntervals=in.nextInt();
		int[][] input = new int[noOfIntervals][2];
		for(int i=0;i<noOfIntervals;i++) {
			for(int j=0;j<2;j++) {
				input[i][j]=in.nextInt();
			}
		}
		int[] newInterval=new int[2];
		System.out.println("Enter new interval");
		newInterval[0]=in.nextInt();
		newInterval[1]=in.nextInt();
		for(int i=0;i<noOfIntervals;i++) {
				if(input[i][0]<=newInterval[0]&&newInterval[0]<=input[i][1]) {
					start=i;
				}
				if(input[i][0]<=newInterval[1]&&newInterval[1]<=input[i][1]) {
					end=i;
				}
		}
		if(end==-1) {
			input[start][1]=newInterval[1];
			for(int i=0;i<noOfIntervals;i++) {
				System.out.println("["+input[i][0]+","+input[i][1]+"]");
			}
		}else if(end !=-1 && end != start) {
			input[start][1] = input[end][1];
			for(int i=0;i<noOfIntervals;i++) {
				if(i<=start || i>end)
				System.out.println("["+input[i][0]+","+input[i][1]+"]");
			}
		}else if(start==-1 && end==-1) {
			if(newInterval[0]<input[0][0]) {
				System.out.println("["+newInterval[0]+","+newInterval[1]+"] ");
				for(int i=0;i<noOfIntervals;i++) {
					System.out.println("["+input[i][0]+","+input[i][1]+"]");
				}
			}else if(newInterval[1]>input[noOfIntervals][1]) {
				for(int i=0;i<noOfIntervals;i++) {
					System.out.println("["+input[i][0]+","+input[i][1]+"]");
				}
				System.out.println("["+newInterval[0]+","+newInterval[1]+"] ");
			}
		}
	}
	
	public static void bestTimeToBuyAndSellStocks(int[] arr) {
		ArrayList<int[]> input = new ArrayList<int[]>();
		int profit=0,max_profit=0,ind_max_profit=0;
		for(int i=0;i<arr.length-1;i++) {
			max_profit=0;
			for(int j=i+1;j<arr.length;j++) {
				profit=arr[j]-arr[i];
				if(max_profit<profit) {
					max_profit=profit;
					int arr1[]= {i,j,profit};
					input.add(arr1);
					if(ind_max_profit<profit) {
						ind_max_profit=profit;
					}
				}
			}
		}
		max_profit=0;
		for(int i=0;i<input.size();i++) {
			for(int j=i+1;j<input.size();j++) {
				int end=input.get(i)[1];
				int start = input.get(j)[0];
				if(Integer.valueOf(input.get(i)[1])<Integer.valueOf(input.get(j)[0])) {
					profit = input.get(i)[2]+input.get(j)[2];
					if(max_profit<profit) {
						max_profit=profit;
					}
				}
			}
		}
		if(max_profit<ind_max_profit) {
			max_profit=ind_max_profit;
		}
		System.out.println("Maximum profir is"+max_profit);
	}
	
	public static int binarySearch(int[] arr,int l,int r,int k) {
		if(l<=r) {
			int mid=(l+r)/2;
			if(arr[mid]==k) {
				System.out.println("Element found at"+mid);
				return mid;
			}
			if(k<arr[mid]) {
				return binarySearch(arr,l,mid-1,k);
			}else {
				return binarySearch(arr,mid+1,r,k);
			}
		}
		return -1;
	}
	
	
	//****  Refer***/ 
	public static int minimumInRotatedArray(int[] arr,int l,int r) {
		if(l<=r) {
			if(l==r) {
				return l;
			}
			int mid=(l+r)/2;
			if(mid==0) {
				return mid;
			}
			if(arr[mid]<arr[mid-1]) {
				return mid;
			}
			if(arr[mid]>arr[r]) {
				return minimumInRotatedArray(arr,mid+1,r);
			}else {
				return minimumInRotatedArray(arr,l,mid-1);
			}
		}
		return -1;

	}
	
	public static void findNOOfPairsWithGivenSumUsingSorting(int[] arr,int sum) {
		quickSort(arr,0,arr.length-1);
		int count=0;
		int l=0,r=arr.length-1;
		while(l<r) {
			if((arr[l]+arr[r]==sum)){
				System.out.println("pair is "+arr[l]+"and "+arr[r]);
				count++;
			}
			if((arr[l]+arr[r]>sum)) {
				r--;
			}else {
				l++;
			}
		}
		if(count==0) {
			System.out.println("No such pairs found");
		}
	}
	
	public static void printAllTripletsWithSumZero(int[] arr) {
		quickSort(arr,0,arr.length-1);
		int count=0;
		for(int i=0;i<arr.length-2;i++) {
			int l=i+1,r=arr.length-1;
			while(l<r) {
				if((arr[l]+arr[r]==-arr[i])){
					System.out.println("Triplet is "+arr[i]+" , "+arr[l]+" , "+arr[r]);
					count++;
				}
				if((arr[l]+arr[r]>-arr[i])) {
					r--;
				}else {
					l++;
				}
			}
		}
		if(count==0) {
			System.out.println("No such pairs found");
		}
	}
	
	public static void leastCommonMultiple(int[] arr) {
		int max=JavaUtil.getMaxEle(arr);
		int res=1,fac=2;
		while(fac<=max) {
			ArrayList<Integer> multiples=new ArrayList<Integer>();
			for(int i=0;i<arr.length;i++) {
				if(arr[i]%fac==0) {
					multiples.add(i);
				}
			}
				if(multiples.size()>1) {
					for(int j=0;j<multiples.size();j++) {
						arr[multiples.get(j)]= arr[multiples.get(j)]/fac;
					}
					res=res*fac;
					max=JavaUtil.getMaxEle(arr);
				}else {
					fac++;
				}
		}
		for(int i=0;i<arr.length;i++) {
			res=res*arr[i];
		}
		System.out.println("LCM of given array is "+res);
	}
	
	public static void sumOfPerfectNumbers(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			if(JavaUtil.isPerfectNumber(arr[i])) {
				sum=sum+arr[i];
			}
		}
		System.out.println("Sum of perfect numbers is "+sum);
	}
	
	public static boolean isValid(int n) {
		boolean isOne=false,isTwo=false,isThree=false;
		while(n!=0) {
			if(n%10==1)isOne=true;
			if(n%10==2)isTwo=true;
			if(n%10==3)isThree=true;
			n=n/10;
		}
		if(isOne && isTwo && isThree) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/****  https://www.geeksforgeeks.org/print-number-ascending-order-contains-1-2-3-digits/  ***/
	public static void numbersInAscOrderContains123(int[] arr) {
		ArrayList<Integer> nums=new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(isValid(arr[i])) {
				nums.add(arr[i]);
			}
		}
		if(nums.size()>0) {
			for(int i=1;i<nums.size();i++) {
				int j=i-1;
				int key=nums.get(i);
				while(j>=0 && nums.get(j)>key) {
					nums.set(j+1, nums.get(j));
					j--;
				}
				nums.set(j+1, key);
			}
			for(int i=0;i<nums.size();i++) {
				System.out.println(nums.get(i));
			}
		}else {
			System.out.println("-1");
		}
	}
	
}

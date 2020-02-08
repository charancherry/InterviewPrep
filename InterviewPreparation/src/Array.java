import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;

import Utilities.JavaUtil;

public class Array {
	static long count=0;
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
//		count=0;
//		mergeSort(mergeSortArray,0,mergeSortArray.length-1);
//		System.out.println("inversion count is "+count);
//		System.out.println("Array after Merge Sort is : ");
//		JavaUtil.print(mergeSortArray);	
//	    
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
//		
//		/****************   https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/   **************/
//		int[] minimumInRotatedArray = JavaUtil.createArray();
//		System.out.println("Enter the element to find");
//		int k = in.nextInt();
//		int index = minimumInRotatedArray(minimumInRotatedArray,0,minimumInRotatedArray.length-1);
//		if(index!=-1) {
//			if(minimumInRotatedArray[0]<k) {
//				int ind = binarySearch(minimumInRotatedArray,0,index-1,k);
//			}else {
//				int ind = binarySearch(minimumInRotatedArray,index+1,minimumInRotatedArray.length-1,k);
//			}
//			System.out.println("Min Element found at"+index);
//		}else {
//			int ind = binarySearch(minimumInRotatedArray,0,minimumInRotatedArray.length-1,k);
//			System.out.println("Min Element Not found");
//		}
//		
//		int[] numberOfPairsWithGivenSum = JavaUtil.createArray();
//		System.out.println("Enter the sum");
//		int sum = in.nextInt();
//		findNOOfPairsWithGivenSumUsingSorting(numberOfPairsWithGivenSum,sum);
//		
//		int[] tripletsWithSumZero = JavaUtil.createArray();
//		printAllTripletsWithSumZero(tripletsWithSumZero);
//		
//		int[] leastCommonMultiple = JavaUtil.createArray();
//		leastCommonMultiple(leastCommonMultiple);
//		
//		int[] sumOfPerfectNumbers = JavaUtil.createArray();
//		sumOfPerfectNumbers(sumOfPerfectNumbers);
//		
//		int[] numbers = JavaUtil.createArray();
//		numbersInAscOrderContains123(numbers);
//		
//		int[] numbers = JavaUtil.createArray();
//		replaceWithGreatestElementOnRightSide(numbers);
//		
//		int[] arr=JavaUtil.createArray();
//		reArrange(arr);
//		
//		int[] shuffleArray=JavaUtil.createArray();
//		shuffleArray(shuffleArray,0,shuffleArray.length-1);
//		JavaUtil.print(shuffleArray);
//		
//		int[] arr=JavaUtil.createArray();
//		int k=in.nextInt();
//
//		int[] seperate012=JavaUtil.createArray();
//		seperate012(seperate012);
//		
//		int[] kSmallestInSameOrder=JavaUtil.createArray();
//		System.out.println("Enter k value");
//		int k = in.nextInt();
//		kSmallestInSameOrder(kSmallestInSameOrder,k);
//		
//		int[] arr1=JavaUtil.createArray();
//		int[] arr2=JavaUtil.createArray();
//		minimumSubArray(arr1,arr2);
//		
//		int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
//		arr=flipAndInvertImage(arr);
//		
//		int[] MaxOccurWithEqualProb = JavaUtil.createArray();
//		MaxOccurWithEqualProb(MaxOccurWithEqualProb);
//		
//		
//		int[] majorityElement = JavaUtil.createArray();
//		majorityElement(majorityElement);
//		
//		int[] uniqueElement = JavaUtil.createArray();
//		uniqueElement(uniqueElement);
//	
//		String s=in.nextLine();
//		int n=in.nextInt();
//		checkDivisibility(s,n);
//	    
//		int[] largestNumber = JavaUtil.createArray();
//		largestNumber(largestNumber);
		
//		medianOfContinuousStream();
		
//		swapEveryTwoBits(4);
//		
//		int[] arr1= {1,5,9,10,15,20};
//		int[] arr2= {2,3,8,13};
//		mergeTwoArrays(arr1,arr2);
//		
//		int[] findElementWithGivenCriteria = JavaUtil.createArray();
//		findElementWithGivenCriteria(findElementWithGivenCriteria);
//
//		int[] minArrayLengthToMakeArraySorted = JavaUtil.createArray();
//		minArrayLengthToMakeArraySorted(minArrayLengthToMakeArraySorted);
		
		int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
		System.out.println(compute_avg(a,b));
		
	}
			
	public static void bubbleSort(int[] arr) {
		int l=arr.length;
		for(int i=0;i<l-1;i++) {
			for(int j=0;j<l-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					JavaUtil.swap(arr, j, j+1);
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
			JavaUtil.print(arr);
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
				count=count+left.length-i;
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
	
	static void mergeInPlace(int[] arr, int beg, int mid, int end, int maxele) {
		int i = beg;
		int j = mid + 1;
		int k = beg;
		while (i <= mid && j <= end) {
			if (arr[i] % maxele <= arr[j] % maxele) {
				arr[k] = arr[k] + (arr[i] % maxele) * maxele;
				k++;
				i++;
			} else {
				arr[k] = arr[k] + (arr[j] % maxele) * maxele;
				k++;
				j++;
			}
		}
		while (i <= mid) {
			arr[k] = arr[k] + (arr[i] % maxele) * maxele;
			k++;
			i++;
		}
		while (j <= end) {
			arr[k] = arr[k] + (arr[j] % maxele) * maxele;
			k++;
			j++;
		}

		// Obtaining actual values
		for (i = beg; i <= end; i++) {
			arr[i] = arr[i] / maxele;
		}
	}

	// Recursive merge sort
	// with extra parameter, naxele
	// https://www.geeksforgeeks.org/merge-sort-with-o1-extra-space-merge-and-on-lg-n-time/
	/// V V Imp maxele=Max(arr)+1
	static void mergeSortInPlace(int[] arr, int beg, int end, int maxele) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			mergeSortInPlace(arr, beg, mid, maxele);
			mergeSortInPlace(arr, mid + 1, end, maxele);
			mergeInPlace(arr, beg, mid, end, maxele);
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

	/*****************************    https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/       ****************/
	public static int kthSmallestElement(int[] array,int kthSmallest) {
		
		final int length = array.length;
		int lowerIndex = 0;
		int upperIndex = length - 1;
		while (lowerIndex <= upperIndex) {
			final int pivot = partition(array, lowerIndex, upperIndex);
			if (pivot + 1 == kthSmallest) {
				return array[pivot];
			} else if (kthSmallest > pivot) {
				lowerIndex = pivot + 1;
			} else {
				upperIndex = pivot - 1;
			}
		}
		return -1;
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

	/******************   https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/    ***************/
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
				s=i+1;
				cur_sum=0;
			}
		}
		System.out.println("Max sum is"+max_sum +"and start index="+start+"end index="+end);
	}
	
	public static int minNumberOfPlatforms(int[] arrivalTimes, int[] deptTimes) {
		Arrays.sort(arrivalTimes);
		Arrays.sort(deptTimes);
		int noOfPlatforms = 1;
		int totalNumberOfPlatforms = 0;
		final int length = arrivalTimes.length;
		int j = 0, i = 1;
		while (i < length && j < length) {
			if (arrivalTimes[i] <= deptTimes[j]) {
				noOfPlatforms = noOfPlatforms + 1;
				if (noOfPlatforms > totalNumberOfPlatforms) {
					totalNumberOfPlatforms = noOfPlatforms;
				}
				i++;
			} else {
				noOfPlatforms--;
				j++;
			}
		} // plat_needed indicates number of platforms
		return totalNumberOfPlatforms;

	}
	
	public static Integer findLargetSumContiguousIncreasingArray(int[] array) {
		int localSumStartIndex = 0;
		int globalSumStartIndex = 0;
		int gloablSumEndIndex = 0;
		int localSum = array[0];
		int globalSum = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				if (localSum > globalSum) {
					globalSum = localSum;
					globalSumStartIndex = localSumStartIndex;
					gloablSumEndIndex = i - 1;
				}
				localSumStartIndex = i;
				localSum = array[i];
			} else {
				localSum = localSum + array[i];
			}

			if (localSum < 0) {
				localSum = 0;
				localSumStartIndex++;
			}
		}

		if (localSum > globalSum) {
			globalSum = localSum;
			globalSumStartIndex = localSumStartIndex;
			gloablSumEndIndex = array.length - 1;
		}

		for (int i = globalSumStartIndex; i <= gloablSumEndIndex; i++) {
			System.out.print(array[i] + " ");
		}
		return globalSum;
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
				s=i+1;
				cur_sum=0;
			}
		}
		System.out.println("Min sum is"+min_sum +"and start index="+start+"end index="+end);
	}

	/****************************   https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/    ***************/	
	public static void MaxSubArrayWithEqualNumberOfOneAndZero(int[] arr) {
		int sum=arr[0],max=Integer.MIN_VALUE,start=-1;
		for(int i=0;i<arr.length;i++) {
			sum = arr[i]==0?-1:1;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]==0) {
					sum=sum-1;
				}else {
					sum=sum+1;
				}
				if(sum==0&&max<j-i+1) {
					start=i;
					max=j-i+1;
				}
			}
		}
		if(sum==-1) {
			System.out.println("Sub-array does not exist");
		}else {
			System.out.println("max sub array is of size"+max);
		}
	}
	
	// rain water problem
	// https://www.geeksforgeeks.org/trapping-rain-water/
	// in two dimension - https://leetcode.com/problems/trapping-rain-water-ii/
	public static int trapCount(int[] array) {
		final int length = array.length;
		final int[] leftMax = new int[length];
		final int[] rightMax = new int[length];

		leftMax[0] = array[0];
		for (int i = 1; i < length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], array[i]);
		}

		rightMax[length - 1] = array[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], array[i]);
		}

		int water = 0;
		for (int i = 1; i < length; i++) {
			water = water + Math.min(leftMax[i], rightMax[i]) - array[i];
		}
		return water;

	}

	/*************  https://leetcode.com/problems/first-missing-positive/   ***********/
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
				System.out.println("minimum missing element is "+i);
				return;
			}
		}
		System.out.println("Minimum Missing element is "+(i+1));
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
		int m1=-1,m2=-1,j=0,i=0;
		int l1=arr1.length;
		int l2=arr2.length;
		for(int c=0;c<=arr1.length;c++) {
			m1=m2;
			if(i==arr1.length) {
				m2=arr2[0];
				break;
			}
			if(j==arr2.length) {
				m2=arr1[0];
				break;
			}
			if(arr1[i]<arr2[j]) {
				m2=arr1[i];
				i++;
			}else {
				m2=arr2[j];
				j++;
			}
		}
		System.out.println("Median is "+(m1+m2)/2);
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
	
	public static int binarySearchToFindNearestElementLowerThanOrEqualToKey(int[] inputArray, int lowerIndex,
			int upperIndex, int searchKey) {
		if (lowerIndex <= upperIndex) {
			if (searchKey >= inputArray[upperIndex])
				return upperIndex;
			else if (searchKey <= inputArray[lowerIndex])
				return lowerIndex;
			final int midIndex = (lowerIndex + upperIndex) / 2;
			if (inputArray[midIndex] == searchKey) {
				return midIndex;
			} else if (midIndex > lowerIndex && inputArray[midIndex] > searchKey
					&& inputArray[midIndex - 1] < searchKey) {
				// instead of returning this, we have to find out which one to return
				return midIndex - 1;
			} else if (midIndex < upperIndex && inputArray[midIndex] < searchKey
					&& inputArray[midIndex + 1] > searchKey) {
				return midIndex + 1;
			}
			if (searchKey < inputArray[midIndex])
				return binarySearchToFindNearestElementLowerThanOrEqualToKey(inputArray, lowerIndex, midIndex - 1,
						searchKey);
			else
				return binarySearchToFindNearestElementLowerThanOrEqualToKey(inputArray, midIndex + 1, upperIndex,
						searchKey);
		}
		return -1;
	}
	
	//****  https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/ ***************/
	public static int minimumInRotatedArray(int[] arr,int l,int r) {
		if(l<=r) {
			if(l==r) {
				return l;
			}
			int mid=(l+r)/2;
			if(mid==0) {
				return (arr[l]<arr[r]?arr[l]:arr[r]);
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
	
	/*************   https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/    ********************/
	public static void seperate012(int[] arr) {
		int start=0;
		int end=arr.length-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				if(start<i) {
					JavaUtil.swap(arr, start, i);
					start++;
					i--;
				}
			}else if(arr[i]==2) {
				if(end>i) {
					JavaUtil.swap(arr, end, i);
					end--;
					i--;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
	}
	
	/**************  https://www.geeksforgeeks.org/k-th-missing-element-in-an-unsorted-array/  **************/
	public static void kthMissingElement(int[] arr,int k) {
		int min=JavaUtil.getMinEle(arr);
		int max=JavaUtil.getMaxEle(arr);
		HashSet<Integer> arrSet = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			arrSet.add(arr[i]);
		}
		int missedSoFar=0;
		int missedElementsCount = max-min+1-arr.length;
		if(k>missedElementsCount) {
			System.out.println("-1");
			return;
		}
		for(int i=min;i<max;i++) {
			if(!arrSet.contains(i)) {
				missedSoFar++;
				if(missedSoFar==k) {
					System.out.println(i);
					return;
				}
			}
		}
	}
	
	/*********   https://www.geeksforgeeks.org/shuffle-2n-integers-format-a1-b1-a2-b2-a3-b3-bn-without-using-extra-space/  ***********/
	public static void shuffleArray(int[] arr,int l,int r) {
		if(l<r) {
			if(l-r==1) {
				return;
			}
			int mid=(l+r)/2;
			int temp=mid+1;
			int fmid = (l+mid)/2;
			for(int i=fmid+1;i<=mid;i++) {
				JavaUtil.swap(arr, i, temp);
				temp++;
			}
			shuffleArray(arr,l,mid);
			shuffleArray(arr,mid+1,r);
		}
	}
	
	/******* https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/  **********/
	public static void findNOOfPairsWithGivenSumUsingSorting(int[] arr,int sum) {
		quickSort(arr,0,arr.length-1);
		int count=0;
		int l=0,r=arr.length-1;
		while(l<r) {
			if((arr[l]+arr[r]==sum)){
				System.out.println("pair is "+arr[l]+"and "+arr[r]);
				l++;
				r--;
				count++;
				continue;
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
					l++;
					r--;
					count++;
					continue;
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
	
	public static void replaceWithGreatestElementOnRightSide(int[] nums) {
		int max=nums[nums.length-1];
		nums[nums.length-1]=-1;
		for(int i=nums.length-2;i>=0;i--) {
			int temp=nums[i];
			nums[i]=max;
			if(max<temp)
				max=temp;
		}
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]);
		}
	}
	
	/*****************  https://www.geeksforgeeks.org/find-index-maximum-occurring-element-equal-probability/amp/   *********/
	public static void MaxOccurWithEqualProb(int[] arr) {
		Map<Integer,ArrayList> map = new HashMap<Integer,ArrayList>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				ArrayList a = map.get(arr[i]);
				a.add(i);
				map.put(arr[i], a);
			}else {
				ArrayList a = new ArrayList();
				a.add(i);
				map.put(arr[i], a);
			}
		}
		int max=Integer.MIN_VALUE;
		int max_key=Integer.MAX_VALUE;
		for(Integer key:map.keySet()) {
			ArrayList a = map.get(key);
			if(max<a.size()) {
				max=a.size();
				max_key=key;
			}
		}
		ArrayList a = map.get(max_key);
		int rand=(int)Math.random()%max_key;
			System.out.print(a.get(rand));
	}
	
/////*******************  https://www.geeksforgeeks.org/majority-element/ *********************/
	/********************  see  O(n) logic also ***************************/
	public static void majorityElement(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				int count=map.get(arr[i]);
				count++;
				map.put(arr[i], count);
			}else {
				map.put(arr[i], 1);
			}
		}
		for(int k:map.keySet()) {
			if(map.get(k)>arr.length/2) {
				System.out.println("Major element is "+k);
				return;
			}
		}
		System.out.println("There is no majority element");
	}
	
	/**************   https://www.geeksforgeeks.org/check-divisibility-binary-stream/  ***********/
	public static void checkDivisibility(String s,int n) {
		char[] stream = s.toCharArray();
		int r=0;
		for(int i=0;i<s.length();i++) {
			if(stream[i]=='1') {
				r = ((r*2)+1)%n;
			}else {
				r=(r*2)%n;
			}
		}
		if(r%n==0) {
			System.out.println("Given stream is divisible by"+n);
		}else {
			System.out.println("Given stream is not divisible");
		}
	}
	
	/**************************    https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/    *******************/
	   public static void uniqueElement(int[] arr){
		    int res=0;
		    for(int i=0;i<arr.length;i++){
		        res=res^arr[i];
		    }
		    System.out.println(res);
		}
	   
	    public static boolean isGreater(int num1,int num2){
	        String str1=Integer.toString(num1)+Integer.toString(num2);
	        String str2=Integer.toString(num2)+Integer.toString(num1);
	        if(str2.compareTo(str1)>0){
	            return true;
	        }else{
	            return false;
	        }
	    }
	    
	    /**********  https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0 **********/
	    public static void largestNumber(int[] arr){
	        for(int i=1;i<arr.length;i++){
	            int temp=arr[i];
	            int j=i-1;
	            while(j>=0 && isGreater(arr[j],temp)){
	                arr[j+1]=arr[j];
	                j--;
	            }
	            arr[j+1]=temp;
	        }
	        String res="";
	        for(int ind=0;ind<arr.length;ind++){
	            res += Integer.toString(arr[ind]);
	        }
	        System.out.println(res);
	    }
	    
	    public static void maxheapify(int[] arr,int n,int i) {
	    	int max=i;
	    	int l = 2*i+1;
	    	int r=2*i+2;
	    	if(l<n && arr[l]>arr[i]) {
	    		max=l;
	    	}
	    	if(r<n && arr[r]>arr[i]) {
	    		max=r;
	    	}
	    	if(max!=i) {
	    		JavaUtil.swap(arr, max, i);
	    		maxheapify(arr,n,max);
	    	}
	    }
	    
	    public static void minheapify(int[] arr,int n,int i) {
	    	int min=i;
	    	int l = 2*i+1;
	    	int r=2*i+2;
	    	if(l<n && arr[l]<arr[i]) {
	    		min=l;
	    	}
	    	if(r<n && arr[r]<arr[i]) {
	    		min=r;
	    	}
	    	if(min!=i) {
	    		JavaUtil.swap(arr, min, i);
	    		minheapify(arr,n,min);
	    	}
	    }
	    
	    public static void buildMaxHeap(int[] arr,int l) {
	    	for(int i=l/2-1;i>=0;i--) {
	    		maxheapify(arr,l,i);
	    	}
	    }
	    
	    
	    public static void buildMinHeap(int[] arr,int l) {
	    	for(int i=l/2-1;i>=0;i--) {
	    		minheapify(arr,l,i);
	    	}
	    }
	    
	    /**************************   https://medium.com/@eranda/running-median-with-heaps-829522330e8a  **************/
	    public static void medianOfContinuousStream() {
	    	Scanner in=new Scanner(System.in);
	    	int n=in.nextInt();
	    	int[] a=new int[n];
	    	int[] max_heap = new int[n];
	    	int[] min_heap=new int[n];
	    	int maxHeapSize=0;
	    	int minHeapSize=0;
	    	float cur_median=0;
	    	for(int i=0;i<n;i++) {
	    		a[i]=in.nextInt();
	    		if(a[i]<cur_median) {
	    			max_heap[maxHeapSize++]=a[i];
	    			if(max_heap[0]<max_heap[maxHeapSize-1]) {
	    				JavaUtil.swap(max_heap, 0, maxHeapSize-1);
	    			}
	    		}else {
	    			min_heap[minHeapSize++]=a[i];
	    			if(min_heap[0]>min_heap[minHeapSize-1]) {
	    				JavaUtil.swap(min_heap, 0, minHeapSize-1);
	    			}
	    		}
	    		if(Math.abs(maxHeapSize-minHeapSize)>1) {
	    			if(maxHeapSize>minHeapSize) {
	    				JavaUtil.swap(max_heap, 0, maxHeapSize-1);
	    				min_heap[minHeapSize++]=max_heap[maxHeapSize-1];
	    				JavaUtil.swap(min_heap, 0, minHeapSize-1);
	    				maxHeapSize--;
	    				buildMaxHeap(max_heap,maxHeapSize);
	    			}else {
	    				JavaUtil.swap(min_heap, 0, minHeapSize-1);
	    				max_heap[maxHeapSize++]=min_heap[minHeapSize-1];
	    				JavaUtil.swap(max_heap, 0, maxHeapSize-1);
	    				minHeapSize--;
	    				buildMinHeap(min_heap,minHeapSize);
	    			}
	    		}
	    		
	    		if(minHeapSize==maxHeapSize) {
	    			cur_median=(max_heap[0]+min_heap[0])/2f;
	    		}else if(minHeapSize>maxHeapSize) {
	    			cur_median=min_heap[0];
	    		}else {
	    			cur_median=max_heap[0];
	    		}
	    		System.out.println("Median is "+cur_median);
	    	}
	    }
	    
	    public static void swapEveryTwoBits(int n) {
	    	int swapNum= (((n&0b10101010)>>1) |((n&0b01010101)<<1)); 
	    	System.out.println("Number after swapping every two bits is "+swapNum);
	    }
	    
	    
	    /*******************   https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/   **********/
	    public static void mergeTwoArrays(int[] a1,int[] a2){
	        for(int i=a2.length-1;i>=0;i--){
	            if(a1[a1.length-1]>a2[i]){
	                int j=a1.length-2,temp=a2[i];
	                a2[i]=a1[a1.length-1];
	                while(j>=0&&a1[j]>temp){
	                    a1[j+1]=a1[j];
	                    j--;
	                }
	                a1[j+1]=temp;
	            }
	        }
	        for(int i=0;i<a1.length;i++){
	            System.out.print(a1[i]+" ");
	        }
	        for(int i=0;i<a2.length;i++){
	            System.out.print(a2[i]+" ");
	        }
	    }
	    
	    /*********************   https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/   *********/
	    public static void findElementWithGivenCriteria (int[] arr) {
	    	int n=arr.length;
	    	int[] leftmax=new int[n];
	    	int[] rightmin=new int[n];
	    	leftmax[0]=Integer.MIN_VALUE;
	    	for(int i=1;i<n;i++) {
	    		leftmax[i]=Math.max(leftmax[i-1], arr[i-1]);
	    	}
	    	rightmin[n-1]=Integer.MAX_VALUE;
	    	for(int i=n-2;i>=0;i--) {
	    		rightmin[i]=Math.min(rightmin[i+1], arr[i+1]);
	    	}
	    	for(int i=0;i<n;i++) {
	    		if(arr[i]>leftmax[i]&&arr[i]<rightmin[i]) {
	    			System.out.println("Required element is "+arr[i]);
	    		}
	    	}
	    }
	    
	    /*******************************   https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/  **************/
	    public static void minArrayLengthToMakeArraySorted(int[] arr) {
	    	int s=0,e=0;
	    	int n=arr.length;
	    	for(int i=1;i<n;i++) {
	    		if(arr[i]<arr[i-1]) {
	    			s=i;
	    			break;
	    		}
	    	}
	    	if(s==n-1) {
	    		System.out.println("Array is already sorted");
	    		return;
	    	}
	    	for(int i=n-1;i>0;i--) {
	    		if(arr[i]<arr[i-1]) {
	    			e=i;
	    			break;
	    		}
	    	}
	    	int max=arr[s],min=arr[s];
	    	for(int i=s;i<=e;i++) {
	    		if(arr[i]<min) {
	    			min=arr[i];
	    		}else if(arr[i]>max) {
	    			max=arr[i];
	    		}
	    	}
	    	for(int i=0;i<s;i++) {
	    		if(arr[i]>min) {
	    			s=i;
	    			break;
	    		}
	    	}
	    	for(int i=n-1;i>e;i--) {
	    		if(arr[i]<max) {
	    			e=i;
	    			break;
	    		}
	    	}
	    	System.out.println("sub array between "+s+" and "+e+" to be sorted");
	    }
	    
		/*******************  https://leetcode.com/problems/flipping-an-image/     *****************/
	    public static int[][] flipAndInvertImage(int[][] A) {
	        int r=A.length;
	        int c=A[0].length;
	        for(int i=0;i<r;i++){
	            for(int j=0;j<(c+1)/2;j++){
	                int temp=(A[i][j]^1);
	                A[i][j]=(A[i][c-1-j]^1);
	                A[i][c-1-j]=temp;
	            }
	        }
	        return A;
	    }
		
		//************************ https://www.geeksforgeeks.org/find-smallest-subarray-contains-elements-order/  ************/
		public static void minimumSubArray(int[] arr1,int[] arr2) {
			int l=0,min_so_far=Integer.MAX_VALUE,start=-1,end=-1;
			for(int i=0;i<=arr1.length-arr2.length;i++) {
				int k=0;
				for(int j=i;j<arr1.length;j++) {
					if(k==0) {
						if(arr1[j]!=arr2[k]) {
							break;
						}
					}
					if(k<=arr2.length && arr1[j]==arr2[k]) {
						k++;
					}
					if(k==arr2.length) {
						l=j-i;
						if(l<=min_so_far) {
							min_so_far=l;
							start=i;
							end=j;
						}
						break;
					}
				}
			}
			if(start==-1) {
				System.out.println("Sub array is not found");
			}else {
				System.out.println("Length of min sub array is "+min_so_far);
				for(int i=start;i<=end;i++) {
					System.out.print(arr1[i]+" ");
				}
			}
		}
		/***********************  https://www.geeksforgeeks.org/k-smallest-elements-order-using-o1-extra-space/     *************************/
		public static void kSmallestInSameOrder(int[] arr,int k) {
			int max=Integer.MIN_VALUE,max_so_far=Integer.MAX_VALUE;
			for(int i=0;i<arr.length-k;i++) {
				for(int j=0;j<arr.length;j++) {
					if(arr[j]>max && arr[j]<max_so_far) {
						max=arr[j];
					}
				}
				max_so_far=max;
				max=Integer.MIN_VALUE;
			}
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i]<max_so_far) {
					System.out.print(arr[i]+" ");
				}
			}
		}
		
		/**********************   https://www.geeksforgeeks.org/compute-average-two-numbers-without-overflow/     *****************/
		public static int compute_avg(int a,int b) {
			if(a==b) {
				return a;
			}
			return (a+b)/2;
		}
	    
	    
	
}

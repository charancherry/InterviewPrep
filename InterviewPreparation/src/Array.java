import java.util.Scanner;

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
		
		
	
//		int[] findkthSmallesstElement =JavaUtil.createArray();
//		System.out.println("Enter k value ");
//		int k = in.nextInt();
//		if(k>findkthSmallesstElement.length) {
//			System.out.println("Invalis k value");
//		}else {
//			int result=kthSmallestElement(findkthSmallesstElement,k);
//			System.out.println("kth smallest element is "+result);
//		}
			
//		int[]  findSubArrayWithGivenSum=JavaUtil.createArray();
//		int sum = in.nextInt();
//		findSubArrayWithGivenSum(findSubArrayWithGivenSum,sum);
		
		int[]  findMaxSubArray=JavaUtil.createArray();
		//findMaxSubArray(findMaxSubArray);
		//findMinSubArray(findMaxSubArray);
		MaxSubArrayWithEqualNumberOfOneAndZero(findMaxSubArray);
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
			int mid=(l+(r-1))/2;
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
		return (i+1);
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
}

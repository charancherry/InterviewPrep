import Utilities.JavaUtil;

public class Array {

	public static void main(String[] args) {
		
		int[] bubbleSortArray = JavaUtil.createArray();
		System.out.println("Array befor Sorting is : ");
		JavaUtil.print(bubbleSortArray);
		bubbleSort(bubbleSortArray);
		System.out.println("Array after Sorting is : ");
		JavaUtil.print(bubbleSortArray);
		
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
}

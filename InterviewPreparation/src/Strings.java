import java.util.*;

import Utilities.JavaUtil;

import org.json.JSONException;
import org.json.JSONObject;
import java.lang.Math;
public class Strings {
	static int max=0;
	public static void main(String[] args) throws JSONException {
		Scanner in = new Scanner(System.in);
		
//		System.out.println("Enter String to be reversed");
//		String str= in.nextLine();
//		str = reverseString(str);
//		System.out.println("Reversed String is "+str);
//		
//		System.out.println("Enter the strings to be added");
//		String str1 = in.nextLine();
//		String str2 = in.nextLine();
//		addStrings(str1,str2);
//		
//		System.out.println("Enter the string");
//		String str = in.nextLine();
//		firstNonReapeatingChar(str.toCharArray());
//		
//		System.out.println("Enter the string");
//		String str = in.nextLine();
//		System.out.println("Enter K");
//		int k=in.nextInt();
//		kthCharInDecryptedString(str.toCharArray(),k);
//
//		System.out.println("Enter the strings");
//		String str1 = in.nextLine();
//		String str2 = in.nextLine();
//		oneXtraCharInString(str1.toCharArray(),str2.toCharArray());
//		
//		System.out.println("Enter the string");
//		String str = in.nextLine();
//		System.out.println("Enter the index from where string to be reversed");
//		int ind=in.nextInt();
//		reverseStringFromParticularIndex(str.toCharArray(),ind);
//
//		System.out.println("Enter the string");
//		String str = in.nextLine();
//		printAllPermutations(str.toCharArray(),0,str.length()-1);
//		
//		System.out.println("Enter the number");
//		long num=in.nextInt();
//		maxNumberFromGivenNum(num);
//		
//		System.out.println("Enter the number");
//		int num=in.nextInt();
//		findnearestPalyndrome(num);
//		
//		System.out.println("Enter the strings");
//		String str = in.nextLine();
//		reverseWordsInStrinf(str.toCharArray());
//		
//		System.out.println("Enter the string");
//		String str=in.next();
//		toUppercase(str.toCharArray());
//		
//		System.out.println("Enter the string");
//		String str=in.next();
//		checkIfParenthesisAreBalanced(str.toCharArray());
//		
//		System.out.println("Enter No of strings");
//		int n= in.nextInt();
//		System.out.println("Enter the strings");
//		ArrayList<char[]> strings=new ArrayList<char[]>();
//		for(int i=0;i<n;i++) {
//			String str=in.next();
//			strings.add(str.toCharArray());
//		}
//		sortWords(strings);
//		
//		System.out.println("Enter No of strings");
//		int n= in.nextInt();
//		System.out.println("Enter the strings");
//		ArrayList<String> strings=new ArrayList<String>();
//		for(int i=0;i<n;i++) {
//			String str=in.next();
//			strings.add(str);
//		}
//		lexographicalOrderOfGivenWords(strings);
//		
//		System.out.println("Enter the string");
//		String str=in.next();
//		sortStringFollowedByIntegerSum(str.toCharArray());
//		
//		System.out.println("Enter the Number");
//		int n=in.nextInt();
//		numberAsStringAANDB(n);
//		
//		String[] a = {"bella","label","roller"};
//		List<String> str = commonChars(a);
//		System.out.println(str);
//
//		System.out.println("Enter string");
//		String str=in.next();
//		recurssivelyRemoveAdjDuplicates(str);
//		
//		System.out.println("Enter strings");
//		String str1=in.next();
//		String str2=in.next();
//		String result = abbreviation(str1,str2);
//		System.out.println(result);
//		
//		int n=in.nextInt();
//	    convertToWords(n);
//		
//		System.out.println("Enter the n value");
//		int n=in.nextInt();
//		decodeAndFind(n);
//		
//		System.out.println("Enter strings");
//		String str1=in.next();
//		printCombinationsRecursive(str1.toCharArray(),0,"");
//		
//		System.out.println("Enter strings");
//		String longestUniqueSubString=in.next();
//		longestUniqueSubString(longestUniqueSubString);
//		
//		System.out.println("Enter strings");
//		String nextGretestNumber=in.next();
//		nextGretestNumber(nextGretestNumber.toCharArray());
//		
//		System.out.println("Enter strings");
//		String lexographicallyFirstPalyndrome=in.next();
//		lexographicallyFirstPalyndrome(lexographicallyFirstPalyndrome);
//		
//		System.out.println("Enter string and pattern");
//		String str=in.nextLine();
//		String p=in.nextLine();
//		minWindow(str,p);
//		
//		System.out.println("Enter strings");
//		String largestLexographicSubsequence=in.next();
//		largestLexographicSubsequence(largestLexographicSubsequence);
//		
//		System.out.println("Enter strings");
//		String lexogrpahicallyLargestPalyndromicSubSequence=in.next();
//		lexogrpahicallyLargestPalyndromicSubSequence(lexogrpahicallyLargestPalyndromicSubSequence);
		
		System.out.println("Enter string and pattern");
		String str=in.nextLine();
		decodeString(str);
	}
	
	
	public static boolean isUpperCaseExist(char[] c,int s,int l) {
		for(int i=s+1;i<l;i++) {
			if(c[i]>='A' && c[i]<='Z') {
				return true;
			}
		}
		return false;
	}
	
    public static int getIndex(ArrayList<Integer> list,int temp) {
        for(int i=0;i<list.size();i++) {
            if(list.get(i)>temp) {
                return list.get(i);
            }
        }
        return -1;
    }
	
	static String abbreviation(String a, String b) {
		HashMap<Character,ArrayList> m = new HashMap<Character,ArrayList>();
		char[] c1=a.toCharArray();
		char[] c2=b.toCharArray();
		for(int i=0;i<c1.length;i++) {
			char key;
			if(c1[i]>='a' && c1[i]<='z') {
				key=(char)((int)c1[i]-32);
			}else {
				key=c1[i];
			}
			if(m.containsKey(key)) {
				ArrayList<Integer> index = m.get(key);
				index.add(i);
				m.put(key, index);
			}else {
				ArrayList<Integer> index = new ArrayList<Integer>();
				index.add(i);
				m.put(key, index);
			}
		}
		int temp_Index=-1;
		int start=-1;
		boolean isUpperCaseExist =false;
		for(int i=0;i<c2.length;i++) {
			if(m.containsKey(c2[i])) {
				char c = c2[i];
				ArrayList<Integer> index=m.get(c2[i]);
				int ind= getIndex(index,temp_Index);
				if( ind!= -1){
					if(temp_Index == -1) {
						 isUpperCaseExist = false;
					}else {
					 isUpperCaseExist = isUpperCaseExist(c1,temp_Index,ind);
					}
					if(isUpperCaseExist) {
						return new String("NO");
					}
					temp_Index = ind;
					index.remove((Integer)ind);
				}else {
					return new String("NO");
				}
			}else {
				return new String("NO");
			}
		}
		boolean isUpperCaseExistAtEnd = isUpperCaseExist(c1,temp_Index,c1.length);
        boolean isUpperCaseExistAtStart = isUpperCaseExist(c1,0,start);
        if(isUpperCaseExistAtEnd || isUpperCaseExistAtStart) {
            return new String("NO");    
        }
        return new String("YES");

	}

	
	/****************************  https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/  *************/
	public static void recurssivelyRemoveAdjDuplicates(String str) {
		char[] c = str.toCharArray();
		Stack s = new Stack();
		char temp='\0';
		s.push(c[0]);
		for(int i=1;i<str.length();i++) {
			if(!s.empty() && (char) s.peek() == c[i]) {
				temp=c[i];
			}
			if(temp != '\0' && temp != c[i]) {
				while(!s.empty() && (char) s.peek()==temp) {
					s.pop();
				}
				temp = '\0';
				i--;
				continue;
			}
			s.push(c[i]);
		}
		if(temp != '\0') {
			while(!s.empty() && (char) s.peek()==temp) {
				s.pop();
			}
		}
		while(!s.empty()) {
			System.out.print(s.pop());
		}
	}
	public static String reverseString(String str) {
		char[] charArray = str.toCharArray();
		int l= charArray.length-1;
		for(int i=0;i<=charArray.length/2;i++) {
			JavaUtil.charSwap(charArray, i, l-i);
			
		}
		return new String(charArray);
	}
	
	public static void addStrings(String str1,String str2) {
		char[] strArray1=str1.toCharArray();
		char[] strArray2=str2.toCharArray();
		StringBuilder resultString = new StringBuilder();
		int i=0,j=0,carry=0,sum1=0;
		while(i<str1.length()&&j<str2.length()) {
			sum1=strArray1[str1.length()-i-1]+strArray2[str2.length()-j-1]-96;
			if(carry!=0) {
				sum1=sum1+carry;
				carry=0;
			}
			carry=sum1/10;
			sum1=sum1%10;
			resultString.append(sum1);
			i++;
			j++;
		}
		while(i<str1.length()) {
			sum1=strArray1[str1.length()-i-1]-48+carry;
			carry=sum1/10;
			sum1=sum1%10;
			resultString.append(sum1);
			i++;

		}
		while(j<str2.length()) {
			sum1=strArray2[str2.length()-j-1]-48+carry;
			carry=sum1/10;
			sum1=sum1%10;
			resultString.append(sum1);
			j++;
		}
		if(carry !=0) {
			resultString.append(carry);
		}
		System.out.print(resultString);
	}
	
	public static void firstNonReapeatingChar(char[] arr) throws JSONException {
		JSONObject charInfo = new JSONObject();
		JSONObject info = new JSONObject();
		for(int i=0;i<arr.length;i++) {
			if(!charInfo.has(String.valueOf(arr[i]))) {
				info = new JSONObject();
				info.put("index",i);
				info.put("count", 1);
				charInfo.put(String.valueOf(arr[i]), info);
			}else {
				JSONObject infoJson = charInfo.getJSONObject(String.valueOf(arr[i]));
				int count = infoJson.getInt("count");
				 count++;
				infoJson.put("count", count);
				charInfo.put(String.valueOf(arr[i]), infoJson);
			}
		}
		int res_index=Integer.MAX_VALUE;
		String res_key="";
		Iterator keys=charInfo.keys();
		while(keys.hasNext()) {
			String key=(String) keys.next();
			JSONObject info1 = charInfo.getJSONObject(key);
			if(info1.getInt("count")==1) {
				if(res_index>info1.getInt("index")) {
					res_index=info1.getInt("index");
					res_key=key;
				}
			}
		}
		System.out.println("First Unique Character is"+res_key);
	}
	
	public static int number(char[] arr,int start,int end) {
		int sum=0;
		for(int i=end;i>=start;i--) {
			sum=sum+ ((int)arr[i]-48)*(int)Math.pow(10,end-i);
		}
		return sum;
	}
	
	/*************    https://www.geeksforgeeks.org/find-kth-character-of-decrypted-string/  *************/
	public static void kthCharInDecryptedString(char[] arr,int k) {
		int count=0,prev_count=0;
		int char_start=0,char_end=0,count_start=0,count_end=0;
		boolean chars=false,numbers=false;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>='a' && arr[i]<='z') {
				if(!chars) {
					if(i!=0) {
						prev_count=count;
						count=count+((char_end-char_start+1)*number(arr,count_start,count_end));
						if(k<=count) {
							break;
						}
					}
					chars=true;
					numbers=false;
					char_start=i;
				}
				char_end=i;
			}
			if(arr[i]>='0' && arr[i]<='9') {
				if(!numbers) {
					numbers=true;
					chars=false;
					count_start=i;
				}
				count_end=i;
			}	
		}
		int index=((k-prev_count)%(char_end-char_start+1))-1;
		if(index==-1) {
			index=char_end-char_start;
		}
		System.out.println("kth character is"+arr[char_start+index]);
	}
	
//    public List<String> commonChars(String[] A) {
//        List<String> str=new ArrayList<String>();
//        char[] c = A[0].toCharArray();
//        boolean isExist=false;
//        for(int i=0;i<c.length;i++){
//            isExist=true;
//            for(int j=0;j<A.length;j++){
//                if(!A[j].contains(Character.toString(c[i]))){
//                    isExist=false;
//                }
//        }   
//            if(isExist){
//             str.add(Character.toString(c[i]));   
//            }
//    }
//        return str;
//    }
    
    public static List<String> commonChars(String[] A) {
        List<String> str=new ArrayList<String>();
        int[][] count = new int[A.length][26];
        for(int i=0;i<A.length;i++){
            char[] temp=A[i].toCharArray();
            for(int j=0;j<temp.length;j++){
                count[i][temp[j]-'a']++;
            }
        }
        int max=0;
        char[] temp = A[0].toCharArray();
        for(int i=0;i<temp.length;i++){
            max=count[0][temp[i]-'a'];
            for(int j=0;j<count.length;j++){
                if(count[j][temp[i]-'a']==0){
                    max=0;
                    break;
                }else{
                    if(max>count[j][temp[i]-'a']){
                        max=count[j][temp[i]-'a'];
                    }
                }
            }
            if(max>0&&!str.contains(Character.toString(temp[i]))){
                for(int k=0;k<max;k++){
                    str.add(Character.toString(temp[i]));
                }
            }
        }
        return str;
    }
	
	public static void oneXtraCharInString(char[] str1,char[] str2) {
		HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
		for(int i=0;i<str2.length;i++) {
			charMap.put(str2[i], 1);
		}
		for(int i=0;i<str1.length;i++) {
			charMap.put(str1[i], 0);
		}
		for(Character c:charMap.keySet()){
			if(charMap.get(c)==1) {
				System.out.println("Xtra Char is "+c);
				return;
			}
		}
		
	}
	
	public static void reverseStringFromParticularIndex(char[] arr,int k) {
		for(int i=0;i<(arr.length-k+1)/2;i++) {
			JavaUtil.charSwap(arr, k-1+i, arr.length-1-i);
		}
		
		System.out.println("Resulting string after swapping from particular index is "+new String(arr));
	}
	
	public static void printAllPermutations(char[] arr,int l,int r) {
		if(l==r) {
			System.out.println(new String(arr));
		}else {
			for(int i=l;i<=r;i++) {
				JavaUtil.charSwap(arr, l, i);
				printAllPermutations(arr,l+1,r);
				JavaUtil.charSwap(arr, l, i);
			}
		}
	}
	
	// doesn't scale for large strings
		// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
		// also think of printing it in alphabetical order
		// https://www.geeksforgeeks.org/distinct-permutations-string-set-2/
		public static void printPermutationsWithoutDuplicates(char[] inputArray, int lowerIndex, int upperIndex,
				Set<String> stringStore) {
			if (lowerIndex <= upperIndex) {
				if (lowerIndex == upperIndex) {
					stringStore.add(String.valueOf(inputArray));
				}
				for (int i = lowerIndex; i <= upperIndex; i++) {
					JavaUtil.charSwap(inputArray, lowerIndex, i);
					printPermutationsWithoutDuplicates(inputArray, lowerIndex + 1, upperIndex, stringStore);
					JavaUtil.charSwap(inputArray, lowerIndex, i);
				}
			}

		}
		
		// doesn't scale for large strings
		// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
		// http://blog.gainlo.co/index.php/2017/01/05/uber-interview-questions-permutations-array-arrays/
		public static void printPermutations(char[] inputArray, int lowerIndex, int upperIndex) {
			if (lowerIndex == upperIndex) {
				System.out.println(String.valueOf(inputArray));
			}
			for (int i = lowerIndex; i <= upperIndex; i++) {
				if (shouldSwap(inputArray, lowerIndex, i)) {
					JavaUtil.charSwap(inputArray, lowerIndex, i);
					printPermutations(inputArray, lowerIndex + 1, upperIndex);
					JavaUtil.charSwap(inputArray, lowerIndex, i);
				}
			}

		}

		// working fine
		static boolean shouldSwap(char str[], int lowerIndex, int upperIndex) {
			for (int i = lowerIndex; i < upperIndex; i++) {
				if (str[i] == str[upperIndex]) {
					return false;
				}
			}
			return true;
		}
	
	public static void printCombinationsRecursive(char[] array, int index, String result) {
		// Print current subset
		if (index >= array.length) {
			System.out.println(result + " ");
			return;
		}
		printCombinationsRecursive(array, index + 1, result + array[index]);
		printCombinationsRecursive(array, index + 1, result);
	}
	
	public static void maxNumberFromGivenNum(long num) {
		int digit;
		int count=0;
		HashMap<Integer,Integer> digits = new HashMap<Integer,Integer>();
		while(num !=0 ) {
			count=1;
			digit=(int)num%10;
			num=num/10;
			if(digits.containsKey(digit)) {
				count=digits.get(digit);
				count++;
			}
			digits.put(digit, count);
		}
		for(int i=9;i>=0;i--) {
			if(digits.containsKey(i)) {
				count=digits.get(i);
				for(int j=0;j<count;j++) {
					System.out.print(i);
				}
			}
		}
	}
	
	/************************  https://www.geeksforgeeks.org/closest-palindrome-number-whose-absolute-difference-min/ ************/
	public static void findnearestPalyndrome(int num) {
		int count=0;
		char[] nums=String.valueOf(num).toCharArray();
		int l=nums.length-1;
		for(int i=0;i<=l/2;i++) {
			if(nums[i]==nums[l-i]) {
				count++;
			}
		}
		if(count==nums.length/2) {
			nums[l/2]++;
			if(nums.length%2==0) {
				nums[l/2+1]++;
			}
		}else {
			for(int i=l/2+1;i<=l;i++) {
				nums[i]=nums[l-i];
			}
		}
		System.out.print("Nearest Palyndrome is"+new String(nums));
	}
	
	public static void reverseWordsInStrinf(char[] arr) {
		int start_ind=0;
		int l=arr.length-1;
		for(int i=0;i<=l+1;i++) {
			if(i==l+1 || arr[i]==' ') {
				int iter = (i-start_ind)/2;
				for(int j=0;j<iter;j++)
				JavaUtil.charSwap(arr, start_ind+j,i-1-j);
				start_ind=i+1;
			}
		}
		System.out.print("Nearest Palyndrome is"+new String(arr));
	}
	
	public static void toUppercase(char[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>='a' && arr[i]<='z') {
				arr[i]=(char)((int)arr[i]-32);
			}
		}
		System.out.println("Upper String is "+new String(arr));
	}
	
	
	
	/*****  https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression-o1-space-on2-time-complexity ****/
	public static void checkIfParenthesisAreBalanced(char[] arr) {
		int parCount=0,flowerCount=0,squareCount=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='(')parCount++;
			else if(arr[i]==')') {
				if(parCount<=0) {
					System.out.println("Not balanced");
					return;
				}else {
					parCount--;
				}
			}else if(arr[i]=='{')flowerCount++;
			else if(arr[i]=='}') {
				if(flowerCount<=0) {
					System.out.println("Not balanced");
					return;
				}else {
					flowerCount--;
				}
			}else if(arr[i]=='[')squareCount++;
			else if(arr[i]==']') {
				if(squareCount<=0) {
					System.out.println("Not balanced");
					return;
				}else {
					squareCount--;
				}
			}
		}
		System.out.println("Balanced paranthesis");
	}
	
	public static boolean isGreater(char[] str1,char[] str2) {
		boolean isGreater=false;
		for(int i=0;i<str1.length&&i<str2.length;i++) {
			if(str2[i]>str1[i]) {
				return true;
			}
		}
		return false;
	}
	
	
	/****   https://www.geeksforgeeks.org/print-array-strings-sorted-order-without-copying-one-string-another/**/
	public static void sortWords(ArrayList<char[]> str) {
		for(int i=1;i<str.size();i++) {
			char[] temp=str.get(i);
			int j=i-1;
			while(j>=0 && isGreater(temp,str.get(j))) {
				str.set(j+1, str.get(j));
				j--;
			}
			str.set(j+1, temp);
		}
		System.out.println("Sorted Strings are");
		for(int i=0;i<str.size();i++) {
			System.out.println(new String(str.get(i)));
		}
	}
	
	public static void lexographicalOrderOfGivenWords(ArrayList<String> str) {
		Collections.sort(str, new Comparator<String>(){
			public int compare(String s1,String s2) {
				char[] c1=s1.toCharArray();
				char[] c2=s2.toCharArray();
				int len=c1.length<c2.length?c1.length:c2.length;
				for(int i=0;i<len;i++) {
					if(c1[i]<c2[i]) {
						return -1;
					}else {
						return 1;
					}
				}
				return c1.length<c2.length?-1:1;
			}
		});
		for(int i=0;i<str.size();i++) {
			System.out.println(str.get(i));
		}
	}
	
	
	/**** https://www.geeksforgeeks.org/rearrange-a-string-in-sorted-order-followed-by-the-integer-sum/  **/
	public static void sortStringFollowedByIntegerSum(char[] arr) {
		int sum=0,count=0;
		Map<Character,Integer> charInfo = new TreeMap<Character,Integer>();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>='A' && arr[i]<='Z') {
				count=1;
				if(charInfo.containsKey(arr[i])) {
					count=charInfo.get(arr[i]);
					count++;
				}
				charInfo.put(arr[i], count);
			}else {
				sum = sum+(int)arr[i] -48;
			}
		}
		for(Character c:charInfo.keySet()) {
			count=charInfo.get(c);
			for(int i=0;i<count;i++) {
				System.out.print(c);
			}
		}
		System.out.print(sum);
	}
	
	
	/***  https://www.geeksforgeeks.org/print-a-number-as-string-of-a-and-b-in-lexicographic-order ***/
	
	/**************     // Since k length string can  
        // represent at most pow(2, k+1)-2  
        // that is if k = 4, it can  
        // represent at most pow(2, 4+1)-2 = 30  
        // so we have to calculate the  
        // length of the corresponding string  
        if ((int)Math.pow(2, k + 1) - 2 < M)  
            k++;  
        else
            break;  
    }     *****************/
	
	public static void numberAsStringAANDB(int n) {
		int temp=n,noOfDigits=1,noOfWords=2;
		StringBuilder str=new StringBuilder();
		while(temp>noOfWords) {
			noOfDigits++;
			noOfWords=noOfWords+(int)Math.pow(2, noOfDigits);
		}
		int pos=(int) Math.pow(2, noOfDigits) - (noOfWords-n)-1;
		while(pos !=0 ) {
			if(pos%2==0) {
				str.append('A');
			}else {
				str.append('B');
			}
			noOfDigits--;
			pos=pos/2;
		}
		while(noOfDigits!=0) {
			str.append('A');
			noOfDigits--;
		}
		System.out.println("Result string is "+reverseString(str.toString()));
		
	}
	
	
	/*********************  https://www.geeksforgeeks.org/look-and-say-sequence/ **************/
	public static void decodeAndFind(int n) {
		if(n==1) {
			System.out.println("1");
			return;
		}
		if(n==2) {
			System.out.println("11");
			return;
		}
		String temp="11";
		for(int i=3;i<=n;i++) {
			StringBuilder str = new StringBuilder();
			char[] c=temp.toCharArray();
			int count=1;
			for(int j=1;j<temp.length();j++) {
				if(c[j]!=c[j-1]) {
					str.append(count);
					str.append(c[j-1]);
					count=1;
				}else {
					count++;
				}
			}
			str.append(count);
			str.append(c[c.length-1]);
			temp=str.toString();
		}
		System.out.println(temp);
	}
	
	public static void convertToWords(int n){
        String[] tens = {"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        String[] ones ={"one","two","three","four","five","six","seven","eight","nine"};
        String[] special={"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String res ="";
        int thousand = n/1000;
        if(thousand!=0){
            res =res+ones[thousand-1]+" thousand ";
        }
        int hun =n%1000/100;
        if(hun!=0){
            res = res+ones[hun-1]+" hundred ";
        }
        int ten = n%1000%100/10;
        int units=n%1000%100%10;
        if(hun!=0&&(ten!=0||units!=0)){
            res = res +"and ";
        }
        if(ten!=1 && ten !=0){
            res =res+tens[ten-1]+" ";
            if(units !=0){
                res = res+ones[units-1];
            }
        }else if(ten ==1 && units==0){
            res = res +tens[0];
        }else if(ten==1 && units !=0){
            res = res+special[units-1];
        }else if(units !=0){
            res = res+ones[units-1];
        }
        System.out.println(res);
    }
	
	/*****************   https://www.geeksforgeeks.org/print-longest-substring-without-repeating-characters/   ************/
	public static void longestUniqueSubString(String str) {
		HashMap<Character,Integer> m = new HashMap<Character,Integer>();
		int cur_len=1;
		int max_len=1,start=0,s=0;
		m.put(str.charAt(0), 0);
		for(int i=1;i<str.length();i++) {
			if(!m.containsKey(str.charAt(i))) {
				m.put(str.charAt(i), i);
			}else {
				if(m.get(str.charAt(i))>=s) {
					cur_len=i-s;
					if(cur_len>max_len) {
						max_len=cur_len;
						start=s;
					}
					s=m.get(str.charAt(i))+1;
				}
				m.put(str.charAt(i), i);
			}
		}
		if(max_len<str.length()-s) {
			max_len=str.length()-s;
			start=s;
		}
		System.out.println("Length of longest unique substring is "+max_len);
		System.out.println("Longest unique substring is "+str.substring(start,max_len));
	}
	

    /******************    https://www.geeksforgeeks.org/find-next-greater-number-set-digits/  *********/
    public static void nextGretestNumber(char[] c) {
    	int min=-1;
    	for(int i=c.length-1;i>=0;i--) {
    		if(c[i]>c[i-1]) {
    			min=i-1;
    			break;
    		}
    	}
    	if(min==-1) {
    		System.out.println("Given number is max possible number");
    	}
    	int next_min=min+1;
    	for(int j=min+1;j<c.length;j++) {
    		if(c[j]>c[min] && c[j]<c[next_min]) {
    			next_min=j;
    		}
    	}
    		JavaUtil.charSwap(c, min, next_min);
    		Arrays.sort(c, min+1, c.length);
    		 for (int i = 0; i < c.length; i++) 
                 System.out.print(c[i]); 
    }
    
    public static boolean isPalyndromePossible(String str,TreeMap<Character,Integer> m) {
    	for(int i=0;i<str.length();i++) {
    		if(!m.containsKey(str.charAt(i))) {
    			m.put(str.charAt(i),1);
    		}else {
    			int count=m.get(str.charAt(i));
    			count++;
    			m.put(str.charAt(i),count);
    		}
    	}
    	int oddCount=0;
    	for(Character c : m.keySet()) {
    		if(m.get(c)%2!=0) {
    			oddCount++;
    		}
    	}
    	if(str.length()%2==0) {
    		if(oddCount>0) {
    			return false;
    		}
    		return true;
    	}else {
    		if(oddCount!=1) {
    			return false;
    		}
    		return true;
    	}
    }
    
    public static String getOddString(TreeMap<Character,Integer> m) {
    	for(Character c : m.keySet()) {
    		if(m.get(c)%2!=0) {
    			return Character.toString(c);
    		}
    	}
    	return null;
    }
    
    /***************    https://www.geeksforgeeks.org/lexicographically-first-palindromic-string/ ************/
    public static void lexographicallyFirstPalyndrome(String str) {
    	TreeMap<Character,Integer> m=new TreeMap<Character,Integer>();
    	if(!isPalyndromePossible(str,m)) {
    		System.out.println("Palyndrome is not possible");
    		return;
    	}else {
    		String odd=getOddString(m);
    		String front="";
    		String rear="";
    		for(Character c : m.keySet()) {
    			if(m.get(c)%2==0) {
    				for(int i=0;i<m.get(c)/2;i++) {
    					front=front+Character.toString(c);
    					rear=Character.toString(c)+rear;
    				}
    			}
    		}
    		String pal=front+odd+rear;
    		System.out.println("Lexographically first palyndrome string is "+pal);
    		
    	}
    }
    
    /**************   https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/   ***************/
    /**************   https://www.geeksforgeeks.org/smallest-window-contains-characters-string/   ***********************/
    public static void minWindow(String str,String p) {
    	int[] hash_pat=new int[256];
    	int[] hash_str=new int[256];
    	int l1=str.length();
    	int l2=p.length();
    	if(l1<l2) {
    		System.out.println("Given pattern cannot be found");
    		return;
    	}
    	for(int i=0;i<p.length();i++) {
    		hash_pat[p.charAt(i)]++;
    	}
    	int count=0,start=0,min_len=Integer.MAX_VALUE,s=-1;
    	for(int i=0;i<str.length();i++) {
    		hash_str[str.charAt(i)]++;
    		if(hash_pat[str.charAt(i)]>0&&hash_pat[str.charAt(i)]>=hash_str[str.charAt(i)]) {
    			count++;
    		}
    		if(count==l2) {
    			while(hash_str[str.charAt(start)]>hash_pat[str.charAt(start)]||hash_pat[str.charAt(start)]==0) {
    				if(hash_str[str.charAt(start)]>hash_pat[str.charAt(start)]) {
    					hash_str[str.charAt(start)]--;
    				}
    				start++;
    			}
    			int len=i-start+1;
    			if(min_len>len){
    				min_len=len;
    				s=start;
    			}
    		}
    	}
    	if(s==-1) {
    		System.out.println("pattern cannot be found in given string");
    		return;
    	}
    	System.out.println("Minimum window in which given pattern is found is "+str.substring(s,s+min_len));
    }
    
    /****************   https://www.geeksforgeeks.org/lexicographically-largest-sub-sequence-of-the-given-string/  ***********/
    public static void largestLexographicSubsequence(String str) {
    	int index=0;
    	char c=str.charAt(0);
    	StringBuilder s=new StringBuilder();
    	while(index<str.length()) {
    		c=str.charAt(index);
    		for(int i=index+1;i<str.length();i++) {
    			if(str.charAt(i)>c) {
    				c=str.charAt(i);
    			}
    		}
    		for(int i=index;i<str.length();i++) {
    			if(str.charAt(i)==c) {
    				s.append(str.charAt(i));
    				index=i;
    			}
    		}
    		index=index+1;
    	}
    	System.out.println("Lexographically largest sequence is "+s.toString());
    }
    
    
    /*******************   https://www.geeksforgeeks.org/find-the-lexicographically-largest-palindromic-subsequence-of-a-string/   *********/
    public static void lexogrpahicallyLargestPalyndromicSubSequence(String str) {
    	char c=str.charAt(0);
    	for(int i=1;i<str.length();i++) {
    		if(str.charAt(i)>c) {
    			c=str.charAt(i);
    		}
    	}
    	StringBuilder s=new StringBuilder();
    	for(int i=0;i<str.length();i++) {
    		if(str.charAt(i)==c) {
    			s.append(c);
    		}
    	}
    	System.out.println("Lexographically largest palyndromic subsequence is  "+s.toString());
    }
    
    /********************  https://www.geeksforgeeks.org/decode-string-recursively-encoded-count-followed-substring/    **********/
    public static void decodeString(String str) {
    	StringBuilder temp=new StringBuilder();
    	int f=0;
    	for(int i=str.length()-1;i>=0;i--) {
    		f=0;
    		StringBuilder result=new StringBuilder();
    		while(i>=0 && str.charAt(i)==']') {
    			i--;
    		}
    		while(i>=0 && str.charAt(i)>='a' && str.charAt(i)<='z') {
    			temp.append(str.charAt(i));
    			i--;
    		}
    		while(i>=0 && str.charAt(i)=='[') {
    			i--;
    		}
    		while(i>=0 && str.charAt(i)>='1'&&str.charAt(i)<='9') {
    			f=(f*10)+(str.charAt(i)-'0');
    			i--;
    		}
    		for(int j=0;j<f;j++) {
    			result=result.append(temp);
    		}
    		i++;
    		temp=result;
    	}
		System.out.print(temp.reverse());
    }


}

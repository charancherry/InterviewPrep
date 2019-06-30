/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * @author Sai Charan Gunda
 *
 */

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("HelloWorld");
		Scanner s = new Scanner(System.in);
		String str=s.nextLine();
		int n = s.nextInt();
		int a[]=new int[n];
		StringBuilder str1 = new StringBuilder(str);
		System.out.println(str1);
		for(int i=0;i<n;i++) {
			a[i]=s.nextInt();
		}
		for(int i=0;i<n;i++) {
			System.out.println(a[i]);
		}
	}

}

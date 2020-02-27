package Utilities;

public class Singleton {
	
	private static Singleton singleInstance=null;
	
	private Singleton() {
		
	}
	public static Singleton getInstance() {
		if(singleInstance==null) {
			singleInstance=new Singleton();
		}
		return singleInstance;
	}
	
	public static void main(String[] args) {
		Singleton obj=null;
		obj.getInstance();
	}
}

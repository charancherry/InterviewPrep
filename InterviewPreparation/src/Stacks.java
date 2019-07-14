import java.util.Scanner;
import java.util.Stack;

import Utilities.JavaUtil;
public class Stacks {
	static final int max=1000;
	int top;
	int[] arr=new int[max];
	Stacks() {
		top=-1;
	}
	
	public void push(int x) {
		if(top>=max-1) {
			System.out.println("Stack Overflow");
			return;
		}else {
			top++;
			arr[top]=x;
			return;
		}
	}
	
	public int pop() {
		if(top<0) {
			System.out.println("stack is empty");
			return -1;
		}else {
			int x=arr[top];
			top--;
			return x;
		}
	}
	
	public int top() {
		if(top<0) {
			System.out.println("stack is empty");
			return -1;
		}else {
			return arr[top];
		}
	}
	
	public void print() {
		if(top<0) {
			System.out.println("stack is empty");
		}else {
			for(int i=top;i>=0;i--) {
				System.out.print(arr[i]);
			}
		}
	}
}
 class main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stacks s= new Stacks();
		for(int i=0;i<7;i++) {
			s.push(i);
		}
		
		System.out.println("Enter Infix Expression to be converted to Postfix expression");
		String infixToPostfixexp=in.next();
		String infixToPostfix = infixToPostfix(infixToPostfixexp.toCharArray());
		System.out.println("infixToPostfix expression is "+infixToPostfix);

		System.out.println("Enter Infix Expression to be converted to Prefix expression");
		String infixToPrefixexp=in.next();
		String infixToPrefix = infixToPrefix(infixToPrefixexp.toCharArray());
		System.out.println("infixToPrefix expression is "+infixToPrefix);
		
		System.out.println("Enter Postfix Expression to be converted to Infix expression");
		String postfixToInfixexp=in.next();
		String postfixToInfix = postfixToInfix(postfixToInfixexp.toCharArray());
		System.out.println("postfixToInfix expression is "+postfixToInfix);
		
		System.out.println("Enter Prefix Expression to be converted to Infix expression");
		String prefixToInfixexp=in.next();
		String prefixToInfix = prefixToInfix(prefixToInfixexp.toCharArray());
		System.out.println("prefixToInfix expression is "+prefixToInfix);
		
		System.out.println("Enter Postfix Expression to be converted to Prefix expression");
		String postfixToPrefixexp=in.next();
		String postfixToPrefix = postfixToPrefix(postfixToPrefixexp.toCharArray());
		System.out.println("postfixToPrefix expression is "+postfixToPrefix);
		
		int[] nextGreaterElement= JavaUtil.createArray();
		nextGreaterElement(nextGreaterElement);
		
		String balancedparanthesis = in.next();
		balancedparanthesis(balancedparanthesis.toCharArray());
		
		int[] stockPrice=JavaUtil.createArray();
		stockSpanProb(stockPrice);
	}
	
	public static int precedence(char c) {
		if(c=='^') {
			return 3;
		}else if(c=='*' || c=='/') {
			return 2;
		}else if(c=='+'||c=='-') {
			return 1;
		}
		return 0;
	}
	
	public static String reverseStringForprefixToInfix(char[] exp) {
		int l=exp.length-1;
		for(int i=0;i<l/2;i++) {
			char temp=exp[l-i];
			if(exp[i]=='(') {
				exp[l-i]=')';
			}else if(exp[i]==')'){
				exp[l-i]='(';
			}else {
				exp[l-i]=exp[i];
			}
			
			if(temp=='(') {
				exp[i]=')';
			}else if(temp==')'){
				exp[i]='(';
			}else {
				exp[i]=temp;
			}
		}
		return new String(exp);
	}
	
	/*******    https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/  *****/
	public static String infixToPostfix(char[] exp) {
		Stack oper=new Stack();
		StringBuilder str=new StringBuilder();
		for(int i=0;i<exp.length;i++) {
			if((exp[i]>='a' && exp[i]<='z') || (exp[i]>='A' && exp[i]<='Z')) {
				str.append(exp[i]);
			}
			else if(exp[i]=='(') {
				oper.push(exp[i]);
			}else if(exp[i]==')') {
				while((char)oper.peek() !='(') {
					str.append(oper.pop());
				}
				oper.pop();
			}else {
				while( !oper.empty() && precedence(exp[i])<=precedence((char)oper.peek())) {
					str.append(oper.pop());
				}
				oper.push(exp[i]);
			}
		}
		while(!oper.empty()) {
			str.append(oper.pop());
		}
		return str.toString();
		
	}
	
	public static String infixToPrefix(char[] exp) {
		String str=reverseStringForprefixToInfix(exp);
		str=infixToPostfix(str.toCharArray());
		return Strings.reverseString(str);
	}
	
	public static String postfixToInfix(char[] exp) {
		Stack s=new Stack();
		StringBuilder str=new StringBuilder();
		for(int i=0;i<exp.length;i++) {
			if((exp[i]>='a' && exp[i]<='z') || (exp[i]>='A' && exp[i]<='Z')) {
				s.push(exp[i]);
			}else {
				str=new StringBuilder();
				Object temp=s.pop();
				str.append('(');
				str.append(s.pop());
				str.append(exp[i]);
				str.append(temp);
				str.append(')');
				s.push(str.toString());
			}
		}
		return (String) s.peek();
	}
	
	public static String prefixToInfix(char[] exp) {
		Stack s=new Stack();
		StringBuilder str=new StringBuilder();
		for(int i=exp.length-1;i>=0;i--) {
			if((exp[i]>='a' && exp[i]<='z') || (exp[i]>='A' && exp[i]<='Z')) {
				s.push(exp[i]);
			}else {
				str=new StringBuilder();
				str.append('(');
				str.append(s.pop());
				str.append(exp[i]);
				str.append(s.pop());
				str.append(')');
				s.push(str.toString());
			}
		}
		return (String) s.peek();
	}
	
	public static String postfixToPrefix(char[] exp) {
		String str=postfixToInfix(exp);
		str=infixToPrefix(str.toCharArray());
		return str;
	}
	
	
	/***********  https://www.geeksforgeeks.org/next-greater-element/ ***********/
	public static void nextGreaterElement(int[] arr) {
		Stack s=new Stack();
		s.push(arr[0]);
		for(int i=1;i<arr.length;i++) {
			while(!s.empty() && arr[i]>(int)s.peek()) {
				System.out.println("Next greater element of "+s.peek()+"is "+arr[i]);
				s.pop();
			}
			s.push(arr[i]);
		}
		while(!s.empty()) {
			System.out.println("Next greater element of "+s.peek()+"is -1");
			s.pop();
		}
	}
	
	public static void balancedparanthesis(char[] arr) {
		Stack s=new Stack();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='(' || arr[i]=='{' || arr[i]=='[') {
				s.push(arr[i]);
			}else {
				if(arr[i]==')') {
					if((char)s.peek()=='(')s.pop();
					else {
						System.out.println("Not Balanced");
						return;
					}
				}
				if(arr[i]=='}') {
					if((char)s.peek()=='{')s.pop();
					else {
						System.out.println("Not Balanced");
						return;
					}
				}
				if(arr[i]==']') {
					if((char)s.peek()=='[')s.pop();
					else {
						System.out.println("Not Balanced");
						return;
					}
				}
			}
		}
		System.out.println("Balanced");
	}
	
	public static void stockSpanProb(int[] prices) {
		Stack s=new Stack();
		int[] span=new int[prices.length];
		s.push(0);
		span[0]=1;
		for(int i=1;i<prices.length;i++) {
			while(!s.empty() && prices[(int)s.peek()]<=prices[i])
				s.pop();
			span[i] = s.empty() ? i+1 : i-(int)s.peek();
			s.push(i);
		}
		for(int i=0;i<span.length;i++) {
			System.out.print(span[i]);
		}
	}

}




import java.util.HashMap;
import java.util.Scanner;

public class LinkedList {

	Node head;

	public static class Node{
		int data;
		Node next;
		public Node(int d) {
			data=d;
			next=null;
		}
	}

	public Node addNode(int d,Node head) {
		Node node=new Node(d);
		if(head==null) {
			head=node;
		}else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=node;
		}
		return head;
	}
	
	public void print(Node head) {
		System.out.println("LinkedList is");
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
	}

	public void delete(int d)
	{
		if(head==null) {
			System.out.println("LinkedList is empty");
			return;
		}
		if(head.data==d) {
			head=head.next;
			return;
		}
		Node temp=head.next;
		Node prev=head;
		while(temp!=null) {
			if(temp.data==d) {
				prev.next=temp.next;
				temp.next=null;
				return;
			}
			prev=temp;
			temp=temp.next;
		}
		System.out.println("Given node is not found");
	}
	
	public void deleteAtPosition(int pos) {
		if(head==null) {
			System.out.println("LinkedList is empty");
			return;
		}
		if(pos==0) {
			head=head.next;
			return;
		}
		Node temp=head.next;
		Node prev=head;
		while(temp!=null) {
			pos--;
			if(pos==0) {
				prev.next=temp.next;
				temp.next=null;
				return;
			}
			prev=temp;
			temp=temp.next;
		}
		System.out.println("Linked List is Smaller");
	}
	
	public Node reverse(Node head) {
		Node prev=null;
		Node current=head;
		Node next;
		if(head==null) {
			System.out.println("Linked List is empty");
		}
		if(head.next==null) {
			return null;
		}
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		//head=prev;
		return prev;
	}
	
	public int length(Node head) {
		int length=0;
		Node temp=head;
		while(temp!=null) {
			length++;
			temp=temp.next;
		}
		return length;
	}
	
	public void loopExist() {
		Node slow=head,fast=head;
		while(fast!=null&&fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(slow==fast) {
				System.out.println("Loop exists");
				Node temp=slow;
				slow=slow.next;
				int length=1;
				while(slow!=temp) {
					length++;
					slow=slow.next;
				}
				System.out.println("Length of loop is"+length);
				slow=head;
				while(slow!=fast)
				{
					slow=slow.next;
					fast=fast.next;
				}
				System.out.println("Loop found at"+slow.data);
					return;
			}
		}
		System.out.println("Loop does not exist");
	}
	
	public void deleteNodeWithoutHead(Node n) {
		if(n.next==null) {
			System.out.println("Cannot delete,Head is required");
			return;
		}
		n.data=n.next.data;
		n.next=n.next.next;
	}
	
	public void findNthNodeFromLast(int n) {
		int pos=length(head)-n;
		Node temp=head;
		while(pos!=0) {
			temp=temp.next;
			pos--;
		}
		System.out.println("nth node from last is"+temp.data);
		
	}
	
	/*********************           https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/      ***************/
	public void swapNodes(int d1,int d2) {
		Node temp1=head,prev1=null,next1=null;
		Node temp2=head,prev2=null,next2=null;
		while(temp1!=null) {
			if(temp1.data==d1 || temp1.data==d2) {
				if(next2==null) {
					prev2=prev1;
					next2=temp1.next;
					temp2=temp1;	
				}else {
					next1=temp1.next;
					break;
				}
			}
			prev1=temp1;
			temp1=temp1.next;
		}
		temp1.next=next2;
		if(prev2!=null) {
			prev2.next=temp1;
		}else {
			head=temp1;
		}
		prev1.next=temp2;
		temp2.next=next1;
	}
	
	
	/************ https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/      *****/
	public void deleteDuplicatesInSortedLinkedList() {
		Node prev=null;
		Node temp=head;
		HashMap map=new HashMap();
		while(temp!=null) {
			if(!map.containsKey(temp.data)) {
				map.put(temp.data, true);
			}else {
				prev.next=temp.next;
				temp=prev;
			}
			prev=temp;
			temp=temp.next;
		}
	}
	
	
	/***********************   https://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/ ******************/
	public void moveLastNodeToFirst() {
		Node temp=head;
		Node prev=null;
		if(head==null ||head.next==null) {
			return;
		}
		while(temp.next!=null) {
			prev=temp;
			temp=temp.next;
		}
		temp.next=head;
		prev.next=null;
		head=temp;
	}
	
	/************    https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/   *************/
	public void pairWiseSwapNodes() {
		Node temp=head;
		Node prev=null;
		Node next=null;
		if(head==null || head.next==null) {
			return;
		}
		while(temp!=null) {
			next=temp.next;
			temp.next=next.next;
			next.next=temp;
			if(prev !=null) {
				prev.next=next;
			}else {
				head=next;
			}
			prev=temp;
			temp=temp.next;
		}
	}
	
	
	/***********  https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/  ****/
	public void isPalyndrome() {
		int l=length(head);
		Node temp=head;
		Node prev=null;
		Node mid=null;
		for(int i=0;i<l/2;i++) {
			prev=temp;
			temp=temp.next;
		}
		prev.next=null;
		if(l%2!=0) {
			mid=temp;
			temp=temp.next;
			mid.next=null;
		}
		print(temp);
		reverse(temp);
		print(temp);
		Node temp1=head;
		Node temp2=temp;
		while(temp1!=null) {
			if(temp1.data!=temp2.data) {
				System.out.println("Not a palyndrome");
				return;
			}
			temp1=temp1.next;
			temp2=temp2.next;
		}
		System.out.println("palyndrome");
		reverse(temp);
		if(mid!=null) {
			prev.next=mid;
			mid.next=temp;
		}else {
			prev.next=temp;
		}
	}
	
	
	/************  https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/  ***/
	public void intersectionOfTwoNodes(Node head1,Node head2) {
		Node temp=head1;
		HashMap map=new HashMap();
		while(temp!=null) {
			map.put(temp.data, true);
			temp=temp.next;
		}
		temp=head2;
		while(temp!=null) {
			if(!map.containsKey(temp.data)) {
				map.put(temp.data, true);
				temp=temp.next;
			}else {
				System.out.println("Intersection point is"+temp.data);
				return;
			}
		}
	}
	
	
	/***************       https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/      ********/
	public void segregateOddAndEven() {
		Node head2=null;
		Node prev=null;
		Node temp=head;
		while(temp!=null) {
			if(temp.data%2!=0) {
				if(prev!=null) {
					prev.next=temp.next;
				}else {
					head=head.next;
				}
				temp.next=null;
				head2=addNode(temp.data,head2);
				if(prev!=null) {
					temp=prev.next;
				}else {
					temp=head;
				}
			}else {
				prev=temp;
				temp=temp.next;
			}
		}
		prev.next=head2;
		print(head);
	}
	
	
	/***************  https://www.geeksforgeeks.org/multiply-two-numbers-represented-linked-lists/  *******/
	public void multiplyTwoNumbersRepresentedByLL(Node head1,Node head2) {
		int l1=length(head1)-1;
		int l2=length(head2)-1;
		int n1=0,n2=0;
		while(head1 != null) {
			n1=n1+head1.data*(int)Math.pow(10, l1);
			head1=head1.next;
			l1--;
		}
		while(head2 != null) {
			n2=n2+head2.data*(int)Math.pow(10, l2);
			head2=head2.next;
			l2--;
		}
		System.out.println("Product of given linked list is"+(n1*n2));
	}
	
	///**********************   https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/  ************/
	public void segregate012() {
		int[] count=new int[3];
		Node temp=head;
		while(temp!=null) {
			count[temp.data]++;
			temp=temp.next;
		}
		temp=head;
		int i=0;
		while(temp!=null) {
			if(count[i]==0) {
				i++;
			}
			temp.data=i;
			count[i]--;
			temp=temp.next;
		}
	}
	
	
	
	/******************   https://www.geeksforgeeks.org/move-occurrences-element-end-linked-list/  ****************/
	public void moveAllOccurancesToEnd(int key) {
		Node last=head;
		while(last.next!=null) {
			last=last.next;
		}
		Node last1=last;
		Node prev=null;
		Node temp=head;
		while(temp!=last1) {
			if(temp.data==key) {
				if(prev!=null) {
					prev.next=temp.next;
					temp.next=null;
					last.next=temp;
					last=last.next;
					temp=prev.next;
				}else {
					head=head.next;
					temp.next=null;
					last.next=temp;
					last=last.next;
					temp=head;
				}
			}else {
				prev=temp;
				temp=temp.next;
			}
		}
	}
	
	public void middle() {
		Node fast=head;
		Node slow=head;
		if(head==null) {
			return;
		}
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		System.out.println("middle node is"+slow.data);
	}
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the length of linked list");
		int l=in.nextInt();
		int l1=in.nextInt();
				
		Node head2=null;
		for(int i=0;i<l;i++) {
			int data=in.nextInt();
			list.head=list.addNode(data,list.head);
		}

		
		for(int i=0;i<l1;i++) {
			int data=in.nextInt();
			head2=list.addNode(data,head2);
		}
		list.head.next.next.next=head2.next;
		list.print(list.head);
		list.print(head2);

		list.print(list.head);
		list.head=list.reverse(list.head);
		list.delete(0);
		list.head=list.reverse(list.head);
		list.deleteAtPosition(5);
		System.out.println("Length of given Linked list is"+list.length(list.head));
		list.head.next.next.next.next.next.next=list.head.next.next;
		list.loopExist();
		list.deleteNodeWithoutHead(list.head.next.next);
		list.findNthNodeFromLast(3);
		list.swapNodes(0, 5);
		list.deleteDuplicatesInSortedLinkedList();
		list.moveLastNodeToFirst();
		list.pairWiseSwapNodes();
		list.isPalyndrome();
		list.intersectionOfTwoNodes(list.head, head2);
		list.segregateOddAndEven();
		list.multiplyTwoNumbersRepresentedByLL(list.head, head2);
		list.segregate012();
		int key=in.nextInt();
		list.moveAllOccurancesToEnd(key);
		list.print(list.head);
		list.middle();
	}

}

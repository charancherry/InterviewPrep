import java.awt.List;
import java.util.HashMap;
import java.util.Scanner;

public class DoubleLinkedList {
	
	Node head;
	
	public class Node{
		int data;
		Node next;
		Node prev;
		Node(int d){
			data=d;
			prev=null;
			next=null;
		}
	}
	
	public Node addNode(int d,Node head) {
		Node newnode=new Node(d);
		if(head==null) {
			head=newnode;
		}else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newnode;
			newnode.prev=temp;
		}
		return head;
	}
	
	public Node addAfterGivenNode(int d,int key,Node head) {
		Node temp=head;
		Node newNode=new Node(d); 
		while(temp!=null && temp.data!=key) {
			temp=temp.next;
		}
		if(temp==null) {
			System.out.println("Node doesn't exist");
			return head;
		}
		Node next=temp.next;
		temp.next=newNode;
		newNode.prev=temp;
		newNode.next=next;
		next.prev=newNode;
		return head;
	}
	
	public Node addBeforeGivenNode(int d,int key,Node head) {
		Node temp=head;
		Node newNode=new Node(d); 
		while(temp!=null && temp.data!=key) {
			temp=temp.next;
		}
		if(temp==null) {
			System.out.println("Node doesn't exist");
			return head;
		}
		Node prev=temp.prev;
		prev.next=newNode;
		newNode.prev=prev;
		newNode.next=temp;
		temp.prev=newNode;
		return head;
	}
	
	public Node delete(int d,Node head) {
		Node temp=head;
		while(temp !=null && temp.data!=d) {
			temp=temp.next;
		}
		if(temp==null) {
			System.out.println("Node doesn't exist");
			return head;
		}
		if(temp.prev==null) {
			temp.next.prev=null;
			temp=temp.next;
			head=temp;
		}else {
			temp.prev.next=temp.next;
			if(temp.next!=null)
			temp.next.prev=temp.prev;
		}
		return head;
	}
	
	public void print(Node head) {
		System.out.println();
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
	}
	
	public Node reverse(Node head) {
		Node prev=null;
		Node current=head;
		Node next=null;
		if(head==null || head.next==null) {
			return head;
		}
		while(current!=null) {
			next=current.next;
			current.prev=next;
			current.next=prev;
			prev=current;
			current=next;
		}
		return prev;
	}
	
	
	/*********************************   https://www.geeksforgeeks.org/remove-duplicates-unsorted-doubly-linked-list/  *************/
	public Node removeDuplicates(Node head) {
		Node temp=head;
		HashMap map=new HashMap();
		while(temp!=null) {
			if(!map.containsKey(temp.data)) {
				map.put(temp.data, true);
			}else {
				delete(temp.data,temp);
			}
			temp=temp.next;
		}
		return head;
	}
	
	
	/**********************   https://www.geeksforgeeks.org/find-pairs-given-sum-doubly-linked-list/    ********************/
	public void findPairsWithGivenSum(int sum,Node head) {
		Node start=head;
		while(start.next!=null) {
			start=start.next;
		}
		Node last=start;
		start=head;
		boolean isPairexist=false;
		while(start!=last) {
			if((start.data+last.data)==sum) {
				System.out.println("Pair is "+start.data+" and "+last.data);
				start=start.next;
				last=last.prev;
				isPairexist=true;
				continue;
			}
			if((start.data+last.data)>sum) {
				last=last.prev;
			}
			if((start.data+last.data)<sum) {
				start=start.next;
			}
		}
		if(!isPairexist)
		System.out.println("pair does not exist");
	}
	
	/************************ https://www.geeksforgeeks.org/count-triplets-sorted-doubly-linked-list-whose-sum-equal-given-value-x/  ************/
	public void findTripletsWithGivenSum(int sum,Node head) {
		Node temp=head;
		int count=0;
		while(temp.next.next!=null) {
			Node start=temp.next;
			while(start.next!=null) {
				start=start.next;
			}
			Node last=start;
			start=temp.next;
			while(start!=last) {
				if((temp.data+start.data+last.data)==sum) {
					count++;
					System.out.println("Triplet is "+temp.data+" and "+start.data+" and "+last.data);
					start=start.next;
					last=last.prev;
					 continue;
				}
				if((start.data+last.data+temp.data)>sum) {
					last=last.prev;
				}
				if((start.data+last.data+temp.data)<sum) {
					start=start.next;
				}
			}
			temp=temp.next;
		}
		if(count>0) {
			System.out.println("No of triplets are "+count);
		}else {
			System.out.println("Triplets does not exist");
		}
		
	}
	
	public int length(Node head) {
		Node temp=head;
		int l=0;
		while(temp!=null) {
			l++;
			temp=temp.next;
		}
		return l;
	}
	
	public Node lastNode(Node head) {
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		return temp;
	}
	
	
	public Node partition(Node l,Node r) {
		int x=r.data;
		Node i=l;
		for(Node j=l;j!=r;j=j.next) {
			if(j.data<x) {
				int temp=j.data;
				j.data=i.data;
				i.data=temp;
				i=i.next;
			}
		}
		r.data=i.data;
		i.data=x;
		return i;
	}
	
	public void quickSort(Node l,Node r) {
		if(l!=null && r!=null&& l!=r && l!=r.next) {
			Node temp=partition(l,r);
			quickSort(l,temp.prev);
			quickSort(temp.next,r);
		}
	} 
	
	//*********************************  https://www.geeksforgeeks.org/rotate-doubly-linked-list-n-nodes/  ******************/
	public Node rotateCounterClockwise(int n,Node head) {
		Node head1=head;
		Node temp=head;
		for(int i=0;i<n;i++) {
			temp=temp.next;
		}
		head=temp.next;
		temp.next=null;
		head.prev=null;
		Node last=lastNode(head);
		last.next=head1;
		head1.prev=last;
		return head;
	}
	
	public void isPalyndrome(Node head) {
		int l=length(head);
		Node temp=head;
		Node last=lastNode(head);
		for(int i=0;i<l/2;i++) {
			if(temp.data!=last.data) {
				System.out.println("Given linked List is  not Palyndrome");
				return;
			}else {
				temp=temp.next;
				last=last.prev;
			}
		}
		System.out.println("Given linked List is Palyndrome");
	}
	
	
	/*******************  https://www.geeksforgeeks.org/reverse-doubly-linked-list-groups-given-size/  ****************/
	public Node reverseInGroups(Node head,int size) {
		Node current=head;
		Node prev=null;
		Node next=null;
		int count=0;
		while(current!=null && count<size) {
			next=current.next;
			current.next=prev;
			current.prev=next;
			prev=current;
			current=next;
			count++;
		}
		if(current!=null) {
			head.next=reverseInGroups(current,size);
			head.next.prev=head;
		}
		return prev;
	}
	
	public void LargestNode(Node head) {
		int max=0;
		Node temp=head;
		while(temp!=null) {
			if(temp.data>max) {
				max=temp.data;
			}
			temp=temp.next;
		}
		System.out.println("Largest Node is"+max);
	}
	
	
	/*************************   https://www.geeksforgeeks.org/sort-biotonic-doubly-linked-list/    *****************/
	public void sortBiotonicLinkedList(Node head) {
		Node temp=head.next;
		Node prev=head;
		while(temp!=null) {
			if(temp.data<prev.data) {
				prev.next=null;
				temp.prev=null;
				break;
			}else {
				prev=temp;
				temp=temp.next;
			}
		}
		if(temp==null) {
			print(head);
			return;
		}else {
			Node result=null;
			prev=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			while(prev!=null&&temp!=null) {
				if(prev.data<temp.data) {
					result=addNode(prev.data,result);
					prev=prev.next;
				}else {
					result=addNode(temp.data,result);
					temp=temp.prev;
				}
			}
			while(prev!=null) {
				result=addNode(prev.data,result);
				prev=prev.next;
			}
			while(temp!=null) {
				result=addNode(temp.data,result);
				temp=temp.prev;
			}
			print(result);
		}
	}
	
	/**************************   https://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/    **************/
	public Node swapKNodeFromLastAndFirst(Node head,int k) {
		int l=length(head);
		int count=1;
		if(k>l) {
			System.out.println("k is more than length of linked list");
			return head;
		}
		if(k==l-k+1) {
			return head;
		}
		Node current=head,prev=null,next1=null,next2=null,current1=null,prev1=null;
		while(count<((l-k+1>k) ? l-k+1:k)) {
			if(count==((l-k+1>k) ? k:l-k+1)) {
				current1=current;
				prev1=prev;
				next1=current.next;
			}
			prev=current;
			current=current.next;
			count++;
		}
		next2=current.next;
		if(prev1!=null) {
			prev1.next=current;
		}else {
			head=current;
		}
		current.prev=prev1;
		if(prev !=current1) {
			current.next=next1;
			next1.prev=current;
			prev.next=current1;
			current1.prev=prev;
		}else {
			current.next=current1;
			current1.prev=current;
		}
		current1.next=next2;
		if(next2!=null) {
			next2.prev=current;
		}
		return head;
	}

	public static void main(String[] args) {
		DoubleLinkedList list=new DoubleLinkedList();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter No of nodes");
		int n=in.nextInt();
		for(int i=0;i<n;i++) {
			int d=in.nextInt();
			list.head=list.addNode(d, list.head);
		}
		list.print(list.head);
//		list.addAfterGivenNode(6,8,list.head);
//		list.addBeforeGivenNode(7, 8, list.head);
//		list.print(list.head);
//		list.head=list.delete(5, list.head);
//		list.print(list.head);
//		list.head=list.reverse(list.head);
//		list.print(list.head);
//		list.head=list.removeDuplicates(list.head);
//		list.print(list.head);
//		list.findPairsWithGivenSum(7, list.head);
//		Node last=list.lastNode(list.head);
//		list.quickSort(list.head, last);
//		int pos=in.nextInt();
//		list.head=list.rotateCounterClockwise(pos, list.head);
//		list.isPalyndrome(list.head);
		int groupSize=in.nextInt();
		list.head=list.reverseInGroups(list.head, groupSize);
		list.print(list.head);
//		list.LargestNode(list.head);
//		int sum=in.nextInt();
//		list.findTripletsWithGivenSum(sum, list.head);
//		list.sortBiotonicLinkedList(list.head);
//		list.head=list.swapKNodeFromLastAndFirst(list.head, 6);
//		list.print(list.head);
		}

}

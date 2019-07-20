import java.util.Scanner;


public class CircularDoubleLinkedList {
	
	Node head;
	
	public class Node{
		int data;
		Node next;
		Node prev;
		public Node(int d) {
			data=d;
			next=null;
			prev=null;
		}
	}
	
	public Node addNode(Node head,int d) {
		Node newNode=new Node(d);
		if(head==null) {
			head=newNode;
			head.next=head;
			head.prev=head;
		}else {
			Node temp=head;
			while(temp.next!=head) {
				temp=temp.next;
			}
			temp.next=newNode;
			newNode.prev=temp;
			head.prev=newNode;
			newNode.next=head;
		}
		return head;
	}
	
	public void print(Node head) {
		System.out.println();
		Node temp=head;
		do {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}while(temp!=head);
	}
	
	public Node delete(Node head,int d) {
		Node temp=head;
		Node prev=head;
		do {
			if(temp.data==d) {
				prev=temp.prev;
				temp.next.prev=prev;
				prev.next=temp.next;
				temp.next=null;
				temp.prev=null;
				if(temp==head) {
					head=prev.next;
				}
				System.out.println("Node is deleted");
				return head;
			}
			temp=temp.next;
		}while(temp!=head);
		System.out.println("Node is not found");
		return head;
	}
	
	public void search(Node head,int d) {
		Node temp=head;
		int count=0;
		do{
			count++;
			if(temp.data==d) {
				System.out.println("Given node is found at position "+count);
				return;
			}else {
				temp=temp.next;
			}
		}while(temp!=head);
		System.out.println("Given node is not found");
		return;
	}
	
	/***************************    https://www.geeksforgeeks.org/reverse-a-doubly-circular-linked-list/   ******************/
	public Node reverse(Node head) {
		Node prev=null;
		Node current=head;
		Node next=null;
		do {
			prev=current.prev;
			next=current.next;
			current.prev=next;
			current.next=prev;
			current=next;
		}while(current!=head);
		return current.next;
	}

	public static void main(String[] args) {
		CircularDoubleLinkedList list=new CircularDoubleLinkedList();
		Scanner in =new Scanner(System.in);
		System.out.println("Enter no of nodes");
		int n=in.nextInt();
		for(int i=0;i<n;i++) {
			int d=in.nextInt();
			list.head=list.addNode(list.head, d);
		}
		list.print(list.head);
		list.head=list.delete(list.head, 5);
		list.head=list.reverse(list.head);
		list.print(list.head);
		list.search(list.head, 3);
	}

}

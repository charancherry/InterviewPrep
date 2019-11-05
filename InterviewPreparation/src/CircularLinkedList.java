import java.util.Scanner;

public class CircularLinkedList {
	
	Node head;
	
	public class Node{
		int data;
		Node next;
		
		public Node(int d) {
			data=d;
			next=null;
		}
	}
	
	public Node addNode(Node head,int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			head.next=head;
		}else {
			Node temp=head;
			while(temp.next!=head) {
				temp=temp.next;
			}
			temp.next=newNode;
			newNode.next=head;
		}
		return head;
	}
	
	public void print(Node head) {
		System.out.println();
		Node temp=head;
		if(head==null) {
			return;
		}
		do {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}while(temp!=head);
		//System.out.print(temp.data+"->");
	}
	
	public Node lastNode(Node head) {
		Node last=head;
		while(last.next!=head) {
			last=last.next;
		}
		return last;
	}
	
	public int length(Node head) {
		int length=0;
		Node temp=head;
		while(temp.next != head) {
			length++;
			temp=temp.next;
		}
		length++;
		return length;
	}

	public Node delete(Node head,int d) {
		Node temp=head;
		Node prev=null;
		while(temp!=head||prev==null) {
			if(temp.data==d) {
				if(prev==null) {
					prev=lastNode(head);
					head=prev.next.next;
				}
				prev.next=temp.next;
				temp.next=null;
				return head;
			}
			prev=temp;
			temp=temp.next;
		}
		System.out.println("Required node not found");
		return head;
	}
	
	public Node sortedInsert(Node head,int d) {
		Node temp=head;
		Node prev=null;
		Node newNode=new Node(d);
		while(temp!=head || prev==null) {
			if(temp.data<d) {
				prev=temp;
				temp=temp.next;
			}else {
				if(prev==null) {
					prev=lastNode(head);
					prev.next=newNode;
					newNode.next=head;
					head=newNode;
				}else {
					prev.next=newNode;
					newNode.next=temp;
				}
				return head;
			}
		}
		prev.next=newNode;
		newNode.next=head;
		return head;
	}
	
	public boolean isCircular(Node head) {
		Node temp=head;
		while(temp.next!=head) {
			if(temp==null) {
				return false;
			}else {
				temp=temp.next;
			}
		}
		return true;
	}
	
	
	/*****************  https://www.geeksforgeeks.org/splitting-starting-n-nodes-into-new-circular-linked-list-while-preserving-the-old-nodes/    ************/
	public Node splitFirstNNodesIntoNewCLL(Node head,int k) {
		Node temp=head;
		int count=0;
		Node prev=null;
		while(count<k && temp.next!=head) {
			prev=temp;
			temp=temp.next;
			count++;
		}
		Node head2=head;
		prev.next=head2;
		head=temp;
		while(temp.next!=head2) {
			temp=temp.next;
		}
		temp.next=head;
		print(head2);
		return head;
	}
	
	
	///******************************      https://www.geeksforgeeks.org/delete-all-odd-or-even-positioned-nodes-from-circular-linked-list/ ********************/
	public Node deleteAllOddPostionNodes(Node head) {
		Node temp=head;
		Node prev=null;
		int pos=1;
		int l=length(head);
		while(pos<=l) {
			if(pos%2==1) {
				if(prev==null) {
					prev=lastNode(head);
					head=prev.next.next;
				}
				prev.next=temp.next;
				temp.next=null;
				temp=prev.next;
			}else {
				prev=temp;
				temp=temp.next;
			}
			pos++;
		}
		return head;
	}
	
	///******************************      https://www.geeksforgeeks.org/delete-all-the-even-nodes-of-a-circular-linked-list/ ********************/
		public Node deleteAllEvenPostionNodes(Node head) {
			Node temp=head;
			Node prev=null;
			int pos=1;
			int l=length(head);
			while(temp!=head || prev==null) {
				if(pos%2==0) {
					if(prev==null) {
						prev=lastNode(head);
						head=prev.next.next;
					}
					prev.next=temp.next;
					temp.next=null;
					temp=prev.next;
				}else {
					prev=temp;
					temp=temp.next;
				}
				pos++;
			}
			return head;
		}
		
		public void search(Node head,int d) {
			Node temp=head;
			int count=0;
			while(temp.next!=head) {
				count++;
				if(temp.data==d) {
					System.out.println("Given node is found at position "+count);
					return;
				}else {
					temp=temp.next;
				}
			}
			if(temp.data==d) {
				count++;
				System.out.println("Given node is found at position "+count);
				return;
			}
			System.out.println("Given node is not found");
			return;
		}
		
		public void findMinAndMax(Node head) {
			int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
			Node temp=head;
			Node prev=null;
			if(head==null) {
				return;
			}
			do{
				if(temp.data<min) {
					min=temp.data;
				}
				if(temp.data>max) {
					max=temp.data;
				}
				prev=temp;
				temp=temp.next;
			}while(temp!=head);
			System.out.println("Maximum value is "+max+" and "+"Minimum value is "+min);
		}
		
		
		/*************    https://www.geeksforgeeks.org/exchange-first-last-node-circular-linked-list/   ***********/
		public Node exchangeLastAndFirst(Node head) {
			Node first=head;
			Node last=head;
			Node prev=null;
			while(last.next!=head) {
				prev=last;
				last=last.next;
			}
			prev.next=first;
			last.next=first.next;
			first.next=last;
			return last;
		}
		
		
		/**********************  https://www.geeksforgeeks.org/lucky-alive-person-circle/    ****************************/
		public void luckyAlivePerson(Node head) {
			Node temp=head;
			int l=length(head);
			Node  next=null;
			while(l!=1) {
				next=temp.next;
				temp.next=next.next;
				next.next=null;
				temp=temp.next;
				l--;
			}
			System.out.print("Luckiest person is "+temp.data);
		}
		
		
		/*******************  https://www.geeksforgeeks.org/split-a-circular-linked-list-into-two-halves/  *************************/
		public Node splitIntoTwoHalves(Node head) {
			Node head2=null;
			Node slow=head;
			if(head==null|| head.next==head) {
				System.out.println("List is empty or cannot be divided");
				return head;
			}
			Node fast=head.next;
			while(fast!=head && fast.next!=head) {
				slow=slow.next;
				fast=fast.next.next;
			}
			Node last=lastNode(head);
			head2=slow.next;
			slow.next=head;
			last.next=head2;
			print(head2);
			return head;
		}
		
		
		//************  https://www.geeksforgeeks.org/delete-every-kth-node-from-circular-linked-list/ *************/
		public Node deleteEveryKNode(Node head,int k) {
			Node temp=head;
			Node prev=null;
			if(head==null||head.next==head) {
				System.out.println("List is empty or contains insufficient nodes");
			}
			while(true) {
				if(temp.next==head && temp==head) {
					break;
				}
				print(head);
				for(int i=0;i<k;i++) {
					prev=temp;
					temp=temp.next;
				}
				if(temp==head) {
					prev=head;
					while(prev.next!=head) {
						prev=prev.next;
					}
					prev.next=temp.next;
					head=temp.next;
					temp.next=null;
				}else {
					prev.next=temp.next;
					temp.next=null;
				}
				temp=prev;
			}
			return head;
		}

	public static void main(String[] args) {
		CircularLinkedList list=new CircularLinkedList();
		Scanner in =new Scanner(System.in);
		System.out.println("Enter no of nodes");
		int n=in.nextInt();
		for(int i=0;i<n;i++) {
			int d=in.nextInt();
			list.head=list.addNode(list.head, d);
		}
		list.print(list.head);
//		list.head=list.delete(list.head, 5);
//		list.head=list.sortedInsert(list.head, 12);
//		list.print(list.head);
//		System.out.println("Given linkedList is circular "+list.isCircular(list.head));
//		System.out.println("Length of formed circular linkedList is "+list.length(list.head));
//		list.head=list.splitFirstNNodesIntoNewCLL(list.head, 3);
		list.head=list.deleteAllOddPostionNodes(list.head);
//		list.head=list.deleteAllEvenPostionNodes(list.head);
//		list.search(list.head, 14);
		list.print(list.head);
//		list.findMinAndMax(list.head);
//		list.head=list.exchangeLastAndFirst(list.head);
//		list.print(list.head);
//		list.luckyAlivePerson(list.head);
//		list.splitIntoTwoHalves(list.head);
//		list.head=list.deleteEveryKNode(list.head, 4);
//		list.print(list.head);
	}

}

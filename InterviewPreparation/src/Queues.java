import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queues {

	int capacity;
	int front,rear,size;
	int arr[];

	Queues(int size){
		capacity=size;
		front=size=0;
		rear=0;
		arr = new int[capacity];
	}

	public void enqueue(int data) {
		if(size==capacity) {
			System.out.println("Queue is full");
			return;
		}
		arr[rear]=data;
		rear++;
		size++;
	}

	public int dequeue() {
		if(front==rear) {
			System.out.println("Queue is empty");
			return -1;
		}
		int data=arr[front];
		front++;
		size--;
		return data;
	}

	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if(size==capacity) {
			return true;
		}
		return false;
	}

	public int front() {
		if(size==0) {
			System.out.println("Queue is empty");
			return -1;
		}
		return arr[front];
	}

	public int rear() {
		if(size==0) {
			System.out.println("Queue is empty");
			return -1;
		}
		return arr[rear-1];
	}

	public void print() {
		for(int i=front;i<rear;i++) {
			System.out.print(arr[i]);
		}
	}

	public static void main(String[] args) {
		Queues q= new Queues(5);
		for(int i=0;i<7;i++) {
			q.enqueue(i);
		}
		q.print();
		int front=q.front();
		int rear=q.rear();
		System.out.println("Rear and Front values are "+rear+front);
		System.out.println("Dequeued element id"+q.dequeue());
		System.out.println("Dequeued element id"+q.dequeue());
		System.out.println("Dequeued element id"+q.dequeue());
		System.out.println("Dequeued element id"+q.dequeue());
		System.out.println("Dequeued element id"+q.dequeue());
		System.out.println("Dequeued element id"+q.dequeue());
		
	}
}

 class queueUtilities{
	public static void main(String[] args) {
		
		/********* Implementation of queue using stack ***************/
		/*********************** https://www.geeksforgeeks.org/queue-using-stacks/      **********/
		Stack s1=new Stack();
		Stack s2=new Stack();
		for(int i=0;i<5;i++) {
			enqueue(s1,i);
		}
		System.out.println("Dequeued Element is "+dequeue(s1,s2));
		System.out.println("Dequeued Element is "+dequeue(s1,s2));
		System.out.println("Dequeued Element is "+dequeue(s1,s2));
		System.out.println("Dequeued Element is "+dequeue(s1,s2));
		System.out.println("Dequeued Element is "+dequeue(s1,s2));
		System.out.println("Dequeued Element is "+dequeue(s1,s2));
		
		for(int i=6;i<10;i++) {
			enqueue(s1,i);
		}

		System.out.println("Dequeued Element is "+dequeue(s1,s2));
		System.out.println("Dequeued Element is "+dequeue(s1,s2));
		System.out.println("s1 size is "+s1.size()+"and s2 size is "+s2.size());
		
		
		/************** Implementation of Stack Using Queue **********/
		Queue q1 = new LinkedList(),q2 = new LinkedList();
		for(int i=0;i<5;i++) {
			push(q1,q2,i);
		}
		
		System.out.println("Popped Element is "+pop(q1));
		System.out.println("Popped Element is "+pop(q1));
		System.out.println("Popped Element is "+pop(q1));
		System.out.println("Popped Element is "+pop(q1));
		System.out.println("Popped Element is "+pop(q1));
		System.out.println("Popped Element is "+pop(q1));
		
		for(int i=0;i<5;i++) {
			push(q1,q2,i);
		}
		System.out.println("Popped Element is "+pop(q1));
		System.out.println("Popped Element is "+pop(q1));
		System.out.println("q1 size is "+q1.size()+"and q2 size is "+q2.size());
	}
	
	public static void enqueue(Stack s1,int data) {
		s1.push(data);
	}
	
	public static int dequeue(Stack s1,Stack s2) {
		if(s2.empty()) {
			while(!s1.empty()) {
				s2.push(s1.pop());
			}
		}
		if(s2.empty()) {
			return -1;
		}
		return (int) s2.pop();
	}
	
	public static void push(Queue q1,Queue q2,int data) {
		while(!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		q1.add(data);
		while(!q2.isEmpty()) {
			q1.add(q2.remove());
		}
	}
	
	public static int pop(Queue q1) {
		if(q1.size()==0) {
			return -1;
		}
		return (int) q1.remove();
	}
}

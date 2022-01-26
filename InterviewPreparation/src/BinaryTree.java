import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.*;

public class BinaryTree {
	
	Node root;
	Node root1;
	static Node prev=null;
	static Node head=null;
	static int preIndex=0;
	static int postIndex=0;
	static int count=0;
	static Node temp=null;
	static int d=0;
	static int max_sum=0;
	static boolean isAtSameLevel=true;
	static int max_level=0;
	static int deep_level=0;
	static int max_size=0;
	
	public static class Node{
		int data;
		int hd;
		Node left,right;
		public Node(int d) {
			data=d;
			left=null;
			right=null;
		}
	}
	
	public void inorder(Node root) {
		if(root !=null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	/********************   https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/   ****************/
	public void inOrderWithoutRecursion(Node root) {
		if(root==null) {
			return;
		}
		Stack<Node> s=new Stack<Node>();
		while(root!=null ||!s.isEmpty()) {
			while(root!=null) {
				s.push(root);
				root=root.left;
			}
			Node temp=(Node)s.pop();
			System.out.print(temp.data+" ");
			root=temp.right;
		}
	}
	
	//*****************   https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/   *******************/
	/******************   https://www.youtube.com/watch?v=wGXB9OWhPTg  *******************/
	public void inOrderWithoutStackAndRecurssion(Node root) {
		Node current=root;
		while(current!=null) {
			if(current.left==null) {
				System.out.print(current.data+" ");
				current=current.right;
			}else {
				Node pre=current.left;
				while(pre.right!=null && pre.right!=current) {
					pre=pre.right;
				}
				if(pre.right==null) {
					pre.right=current;
					current=current.left;
				}else {
					pre.right=null;
					System.out.print(current.data+" ");
					current=current.right;
				}
			}
		}
	}
	
	
	public void postOrder(Node root) {
		if(root !=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	
	//*************************   https://www.geeksforgeeks.org/iterative-postorder-traversal/           **************************/
	public void postOrderWithoutRecurssion(Node root) {
		if(root==null)
			return;
		Stack<Node> s1=new Stack<Node>();
		Stack<Node> s2=new Stack<Node>();
		s1.push(root);
		while(!s1.empty()) {
			Node temp=(Node)s1.pop();
			s2.push(temp);
			if(temp.left!=null)
			s1.push(temp.left);
			if(temp.right!=null)
				s1.push(temp.right);
		}
		while(!s2.empty()) {
			Node temp=(Node)s2.pop();
			System.out.print(temp.data+" ");
		}
	}
	
	public void preOrder(Node root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	
	public void preOrderWithoutRecurssion(Node root) {
		Node current=root;
		Stack<Node> s =new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()) {
			current= s.pop();
			System.out.print(current.data+" ");
			if(current.right!=null) {
				s.push(current.right);
			}
			if(current.left!=null) {
				s.push(current.left);
			}
		}
//		while(current != null || !s.empty()) {
//			while(current!=null) {
//				System.out.print(current.data+" ");
//				s.push(current);
//				current=current.left;
//			}
//			Node temp=(Node)s.pop();
//			current=temp.right;
//		}
	}
	
	//*****************   https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/   *******************/
		/******************   https://www.youtube.com/watch?v=wGXB9OWhPTg  *******************/
		public void preOrderWithoutStackAndRecurssion(Node root) {
			Node current=root;
			while(current!=null) {
				if(current.left==null) {
					System.out.print(current.data+" ");
					current=current.right;
				}else {
					Node pre=current.left;
					while(pre.right!=null && pre.right!=current) {
						pre=pre.right;
					}
					if(pre.right==null) {
						System.out.print(current.data+" ");
						pre.right=current;
						current=current.left;
					}else {
						pre.right=null;
						current=current.right;
					}
				}
			}
		}
		
		public void printCurrentLevel(Node root,int l,boolean ledftToRight) {
			if(root==null) {
				return;
			}
			if(l==1) {
				System.out.print(root.data+" ");
				return;
			}
			if(ledftToRight) {
				printCurrentLevel(root.left,l-1,ledftToRight);
				printCurrentLevel(root.right,l-1,ledftToRight);
			}else {
				printCurrentLevel(root.right,l-1,ledftToRight);
				printCurrentLevel(root.left,l-1,ledftToRight);
			}
		}
		
		/***************** https://www.geeksforgeeks.org/level-order-tree-traversal/         **************/
		public void printLevelOrder(Node root,boolean ledftToRight,boolean isSpiral) {
			int h=height(root);
			for(int i=1;i<=h+1;i++) {
				System.out.println();
				printCurrentLevel(root,i,ledftToRight);
				ledftToRight = isSpiral ? !ledftToRight : ledftToRight;
			}
		}
		
		//***************** https://www.geeksforgeeks.org/print-level-order-traversal-line-line/ *************/
		public void levelOrderWithoutRecurssion(Node root) {
			if(root==null) {
				return;
			}
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while(!q.isEmpty()) {
				Node temp=(Node) q.peek();
				System.out.print(temp.data+" ");
				q.remove();
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
			}
		}
		
		public void levelOrderSpiralWithoutRecurssion(Node root,boolean isSpiral,boolean isLeftToRght) {
			if(root==null) {
				return;
			}
			//Queue<Node> q = new LinkedList<Node>();
			Deque<Node> q = new LinkedList<Node>();
			q.add(root);
			while(!q.isEmpty()) {
				int count=q.size();
				for(int i=0;i<count;i++) {
					if(isLeftToRght) {
						Node temp=q.getFirst();
						q.pollFirst();
						System.out.print(temp.data+"");
						if(temp.left!=null) {
							q.addLast(temp.left);
						}
						if(temp.right!=null) {
							q.addLast(temp.right);
						}
					}else {
						Node temp=q.getLast();
						q.pollLast();
						System.out.print(temp.data+"");
						if(temp.right!=null) {
							q.addFirst(temp.right);
						}
						if(temp.left!=null) {
							q.addFirst(temp.left);
						}
					}
				}
				isLeftToRght=isSpiral=true?!isLeftToRght:isLeftToRght;
			}
		}
		
	
	public Node levelOrderInsert(Node root,int d) {
		Node newNode=new Node(d);
		if(root==null) {
			root=newNode;
			return root;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=(Node) q.peek();
			q.remove();
			if(temp.left==null) {
				temp.left=newNode;
				break;
			}else {
				q.add(temp.left);
			}
			if(temp.right==null) {
				temp.right=newNode;
				break;
			}else {
				q.add(temp.right);
			}
		}
		return root;
	}
	
	/************************  https://www.geeksforgeeks.org/print-binary-tree-vertical-order/  ************/
	public void verticalOrderTraversal(Node root) {
		if(root==null) {
			return;
		}
		Queue q=new LinkedList();
		Map<Integer,ArrayList<Integer>> m=new TreeMap<Integer,ArrayList<Integer>>();
		root.hd=0;
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=(Node)q.peek();
			q.remove();
			if(!m.containsKey(temp.hd))
			{
				ArrayList<Integer> nodes=new ArrayList<Integer>();
				nodes.add(temp.data);
				m.put(temp.hd, nodes);
			}else {
				ArrayList<Integer> nodes=m.get(temp.hd);
				nodes.add(temp.data);
				m.put(temp.hd, nodes);
			}
			if(temp.left!=null) {
				temp.left.hd=temp.hd-1;
				q.add(temp.left);
			}
			if(temp.right!=null) {
				temp.right.hd=temp.hd+1;
				q.add(temp.right);
			}
		}
		for(Integer i:m.keySet()) {
			ArrayList<Integer> nodes=m.get(i);
			for(int j=0;j<nodes.size();j++)
			System.out.print(nodes.get(j)+" ");
			System.out.println();
		}
	}
	
	public int height(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		int l=height(root.left)+1;
		int r=height(root.right)+1;
		return (l>r?l:r);
	}
	
	public int printAndCountAllLeafNodes(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null&&root.right==null) {
			System.out.print(root.data+" ");
			return 1;
		}
		return printAndCountAllLeafNodes(root.left)+printAndCountAllLeafNodes(root.right);
	}
	
	public int printAndCountAllNonLeafNodes(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null&& root.right==null) {
			return 0;
		}
		System.out.print(root.data+" ");
		return 1+printAndCountAllNonLeafNodes(root.left)+printAndCountAllNonLeafNodes(root.right);
	}
	
	public int countNoofNodes(Node root) {
		if(root==null) {
			return 0;
		}
		return 1+countNoofNodes(root.left)+countNoofNodes(root.right);
	}
	
	public int countAndprintAllFullNodes(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null&& root.right==null) {
			return 0;
		}
		int temp=0;
		if(root.left!=null&&root.right!=null) {
			System.out.print(root.data+" ");
			temp=1;
		}
		return countAndprintAllFullNodes(root.left)+countAndprintAllFullNodes(root.right)+temp;
	}
			
	public int search(int[] inOrder,int key) {
		for(int i=0;i<inOrder.length;i++) {
			if(inOrder[i]==key) {
				return i;
			}
		}
		return 0;
	}
	
	/**************** https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/ ****************/
	public Node buildTree(int[] pre,int[] inOrder,int l,int r) {
		if(l<=r) {
			int index=search(inOrder,pre[preIndex]);
			preIndex++;
			Node root=new Node(inOrder[index]);
			if(l==r) {
				return root;
			}
			root.left=buildTree(pre,inOrder,l,index-1);
			root.right=buildTree(pre,inOrder,index+1,r);
			return root;
		}
		else {
			return null;
		}
	}
	
	
	/********************* https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/  ******************/
	public Node buildTreeFromPostAndInOrder(int[] post,int[] inOrder,int l,int r) {
		if(l<=r) {
			int index=search(inOrder,post[postIndex]);
			postIndex--;
			Node root=new Node(inOrder[index]);
			if(l==r) {
				return root;
			}
			root.right=buildTreeFromPostAndInOrder(post,inOrder,index+1,r);
			root.left=buildTreeFromPostAndInOrder(post,inOrder,l,index-1);
			return root;
		}
		else {
			return null;
		}	
	}

		
	public void  nthNodeInInorder(Node root,int n) {
		if(root!=null) {
			nthNodeInInorder(root.left,n);
			count++;
			if(count==n) {
				System.out.println(n+"th node is "+root.data);
			}
			nthNodeInInorder(root.right,n);
		}
	}
	
	public int minLeftNode(Node root) {
		while(root.left!=null) {
			root=root.left;
		}
		return root.data;
	}
	
	public Node rightMostNode(Node root) {
		while(root.right!=null) {
			root=root.right;
		}
		return root;
	}
	
	/**************************   https://www.geeksforgeeks.org/inorder-succesor-node-binary-tree/   *************************/
	public void inOrderSuccessor(Node root,int x) {
		if(root==null) {
			return;
		}
		if(root.data==x) {
			if(root.right!=null) {
				int succ=minLeftNode(root.right);
				System.out.println("Inorder Sucessor of "+x+" is "+succ);
			}else {
				temp=root;
			}
			return;
		}else {
			inOrderSuccessor(root.left,x);
			if(temp==null) 
			inOrderSuccessor(root.right,x);
		}
		if(temp!=null) {
			if(root.left==temp) {
				System.out.println("Inorder Sucessor of "+x+" is "+root.data);
			}else {
				temp=root;
			}
		}
	}
	
	public void inOrderPredeccessor(Node root,int x) {
		if(root==null) {
			return;
		}
		if(root.data==x) {
			if(root.left!=null) {
				Node pre =rightMostNode(root.left);
				System.out.println("Inorder predeccessor of "+x+" is "+pre.data);
			}else {
				temp=root;
			}
			return;
		}else {
			inOrderPredeccessor(root.left,x);
			inOrderPredeccessor(root.right,x);
		}
		if(temp!=null) {
			if(root.right==temp) {
				System.out.println("Inorder predeccessor of "+x+" is "+root.data);
			}else {
				temp=root;
			}
		}
	}
	
	/***********************  https://www.geeksforgeeks.org/postorder-successor-node-binary-tree/    ****************/
	public void postOrderSuccessor(Node root,int x) {
		if(root==null) {
			return;
		}
		if(root.data==x) {
			temp=root;
			return;
		}else {
			postOrderSuccessor(root.left,x);
			if(temp==null)
			postOrderSuccessor(root.right,x);
		}
		if(temp!=null) {
			if(root.right==temp) {
				System.out.println("Postorder successor of "+x+" is "+root.data);
			}else if(root.left==temp) {
				int succ=minLeftNode(root.right);
				System.out.println("Postorder Sucessor of "+x+" is "+succ);
			}
			
		}
	}
	
	public void printRightSideNodes(Node root) {
		if(root==null) {
			return;
		}
		if(root.right!=null) {
			printRightSideNodes(root.right);
			System.out.print(root.data+" ");
		}
		else if (root.left!=null) {
			printRightSideNodes(root.left);
			System.out.print(root.data+" ");
		}
	}
	
	public void printLeftSideNodes(Node root) {
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			System.out.print(root.data+" ");
			printLeftSideNodes(root.left);
		}
		else if(root.right!=null) {
			System.out.print(root.data+" ");
			printLeftSideNodes(root.right);
		}
	}
	
	
	/************************   https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/       ****************************/
	public void boundaryTravaersal(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		printLeftSideNodes(root.left);
		printAndCountAllLeafNodes(root);
		printRightSideNodes(root.right);
	}
	
	/**********************  https://www.geeksforgeeks.org/check-leaves-level/     ********************/
	public void isAllLeafsAtSameLevel(Node root,int l) {
		if(root==null) {
			return;
		}
		if(root.left==null&& root.right==null) {
			if(d==0) {
				d=l;
			}else {
				if(d!=l) {
					isAtSameLevel=false;
				}
			}
		}
		isAllLeafsAtSameLevel(root.left,l+1);
		isAllLeafsAtSameLevel(root.right,l+1);
	}
	
	
	public void leftViewOfTree(Node root,int level) {
		if(root==null) {
			return;
		}
		if(max_level<level) {
			max_level=level;
			System.out.print(root.data+" ");
		}
		leftViewOfTree(root.left,level+1);
		leftViewOfTree(root.right,level+1);
	}
	
	public void rightViewOfTree(Node root,int level) {
		if(root==null) {
			return;
		}
		if(max_level<level) {
			max_level=level;
			System.out.print(root.data+" ");
		}
		rightViewOfTree(root.right,level+1);
		rightViewOfTree(root.left,level+1);
	}
	
	
	/******************  https://www.youtube.com/watch?v=V7alrvgS5AI   *************/
	/********************   https://www.geeksforgeeks.org/bottom-view-binary-tree/      ********************/
	public void bottomViewOfTree(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		Map<Integer,Integer> m=new TreeMap<Integer,Integer>();
		root.hd=0;
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=(Node)q.peek();
			q.remove();
			m.put(temp.hd, temp.data);
			if(temp.left!=null) {
				temp.left.hd=temp.hd-1;
				q.add(temp.left);
			}
			if(temp.right!=null) {
				temp.right.hd=temp.hd+1;
				q.add(temp.right);
			}
		}
		for(Integer i:m.keySet()) {
			System.out.print(m.get(i)+" ");
		}
	}
	
	
	/*************************  https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/ **********************/
	public void topViewOfTree(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		Map<Integer,Integer> m=new TreeMap<Integer,Integer>();
		root.hd=0;
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=(Node)q.peek();
			q.remove();
			if(!m.containsKey(temp.hd))
			m.put(temp.hd, temp.data);
			if(temp.left!=null) {
				temp.left.hd=temp.hd-1;
				q.add(temp.left);
			}
			if(temp.right!=null) {
				temp.right.hd=temp.hd+1;
				q.add(temp.right);
			}
		}
		for(Integer i:m.keySet()) {
			System.out.print(m.get(i)+" ");
		}
	}
	
	public void diagonalViewUtil(Node root,HashMap<Integer,LinkedList<Integer>> m,int d) {
		if(root==null) {
			return;
		}
			LinkedList<Integer> list= m.get(d);
			if(list==null) {
				list=new LinkedList<Integer>();
			}
			list.add(root.data);
			m.put(d,list);
			diagonalViewUtil(root.left,m,d+1);
			diagonalViewUtil(root.right,m,d);
		
	}
	
	/**********************    https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/   ***************/
	public void diagonalView(Node root) {
		HashMap<Integer,LinkedList<Integer>> m = new HashMap<Integer,LinkedList<Integer>>();
		diagonalViewUtil(root,m,0);
		for(Integer key:m.keySet()) {
			LinkedList<Integer> list =m.get(key);
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
	
	/*******************  https://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/  **********************/
	public void NodesAtParticulardistanceFromrRoot(Node root,int x){
		if(root==null) {
			return;
		}
		if(x==0) {
			System.out.print(root.data+" ");
		}
		NodesAtParticulardistanceFromrRoot(root.left,x-1);
		NodesAtParticulardistanceFromrRoot(root.right,x-1);
	}
		
	/*******************  https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/  ****************/
	public boolean findPath(Node root,int x) {
		Node current=root;
		boolean lFound,rFound;
		if(current==null) {
			return false;
		}
		if(current.data==x) {
			System.out.print(current.data+" ");
			return true;
		}else {
			lFound=findPath(current.left,x);
			rFound=findPath(current.right,x);
		}
		if(lFound||rFound) {
			System.out.print(current.data+" ");
		}
		return (lFound||rFound);
	}
	
	public boolean findPathForLCA(Node root,int x,ArrayList<Integer> path) {
		Node current=root;
		boolean lFound,rFound;
		if(current==null) {
			return false;
		}
		if(current.data==x) {
			path.add(current.data);
			return true;
		}else {
			lFound=findPathForLCA(current.left,x,path);
			rFound=findPathForLCA(current.right,x,path);
		}
		if(lFound||rFound) {
			path.add(current.data);
		}
		return (lFound||rFound);
	}
	
	/*******************  https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/  **************************/
	public int lowestCommonAncestor(Node root,int x1,int x2) {
		int LCA=-1;
		if(root==null) {
			return -1;
		}
		ArrayList<Integer> path1=new ArrayList<Integer>();
		ArrayList<Integer> path2=new ArrayList<Integer>();
		if(!findPathForLCA(root,x1,path1) || !findPathForLCA(root,x2,path2)) {
			return -1;
		}
		int i=path1.size()-1;
		int j=path2.size()-1;
		while(i>=0&&j>=0) {
			if(path1.get(i)!=path2.get(j)) {
				LCA=(int) path1.get(i+1);
				break;
			}
			i--;
			j--;
		}
		if(i==-1) {
			LCA=(int) path1.get(0);
		}
		if(j==-1) {
			LCA=(int) path2.get(0);
		}
		return LCA;
	}
	
	/********************  https://www.geeksforgeeks.org/print-common-nodes-path-root-common-ancestors/   *******************/
	public boolean commonAncestorsofGivenTwoNodes(Node root,int x1,int x2) {
		if(root==null) {
			return false;
		}
		ArrayList<Integer> path1=new ArrayList<Integer>();
		ArrayList<Integer> path2=new ArrayList<Integer>();
		if(!findPathForLCA(root,x1,path1) || !findPathForLCA(root,x2,path2)) {
			return false;
		}
		int i=path1.size()-1;
		int j=path2.size()-1;
		while(i>=0&&j>=0) {
			if(path1.get(i)!=path2.get(j)) {
				for(int k=i+1;k<=path1.size()-1;k++) {
					System.out.print(path1.get(k)+" ");
				}
				break;
			}
			i--;
			j--;
		}
		if(i==-1) {
			for(int k=i+1;k<=path1.size()-1;k++) {
				System.out.print(path1.get(k)+" ");
			}
		}
		if(j==-1) {
			for(int k=j+1;k<=path2.size()-1;k++) {
				System.out.print(path2.get(k)+" ");
			}
		}
		return true;
	}
	
	/************************  https://www.geeksforgeeks.org/find-distance-root-given-node-binary-tree/  **************************/
	public int distanceFromRoot(Node root,int x) {
		if(root==null) {
			return 0;
		}
		Node current=root;
		int  ldist=0,rdist=0;
		if(current.data==x) {
			return 1;
		}else {
			ldist=distanceFromRoot(root.left,x);
			rdist=distanceFromRoot(current.right,x);
		}
		if(ldist>0) {
			ldist++;
		}
		if(rdist>0) {
			rdist++;
		}
		return Math.max(ldist, rdist);
	}
	
	/***********************   https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/    *****************/
	public int distanceBetweenTwoNodes(Node root,int x1,int x2) {
		if(root==null) {
			return -1;
		}
		int dist1= distanceFromRoot(root,x1);
		int dist2=distanceFromRoot(root,x2);
		if(dist1==0 || dist2==0) {
			return 0;
		}
		int LCA=lowestCommonAncestor(root,x1,x2);
		int dist3=distanceFromRoot(root,LCA);
		return dist1+dist2-2*dist3;
	}
	
	/***********************  https://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/   *************************/
	public void findLevel(Node root,int key,int level) {
		if(root==null){
			return;
		}
		if(root.data==key) {
			System.out.println("Level of key is "+level);
			return;
		}else {
			findLevel(root.left,key,level+1);
			findLevel(root.right,key,level+1);
		}
	}
	
	/****************************   https://www.geeksforgeeks.org/largest-value-level-binary-tree-set-2-iterative-approach/  *************************/
	
	////////////////////////////////////////  Seeeeeeeeeeeee logiccccc /////////////////////////////////////////////////////////
	public void findMaxAtEachLevel(Node root) {
		if(root==null)
			return;
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		int nodeCount=q.size();
		while(!q.isEmpty()) {
			int max=Integer.MIN_VALUE;
			nodeCount=q.size();
			while(nodeCount!=0) {
				Node temp=(Node)q.peek();
				q.remove();
				if(max<temp.data)
					max=temp.data;
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
				nodeCount--;
			}
			System.out.println(max+" ");
		}
	}
	
	/********************************   https://www.geeksforgeeks.org/find-deepest-node-binary-tree/  ***************************/
	public void deepestNode(Node root,int depth) {
		if(root==null) {
			return;
		}
		if(root.left==null && root.right==null) {
			if(deep_level<depth) {
				deep_level=depth;
				temp=root;
			}
		}else {
			deepestNode(root.left,depth+1);
			deepestNode(root.right,depth+1);
		}
	}
	/******************* https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/ ******/
	public boolean checkIfPathExistFromRootToLeafWithGivenSequence(Node root,int[] arr) {
		boolean isNodeExist;
		if(root==null)
			return false;
		if(root.data!=arr[0]) {
			return false;
		}
		for(int i=1;i<arr.length;i++) {
			isNodeExist=false;
			if(root.left!=null && root.left.data==arr[i]) {
				root=root.left;
				isNodeExist=true;
			}
			if(root.right!=null && root.right.data==arr[i]) {
				root=root.right;
				isNodeExist=true;
			}
			if(!isNodeExist)
				return false;
		}
		return true;
	}
	
	public int sumOfAllNodes(Node root) {
		if(root==null) {
			return 0;
		}
		return root.data+sumOfAllNodes(root.left)+sumOfAllNodes(root.right);
	}
	
	
	/*****************************  https://www.geeksforgeeks.org/sum-parent-nodes-child-node-x/  *********************/
	public int sumOfParentNodesWithGivenChild(Node root,int x) {
		if(root==null) {
			return 0;
		}
		return (root.data==x ? root.data:0)+sumOfParentNodesWithGivenChild(root.left,x)+sumOfParentNodesWithGivenChild(root.right,x);
	}
	
	
	/**********************  https://www.geeksforgeeks.org/find-largest-subtree-sum-tree/  *************************/
	public int maxSubTreeSum(Node root) {
		if(root==null) {
			return 0;
		}
		int leftSum=maxSubTreeSum(root.left);
		int rightSum=maxSubTreeSum(root.right);
		if(max_sum<root.data+leftSum+rightSum) {
			max_sum=root.data+leftSum+rightSum;
		}
		return root.data+leftSum+rightSum;
	}
	
	/*****************************   https://www.geeksforgeeks.org/subtree-given-sum-binary-tree/     **************************/
	public int checkSubtreeWithGivenSumExist(Node root,int x) {
		if(root==null) {
			return 0;
		}
		int sum=root.data+checkSubtreeWithGivenSumExist(root.left,x)+checkSubtreeWithGivenSumExist(root.right,x);
		if(x==sum){
			System.out.println("Subtree exist");
		}
		return sum;
	}
	
	
	/*************************  https://www.geeksforgeeks.org/sum-heights-individual-nodes-binary-tree/     *******************/
	public int sumOfHeightsOfAllNodes(Node root) {
		if(root==null) {
			return 0;
		}
		return sumOfHeightsOfAllNodes(root.left)+height(root)+sumOfHeightsOfAllNodes(root.right);
	}
	
	public int maxSumPathToLeafFromRoot(Node root) {
		if(root==null) {
			return 0;
		}
		int lSum=maxSumPathToLeafFromRoot(root.left)+root.data;
		int rSum=maxSumPathToLeafFromRoot(root.right)+root.data;
		return Math.max(lSum,rSum);
	}
	
	/********************   https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/       **************/
	public int maxPathSumBetweenTwoLeafs(Node root) {
		if(root==null) {
			return 0;
		}
		int lSum=maxSumPathToLeafFromRoot(root.left);
		int rSum=maxSumPathToLeafFromRoot(root.right);
		int leftSum=maxPathSumBetweenTwoLeafs(root.left);
		int rightSum=maxPathSumBetweenTwoLeafs(root.right);
		return Math.max(root.data+lSum+rSum, Math.max(leftSum, rightSum));
	}
	
	/***********************   https://www.geeksforgeeks.org/diameter-of-a-binary-tree/      **********************/
	public int diameter(Node root) {
		if(root==null) {
			return 0;
		}
		int lHeight=height(root.left);
		int rHeight=height(root.right);
		int lDiameter=diameter(root.left);
		int rDiameter=diameter(root.right);
		return(Math.max(lHeight+rHeight+1,Math.max(lDiameter,rDiameter)));
	}
	
	/**************************** https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/  ***********************/
	public boolean areMirror(Node root1,Node root2) {
		if(root1==null&&root2==null) {
			return true;
		}
		if(root1==null || root2==null) {
			return false;
		}
		return root1.data==root2.data&&areMirror(root1.left,root2.right)&&areMirror(root1.right,root2.left);
	}
	
	
	/***********************************8   https://www.geeksforgeeks.org/merge-two-binary-trees-node-sum/ *************/
	public static Node mergeTwoTrees(Node root1,Node root2) {
		if(root1==null) {
			return root2;
		}
		if(root2==null) {
			return root1;
		}
		root1.data=root1.data+root2.data;
		root1.left=mergeTwoTrees(root1.left,root2.left);
		root1.right=mergeTwoTrees(root1.right,root2.right);
		return root1;
	}
	
	public static boolean twoTreesAreIdentical(Node root1,Node root2) {
		if((root1==null && root2!=null) || (root1!=null && root2 ==null)) {
			return false;
		}
		if(root1==null && root2==null) {
			return true;
		}
		return  (root1.data==root2.data) && twoTreesAreIdentical(root1.left,root2.left) && twoTreesAreIdentical(root1.right,root2.right);
		
	}
	
	/*********************   https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/        ****************/
	public static boolean isChildrenSumProperty(Node root) {
		if(root==null) {
			return false;
		}
		if(root.left==null&& root.right==null) {
			return true;
		}
		return isChildrenSumProperty(root.left)&&isChildrenSumProperty(root.right)&&(root.data==(root.left!=null?root.left.data:0)+(root.right!=null?root.right.data:0));
	}
	
	/********************************   https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/  **************/
    public static boolean isSubtree(Node T, Node S) {
        if(S==null){
            return true;
        }
        if(T==null){
            return false;
        }
        if(twoTreesAreIdentical(T,S)){
            return true;
        }
        return isSubtree(T.left,S) || isSubtree(T.right,S);
    }
    
    
    
    /******************************   https://www.geeksforgeeks.org/root-leaf-path-maximum-distinct-nodes/   *********************/
    public static int noOfMaxDistinctNodesPath(Node root,HashMap<Integer,Integer> m) {
    	if(root==null) {
    		return m.size();
    	}
    	if(!m.containsKey(root.data)) {
    		m.put(root.data, 1);
    	}else {
    		m.put(root.data, m.get(root.data)+1);
    	}
    	int max= Math.max(noOfMaxDistinctNodesPath(root.left,m), noOfMaxDistinctNodesPath(root.right,m));
    	m.put(root.data, m.get(root.data)-1);
    	if(m.get(root.data)==0) {
    		m.remove(root.data);
    	}
    	return max;
    }
    
    public void tripletsWithGivenSum(Node root,Node parent,int sum) {
    	if(root==null)
    		return;
    	tripletsWithGivenSum(root.left,root,sum);
    	if(parent!=null) {
    		if(root.left!=null && root.data+parent.data+root.left.data==sum) {
    			System.out.println("Triplet with given sum is "+parent.data+" "+root.data+" "+root.left.data);
    		}
    		if(root.right!=null && root.data+parent.data+root.right.data==sum) {
    			System.out.println("Triplet with given sum is "+parent.data+" "+root.data+" "+root.right.data);
    		}
    	}
    	tripletsWithGivenSum(root.right,root,sum);
    }
    
    /*****************   https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/   ********/
	public int NodesAtParticularDistanceFromGivenNode(Node root,Node target,int k) {
		if(root==null) {
			return -1;
		}
		if(target==root) {
			NodesAtParticulardistanceFromrRoot(root,k);
			return 0;
		}
		int dl=NodesAtParticularDistanceFromGivenNode(root.left,target,k);
		if(dl!=-1) {
			if(dl+1==k) {
				System.out.println(root.data);
			}
			NodesAtParticulardistanceFromrRoot(root.right,k-dl-2);
			return dl+1;
		}
		int rl=NodesAtParticularDistanceFromGivenNode(root.right,target,k);
		if(rl!=-1) {
			if(rl+1==k) {
				System.out.println(root.data);
			}
			NodesAtParticulardistanceFromrRoot(root.left,k-rl-2);
			return rl+1;
		}
		return -1;
	}
	
	
	/*******************   https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/    *******************/
	public static void convertTreeToDLL(Node root) {
		if(root==null) {
			return;
		}
		convertTreeToDLL(root.left);
		if(prev==null) {
			head=root;
		}else {
			root.left=prev;
			prev.right=root;
		}
		prev=root;
		convertTreeToDLL(root.right);
	}
	
	public void printNodesInTreeConvertedDLL(Node head) {
		if(head==null) {
			return;
		}
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.right;
		}
	}
	
	public Vector<Node> constructAllPossibleTrees(int[] arr,int start,int end){
		Vector<Node> trees=new Vector<Node>();
		if(start>end) {
			trees.add(null);
			return trees;
		}
		for(int i=start;i<=end;i++) {
			Vector<Node> ltrees= constructAllPossibleTrees(arr,start,i-1);
			Vector<Node> rtrees= constructAllPossibleTrees(arr,i+1,end);
			for(int j=0;j<ltrees.size();j++) {
				for(int k=0;k<rtrees.size();k++) {
					Node node=new Node(arr[i]);
					node.left=ltrees.get(j);
					node.right=rtrees.get(k);
					trees.add(node);
				}
			}
		}
		return trees;
	}
	
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		Scanner in=new Scanner(System.in);
		tree.root=new Node(20);
		tree.root.left=new Node(10);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(18);
		tree.root.right.left=new Node(11);
		tree.root.right.right=new Node(27);
		tree.root.right.left.left=new Node(5);
		tree.root.right.left.right=new Node(6);
		tree.levelOrderSpiralWithoutRecurssion(tree.root,true,true);
//		
//		tree.root1=new Node(20);
//		tree.root1.left=new Node(26);
//		tree.root1.right=new Node(10);
//		tree.root1.left.left=new Node(27);
//		tree.root1.left.right=new Node(24);
//		tree.root1.right.left=new Node(18);
//		tree.root1.right.right=new Node(4);
//		tree.root1.left.right.left=new Node(6);
//		tree.root1.left.right.right=new Node(5);
//		
//		//*********************  All Traversals  *******************/////////////
//		System.out.println("inorderTraversal is ");
//		tree.inorder(tree.root);
//		System.out.println();
//		System.out.println("InOrder traversal without recurssion is");
//		tree.inOrderWithoutRecursion(tree.root);
//		System.out.println();
//		System.out.println("InorderTraversal using Morris Algorithm without stack and recurssion is ");
//		tree.inOrderWithoutStackAndRecurssion(tree.root);
//		System.out.println();
//		System.out.println("preorderTraversal is ");
//		tree.preOrder(tree.root);
//		System.out.println();
//		System.out.println("preorderTraversal without recurssion is ");
//		tree.preOrderWithoutRecurssion(tree.root);
//		System.out.println();
//		System.out.println("preorderTraversal using Morris Algorithm without stack and recurssion is ");
//		tree.preOrderWithoutStackAndRecurssion(tree.root);
//		System.out.println();
//		System.out.println("postorderTraversal is ");
//		tree.postOrder(tree.root);
//		System.out.println();
//		System.out.println("postorderTraversal without recurssion is ");
//		tree.postOrderWithoutRecurssion(tree.root);
//		System.out.println();
//		System.out.println("Level Order traversal of tree is");
//		tree.printLevelOrder(tree.root,false,true);
//		System.out.println();
//		System.out.println("Level Order traversal of tree without recurssion is");
//		tree.levelOrderWithoutRecurssion(tree.root);
//		System.out.println();
//		System.out.println("Boundary traversal of tree is");
//		tree.boundaryTravaersal(tree.root);
//		System.out.println();
//		System.out.println("Vertical order traversal of tree is");
//		tree.verticalOrderTraversal(tree.root);
//		System.out.println();
//
//		
//		
//		/*******************  Nodes details *********************/
//		System.out.println("Height of tree is "+tree.height(tree.root));
//		System.out.println("Diameter of tree is "+tree.diameter(tree.root));
//		System.out.println("No of Nodes are "+tree.countNoofNodes(tree.root));
//		System.out.println("Leaf Nodes are");
//		int noOfLeafs=tree.printAndCountAllLeafNodes(tree.root);
//		System.out.println();
//		System.out.println("No of Leaf Nodes are "+noOfLeafs);
//		System.out.println("Non Leaf Nodes are");
//		int noOfNonLeafs=tree.printAndCountAllNonLeafNodes(tree.root);
//		System.out.println();
//		System.out.println("No of Non Leaf Nodes are "+noOfNonLeafs);
//		System.out.println("Full Nodes are");
//		int noOfFullNodes=tree.countAndprintAllFullNodes(tree.root);
//		System.out.println();
//		System.out.println("No of Full Nodes are "+noOfFullNodes);
//		tree.isAllLeafsAtSameLevel(tree.root, 1);
//		if(isAtSameLevel) {
//			System.out.println("All leafs are at same level");
//		}else {
//			System.out.println("All leafs are not at same level");
//		}
//		System.out.println();
//		
//		HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
//		System.out.println("Max distinct path nodes is "+noOfMaxDistinctNodesPath(tree.root,m));
//		
//		System.out.println("Triplets with given sum are ");
//		tree.tripletsWithGivenSum(tree.root, null, 34);
//		/*******************  Finding Predeccessor and Successor in all traversals       *******************/
//		tree.nthNodeInInorder(tree.root, 4);
//		tree.inOrderSuccessor(tree.root, 20);
//		tree.inOrderPredeccessor(tree.root, 5);
//		tree.postOrderSuccessor(tree.root, 4);
//		
//		
//		/*********************  Different Views of tree *******************************/
//		System.out.println("Left View of tree is ");
//		tree.leftViewOfTree(tree.root,1);
//		System.out.println();
//		System.out.println("Right view of tree is");
//		tree.rightViewOfTree(tree.root, 1);
//		System.out.println();
//		System.out.println("Bottom view of tree is");
//		tree.bottomViewOfTree(tree.root);
//		System.out.println();
//		System.out.println("Top view of tree is");
//		tree.topViewOfTree(tree.root);
//		System.out.println();
//		System.out.println("Diagonal view of tree is");
//		tree.diagonalView(tree.root);
//		System.out.println();
//
//		Node root7=new Node(20);
//		root7.left=new Node(8);
//		root7.right=new Node(22);
//		root7.left.left=new Node(4);
//		root7.left.right=new Node(12);
//		root7.left.right.left=new Node(10);
//		root7.left.right.right=new Node(14);
//		Node target=root7.left.right.right;
//		System.out.println("Nodes at particular distance from target node are ");
//		tree.NodesAtParticularDistanceFromGivenNode(root7, target, 3);
//		System.out.println();
//		System.out.println("Nodes at particular distance from root is");
//		tree.NodesAtParticulardistanceFromrRoot(tree.root, 2);
//		System.out.println();
//		tree.levelOrderInsert(tree.root, 12);
//		tree.inorder(tree.root);
//		int[] pre = {1,2,4,5,3,6};
//		int[] inOrder= {4,2,5,1,3,6};
//		Node root3=tree.buildTree(pre, inOrder, 0, pre.length-1);
//		System.out.println();
//		System.out.println("PostOrder of Given Inorder and preorder sequence is");
//		tree.postOrder(root3);
//		System.out.println();
//		int[] post= {4,5,2,6,3,1};
//		tree.postIndex=post.length-1;
//		Node root4=tree.buildTreeFromPostAndInOrder(post, inOrder, 0, pre.length-1);
//		System.out.println("PretOrder of Given Inorder and postorder sequence is");
//		tree.preOrder(root4);
//		System.out.println();
//		boolean isPathExist=tree.findPath(tree.root, 24);
//		if(isPathExist) {
//			System.out.println();
//			System.out.println("Above is path from Root to given node");
//		}else {
//			System.out.println("Path doesn't exist");
//		}
//		System.out.println();
//		int[] arr= {20,26,24,5};
//		boolean isPathExists = tree.checkIfPathExistFromRootToLeafWithGivenSequence(tree.root, arr);
//		if(isPathExists) {
//			System.out.println("Path exist from Root to leaf with given sequence");
//		}else {
//			System.out.println("Path doesn't exist");
//		}
//		System.out.println("Sum of all nodes is "+tree.sumOfAllNodes(tree.root));
//		System.out.println("Sum of all parent nodes with given node is "+tree.sumOfParentNodesWithGivenChild(tree.root,18));
//		
//		Node root2=new Node(1);
//		root2.left=new Node(-2);
//		root2.right=new Node(3);
//		root2.left.left=new Node(4);
//		root2.left.right=new Node(5);
//		root2.right.left=new Node(-7);
//		root2.right.right=new Node(2);
//		tree.maxSubTreeSum(root2);
//		System.out.println("Largest Sum subtree  is "+tree.max_sum);
//		
//		tree.checkSubtreeWithGivenSumExist(tree.root, 100);
//		System.out.println("Sum of heights of all nodes is "+tree.sumOfHeightsOfAllNodes(tree.root));
//		System.out.println("Max sum path to leaf from root is "+tree.maxSumPathToLeafFromRoot(tree.root));
//		System.out.println("Max sum path between two leafs is "+tree.maxPathSumBetweenTwoLeafs(tree.root));
//		System.out.println("Two trees are mirror "+tree.areMirror(tree.root, tree.root1));
//		System.out.println();
//		System.out.print("Lowest Common Ancestor of two nodes ");
//		int LCA = tree.lowestCommonAncestor(tree.root, 5,6);
//		if(LCA==-1) {
//			System.out.println("doesn't exist");
//		}else {
//			System.out.println(LCA);
//		}
//		
//		System.out.print("Common Ancestors of two nodes ");
//		boolean commonAncestorsExist = tree.commonAncestorsofGivenTwoNodes(tree.root, 5,6);
//		if(!commonAncestorsExist) {
//			System.out.println("doesn't exist");
//		}
//		System.out.println();
//		System.out.println("Distance from root to given node is "+tree.distanceFromRoot(tree.root, 4));
//		System.out.println("Distance between two nodes is "+tree.distanceBetweenTwoNodes(tree.root, 5,6));
//		System.out.println("Level of given node is ");
//		tree.findLevel(tree.root, 5, 1);
//		System.out.println();
//		System.out.println("Max Node in each level is ");
//		tree.findMaxAtEachLevel(tree.root);
//		tree.deepestNode(tree.root, 1);
//		System.out.println("Deepest Node is "+temp.data);
//		
//		Node root5=new Node(10);
//		root5.left=new Node(8);
//		root5.right=new Node(2);
//		root5.left.left=new Node(3);
//		root5.left.right=new Node(5);
//		
//		Node root6=new Node(1);
//		root6.left=new Node(2);
//		root6.right=new Node(3);
//		root6.right.left=new Node(4);
//		root6.left.right=new Node(5);
//		
//		root5=mergeTwoTrees(root5,root6);
//		System.out.println("Level Order traversal of merged tree is");
//		tree.printLevelOrder(root5,true,false);
//		System.out.println();
//		
//		System.out.println("Given two trees are identical "+twoTreesAreIdentical(root5,root6));
//		
//		System.out.println("Given tree satisfies childsum property "+isChildrenSumProperty(root5));
//		
//		System.out.println("Binary Tree to DLL");
//		tree.convertTreeToDLL(tree.root);
//		tree.printNodesInTreeConvertedDLL(tree.head);
//		System.out.println();
//		
//		System.out.println("possible binary trees are ");
//		int[] arr = {4,5,7};
//		Vector<Node> Nodes=tree.constructAllPossibleTrees(arr, 0, arr.length-1);
//		for(int i=0;i<Nodes.size();i++) {
//			tree.preOrder(Nodes.get(i));
//			System.out.println();
//		}
	}
}

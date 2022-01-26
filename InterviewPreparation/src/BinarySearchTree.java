import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchTree {
	Node root;
	static Node head=null;
	static int pre_index=0;
	static int nodeCount=0;
	static int max=Integer.MIN_VALUE;
	Node first;
	Node middle;
	Node prev;
	Node last;
	
	public static class Node{
		int data;
		Node left,right;
		public Node(int d) {
			data=d;
			left=null;
			right=null;
		}
	}
	
	public Node insertNode(Node root,int d) {
		Node newNode=new Node(d);
		if(root==null) {
			root=newNode;
			return root;
		}
		if(d<root.data) {
			root.left=insertNode(root.left,d);
		}else if(d>root.data) {
			root.right=insertNode(root.right,d);
		}
		return root;
	}
	
	public void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	public int minValue(Node root) {
		int minVal=root.data;
		while(root.left!=null) {
			root=root.left;
			minVal=root.data;
		}
		return minVal;
	}
	
	public int maxNode(Node root) {
		int maxVal=root.data;
		Node right=root.right;
		while(right!=null) {
			maxVal=right.data;
			right=right.right;
		}
		return maxVal;
	}
	
	public int minNode(Node root) {
		int minVal=root.data;
		Node left=root.left;
		while(left!=null) {
			minVal=left.data;
			left=left.left;
		}
		return minVal;
	}
	
	public Node delete(Node root,int key) {
		if(root==null) {
			return root;
		}
		if(key<root.data) {
			root.left=delete(root.left,key);
		}else if(key>root.data) {
			root.right=delete(root.right,key);
		}
		else {
			if(root.right==null) {
				root=root.left;
				return root;
			}
			if(root.left==null) {
				root=root.right;
				return root;
			}
			root.data=minValue(root.right);
			root.right=delete(root.right,root.data);
			return root;	
		}
		return root;
	}
	
	public int findIndex(int[] pre,int index) {
		for(int i=index;i<pre.length;i++) {
			if(pre[i]>pre[index])
				return i;
		}
		return -1;
	}
	
	/**********************    https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/  ****************/
	public Node buildTreeFromPreOrder(int[] pre,int l,int r) {
		if(l<=r) {
			int data=pre[l];
			int index=findIndex(pre,l);
			Node root=new Node(data);
			if(l==r) {
				return root;
			}
			root.left=buildTreeFromPreOrder(pre,l+1,index-1);
			root.right=buildTreeFromPreOrder(pre,index,r);
			return root;
		}else {
			return null;
		}
		
	}
	
	public void storeInOrder(Node root,ArrayList nodes) {
		if(root!=null) {
			storeInOrder(root.left,nodes);
			nodes.add(root.data);
			storeInOrder(root.right,nodes);
		}
	}
	
	public void replaceInInorder(Node root,int[] arr) {
		if(root!=null) {
			replaceInInorder(root.left,arr);
			root.data=arr[pre_index];
			pre_index++;
			replaceInInorder(root.right,arr);
		}
	}
	
	/*****************   https://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/ ****************/
	public Node convertBinaryToBST(Node root) {
		ArrayList nodes=new ArrayList();
		storeInOrder(root,nodes);
		int[] arr=new int[nodes.size()];
		for(int i=0;i<nodes.size();i++) {
			arr[i]=(int)nodes.get(i);
		}
		Array.mergeSort(arr, 0, nodes.size()-1);
		replaceInInorder(root,arr);
		return root;
	}
	
	
	/********************   https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/  **********************/
	public boolean isBST(Node root) {
		if(root==null) {
			return true;
		}
		if(root.left!=null && root.data<maxNode(root.left)) {
			return false;
		}
		if(root.right!=null && root.data>minNode(root.right)) {
			return false;
		}
		return (isBST(root.left) || isBST(root.right));
	}
	
	public void kthSmallestNode(Node root,int k) {
		if(root !=null) {
			kthSmallestNode(root.left,k);
			nodeCount++;
			if(k==nodeCount) {
				System.out.println("Kth smallest node is "+root.data);
				return;
			}
			kthSmallestNode(root.right,k);
		}
	}
	
	
	/***************  https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/   ****************/
	public void kthLargestNode(Node root,int k) {
		if(root !=null) {
			kthLargestNode(root.right,k);
			nodeCount++;
			if(k==nodeCount) {
				System.out.println("Kth largest node is "+root.data);
				return;
			}
			kthLargestNode(root.left,k);
		}
	}
	
	public void correctBSTUTil(Node root) {
		if(root==null) {
			return;
		}
		correctBSTUTil(root.left);
		if(prev!=null) {
			if(root.data<prev.data) {
				if(first ==null) {
					first=prev;
					middle=root;
				}else {
					last=root;
				}
			}
		}
		prev=root;
		correctBSTUTil(root.right);
	}
	
	/******************************   https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/     *************/
	public void correctBST(Node root) {
		prev=first=last=middle=null;
		correctBSTUTil(root);
		if(first!=null && last!=null) {
			int temp=last.data;
			last.data=first.data;
			first.data=temp;
		}
		else if(first !=null && middle !=null) {
			int temp=middle.data;
			middle.data=first.data;
			first.data=temp;
		}else {
			System.out.println("It is already BST");
		}
	}
	
	public void checkPairExist(int data,int sum,ArrayList m) {
		for(int i=0;i<m.size();i++) {
			if(data+(int)m.get(i)==sum) {
				System.out.println("Pair with given sum is "+data+" "+m.get(i));
			}
		}
		m.add(data);
	}
	
	public int size(Node root) {
		if(root==null) {
			return 0;
		}
		return 1+size(root.left)+size(root.right);
	}
	
	
	/*************************   https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/         ****************/
	public int largestBST(Node root) {
		if(root==null) {
			return 0;
		}
		if(isBST(root)){
			return size(root);
		}
		return Math.max(largestBST(root.left), largestBST(root.right));
	}
	
	/**********************  https://www.geeksforgeeks.org/find-pair-given-sum-bst/        *****************/
	public void pairWithGivenSum(Node root,int sum,ArrayList m) {
		if(root!=null) {
			pairWithGivenSum(root.left,sum,m);
			checkPairExist(root.data,sum,m);
			pairWithGivenSum(root.right,sum,m);
		}
	}
	
	
	/*********************  https://www.geeksforgeeks.org/check-if-given-sorted-sub-sequence-exists-in-binary-search-tree/ **********/
	public void isSubSequenceExist(Node root,int[] arr) {
		if(root==null) {
			return;
		}
		isSubSequenceExist(root.left,arr);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==root.data)
			nodeCount++;
		}
		isSubSequenceExist(root.right,arr);
	}
	
	/*********************   https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/      ************/
	public Node LCA(Node root,int n1,int n2) {
		if(root==null)
			return null;
		if(n1<root.data && n2<root.data) {
			return LCA(root.left,n1,n2);
		}
		if(n1>root.data && n2>root.data) {
			return LCA(root.right,n1,n2);
		}
		return root;
	}
	
	
	/*****************************   https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/  ****************/
	public boolean givenPreOrderCanRepresentBSTOrNot(int[] pre,int l,int r) {
		if(root==null) {
			return true;
		}
		if(l<r) {
			int data=pre[l];
			int index=findIndex(pre,l);
			for(int i=index+1;i<=r;i++) {
				if(data>pre[i]) {
					return false;
				}
			}
			return givenPreOrderCanRepresentBSTOrNot(pre,l+1,index-1) && givenPreOrderCanRepresentBSTOrNot(pre,index,r);
		}
		return true;
	}
	
	
	public boolean findMaxonPath(Node root,int n1,int n2) {
		if(root==null) {
			return false;
		}
		if(root.data==n1 || root.data==n2) {
			if(max<root.data) {
				max=root.data;
			}
			return true;
		}
		boolean isMaxExistOnLeft = findMaxonPath(root.left,n1,n2);
		boolean isMaxExistOnRight = findMaxonPath(root.right,n1,n2);
			if(isMaxExistOnLeft||isMaxExistOnRight) {
				if(max<root.data) {
					max=root.data;
				}
				return true;
			}else
			return false;
		}
	
	/***********************  https://www.geeksforgeeks.org/maximum-element-two-nodes-bst/   **********************/
	public void maximumBetweenTwonodes(Node root,int n1,int n2) {
		if(root==null)
			return;
		Node lca=LCA(root,n1,n2);
		findMaxonPath(lca,n1,n2);
	}
	
	public static class count{
		int c;
		public count() {
			c=0;
		}
	}
	
	/******************    https://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/   *****************/
	public void kthLargestNode(Node root,int k,count c) {
		if(root==null)
			return;
		kthLargestNode(root.right,k,c);
		c.c++;
		if(c.c==k) {
			System.out.println("Kth largest node is "+root.data);
		}
		kthLargestNode(root.left,k,c);
		
	}
	
	
	/*******************   https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/    *******************/
	public void convertTreeToDLL(Node root) {
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
	
	
	/*********************   https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/  ************/
	public Node convertSortedArrayToBST(int[] arr,int l,int r) {
		if(l>r) {
			return null;
		}
		int mid=(l+r)/2;
		Node node=new Node(arr[mid]);
		node.left=convertSortedArrayToBST(arr,l,mid-1);
		node.right=convertSortedArrayToBST(arr,mid+1,r);
		return node;
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter no of nodes in tree");
		int n=in.nextInt();
		for(int i=0;i<n;i++) {
			int d=in.nextInt();
			tree.root=tree.insertNode(tree.root, d);
		}
//		System.out.println("Inorder traversal of given tree");
//		tree.inorder(tree.root);
//		System.out.println();
//		tree.root=tree.delete(tree.root, in.nextInt());
//		tree.inorder(tree.root);
//		int[] preOrder= {10,5,1,7,40,50};
//		Node root1=tree.buildTreeFromPreOrder(preOrder, 0, preOrder.length-1);
//		System.out.println("InOrder of Given preorder sequence is");
//		tree.inorder(root1);
//		System.out.println();
//		tree.pre_index=0;
//		Node root2=new Node(10);
//		root2.left=new Node(2);
//		root2.right=new Node(7);
//		root2.left.left=new Node(8);
//		root2.left.right=new Node(4);
//		System.out.println("Inorder traversal of Given binary tree is");
//		tree.inorder(root2);
//		System.out.println();
//		root2=tree.convertBinaryToBST(root2);
//		System.out.println("Inorder traversal after converting given binary tree to BST is");
//		tree.inorder(root2);
//		System.out.println();
//		
//		Node root3=new Node(8);
//		root3.left=new Node(5);
//		root3.right=new Node(10);
//		root3.left.left=new Node(2);
//		root3.left.right=new Node(7);
//		tree.inorder(root3);
//				
//		System.out.println("Given tree is BST "+tree.isBST(root3));
//		tree.kthSmallestNode(tree.root, 3);
//		tree.nodeCount=0;
//		tree.kthLargestNode(tree.root, 2);
//		tree.correctBST(root3);
//		tree.inorder(root3);
//		ArrayList m=new ArrayList();
//		tree.pairWithGivenSum(root3, 22, m);
//		System.out.println("Size of given BST is"+tree.size(tree.root));
//		System.out.println("Largest BST sub tree is "+tree.largestBST(tree.root));
//		tree.nodeCount=0;
//		int[] arr= {8,2};
//		tree.isSubSequenceExist(root3, arr);
//		if(tree.nodeCount==arr.length) {
//			System.out.println("sub sequence exist in given tree");
//		}else {
//			System.out.println("Given sub sequence does not exist");
//		}
		Node lsa=tree.LCA(tree.root, 22, 10);
		System.out.println("LCA of given nodes is "+lsa.data);
//		int[] pre= {2,4,1};
//		boolean isBSTPossible = tree.givenPreOrderCanRepresentBSTOrNot(pre, 0, pre.length-1);
//		if(isBSTPossible) {
//			System.out.println("Can represent BST");
//		}else {
//			System.out.println("Cannot represent BST");
//		}
//		tree.maximumBetweenTwonodes(tree.root, 1, 10);
//		System.out.println("Max between given two nodes is "+tree.max);
//		
//		count c=new count();
//		tree.kthLargestNode(tree.root,2,c);
//		
//		System.out.println("BST to DLL");
//		tree.convertTreeToDLL(tree.root);
//		tree.printNodesInTreeConvertedDLL(tree.head);
//		
//		int[] arr = {1,2,3,4,5,6,7};
//		Node head=tree.convertSortedArrayToBST(arr, 0, arr.length-1);
//		tree.inorder(head);
	}

}

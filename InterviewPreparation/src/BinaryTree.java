import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	
	Node root;
	static int preIndex=0;
	static int count=0;
	static Node temp=null;
	static int d=0;
	static boolean isAtSameLevel=true;
	
	public static class Node{
		int data;
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
	
	public Node levelOrderInsert(Node root,int d) {
		Node newNode=new Node(d);
		if(root==null) {
			root=newNode;
			return root;
		}
		Queue q=new LinkedList();
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
	
	public int height(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 0;
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
		return printAndCountAllNonLeafNodes(root.left)+printAndCountAllNonLeafNodes(root.right);
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
	
	public void printCurrentLevel(Node root,int l) {
		if(root==null) {
			return;
		}
		if(l==1) {
			System.out.print(root.data+" ");
			return;
		}
		printCurrentLevel(root.left,l-1);
		printCurrentLevel(root.right,l-1);
	}
	
	/***************** https://www.geeksforgeeks.org/level-order-tree-traversal/         **************/
	public void printLevelOrder(Node root) {
		int h=height(root);
		for(int i=1;i<=h+1;i++) {
			System.out.println();
			printCurrentLevel(root,i);
		}
	} 
	
	
	/********************   https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/   ****************/
	public void inOrderWithoutRecursion(Node root) {
		if(root==null) {
			return;
		}
		Stack s=new Stack();
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
	
	public void postOrder(Node root) {
		if(root !=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
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
				System.out.println("Inorder Sucessor of "+x+" is "+succ);
			}
			
		}
	}
	
	public void printRightSideNodes(Node root) {
		if(root.right!=null) {
			printRightSideNodes(root.right);
			System.out.print(root.data);
		}
	}
	
	
	/************************   https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/       ****************************/
	public void boundaryTravaersal(Node root) {
		Node temp=root;
		while(temp.left!=null) {
			System.out.print(temp.data+" ");
			temp=temp.left;
		}
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

	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		Scanner in=new Scanner(System.in);
		tree.root=new Node(20);
		tree.root.left=new Node(10);
		tree.root.right=new Node(26);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(18);
		tree.root.right.left=new Node(24);
		tree.root.right.right=new Node(27);
		tree.root.left.right.left=new Node(14);
		tree.root.left.right.right=new Node(19);
		tree.root.left.right.left.left=new Node(13);
		tree.root.left.right.left.right=new Node(15);
		tree.root.right.left.left=new Node(1);
		tree.inorder(tree.root);
		tree.levelOrderInsert(tree.root, 12);
		tree.inorder(tree.root);
		System.out.println("Height of tree is "+tree.height(tree.root));
		System.out.println("No of Nodes are "+tree.countNoofNodes(tree.root));
		System.out.println("Leaf Nodes are");
		int noOfLeafs=tree.printAndCountAllLeafNodes(tree.root);
		System.out.println("No of Leaf Nodes are "+noOfLeafs);
		System.out.println("Non Leaf Nodes are");
		int noOfNonLeafs=tree.printAndCountAllNonLeafNodes(tree.root);
		System.out.println("No of Leaf Nodes are "+noOfNonLeafs);
		System.out.println("Full Nodes are");
		int noOfFullNodes=tree.countAndprintAllFullNodes(tree.root);
		System.out.println("No of Full Nodes are "+noOfFullNodes);
		System.out.println("Level Order traversal of tree is");
		tree.printLevelOrder(tree.root);
		System.out.println("InOrder traversal without recurssion is");
		tree.inOrderWithoutRecursion(tree.root);
		int[] pre = {1,2,4,5,3,6};
		int[] inOrder= {4,2,5,1,3,6};
		tree.root=tree.buildTree(pre, inOrder, 0, pre.length-1);
		tree.postOrder(tree.root);
		tree.nthNodeInInorder(tree.root, 4);
		tree.inOrderSuccessor(tree.root, 6);
		tree.postOrderSuccessor(tree.root, 4);
		tree.boundaryTravaersal(tree.root);
		tree.isAllLeafsAtSameLevel(tree.root, 1);
		if(isAtSameLevel) {
			System.out.println("All leafs are at same level");
		}else {
			System.out.println("All leafs are not at same level");
		}
		

	}

}

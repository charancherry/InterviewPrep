import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {
	
	Node root;
	Node root1;
	static int preIndex=0;
	static int count=0;
	static Node temp=null;
	static int d=0;
	static int max_sum=0;
	static boolean isAtSameLevel=true;
	static int max_level=0;
	
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
		Stack s1=new Stack();
		Stack s2=new Stack();
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
		Stack s =new Stack();
		while(current != null || !s.empty()) {
			while(current!=null) {
				System.out.print(current.data+" ");
				s.push(current);
				current=current.left;
			}
			Node temp=(Node)s.pop();
			current=temp.right;
		}
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
		
		//***************** https://www.geeksforgeeks.org/print-level-order-traversal-line-line/ *************/
		public void levelOrderWithoutRecurssion(Node root) {
			if(root==null) {
				return;
			}
			Queue q = new LinkedList();
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
		Queue q=new LinkedList();
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
		Queue q=new LinkedList();
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
		int da=current.data;
		if(current.data==x) {
			System.out.print(current.data+" ");
			temp=current;
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
		tree.root.right.left.left=new Node(5);
		tree.root.right.left.right=new Node(6);
		
		tree.root1=new Node(20);
		tree.root1.left=new Node(26);
		tree.root1.right=new Node(10);
		tree.root1.left.left=new Node(27);
		tree.root1.left.right=new Node(24);
		tree.root1.right.left=new Node(18);
		tree.root1.right.right=new Node(4);
		tree.root1.left.right.left=new Node(6);
		tree.root1.left.right.right=new Node(5);
		
		//*********************  All Traversals  *******************/////////////
		System.out.println("inorderTraversal is ");
		tree.inorder(tree.root);
		System.out.println();
		System.out.println("InOrder traversal without recurssion is");
		tree.inOrderWithoutRecursion(tree.root);
		System.out.println();
		System.out.println("InorderTraversal using Morris Algorithm without stack and recurssion is ");
		tree.inOrderWithoutStackAndRecurssion(tree.root);
		System.out.println();
		System.out.println("preorderTraversal is ");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("preorderTraversal without recurssion is ");
		tree.preOrderWithoutRecurssion(tree.root);
		System.out.println();
		System.out.println("preorderTraversal using Morris Algorithm without stack and recurssion is ");
		tree.preOrderWithoutStackAndRecurssion(tree.root);
		System.out.println();
		System.out.println("postorderTraversal is ");
		tree.postOrder(tree.root);
		System.out.println();
		System.out.println("postorderTraversal without recurssion is ");
		tree.postOrderWithoutRecurssion(tree.root);
		System.out.println();
		System.out.println("Level Order traversal of tree is");
		tree.printLevelOrder(tree.root);
		System.out.println();
		System.out.println("Level Order traversal of tree without recurssion is");
		tree.levelOrderWithoutRecurssion(tree.root);
		System.out.println();
		System.out.println("Boundary traversal of tree is");
		tree.boundaryTravaersal(tree.root);
		System.out.println();
		System.out.println("Vertical order traversal of tree is");
		tree.verticalOrderTraversal(tree.root);
		System.out.println();

		
		
		/*******************  Nodes details *********************/
		System.out.println("Height of tree is "+tree.height(tree.root));
		System.out.println("Diameter of tree is "+tree.diameter(tree.root));
		System.out.println("No of Nodes are "+tree.countNoofNodes(tree.root));
		System.out.println("Leaf Nodes are");
		int noOfLeafs=tree.printAndCountAllLeafNodes(tree.root);
		System.out.println();
		System.out.println("No of Leaf Nodes are "+noOfLeafs);
		System.out.println("Non Leaf Nodes are");
		int noOfNonLeafs=tree.printAndCountAllNonLeafNodes(tree.root);
		System.out.println();
		System.out.println("No of Non Leaf Nodes are "+noOfNonLeafs);
		System.out.println("Full Nodes are");
		int noOfFullNodes=tree.countAndprintAllFullNodes(tree.root);
		System.out.println();
		System.out.println("No of Full Nodes are "+noOfFullNodes);
		tree.isAllLeafsAtSameLevel(tree.root, 1);
		if(isAtSameLevel) {
			System.out.println("All leafs are at same level");
		}else {
			System.out.println("All leafs are not at same level");
		}
		System.out.println();
		
		/*******************  Finding Predeccessor and Successor in all traversals       *******************/
		tree.nthNodeInInorder(tree.root, 4);
		tree.inOrderSuccessor(tree.root, 20);
		tree.inOrderPredeccessor(tree.root, 20);
		tree.postOrderSuccessor(tree.root, 4);
		
		
		/*********************  Different Views of tree *******************************/
		System.out.println("Left View of tree is ");
		tree.leftViewOfTree(tree.root,1);
		System.out.println();
		System.out.println("Right view of tree is");
		tree.rightViewOfTree(tree.root, 1);
		System.out.println();
		System.out.println("Bottom view of tree is");
		tree.bottomViewOfTree(tree.root);
		System.out.println();
		System.out.println("Top view of tree is");
		tree.topViewOfTree(tree.root);
		System.out.println();

		
		System.out.println("Nodes at particular distance from root is");
		tree.NodesAtParticulardistanceFromrRoot(tree.root, 2);
		System.out.println();
		tree.levelOrderInsert(tree.root, 12);
		tree.inorder(tree.root);
		int[] pre = {1,2,4,5,3,6};
		int[] inOrder= {4,2,5,1,3,6};
		Node root3=tree.buildTree(pre, inOrder, 0, pre.length-1);
		System.out.println("PostOrder of Given Inorder and preorder sequence is");
		tree.postOrder(root3);
		System.out.println();
		boolean isPathExist=tree.findPath(tree.root, 24);
		if(isPathExist) {
			System.out.println();
			System.out.println("Above is path from Root to given node");
		}else {
			System.out.println("Path doesn't exist");
		}
		System.out.println();
		int[] arr= {20,26,24,5};
		boolean isPathExists = tree.checkIfPathExistFromRootToLeafWithGivenSequence(tree.root, arr);
		if(isPathExists) {
			System.out.println("Path exist from Root to leaf with given sequence");
		}else {
			System.out.println("Path doesn't exist");
		}
		System.out.println("Sum of all nodes is "+tree.sumOfAllNodes(tree.root));
		System.out.println("Sum of all parent nodes with given node is "+tree.sumOfParentNodesWithGivenChild(tree.root,18));
		
		Node root2=new Node(1);
		root2.left=new Node(-2);
		root2.right=new Node(3);
		root2.left.left=new Node(4);
		root2.left.right=new Node(5);
		root2.right.left=new Node(-7);
		root2.right.right=new Node(2);
		tree.maxSubTreeSum(root2);
		System.out.println("Largest Sum subtree  is "+tree.max_sum);
		
		tree.checkSubtreeWithGivenSumExist(tree.root, 100);
		System.out.println("Sum of heights of all nodes is "+tree.sumOfHeightsOfAllNodes(tree.root));
		System.out.println("Max sum path to leaf from root is "+tree.maxSumPathToLeafFromRoot(tree.root));
		System.out.println("Max sum path between two leafs is "+tree.maxPathSumBetweenTwoLeafs(tree.root));
		System.out.println("Two trees are mirror "+tree.areMirror(tree.root, tree.root1));
	}
}

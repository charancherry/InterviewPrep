import java.util.Scanner;

public class BinarySearchTree {
	Node root;
	
	public class Node{
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

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter no of nodes in tree");
		int n=in.nextInt();
		for(int i=0;i<n;i++) {
			int d=in.nextInt();
			tree.root=tree.insertNode(tree.root, d);
		}
		System.out.println("Inorder traversal of given tree");
		tree.inorder(tree.root);
		tree.root=tree.delete(tree.root, in.nextInt());
		tree.inorder(tree.root);
		tree.root=tree.delete(tree.root, in.nextInt());
		tree.inorder(tree.root);
		tree.root=tree.delete(tree.root, in.nextInt());
		System.out.println(tree.root.data);
		tree.inorder(tree.root);

	}

}

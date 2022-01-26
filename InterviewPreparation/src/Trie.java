
public class Trie {

	static TrieNode root ;
	public static class TrieNode{
		TrieNode[] children=new TrieNode[26];
		boolean isEnd;
		TrieNode() {
			isEnd=false;
			for(int i=0;i<26;i++) {
				children[i]=null;
			}
		}
	}

	public static void insert(String key) {
		TrieNode tNode=root;
		int index;
		for(int i=0;i<key.length();i++) {
			index=key.charAt(i)-'a';
			if(tNode.children[index]==null) {
				tNode.children[index]=new TrieNode();
			}
			tNode=tNode.children[index];
		}
		tNode.isEnd=true;
	}

	public static boolean search(String key) {
		TrieNode tNode=root;
		int index;
		for(int i=0;i<key.length();i++) {
			index=key.charAt(i)-'a';
			if(tNode.children[index]==null) {
				return false;
			}
			tNode=tNode.children[index];	
		}
		return (tNode!=null && tNode.isEnd==true);
	}
	
	public static boolean isLeafNode(TrieNode root) {
		if(root.isEnd==true) {
			return true;
		}
		return false;
	}
	
	public static boolean isLast(TrieNode root) {
		for(int i=0;i<26;i++) {
			if(root.children[i]!=null) {
				return false;
			}
		}
		return true;
	}
	
	public static void display(TrieNode root,String s) {
		if(isLeafNode(root)) {
			System.out.println(s);
		}
		for(int i=0;i<26;i++) {
			if(root.children[i]!=null) {
				char c=(char)(i+'a');
				display(root.children[i],s+c);
			}
		}
	}
	
	public static int autoSuggestions(String key) {
		int index;
		TrieNode tNode=root;
		for(int i=0;i<key.length();i++) {
			index=key.charAt(i)-'a';
			if(tNode.children[index]==null) {
				return 0;
			}
			tNode=tNode.children[index];
		}
		boolean isWord=tNode.isEnd;
		boolean isLast=isLast(tNode);
		if(isWord&&isLast) {
			System.out.println(key);
			return -1;
		}
		if(!isLast) {
			display(tNode,key);
		}
		return 0;
	}

	public static void main(String[] args) {
		String keys[] = {"the", "a", "there", "answer", "any", 
				"by", "bye", "their"}; 

		String output[] = {"Not present in trie", "Present in trie"}; 


		root = new TrieNode(); 

		// Construct trie 
		int i; 
		for (i = 0; i < keys.length ; i++) 
			insert(keys[i]); 

		// Search for different keys 
		if(search("the") == true) 
			System.out.println("the --- " + output[1]); 
		else System.out.println("the --- " + output[0]); 

		if(search("these") == true) 
			System.out.println("these --- " + output[1]); 
		else System.out.println("these --- " + output[0]); 

		if(search("their") == true) 
			System.out.println("their --- " + output[1]); 
		else System.out.println("their --- " + output[0]); 

		if(search("thaw") == true) 
			System.out.println("thaw --- " + output[1]); 
		else System.out.println("thaw --- " + output[0]); 
		
		//System.out.println("The contents of Trie are");
		//display(root,"");
		
		autoSuggestions("their");

	}

}

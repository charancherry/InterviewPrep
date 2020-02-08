import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class Graphs {
	public static class Graph{
		int v;
		LinkedList<Integer>[] adjList;
		LinkedList<Integer[]>[] adjList1;
		Graph(int noOfNodes){
			v=noOfNodes;
			adjList = new LinkedList[v];
			adjList1 = new LinkedList[v];
			for(int i=0;i<v;i++) {
				adjList[i] = new LinkedList<Integer>();
				adjList1[i] = new LinkedList<Integer[]>();
			}
		}
	}
	
	public static void addUnDirectedEdge(Graph g,int s,int d) {
		g.adjList[s].add(d);
		g.adjList[d].add(s);
	}
	
	public static void addDirectedEdge(Graph g,int s,int d) {
		g.adjList[s].add(d);
	}
	
	public static void addEdge(Graph g,int s,int d,int w) {
		Integer[] temp= {d,w};
		g.adjList1[s].add(temp);
		Integer[] temp1= {s,w};
		g.adjList1[d].add(temp1);
	}
	
	public static void printAdjacentNodes(Graph g) {
		int l=g.adjList.length;
		for(int i=0;i<l;i++) {
			System.out.print("Adjacent nodes of node "+i+" are ");
			for(int j=0;j<g.adjList[i].size();j++) {
				System.out.print(g.adjList[i].get(j)+"->");
			}
			System.out.println();
		}
	}
	
	public static void BFS(Graph g,int n) {
		Queue q = new LinkedList<Integer>();
		boolean[] visited = new boolean[g.v];
		q.add(n);
		visited[n]=true;
		while(!q.isEmpty()) {
			int node=(int)q.poll();
			System.out.print(node+" ");
			for(int i=0;i<g.adjList[node].size();i++) {
				if(visited[g.adjList[node].get(i)]==false) {
					q.add(g.adjList[node].get(i));
					visited[g.adjList[node].get(i)] =true;
				}
			}
		}
	}
	
	public static void DFSFromParticularNode(Graph g,int n) {
		Stack s = new Stack();
		boolean[] visited = new boolean[g.v];
		visited[n]=true;
		s.push(n);
		while(!s.isEmpty()) {
			int v=(int) s.pop();
			System.out.print(v+" ");
			for(int i=g.adjList[v].size()-1;i>=0;i--) {
				int adjV=g.adjList[v].get(i);
				if(visited[adjV]!= true) {
					visited[adjV]=true;
					s.push(adjV);
				}
			}
		}
	}
	
	public static void DFSUtil(Graph g,int n,boolean[] visited) {
		Stack s = new Stack();
		visited[n]=true;
		s.push(n);
		while(!s.isEmpty()) {
			int v=(int) s.pop();
			System.out.print(v+" ");
			for(int i=g.adjList[v].size()-1;i>=0;i--) {
				int adjV=g.adjList[v].get(i);
				if(visited[adjV]!= true) {
					visited[adjV]=true;
					s.push(adjV);
				}
			}
		}
	}
	
	public static void recurssiveDFS(Graph g,int n,boolean[] visited) {
		visited[n] = true;
		System.out.print(n+" ");
		for(int i=0;i<g.adjList[n].size();i++) {
			int adjV=g.adjList[n].get(i);
			if(visited[adjV]!= true) {
				recurssiveDFS(g,adjV,visited);
			}
		}
		
	}
	
	public static void DFS(Graph g) {
		boolean[] visited = new boolean[g.v];
		for(int i=0;i<g.v;i++) {
			if(visited[i]==false) {
				//DFSUtil(g,i,visited);
				recurssiveDFS(g,i,visited);
			}
		}
	}
	
	public static boolean isCyclicutil(Graph g,int v,boolean[] visited,int parent) {
		visited[v]=true;
		for(int i=0;i<g.adjList[v].size();i++) {
			int c=g.adjList[v].get(i);
			if(visited[c]==true) { 
				if(parent != c) { 
					return true;
				}
			}else {
				if(isCyclicutil(g,c,visited,v)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static boolean isCyclic(Graph g) {
		boolean[] visited = new boolean[g.v];
		for(int i=0;i<g.v;i++) {
			if(!visited[i]) {
				if(isCyclicutil(g,i,visited,-1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void topologicalUtil(Graph g,int v,boolean[] visited,Stack s) {
		visited[v]=true;
		for(int i=0;i<g.adjList[v].size();i++) {
			int n=g.adjList[v].get(i);
			if(!visited[n]) {
				topologicalUtil(g,n,visited,s);
			}
		}
		s.add(v);
	}
	
	
	/*******************   https://www.geeksforgeeks.org/topological-sorting/     *****************/
	public static void topologicalSort(Graph g) {
		boolean[] visited = new boolean[g.v];
		Stack s = new Stack();
		for(int i=0;i<g.v;i++) {
			if(!visited[i]) {
				topologicalUtil(g,i,visited,s);
			}
		}
		while(!s.empty()) {
			System.out.print((char)('a'+(int) s.pop())+" ");
		}
		
	}
	
	
	public static void alienDictionary(String[] words,int k,int n) {
		Graph g=new Graph(n);
		for(int i=0;i<k-1;i++) {
			char[] w1=words[i].toCharArray();
			char[] w2=words[i+1].toCharArray();
			for(int j=0;j<Math.min(w1.length, w2.length);j++) {
				if(w1[j]!=w2[j]) {
					g.adjList[w1[j]-'a'].add(w2[j]-'a');
					break;
				}
			}
		}
		topologicalSort(g);
	}
	
	public static void isPathExistUtil(Graph g, int s,int d,boolean[] visited,Stack S) {
		visited[s]=true;
		S.add(s);
		for(int i=0;i<g.adjList[s].size();i++) {
			Integer n=g.adjList[s].get(i);
			if(!visited[n]) {
				if(n==d) {
					S.add(n);
						System.out.print(S);
					return;
				}else {
					isPathExistUtil(g,n,d,visited,S);
					S.remove(n);
				}
			}
		}
	}
	
	public static void isPathExist(Graph g,int s,int d) {
		Stack S=new Stack();
		boolean[] visited = new boolean[g.v];
		isPathExistUtil(g,s,d,visited,S);
	}
	
	public static void isPathWithMoreThanKExist(Graph g,int s,int val,Stack S,int sum) {
		for(int i=0;i<g.adjList1[s].size();i++) {
			Integer d =g.adjList1[s].get(i)[0];
			int w =g.adjList1[s].get(i)[1];
			if(!S.contains(d)) {
				if(w+sum>val) {
					S.add(d);
					System.out.print(S);
					System.out.println("sum="+(sum+w));
					S.remove(d);
					return;
				}else {
					S.add(d);
					sum=sum+w;
					isPathWithMoreThanKExist(g,d,val,S,sum);
					sum=sum-w;
					S.remove(d);
				}
			}
		}
	}
	
	
	public static void isPathWithMoreThanKExist(Graph g,int val) {
		for(int i=0;i<g.v;i++) {
			Stack s= new Stack();
			s.add(i);
				isPathWithMoreThanKExist(g,i,val,s,0);
		}
	}
	
	public static int minKeyNode(boolean[] mst,int[] key) {
		int min=Integer.MAX_VALUE;
		int min_index=0;
		for(int i=0;i<key.length;i++) {
			if(mst[i]==false && key[i]<min) {
				min=key[i];
				min_index=i;
			}
		}
		return min_index;
	}
	
	public static void printMinSpanTree(int[] parent,int[] key) {
		for(int i=1;i<key.length;i++) {
			System.out.println(parent[i]+" - "+i+" "+key[i]);
		}
	}
	
	
	public static void minimumSpanningTree(int[][] g) {
		int[] dist = new int[g.length];
		int[] parent = new int[g.length];
		boolean[] mst = new boolean[g.length];
		for(int i=1;i<g.length;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		dist[0]=0;
		parent[0]=-1;
		for(int i=0;i<g.length;i++) {
			int min=minKeyNode(mst,dist);
			mst[min]=true;
			for(int v=0;v<g.length;v++) {
				if(g[min][v]>0 && mst[v]==false && g[min][v]<dist[v]) {
					dist[v]=g[min][v];
					parent[v]=min;
				}
			}
		}
		printMinSpanTree(parent,dist);
	}
	
	
	public static void dijkstra(int[][] g) {
		int[] dist=new int[g.length];
		int[] parent=new int[g.length];
		boolean[] spt =new boolean[g.length];
		for(int i=1;i<g.length;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		dist[0]=0;
		parent[0]=-1;
		for(int i=0;i<g.length;i++) {
			int min=minKeyNode(spt,dist);
			spt[min]=true;
			for(int v=0;v<g.length;v++) {
				if(spt[v]==false && g[min][v]>0 && dist[min]+g[min][v]<dist[v]) {
					dist[v]=dist[min]+g[min][v];
					parent[v]=min;
				}
			}
		}
		printMinSpanTree(parent,dist);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		System.out.println("Enter No of nodes in graph");
//		int n = in.nextInt();
		Graph g=new Graph(5);
		addUnDirectedEdge(g, 0, 1);
		addUnDirectedEdge(g, 0, 4);
		addUnDirectedEdge(g, 1, 2);
		addUnDirectedEdge(g, 1, 3);
		addUnDirectedEdge(g, 1, 4);
		addUnDirectedEdge(g, 2, 3);
		addUnDirectedEdge(g, 2, 4);
//		System.out.println("Adjacent vertices of each vertex is ");
//		printAdjacentNodes(g);
//		System.out.println();
//		System.out.println("Breadth First Search of given graph is ");
//		BFS(g,0);
//		System.out.println();
//		
//		System.out.println("Depth First Search of given graph is ");
//		DFSFromParticularNode(g,0);
//		DFS(g);
//		System.out.println();
//		
//		Graph g1 = new Graph(5); 
//		addUnDirectedEdge(g1,1, 0); 
//		addUnDirectedEdge(g1,0, 2); 
//		addUnDirectedEdge(g1,2, 1); 
//		addUnDirectedEdge(g1,0, 3); 
//		addUnDirectedEdge(g1,3, 4); 
//        printAdjacentNodes(g1);
//        System.out.println("Cycle present in given graph "+isCyclic(g1));
//		
//		Graph g3= new Graph(6);
//		addDirectedEdge(g3,5, 2); 
//		addDirectedEdge(g3,5, 0); 
//		addDirectedEdge(g3,4, 0); 
//		addDirectedEdge(g3,4, 1); 
//		addDirectedEdge(g3,2, 3); 
//		addDirectedEdge(g3,3, 1);
//		System.out.println("Topological sort of given graph is ");
//		topologicalSort(g3);
//		
//		Graph g4 = new Graph(4);
//		addDirectedEdge(g4,0,1);
//		addDirectedEdge(g4,0,2);
//		addDirectedEdge(g4,1,2);
//		addDirectedEdge(g4,2,0);
//		addDirectedEdge(g4,2,3);
//		addDirectedEdge(g4,3,3);
//		isPathExist(g4,0,1);
//		
//		int graph[][] = { { 0, 2, 0, 6, 0 },  
//                { 2, 0, 3, 8, 5 },  
//                { 0, 3, 0, 0, 7 },  
//                { 6, 8, 0, 0, 9 },  
//		minimumSpanningTree(graph);
//                { 0, 5, 7, 9, 0 } };  
//		System.out.println();
//		dijkstra(graph);
//        
//		Graph g5 =new Graph(9);
//		addEdge(g5, 0,1,4);
//		addEdge(g5, 0,7,8);
//		addEdge(g5, 1,2,8);
//		addEdge(g5, 1,7,11);
//		addEdge(g5, 2,3,7);
//		addEdge(g5, 2,8,2);
//		addEdge(g5, 2,5,4);
//		addEdge(g5, 3,4,9);
//		addEdge(g5, 3,5,14);
//		addEdge(g5, 4,5,10);
//		addEdge(g5, 5,6,2);
//		addEdge(g5, 6,7,1);
//		addEdge(g5, 6,8,6);
//		addEdge(g5, 7,8,7);
//		isPathWithMoreThanKExist(g5,58);
		
		
		String[] words= {"baa","abcd","abca","cab","cad"};
		//String[] words= {"caa","aaa","aab"};
		alienDictionary(words,5,4);
		
	}

}

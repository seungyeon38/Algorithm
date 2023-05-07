package class4_2;

import java.util.*;
import java.io.*; 

public class boj1991_트리순회_S1_128ms {
	static StringBuilder sb = new StringBuilder(); 
	static Node[] tree; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~26
		
		tree = new Node[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			tree[c-'A'] = new Node(c, l, r);
		}
		
		preorder(tree[0]);
		sb.append("\n");
		inorder(tree[0]);
		sb.append("\n");
		postorder(tree[0]);
		
		System.out.println(sb.toString());
	}
	
	public static void preorder(Node n) { // 전위 
		sb.append(n.c);
		if(n.left != '.') preorder(tree[n.left-'A']);
		if(n.right != '.') preorder(tree[n.right-'A']);
	}
	
	public static void inorder(Node n) { // 중위 
		if(n.left != '.') inorder(tree[n.left-'A']);
		sb.append(n.c);
		if(n.right != '.')inorder(tree[n.right-'A']);
	}
	
	public static void postorder(Node n) { // 후위 
		if(n.left != '.') postorder(tree[n.left-'A']);
		if(n.right != '.') postorder(tree[n.right-'A']);
		sb.append(n.c);
	}
	
	public static class Node{
		char c;
		char left;
		char right; 
		
		Node(char c, char l, char r){
			this.c = c; 
			this.left = l;
			this.right = r;
		}
	}
}

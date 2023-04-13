package 트리;

import java.util.*;
import java.io.*;

public class q070_boj1991_트리순회 {
	static char[][] tree;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~26
		tree = new char[27][2];
		sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int idx = st.nextToken().charAt(0)-'A';
			
			tree[idx][0] = st.nextToken().charAt(0);
			tree[idx][1] = st.nextToken().charAt(0);
		}
		
		preorder('A');
		sb.append("\n");
		inorder('A'); 
		sb.append("\n");
		postorder('A');
		
		System.out.println(sb.toString());
	}
	
	public static void preorder(char c) {
		sb.append(c);
		int idx = c-'A';
		if(tree[idx][0] != '.') preorder(tree[idx][0]);
		if(tree[idx][1] != '.') preorder(tree[idx][1]);
	}
	
	public static void inorder(char c) {
		int idx = c-'A';
		if(tree[idx][0] != '.') inorder(tree[idx][0]);
		sb.append(c);
		if(tree[idx][1] != '.') inorder(tree[idx][1]);
	}
	
	public static void postorder(char c) {
		int idx = c-'A';
		if(tree[idx][0] != '.') postorder(tree[idx][0]);
		if(tree[idx][1] != '.') postorder(tree[idx][1]);
		sb.append(c);
	}
}

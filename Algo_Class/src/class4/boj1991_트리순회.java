package class4;

import java.util.*;
import java.io.*;

public class boj1991_트리순회 {
	static StringBuilder sb; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 26
		
		Node head = new Node('A', null, null);
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insert(head, parent, left, right);
		}
		
		pre(head);
		sb.append("\n");
		in(head);
		sb.append("\n");
		post(head);
		
		System.out.println(sb.toString());
	}
	
	public static void insert(Node temp, char p, char l, char r) {
		if(temp.value == p) { // 부모 찾으면 
			temp.r = (r == '.' ? null : new Node(r, null, null));
			temp.l = (l == '.' ? null : new Node(l, null, null)); 
		} else { 
			if(temp.r != null) insert(temp.r, p, l, r);
			if(temp.l != null) insert(temp.l, p, l, r);
		}
	}
	
	public static void pre(Node n) { // 전위 (루트 - 왼 - 오)
		if(n == null) return; 
		sb.append(n.value);
		pre(n.l);
		pre(n.r);
	}
	
	public static void in(Node n) { // 중위 (왼 - 루 - 오)
		if(n == null) return; 
		in(n.l);
		sb.append(n.value);
		in(n.r);
	}
	
	public static void post(Node n) { // 후위 (왼 - 오 - 루)
		if(n == null) return; 
		post(n.l);
		post(n.r);
		sb.append(n.value);
	}
	
	public static class Node{
		char value; 
		Node l;
		Node r; 
		
		Node(char value, Node l, Node r){
			this.value = value;
			this.l = l;
			this.r = r;
		}
	}
}

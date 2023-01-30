package Algorithm;

import java.util.*;
import java.io.*;

public class q044_boj1033 {
	static ArrayList<Node>[] list;
	static int N; 
	static boolean[] visited;
	static long[] result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 10
		
		list = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		StringTokenizer st;
		long lcm = 1; 
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, p, q));
			list[b].add(new Node(a, q, p));
			
			lcm *= p*q/gcd(p, q);
		}
		
		result = new long[N];
		visited = new boolean[N];
		
		result[0] = lcm; 
		visited[0] = true; 
		
		dfs(1, 0);
		
		long gcd = result[0]; 
		
		for(int i=1; i<N; i++) {
			gcd = gcd(gcd, result[i]);
		}
		
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N; i++) {
			sb.append(result[i]/gcd).append(" ");
		}

		System.out.println(sb.toString());
	}
	
	public static class Node{
		int n; 
		int r1;
		int r2; 
		
		Node(int n, int r1, int r2){
			this.n = n; 
			this.r1 = r1;
			this.r2 = r2;
		}
	}
	
	public static long gcd(long n1, long n2) {
		if(n1 == 0) return n2; 
		else return gcd(n2%n1, n1);
	}
	
	public static void dfs(int idx, int sp) {
		if(idx == N) return; 
		
		for(Node node : list[sp]) {
			if(!visited[node.n]) {
				visited[node.n] = true;
				result[node.n] = result[sp]*node.r2/node.r1;
				
				dfs(idx+1, node.n);
			}
		}
	}
}

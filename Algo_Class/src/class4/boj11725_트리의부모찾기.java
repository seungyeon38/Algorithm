package class4;

import java.util.*;
import java.io.*;

public class boj11725_트리의부모찾기 {
	static ArrayList<Integer>[] tree;
	static int[] result;
	static boolean[] visited; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 2~100000
		
		tree = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		
		result = new int[N+1];
		visited = new boolean[N+1];
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder(); 
		
		for(int i=2; i<=N; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb.toString()); 
	}
	
	public static void dfs(int s) {
		for(int n : tree[s]) {
			if(!visited[n]) {
				visited[n] = true; 
				result[n] = s;
				dfs(n);
			}
		}
	}
}

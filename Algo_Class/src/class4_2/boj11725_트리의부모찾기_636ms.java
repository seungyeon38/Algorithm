package class4_2;

import java.util.*;
import java.io.*;

public class boj11725_트리의부모찾기_636ms {
	static ArrayList<Integer>[] adj_list;
	static boolean[] visited; 
	static int[] parents;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 노드의 개수 2~100000
		adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adj_list[n1].add(n2);
			adj_list[n2].add(n1);
		}
		
		parents = new int[N+1];
		visited = new boolean[N+1];
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder(); 
		for(int i=2; i<=N; i++) {
			sb.append(parents[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int parent) {
		visited[parent] = true;
		
		for(int c : adj_list[parent]) {
			if(visited[c]) continue; 
			parents[c] = parent;
			dfs(c);
		}
	}
}

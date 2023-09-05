package c_탐색;

import java.util.*;
import java.io.*;

public class boj1260_dfs와bfs_248ms {
	static boolean[] visited; 
	static ArrayList<Integer>[] adj_list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수 
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수 
		int V = Integer.parseInt(st.nextToken()); // 시작 정점 번호 
		
		visited = new boolean[N+1];
		adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			adj_list[p1].add(p2);
			adj_list[p2].add(p1);
		}
		
		for(int i=0; i<=N; i++) {
			Collections.sort(adj_list[i]);
		}
		
		dfs(V);
		Arrays.fill(visited, false);
		sb.append("\n");
		bfs(V);
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n) {
		if(visited[n]) return;
		
		visited[n] = true;
		sb.append(n).append(" ");
		
		for(int next : adj_list[n]) {
			if(visited[next]) continue; 
			
			dfs(next);
		}
	}
	
	public static void bfs(int sp) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(sp);
		visited[sp] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			sb.append(cur).append(" ");
			
			for(int next : adj_list[cur]) {
				if(visited[next]) continue;
				visited[next] = true;
				queue.add(next);
			}
		}
		
	}
}

package 탐색;

import java.util.*;
import java.io.*;

public class boj1260_DFS와BFS_260ms {
	static int N; 
	static ArrayList<Integer>[] adj_list;
	static boolean[] visited; 
	static StringBuilder sb; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수 1~1000
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수 1~10000
		int V = Integer.parseInt(st.nextToken()); // 시작 정점 
		
		adj_list = new ArrayList[N+1];
		sb = new StringBuilder();
		
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			adj_list[n1].add(n2);
			adj_list[n2].add(n1);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(adj_list[i]);
		}
		
		visited = new boolean[N+1];
		dfs(V);
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
	
	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		boolean[] visited = new boolean[N+1];
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");
			visited[cur] = true; 
			for(int next : adj_list[cur]) {
				if(visited[next]) continue; 
				visited[next] = true; 
				queue.add(next);
			}
			
		}
	}
}

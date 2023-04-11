package 탐색;

import java.util.*;
import java.io.*;

public class q026_boj1260_DFS와BFS {
	static int N;
	static boolean[][] adj_list; 
	static boolean[] visited; 
	static StringBuilder sb; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); // 정점 개수 1~1000
		int M = Integer.parseInt(st.nextToken()); // 간선 개수 1~10000
		int V = Integer.parseInt(st.nextToken()); // 시작 정점 
		adj_list = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adj_list[s][e] = true;
			adj_list[e][s] = true;
		}
		
		dfs(V);
		sb.append("\n");
		Arrays.fill(visited, false);
		bfs(V);
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n) {
		if(visited[n]) return; 
		
		visited[n] = true; 
		sb.append(n).append(" ");	

		for(int i=1; i<=N; i++) {
			if(adj_list[n][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(n);
		visited[n] = true; 
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			sb.append(num).append(" ");
			
			for(int i=1; i<=N; i++) {
				if(adj_list[num][i] && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}

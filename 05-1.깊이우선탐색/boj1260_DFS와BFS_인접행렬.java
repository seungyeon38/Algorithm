package Algorithm;

import java.util.*;
import java.io.*;

public class boj1260_DFS와BFS_인접행렬 {
	static int N;
	static boolean[][] adjMatrix;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 1000
		int M = Integer.parseInt(st.nextToken()); // 간선 10000
		int V = Integer.parseInt(st.nextToken()); // 시작 정점 
		
		adjMatrix = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adjMatrix[s][e] = true;
			adjMatrix[e][s] = true;
		}
		
		sb = new StringBuilder();
		dfs(V);
//		dfs2(V, new boolean[N+1]);
		sb.append("\n");
		bfs(V);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int s) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[N+1];
		
		stack.push(s);
		
		while(!stack.isEmpty()) {
			int n = stack.pop();					
			if(!visited[n]) {
				visited[n] = true;
				sb.append(n).append(" ");
			}
			
			for(int i=N; i>0; i--) {
				if(adjMatrix[n][i] && !visited[i]) {
					stack.push(i);
				}
			}
		}
	}
	
	public static void dfs2(int s, boolean[] visited) {
		visited[s] = true;
		sb.append(s).append(" ");
		for(int i=1; i<=N; i++) {
			if(adjMatrix[s][i] && !visited[i]) {
				visited[i] = true;
				dfs2(i, visited);
			}
		}
	}
	
	public static void bfs(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(s);
		visited[s] = true;

		while(!queue.isEmpty()) {
			int n = queue.poll();
			sb.append(n).append(" ");
			
			for(int i=1; i<=N; i++) {
				if(adjMatrix[n][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}

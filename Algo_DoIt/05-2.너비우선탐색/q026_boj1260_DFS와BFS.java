package Algorithm;

import java.util.*;
import java.io.*;

public class q026_boj1260 {
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited; 
	public static int N, M;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 노드 1000 
		M = Integer.parseInt(st.nextToken()); // 에지 10000
		int V = Integer.parseInt(st.nextToken()); // 탐색할 노드 번호 
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph[s].add(e);
			graph[e].add(s);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(graph[i]);
		}
		
		sb = new StringBuilder();
		
		dfs(V);
		
		visited = new boolean[N+1];
		sb.append("\n");
		
		bfs(V);
		
//		visited = new boolean[N+1];
//		sb.append("\n");
		
//		dfs2(V);
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n) {
		visited[n] = true; 
		sb.append(n).append(" ");
		
		for(int i : graph[n]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
//	public static void dfs2(int V) {
//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(V);
//		visited[V] = true; 
//
//		while(!stack.empty()) {
//			int num = stack.pop();
//			sb.append(num).append(" ");
//			
//			for(int i : graph[num]) {
//				if(!visited[i]) {
//					stack.push(i);
//					visited[i] = true; 
//				}
//			}
//		}
//	}
	
	public static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		visited[V] = true; 
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			sb.append(num).append(" ");
			
			for(int i : graph[num]) {
				if(!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}

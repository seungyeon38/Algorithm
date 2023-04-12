package 그래프;

import java.util.*;
import java.io.*;

public class q956_boj1753_최단경로 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int V = Integer.parseInt(st.nextToken()); // 정점 개수 1~20000
		int E = Integer.parseInt(st.nextToken()); // 간선 개수 1~300000
		
		int K = Integer.parseInt(br.readLine()); // 시작 정점 번호 
		
		ArrayList<Node>[] adj_list = new ArrayList[V+1];
		
		for(int i=0; i<=V; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 1~10 
			
			adj_list[u].add(new Node(v, w));
		}
		 
		// K부터 다른 노드까지의 거리 
		int[] distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] visited = new boolean[V+1];
		
		distance[K] = 0;
		
		for(int i=1; i<=V; i++) {
			int min_idx = 0; 
			int min = Integer.MAX_VALUE; 
			for(int j=1; j<=V; j++) {
				if(distance[j]<min && !visited[j]) {
					min = distance[j];
					min_idx = j;
				}
			}
			
			visited[min_idx] = true; 
			
			for(Node n : adj_list[min_idx]) {
				distance[n.n] = Math.min(n.w+distance[min_idx], distance[n.n]);
			}
		}
		
		StringBuilder sb = new StringBuilder(); 
		for(int i=1; i<=V; i++) {
			if(distance[i] < Integer.MAX_VALUE) {
				sb.append(distance[i]).append("\n");
			} else {
				sb.append("INF").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Node{
		int n;
		int w; 
		
		Node(int n, int w){
			this.n = n; 
			this.w = w;
		}
	}
}

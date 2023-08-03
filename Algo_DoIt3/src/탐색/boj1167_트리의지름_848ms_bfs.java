package 탐색;

import java.util.*;
import java.io.*;

public class boj1167_트리의지름_848ms_bfs {
	static int V;
	static ArrayList<Node>[] adj_list;
	static int[] distance; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine()); // 정점의 개수 2~100000
		adj_list = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 정점 번호 
			int e = Integer.parseInt(st.nextToken()); 
			while(e != -1) {
				int d = Integer.parseInt(st.nextToken()); // 거리 1~10000
				adj_list[s].add(new Node(e, d));
				e = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(1);
		int max = 0;
		int max_idx = -1;
		for(int i=1; i<=V; i++) {
			if(max < distance[i]) {
				max = distance[i];
				max_idx = i;
			}
		}

		bfs(max_idx);
		int result = 0; 
		for(int i=1; i<=V; i++) {
			result = Math.max(result, distance[i]);
		}
		
		System.out.println(result);
	}
	
	public static void bfs(int s) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(s, 0));
		boolean[] visited = new boolean[V+1];
		visited[s] = true; 
		distance = new int[V+1];
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(Node next : adj_list[cur.n]) {
				if(visited[next.n]) continue; 
				
				visited[next.n] = true; 
				distance[next.n] = distance[cur.n]+next.distance;
				queue.add(new Node(next.n, distance[next.n]));
			}
		}
	}
	
	public static class Node{
		int n; 
		int distance; 
		
		Node(int n, int distance){
			this.n = n; 
			this.distance = distance;
		}
	}
}

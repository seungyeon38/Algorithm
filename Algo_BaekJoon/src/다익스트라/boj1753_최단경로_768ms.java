package 다익스트라;

import java.util.*;
import java.io.*;

public class boj1753_최단경로_768ms {
	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int V = Integer.parseInt(st.nextToken()); // 정점의 개수 1~2000
		 int E = Integer.parseInt(st.nextToken()); // 간선의 개수 1~300000
		 
		 ArrayList<Node>[] adj_list = new ArrayList[V+1];
		 for(int i=0; i<=V; i++) {
			 adj_list[i] = new ArrayList<>();
		 }
		 
		 int s = Integer.parseInt(br.readLine());
				 
		 for(int i=0; i<E; i++) {
			 st = new StringTokenizer(br.readLine());
			 int u = Integer.parseInt(st.nextToken());
			 int v = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken()); // 1~10
			 
			 adj_list[u].add(new Node(v, w));
		 }
		 
		 PriorityQueue<Node> pq = new PriorityQueue<>();
		 pq.add(new Node(s, 0));
		 int INF = 3000001;

		 int[] distance = new int[V+1];
		 Arrays.fill(distance, INF);
		 distance[s] = 0;

		 boolean[] visited = new boolean[V+1];
		 
		 while(!pq.isEmpty()) {
			 Node cur = pq.poll();
			 
			 if(visited[cur.n]) continue;
			 visited[cur.n] = true;
			 
			 for(Node next : adj_list[cur.n]) {				 
				 if(distance[next.n] > next.w+distance[cur.n]) {
					 distance[next.n] = next.w+distance[cur.n];
					 pq.add(new Node(next.n, distance[next.n]));
				 }
			 }
		 }
		 
		 StringBuilder sb = new StringBuilder();
		 for(int i=1; i<=V; i++) {
			 if(distance[i] == INF) sb.append("INF\n");
			 else sb.append(distance[i]).append("\n");
		 }
		 
		 System.out.println(sb.toString());
	}
	
	public static class Node implements Comparable<Node>{
		int n;
		int w; 
		
		Node(int n, int w){
			this.n = n; 
			this.w = w;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.w - n.w;
		}
	}
}

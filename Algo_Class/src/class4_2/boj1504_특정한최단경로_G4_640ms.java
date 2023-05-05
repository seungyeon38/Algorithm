package class4_2;

import java.util.*;
import java.io.*; 

public class boj1504_특정한최단경로_G4_640ms {
	static int INF = 200000000;
	static int N; 
	static ArrayList<Node>[] adj_list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 개수 2~800
		int E = Integer.parseInt(st.nextToken()); // 간선 개수 0~200000
		
		adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Node>();
		}

		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 1~1000
			
			adj_list[a].add(new Node(b, c));
			adj_list[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		// 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 
		int v1 = Integer.parseInt(st.nextToken()); 
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1-v1-v2-N 
		// 1-v2-v1-N 
		// 1~다른곳 : distance1
		// v1~v2 
		// 다른곳~N : distance4
		int[] distance1 = dijkstra(1);
		int[] distance2 = dijkstra(v1);
		int[] distance3 = dijkstra(N);
		
		int d1 = distance1[v1] + distance2[v2] + distance3[v2];
		int d2 = distance1[v2] + distance2[v2] + distance3[v1];
		
		if(d1>=INF && d2>=INF) {
			System.out.println("-1");
		} else {
			System.out.println(Math.min(d1, d2));
		}
	}
	
	public static int[] dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s, 0));
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		Arrays.fill(distance, INF);
		distance[s] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.n]) continue; 
			visited[cur.n] = true;
			
			for(Node next : adj_list[cur.n]) {
				if(visited[next.n]) continue;
				if(distance[next.n] > distance[cur.n] + next.distance) {
					distance[next.n] = distance[cur.n] + next.distance;
					pq.add(new Node(next.n, distance[next.n]));
				}
			}
		}
		
		return distance;
	}
	
	public static class Node implements Comparable<Node>{
		int n; 
		int distance;
		
		Node(int n, int distance){
			this.n = n; 
			this.distance = distance; 
		}
		
		@Override
		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}
}

package day7;

import java.util.*;
import java.io.*;

public class boj2211_네트워크복구_G2_636ms_dijkstra {
	static int N; 
	static ArrayList<Node>[] adj_list;
	static int[] dist; 
	static int[] route;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 컴퓨터 1~1000
		int M = Integer.parseInt(st.nextToken()); // 회선 개수 
		
		// 최소 개수의 회선만을 복구해야 한다.
		// 네트워크를 복구한 후에 서로 다른 두 컴퓨터 간에 통신이 가능하도록 복구해야 한다.
		// 슈퍼컴퓨터가 다른 컴퓨터들과 통신하는데 걸리는 최소 시간이, 원래의 네트워크에서 통신하는데 걸리는 최소 시간보다 커져서는 안 된다.
		adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		dist = new int[N+1];
		route = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // 1~10 
			
			adj_list[A].add(new Node(B, C));
			adj_list[B].add(new Node(A, C));
		}
		
		dijkstra(1);
		
		HashSet<String> set = new HashSet<String>();
		for(int i=2; i<=N; i++) {
			int end = i;
			while(route[end] != 0) {
				set.add(end + " " + route[end]);
				end = route[end];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(set.size()).append("\n");
		for(String str : set) {
			sb.append(str).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		pq.add(new Node(s, 0));
		boolean[] visited = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.n]) continue;
			visited[cur.n] = true; 
						
			for(Node next : adj_list[cur.n]) {
				if(dist[next.n] > dist[cur.n]+next.w) {
					dist[next.n] = dist[cur.n]+next.w;
					pq.add(new Node(next.n, dist[next.n]));
					route[next.n] = cur.n;
				}
			}
		}
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

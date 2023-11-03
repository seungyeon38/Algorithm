package 다익스트라;

import java.util.*;
import java.io.*;

public class boj5972_택배배송_428ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 헛간 1~50000
		int M = Integer.parseInt(st.nextToken()); // 길 1~50000
		
		// 최소한의 소를 만나면서 가기 
		// 1에서 N까지
		ArrayList<Node>[] adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adj_list[A].add(new Node(B, C));
			adj_list[B].add(new Node(A, C));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
//		boolean[] visited = new boolean[N+1];
//		visited[1] = true;
		int[] distance = new int[N+1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		distance[1] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(Node next : adj_list[cur.n]) {
				if(distance[next.n] > distance[cur.n]+next.w) {
					distance[next.n] = distance[cur.n]+next.w;
					pq.add(new Node(next.n, distance[next.n]));
				}
			}
		}
		
		System.out.println(distance[N]);
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

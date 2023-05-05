package class4_2;

import java.util.*;
import java.io.*;

public class boj1238_파티_G3_216ms {
	static int N;
	static int[] distance; 
	static int[] total;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수 1~1000
		int M = Integer.parseInt(st.nextToken()); // 단방향 도로 1~10000
		int X = Integer.parseInt(st.nextToken()); // 파티 마을 
		ArrayList<Node>[] to = new ArrayList[N+1]; // 가는 길 
		ArrayList<Node>[] from = new ArrayList[N+1]; // 오는 길 
		for(int i=0; i<=N; i++) {
			to[i] = new ArrayList<Node>();
			from[i] = new ArrayList<Node>();
		}
		
		// 오고 가는데 가장 오래 걸리는 학생의 소요시간 구하기 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			to[B].add(new Node(A, T));
			from[A].add(new Node(B, T));
		}
		
		distance = new int[N+1];
		// to에서 T~다른 곳 
		// from에서 T~다른 곳 
		// 합해서 가장 오래 걸리는 학생의 소요시간 출력 
		dijkstra(X, to);
		total = new int[N+1];
		for(int i=0; i<=N; i++) {
			total[i] = distance[i];
		}

		dijkstra(X, from);
		for(int i=0; i<=N; i++) {
			total[i] += distance[i];
		}
		
		int result = 0;
		for(int i=1; i<=N; i++) {
			result = Math.max(result, total[i]);
		}

		System.out.println(result);
	}
	
	public static void dijkstra(int s, ArrayList<Node>[] list) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s, 0));
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[s] = 0;
		boolean[] visited = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.n]) continue;
			visited[cur.n] = true;
			
			for(Node next : list[cur.n]) {
				if(visited[next.n]) continue; 
				if(distance[next.n] > distance[cur.n]+next.time) {
					distance[next.n] = distance[cur.n]+next.time;
					pq.add(new Node(next.n, distance[next.n]));
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
		int n;
		int time;
		
		Node(int n, int time){
			this.n = n;
			this.time = time;
		}
		
		@Override 
		public int compareTo(Node n) {
			return this.time - n.time;
		}
	}
}

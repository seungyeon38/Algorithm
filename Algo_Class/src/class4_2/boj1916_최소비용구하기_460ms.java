package class4_2;

import java.util.*;
import java.io.*;

public class boj1916_최소비용구하기_460ms {
	static int N, M; 
	static ArrayList<Bus>[] map;
	static int[] distance;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 도시 개수 1~1000
		M = Integer.parseInt(br.readLine()); // 버스 개수 1~100000
		map = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			map[i] = new ArrayList<Bus>();
		}
				
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sp = Integer.parseInt(st.nextToken());
			int ep = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 1~100000
			
			map[sp].add(new Bus(ep, w));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sp = Integer.parseInt(st.nextToken());
		int ep = Integer.parseInt(st.nextToken());

		dijkstra(sp, ep); 
				
		System.out.println(distance[ep]);
	}
	
	public static class Bus implements Comparable<Bus>{
		int e;
		int w;
		
		Bus(int e, int w){
			this.e = e;
			this.w = w; 
		}
		
		@Override 
		public int compareTo(Bus b) {
			return this.w - b.w;
		}
	}
	
	public static void dijkstra(int s, int e) {
		PriorityQueue<Bus> pq = new PriorityQueue<Bus>();
		pq.add(new Bus(s, 0));
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[s] = 0; 
		boolean[] visited = new boolean[N+1];

		while(!pq.isEmpty()) {
			Bus b = pq.poll();
			
			if(visited[b.e]) continue; 
			if(b.e == e) break;
			
			visited[b.e] = true; 
			
			for(Bus next : map[b.e]) {
				if(visited[next.e]) continue; 
				
				if(distance[b.e] != Integer.MAX_VALUE && distance[next.e] > distance[b.e] + next.w) {
					distance[next.e] = distance[b.e] + next.w;
					pq.add(new Bus(next.e, distance[next.e]));
				}
			}
		}
	}
}

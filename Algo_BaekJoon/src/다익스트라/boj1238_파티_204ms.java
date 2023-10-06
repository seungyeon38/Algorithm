package 다익스트라;

import java.util.*;
import java.io.*;

public class boj1238_파티_204ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~1000
		int M = Integer.parseInt(st.nextToken()); // 1~10000
		int X = Integer.parseInt(st.nextToken()); // 파티 마을 
		
		// 가장 많은 시간을 소비하는 학생의 소요시간 구하기 
		ArrayList<City>[] adj_list = new ArrayList[N+1];
		ArrayList<City>[] reverse_adj_list = new ArrayList[N+1];

		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<>();
			reverse_adj_list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj_list[s].add(new City(e, w));
			reverse_adj_list[e].add(new City(s, w));
		}
		
		int[] distance = new int[N+1];
		int[] reverse_distance = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			distance[i] = Integer.MAX_VALUE;
			reverse_distance[i] = Integer.MAX_VALUE;
		}
		
		distance[X] = 0;
		reverse_distance[X] = 0;
		
		boolean[] visited = new boolean[N+1];
		boolean[] reverse_visited = new boolean[N+1];
		
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.add(new City(X, 0));
		
		while(!pq.isEmpty()) {
			City cur = pq.poll();
			
			if(visited[cur.n]) continue; 
			visited[cur.n] = true; 
			
			for(City next : adj_list[cur.n]) {
				if(distance[cur.n]!=Integer.MAX_VALUE && distance[next.n] > distance[cur.n]+next.w) {
					distance[next.n] = distance[cur.n]+next.w;
					pq.add(new City(next.n, distance[next.n]));
				}
			}
		}
		
		pq = new PriorityQueue<>();
		pq.add(new City(X, 0));
		
		while(!pq.isEmpty()) {
			City cur = pq.poll();
			
			if(reverse_visited[cur.n]) continue; 
			reverse_visited[cur.n] = true; 
			
			for(City next : reverse_adj_list[cur.n]) {
				if(reverse_distance[cur.n]!=Integer.MAX_VALUE && reverse_distance[next.n] > reverse_distance[cur.n]+next.w) {
					reverse_distance[next.n] = reverse_distance[cur.n]+next.w;
					pq.add(new City(next.n, reverse_distance[next.n]));
				}
			}
		}
		
		int result = 0;
		for(int i=1; i<=N; i++) {
			result = Math.max(result, distance[i]+reverse_distance[i]);
		}
		
		System.out.println(result);
	}
	
	public static class City implements Comparable<City>{
		int n;
		int w;
		
		City(int n, int w){
			this.n = n; 
			this.w = w;
		}
		
		@Override
		public int compareTo(City c) {
			return this.w-c.w;
		}
	}
}

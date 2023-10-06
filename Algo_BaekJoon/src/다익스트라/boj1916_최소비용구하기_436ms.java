package 다익스트라;

import java.util.*;
import java.io.*;

public class boj1916_최소비용구하기_436ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 도시의 개수 1~1000
		int M = Integer.parseInt(br.readLine()); // 버스의 개수 1~100000
		
		ArrayList<City>[] adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 0~100000
			
			adj_list[s].add(new City(e, w));
		}	
		
		st = new StringTokenizer(br.readLine());
		int sp = Integer.parseInt(st.nextToken());
		int ep = Integer.parseInt(st.nextToken());
		
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.add(new City(sp, 0));
		
		long[] distance = new long[N+1];
		for(int i=0; i<=N; i++) {
			distance[i] = Long.MAX_VALUE;
		}
		distance[sp] = 0;
		boolean[] visited = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			City cur = pq.poll();
			
			if(visited[cur.n]) continue; 
			visited[cur.n] = true; 
			
			if(cur.n == ep) break;
			
			for(City next : adj_list[cur.n]) {
				if(distance[cur.n]!=Long.MAX_VALUE && distance[next.n]>distance[cur.n]+next.w) {
					distance[next.n] = distance[cur.n]+next.w;
					pq.add(new City(next.n, distance[next.n]));
				}
			}
		}
		
		System.out.println(distance[ep]);
	}
	
	public static class City implements Comparable<City>{
		int n;
		long w;
		
		City(int n, long w){
			this.n = n;
			this.w = w;
		}
		
		@Override 
		public int compareTo(City c) {
			return (int)(this.w - c.w);
		}
	}
}

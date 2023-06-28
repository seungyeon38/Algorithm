package class4_2;

import java.util.*;
import java.io.*;

public class boj14938_서강그라운드_144ms {
	static int n, m, r;
	static ArrayList<Loc>[] adj_list;
	static int[] distance; 
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 지역의 개수 1~100
		m = Integer.parseInt(st.nextToken()); // 수색범위 1~15 
		r = Integer.parseInt(st.nextToken()); // 길의 개수 1~100
		
		int[] items = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			items[i] = Integer.parseInt(st.nextToken()); // 각 구역에 있는 아이템 수 1~30 
		}
		
		adj_list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			adj_list[i] = new ArrayList<Loc>();
		}
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			adj_list[a].add(new Loc(b, l));
			adj_list[b].add(new Loc(a, l));
		}
		
		int result = 0; 
		for(int i=1; i<=n; i++) { // 몇 번에 떨어질지 
			int item_cnt = 0;
			// i부터 거리 구하기 
			dijkstra(i);
			for(int j=1; j<=n; j++) {
				if(distance[j] <= m) {
					item_cnt += items[j];
				}
			}
			result = Math.max(result, item_cnt);
		}
		
		System.out.println(result);
	}
	
	public static void dijkstra(int s) {
		PriorityQueue<Loc> pq = new PriorityQueue<Loc>();
		pq.add(new Loc(s, 0));
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[s] = 0;
		visited = new boolean[n+1];
		
		while(!pq.isEmpty()) {
			Loc cur = pq.poll();
			
			if(visited[cur.n]) continue; 
			visited[cur.n] = true;
			
			for(Loc l : adj_list[cur.n]) {
				if(!visited[l.n] && distance[l.n] > distance[cur.n]+l.length) {
					distance[l.n] = distance[cur.n]+l.length;
					pq.add(new Loc(l.n, distance[l.n]));
				}
			}
		}
	}
	
	public static class Loc implements Comparable<Loc>{
		int n; 
		int length; 
		
		Loc(int n, int length){
			this.n = n;
			this.length = length;
		}
		
		@Override 
		public int compareTo(Loc l) {
			return this.length - l.length;
		}
	}
}

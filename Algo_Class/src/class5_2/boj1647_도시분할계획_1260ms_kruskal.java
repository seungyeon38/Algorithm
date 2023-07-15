package class5_2; 

import java.util.*;
import java.io.*;

public class boj1647_도시분할계획_1260ms_kruskal {
	static int[] parents; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집의 개수 2~100000
		int M = Integer.parseInt(st.nextToken()); // 길의 개수 1~1000000
		
		// 두개로 나눠 
		// MST 구하고, 그 중에 유지비 가장 높은거 빼기?
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(s, e, c));
		}
		
		parents = new int[N+1];
		for(int i=0; i<=N; i++) {
			parents[i] = i; 
		}
		
		int cnt = 1; 
		int result = 0;
		int last = 0;
		while(cnt < N) {
			Edge cur = pq.poll();
			
			if(find(cur.s) == find(cur.e)) continue; 
			
			last = cur.cost;
			result += cur.cost;
			union(cur.s, cur.e);
			cnt++; 
		}
		
		System.out.println(result-last);
	}
	
	public static void union(int n1, int n2) {
		int n1_p = find(n1);
		int n2_p = find(n2);
		
		if(n1_p == n2_p) return; 
		
		parents[n1_p] = n2_p;
	}
	
	public static int find(int n) {
		if(n == parents[n]) return n;
		
		return parents[n] = find(parents[n]);
	}
	
	public static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int cost;
		
		Edge(int s, int e, int c){
			this.s = s; 
			this.e = e;
			this.cost = c;
		}
		
		@Override 
		public int compareTo(Edge e) {
			return this.cost-e.cost;
		}
	}
}

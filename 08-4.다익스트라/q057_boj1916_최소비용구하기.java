package Algorithm;

import java.util.*;
import java.io.*;

public class q057_boj1916 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 도시의 개수 1000
		int M = Integer.parseInt(br.readLine()); // 버스의 개수 100000
		
		ArrayList<City>[] list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<City>();
		}
		
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 100000
			
			list[from].add(new City(to, w));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int sp = Integer.parseInt(st.nextToken()); // 출발점 
		int destination = Integer.parseInt(st.nextToken());
		
		int[] result = new int[N+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N+1];
		PriorityQueue<City> pq = new PriorityQueue<City>();
		
		pq.offer(new City(sp, 0));
		result[sp] = 0;
		
		while(!pq.isEmpty()) {
			City c = pq.poll();
			
			if(visited[c.idx]) continue;
			visited[c.idx] = true;
			
			if(c.idx == destination) continue;
			
			for(City temp : list[c.idx]) {
				if(!visited[temp.idx] && result[temp.idx] > result[c.idx]+temp.w) {
					result[temp.idx] = result[c.idx]+temp.w;
					pq.offer(new City(temp.idx, result[temp.idx]));
				}
			}
		}
		
		System.out.println(result[destination]);
	}
	
	public static class City implements Comparable<City>{
		int idx; 
		int w;
		
		City(int idx, int w){
			this.idx = idx; 
			this.w = w;
		}
		
		@Override
		public int compareTo(City c) {
			if(this.w < c.w) return -1;
			else return 1;
		}
	}
}

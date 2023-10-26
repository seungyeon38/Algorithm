package 다익스트라;

import java.util.*;
import java.io.*;

public class boj10282_해킹_884ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수 1~10000
			int d = Integer.parseInt(st.nextToken()); // 의존성 개수 1~100000
			int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호 
			
			ArrayList<Computer>[] adj_list = new ArrayList[n+1];
			for(int i=0; i<=n; i++) {
				adj_list[i] = new ArrayList<Computer>();
			}

			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); // 컴퓨터 
				int b = Integer.parseInt(st.nextToken()); // 컴퓨터 
				int s = Integer.parseInt(st.nextToken()); // 시간 0~1000
				// b가 감염되면 s초 후 a도 감염된다. 
				adj_list[b].add(new Computer(a, s));
			}
			
			PriorityQueue<Computer> pq = new PriorityQueue<>();
			pq.add(new Computer(c, 0));
			int[] time = new int[n+1];
			Arrays.fill(time, Integer.MAX_VALUE);
			time[c] = 0;
			boolean[] visited = new boolean[n+1];
			
			while(!pq.isEmpty()) {
				Computer cur = pq.poll();
				
				if(visited[cur.n]) continue; 
				visited[cur.n] = true; 
				
				for(Computer next : adj_list[cur.n]) {
					if(time[cur.n]!=Integer.MAX_VALUE && time[next.n]>time[cur.n]+next.t) {
						time[next.n] = time[cur.n]+next.t;
						pq.add(new Computer(next.n, time[next.n]));
					}
				}
			}
			
			int result_n = 0;
			int result_t = 0;
			for(int i=1; i<=n; i++) {
				if(time[i] != Integer.MAX_VALUE) {
					result_n++;
					result_t = Math.max(result_t, time[i]);
				}
			}
			
			sb.append(result_n).append(" ").append(result_t).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Computer implements Comparable<Computer>{
		int n;
		int t;
		
		Computer(int n, int t){
			this.n = n;
			this.t = t;
		}
		
		@Override
		public int compareTo(Computer c) {
			return this.t - c.t;
		}
	}
}

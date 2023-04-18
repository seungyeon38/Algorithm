package day2;

import java.util.*;
import java.io.*;

public class boj18769_그리드네트워크_G4_2972ms_MST {
	static int[][][] parents; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 1~10 
		StringBuilder sb = new StringBuilder(); 
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); 

		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			for(int r=0; r<R; r++) {
				st = new StringTokenizer(br.readLine()); 
				for(int c=1; c<C; c++) {
					pq.add(new Edge(r, c-1, r, c, Integer.parseInt(st.nextToken())));
				}
			}
			
			for(int r=1; r<R; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<C; c++) {
					pq.add(new Edge(r-1, c, r, c, Integer.parseInt(st.nextToken())));
				}
			}
			
			parents = new int[R][C][2];
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					parents[i][j] = new int[] {i, j};
				}
			}
				
			int result = 0;
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				
				if(find(edge.sr, edge.sc) == find(edge.er, edge.ec)) continue;
				
				union(edge.sr, edge.sc, edge.er, edge.ec);
				result += edge.w;
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void union(int r1, int c1, int r2, int c2) {
		int[] parent1 = find(r1, c1);
		int[] parent2 = find(r2, c2);
		
		if(parent1[0]==parent2[0] && parent1[1]==parent2[1]) return; 
		
		parents[parent1[0]][parent1[1]] = parent2;
	}
	
	public static int[] find(int r, int c) {
		if(parents[r][c][0] == r && parents[r][c][1] == c) return parents[r][c];
		
		return parents[r][c] = find(parents[r][c][0], parents[r][c][1]);
	}
	
	public static class Edge implements Comparable<Edge>{
		int sr; 
		int sc;
		int er;
		int ec; 
		int w;
		
		Edge(int sr, int sc, int er, int ec, int w){
			this.sr = sr;
			this.sc = sc;
			this.er = er;
			this.ec = ec;
			this.w = w; 
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}
}

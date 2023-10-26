package 다익스트라;

import java.util.*;
import java.io.*;

public class boj1261_알고스팟_144ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 세로 1~100
		int N = Integer.parseInt(st.nextToken()); // 가로 1~100
		char[][] maze = new char[N][M]; // 0:빈방, 1:벽
		for(int i=0; i<N; i++) {
			maze[i] = br.readLine().toCharArray();
		}
		
		
		int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		// 벽을 최소 몇 개 부서야 되는지 
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0,0,0));
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true; 
		int result = Integer.MAX_VALUE; 
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			if(cur.r == N-1 && cur.c == M-1) {
				result = cur.cnt;
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = cur.r+dir[d][0];
				int nc = cur.c+dir[d][1];
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue; 
				if(visited[nr][nc]) continue; 
				
				visited[nr][nc] = true; 
				if(maze[nr][nc] == '1') { // 벽
					pq.add(new Point(nr, nc, cur.cnt+1));
				} else pq.add(new Point(nr, nc, cur.cnt));
			}
		}
		
		System.out.println(result);
	}
	
	public static class Point implements Comparable<Point>{
		int r;
		int c;
		int cnt; 
		
		Point(int r, int c, int cnt){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Point p) {
			return this.cnt-p.cnt;
		}
	}
}

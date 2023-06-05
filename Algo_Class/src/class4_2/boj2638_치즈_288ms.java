package class4_2;

import java.util.*;
import java.io.*;

public class boj2638_치즈_288ms {
	static int N, M; 
	static int[][] grid; 
	static boolean[][] outside;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 5~100
		M = Integer.parseInt(st.nextToken()); // 5~100
		
		grid = new int[N][M];
		int cheese_cnt = 0; 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == 1) cheese_cnt++;
			}
		}
		
		outside = new boolean[N][M];
		int time = 0; 
		
		while(cheese_cnt > 0) {
			calcOut(); // 치즈가 없는 부분 중 외부 공기와 접촉하는 공간 계산 
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(grid[i][j] == 1) { // 치즈 
						int cnt = 0; 
						for(int d=0; d<4; d++) {
							int nr = i+dir[d][0];
							int nc = j+dir[d][1]; 
							
							if(grid[nr][nc]==0 && outside[nr][nc]) {
								cnt++;
							}
						}
						if(cnt >= 2) {
							grid[i][j] = 0; // 녹음 
							cheese_cnt--;
						}
					}
				}
			}
			time++;
		}
		
		System.out.println(time);
	}
	
	public static void calcOut() { // 치즈 내부 공간인지 판단 
		for(int i=0; i<N; i++) {
			Arrays.fill(outside[i], false);
		}

//		[0][0] ~ [0][M]
//		[0][0] ~ [N][0]
//		[N][0] ~ [N][M]
//		[0][M] ~ [N][M]
		for(int i=0; i<N; i++) {
			if(grid[i][0] == 0 && !outside[i][0]) bfs(i, 0);
			if(grid[i][M-1] == 0 && !outside[i][M-1]) bfs(i, M-1);
		}
		
		for(int j=0; j<M; j++) {
			if(grid[0][j] == 0 && !outside[0][j]) bfs(0, j);
			if(grid[N-1][j] == 0 && !outside[N-1][j]) bfs(N-1, j);
		}
	}
	
	public static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sr, sc});
		boolean[][] visited = new boolean[N][M];
		visited[sr][sc] = true; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dir[d][0]; 
				int nc = cur[1]+dir[d][1];
				
				if(isOut(nr, nc)) continue; 
				if(visited[nr][nc]) continue; 
				if(grid[nr][nc] == 1) continue; // 치즈 있는 자리가 아니어야함 
				if(outside[nr][nc]) continue; // 이미 판단된 자리
				
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true; 
				outside[nr][nc] = true; 
			}
		}
	}
	
	public static boolean isOut(int r, int c) {
		if(r<0 || r>=N || c<0 || c>=M) return true;
		
		return false; 
	}
}

package class4;

import java.util.*;
import java.io.*;

public class boj2638_치즈 {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N, M;
	static int[][] grid; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 5~100
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		
		int c_n = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == 1) c_n++;
			}
		}
		
		int result = 0;
		ArrayList<int[]> to0 = new ArrayList<int[]>();
		
		while(c_n > 0) {
			init();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(grid[i][j] == 1) { // 치즈가 있는 위치면 
						if(calc(i, j)) { // 녹으면 
							to0.add(new int[] {i, j});
							c_n--;
						}
					}
				}
			}
						
			for(int[] l : to0) {
				grid[l[0]][l[1]] = 0;
			}
			
			to0.clear();
			result++;
		}
		
		System.out.println(result);
	}
	
	public static void init() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(grid[i][j] == -1) grid[i][j] = 0;
			}
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[]{0, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dir[d][0];
				int nc = cur[1] + dir[d][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				
				if(grid[nr][nc] == 0) {
					grid[nr][nc] = -1; // 바깥 치즈 없는 부분 : -1
					queue.offer(new int[]{nr, nc});
				}
			}
		}
	}
	
	public static boolean calc(int r, int c) {
		int n = 0; // 외부 공기와 닿는 부분 개수 
		
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
			
			if(grid[nr][nc] == -1) {
				n++;
				if(n > 1) return true; 
			}
		}
		
		return false; 
	}
}

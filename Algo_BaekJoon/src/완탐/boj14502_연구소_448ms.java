package 완탐;

import java.util.*;
import java.io.*;

public class boj14502_연구소_448ms {
	static int N,M;
	static int[][] grid;
	static ArrayList<int[]> empty;
	static int empty_cnt;
	static boolean[] selected; 
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static int max = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 크기 3~8
		M = Integer.parseInt(st.nextToken()); // 가로 크기 3~8 
		
		// 0: 빈칸, 1: 벽, 2: 바이러스 
		
		// 벽 3개 세우기
		// ArrayList에 빈칸 저장 
		// 3개 고르고 벽 세워서 바이러스 퍼진 경우에 안전 영역 크기 구해서 최댓값 저장 
		
		grid = new int[N][M];
		empty = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				grid[r][c] = Integer.parseInt(st.nextToken());
				if(grid[r][c] == 0) empty.add(new int[] {r, c});
			}
		}
		
		empty_cnt = empty.size();
		selected = new boolean[empty_cnt];
		
		calc(0, 0);
		
		System.out.println(max);
	}
	
	public static void calc(int temp_cnt, int idx) {
		if(temp_cnt == 3) {
			int[][] temp_grid = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					temp_grid[i][j] = grid[i][j];
				}
			}
						
			for(int i=0; i<empty_cnt; i++) {
				if(!selected[i]) continue; 
				int[] wall = empty.get(i);

				temp_grid[wall[0]][wall[1]] = 1;
			}
			
			spreadVirus(temp_grid);
			
//			System.out.println("바이러스 퍼뜨린 후");
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(temp_grid[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			int safe_cnt = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(temp_grid[i][j] == 0) safe_cnt++;
				}
			}
			
			max = Math.max(max, safe_cnt);
			
			return; 
		}
		
		for(int i=idx; i<empty_cnt; i++) {
			selected[i] = true; 
			calc(temp_cnt+1, i+1);
			selected[i] = false; 
		}
	}
	
	public static void spreadVirus(int[][] grid) {
		boolean[][] visited = new boolean[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(grid[r][c]==2 && !visited[r][c]) {
					dfs(grid, visited, r, c);
				}
			}
		}
	}
	
	public static void dfs(int[][] grid, boolean[][] visited, int cur_r, int cur_c) {
		for(int d=0; d<4; d++) {
			int nr = cur_r + dir[d][0];
			int nc = cur_c + dir[d][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue; 
			if(visited[nr][nc]) continue;
			if(grid[nr][nc] != 0) continue;
			
			visited[nr][nc] = true; 
			grid[nr][nc] = 2; 
			dfs(grid, visited, nr, nc);
		}
	}
}

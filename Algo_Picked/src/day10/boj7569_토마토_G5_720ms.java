package day10;

import java.util.*;
import java.io.*;

public class boj7569_토마토_G5_720ms {
	static int M, N, H;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 상자 크기 2~100
		N = Integer.parseInt(st.nextToken()); // 상자 크기 2~100
		H = Integer.parseInt(st.nextToken()); // 상자의 수 1~100
		
		// 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 들어있지 않은 칸
		int[][][] grid = new int[N][M][H];
		Queue<int[]> ripe_queue = new LinkedList<int[]>();
		
		for(int h=0; h<H; h++) {
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					grid[r][c][h] = Integer.parseInt(st.nextToken());
					
					if(grid[r][c][h] == 1) {
						ripe_queue.add(new int[]{r, c, h});
					}
				}
			}
		}
		
		int[][] dir = {{0, 0, -1}, {0, 0, 1}, {0, -1, 0}, {0, 1, 0}, {1, 0, 0}, {-1, 0, 0}};
		
		int day = -1;
		while(!ripe_queue.isEmpty()) {
			for(int i=0, size=ripe_queue.size(); i<size; i++) {
				int[] ripe = ripe_queue.poll();
				for(int d=0; d<6; d++) {
					int nr = ripe[0]+dir[d][0];
					int nc = ripe[1]+dir[d][1];
					int nh = ripe[2]+dir[d][2];
					
					if(isOut(nr, nc, nh)) continue;
					
					if(grid[nr][nc][nh] == 0) {
						grid[nr][nc][nh] = 1;
						ripe_queue.add(new int[] {nr, nc, nh});
					}
				}
			}
			
			day++;
		}
		
		boolean allRipe = true; 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<H; k++) {
					if(grid[i][j][k] == 0) { // 안 익은 토마토가 있으면 
						day = -1; 
						allRipe = false; 
						break; 
					}
				}
				if(!allRipe) break;
			}
			if(!allRipe) break; 
		}
		
		System.out.println(day);
	}
	
	public static boolean isOut(int r, int c, int h) {
		if(r<0 || r>=N || c<0 || c>=M || h<0 || h>=H) return true; 
		
		return false; 
	}
}

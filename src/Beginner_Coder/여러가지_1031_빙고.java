package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여러가지_1031_빙고 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] grid_n = new int[5][5];
		boolean[][] grid = new boolean[5][5];
		
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				grid_n[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int n=0;
		boolean result = false; 
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				check(grid_n, grid, Integer.parseInt(st.nextToken()));
				n++;
				if(n >= 12 && binggo(grid)) { // 선이 3개 그어지기 위한 최소 개수 
					result = true;
					break;
				}
			}
			if(result) {
				break;
			}
		}
		
		System.out.println(n);
	}
	
	public static void check(int[][] grid_n, boolean[][] grid, int n) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(grid_n[i][j] == n) {
					grid[i][j] = true; 
					break;
				}
			}
		}
	}
	
	public static boolean binggo(boolean[][] grid) {
		int binggo_n = 0;
		
		// 대각선 
		boolean binggo = true;
		for(int i=0; i<5; i++) {
			if(!grid[i][i]) {
				binggo = false; 
				break;
			}
		}
		if(binggo) binggo_n++;
		
		// 대각선 
		binggo = true;
		for(int i=0; i<5; i++) {
			if(!grid[i][4-i]) {
				binggo = false; 
				break; 
			}
		}
		if(binggo) binggo_n++;
		
		// 가로 
		for(int i=0; i<5; i++) {
			binggo = true;
			for(int j=0; j<5; j++) {
				if(!grid[i][j]) {
					binggo = false;
					break;
				}
			}
			if(binggo) binggo_n++;
		}
		
		// 세로 
		for(int i=0; i<5; i++) {
			binggo = true;
			for(int j=0; j<5; j++) {
				if(!grid[j][i]) {
					binggo = false;
					break;
				}
			}
			if(binggo) binggo_n++;
		}
		
		if(binggo_n >= 3) return true;
		
		return false;
	}
}

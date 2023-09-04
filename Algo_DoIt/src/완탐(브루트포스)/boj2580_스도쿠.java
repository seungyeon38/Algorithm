package Algorithm;

import java.util.*;
import java.io.*;

public class boj2580_스도쿠 {
	static int[][] grid; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		grid = new int[9][9];
		
		StringTokenizer st;
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);
	}
	
	public static void sudoku(int r, int c) {
		if(c == 9) { // c 끝으로 가면 아래로
			r++;
			c=0;
		}
		
		if(r == 9) { // 끝
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(grid[i][j]+ " ");
				}
				System.out.println();
			}
			
			System.exit(0); 
		}
		
		if(grid[r][c] == 0) { // 0일 때만 
			for(int i=1; i<10; i++) { // 1~9 탐색
				if(isPossible(r, c, i)) { // 가능하면 
					grid[r][c] = i;
					sudoku(r, c+1);
				}
			}
			grid[r][c] = 0;
		} else {
			sudoku(r, c+1);
		}
	}
	
	public static boolean isPossible(int r, int c, int v) {		
		for(int i=0; i<9; i++) {
			if(grid[r][i] == v) return false; // 가로 
			if(grid[i][c] == v) return false; // 세로 
		}
		
		// 정사각형 
		int sr = r/3*3;
		int sc = c/3*3;
		
		for(int i=sr, mr=sr+3; i<mr; i++) {
			for(int j=sc, mc=sc+3; j<mc; j++) {
				if(grid[i][j] == v) return false; 
			}
		}
		
		return true;
	}
}

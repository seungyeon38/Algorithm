package 구현;

import java.util.*;
import java.io.*;

public class boj1730_판화_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 목판의 크기 2~10
		boolean[][][] grid = new boolean[N][N][4];
		char[] move = br.readLine().toCharArray();
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U, D, L, R
		int cur_r = 0;
		int cur_c = 0;
		
		for(int i=0; i<move.length; i++) {
			char c = move[i];
			int d = -1; 
			switch(c) {
			case 'U':
				d = 0;
				break;
			case 'D':
				d = 1;
				break;
			case 'L':
				d = 2;
				break;
			case 'R':
				d = 3;
				break;
			}
			
			
			int nr = cur_r + dir[d][0];
			int nc = cur_c + dir[d][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue; 
			grid[cur_r][cur_c][d] = true; 
			grid[nr][nc][d] = true; 
			cur_r = nr; 
			cur_c = nc;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(grid[r][c][0] || grid[r][c][1]) { // 수직 
					if(grid[r][c][2] || grid[r][c][3]) { // 수직, 수평 
						sb.append("+");
					} else {
						sb.append("|");
					}
				} else if(grid[r][c][2] || grid[r][c][3]) { // 수평 
					sb.append("-");
				} else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

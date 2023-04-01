package class3;

import java.util.*;
import java.io.*;

public class boj1012_유기농배추_dfs {
	static boolean[][] grid;
	static int result;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken()); // 50
			int N = Integer.parseInt(st.nextToken()); // 50
			int K = Integer.parseInt(st.nextToken()); // 2500
			
			grid = new boolean[M+2][N+2];
			result = 0; 
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				grid[Integer.parseInt(st.nextToken())+1][Integer.parseInt(st.nextToken())+1] = true; 
			}
			
			for(int r=1; r<=M; r++) {
				for(int c=1; c<=N; c++) {
					if(grid[r][c]) {
						dfs(r, c);
						result++; 
					}
				}
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int r, int c) {
		for(int d=0; d<4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if(grid[nr][nc]) {
				grid[nr][nc]=false; 
				dfs(nr, nc);
			}
		}
	}
}

package class4_2;

import java.util.*;
import java.io.*;

public class boj9465_스티커_680ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine()); // 1~100000
			int[][] grid = new int[2][n];
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1; i<n; i++) {
				grid[0][i] = Math.max(grid[0][i-1], grid[1][i-1]+grid[0][i]);
				grid[1][i] = Math.max(grid[1][i-1], grid[0][i-1]+grid[1][i]);
			}
			
			sb.append(Math.max(grid[0][n-1], grid[1][n-1])).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

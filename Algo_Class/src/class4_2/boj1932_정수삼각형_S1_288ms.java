package class4_2;

import java.util.*;
import java.io.*; 

public class boj1932_정수삼각형_S1_288ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 1~500
		int[][] grid = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				grid[i][j] += Math.max(grid[i-1][j-1], grid[i-1][j]);
			}
		}
		
		int max = 0;
		for(int i=1; i<=n; i++) {
			max = Math.max(max, grid[n][i]);
		}
		
		System.out.println(max);
	}
}

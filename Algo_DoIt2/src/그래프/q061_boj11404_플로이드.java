package 그래프;

import java.util.*;
import java.io.*;

public class q061_boj11404_플로이드 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 도시 개수 2~100
		int m = Integer.parseInt(br.readLine()); // 버스 개수 1~100000
		int INF = 100000000; 
		int[][] grid = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			Arrays.fill(grid[i], INF);
		}
		
		for(int i=0; i<=n; i++) {
			grid[i][i] = 0;
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 1~100000
			
			grid[a][b] = Math.min(grid[a][b], c);
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					grid[i][j] = Math.min(grid[i][j], grid[i][k]+grid[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder(); 
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(grid[i][j] == INF) sb.append("0 ");
				else sb.append(grid[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

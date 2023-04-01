package class4;

import java.util.*;
import java.io.*;

public class boj11404_플로이드 {
	static int[][] cost; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 2~100
		int m = Integer.parseInt(br.readLine()); // 1~100000
		int INF = 10000001; 
		
		cost = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			Arrays.fill(cost[i], INF);
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			cost[s][e] = Math.min(cost[s][e], w);
		}
		
		for(int k=1; k<=n; k++) {
			for(int s=1; s<=n; s++) {
				for(int e=1; e<=n; e++) {
					if(s == e) cost[s][e] = 0;
					else if(cost[s][e] > cost[s][k] + cost[k][e]) {
						cost[s][e] = cost[s][k] + cost[k][e];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(cost[i][j] == INF) sb.append("0").append(" ");
				else sb.append(cost[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

package day7;

import java.util.*;
import java.io.*;

public class boj1719_택배_G3_플로이드워샬_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 집하장 개수 1~200
		int m = Integer.parseInt(st.nextToken()); // 경로 개수 1~10000
		
		int[][] adj_matrix = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			Arrays.fill(adj_matrix[i], Integer.MAX_VALUE);
		}
		
		for(int i=0; i<=n; i++) {
			adj_matrix[i][i] = 0;
		}
		
		int[][] result = new int[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj_matrix[n1][n2] = Math.min(adj_matrix[n1][n2], w);
			adj_matrix[n2][n1] = Math.min(adj_matrix[n2][n1], w); 
			
			result[n1][n2] = n2; 
			result[n2][n1] = n1;
		}
				
		for(int k=1; k<=n; k++) {
			for(int s=1; s<=n; s++) {
				if(k == s) continue; 
				for(int e=1; e<=n; e++) {
					if(adj_matrix[s][k] == Integer.MAX_VALUE || adj_matrix[k][e] == Integer.MAX_VALUE) break;
					if(adj_matrix[s][e] > adj_matrix[s][k]+adj_matrix[k][e]) {
						adj_matrix[s][e] = adj_matrix[s][k]+adj_matrix[k][e];
						result[s][e] = result[s][k];
					}
				}
			}
		}
		 
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i == j) sb.append("- ");
				else sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

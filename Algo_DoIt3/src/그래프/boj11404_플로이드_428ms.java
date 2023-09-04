package 그래프;

import java.util.*;
import java.io.*;

public class boj11404_플로이드_428ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 도시 개수 2~100
		int m = Integer.parseInt(br.readLine()); // 버스 개수 1~100000
		
		int[][] distance = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i != j) distance[i][j] = Integer.MAX_VALUE;
			}
		}
				
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 1~100000
			
			distance[a][b] = Math.min(distance[a][b], c);
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) continue;
					
					if(distance[i][j] > distance[i][k]+distance[k][j]) {
						distance[i][j] = distance[i][k]+distance[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(distance[i][j] == Integer.MAX_VALUE) sb.append("0 ");
				else sb.append(distance[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

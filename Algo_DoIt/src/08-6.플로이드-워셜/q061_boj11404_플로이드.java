package Algorithm;

import java.util.*;
import java.io.*;

public class q061_boj11404 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 도시 100
		int m = Integer.parseInt(br.readLine()); // 버스 100000
		
		StringTokenizer st;
		
		int[][] distance = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			Arrays.fill(distance[i], 10000001);
		}
		
		for(int i=1; i<=n; i++) {
			distance[i][i] = 0;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()); // 시작 도시 
			int b = Integer.parseInt(st.nextToken()); // 도착 도시 
			int c = Integer.parseInt(st.nextToken()); // 비용 
			
			if(distance[a][b] > c) distance[a][b] = c;
		}
		
		for(int k=1; k<=n; k++) {
			for(int s=1; s<=n; s++) {
				for(int e=1; e<=n; e++) {
					if(distance[s][e] > distance[s][k]+distance[k][e]) {
						distance[s][e] = distance[s][k]+distance[k][e];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int s=1; s<=n; s++) {
			for(int e=1; e<=n; e++) {
				if(distance[s][e] == 10000001) {
					sb.append("0 ");
				} else {
					sb.append(distance[s][e]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

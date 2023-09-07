package f_그래프;

import java.util.*;
import java.io.*;

public class boj11404_플로이드_448ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 도시의 개수 2~100
		int m = Integer.parseInt(br.readLine()); // 버스의 개수 1~100000
		StringTokenizer st; 
		long[][] distance = new long[n+1][n+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=n; j++) {
				distance[i][j] = Long.MAX_VALUE;
			}
		}
		
		for(int i=1; i<=n; i++) {
			distance[i][i] = 0;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()); // 시작 도시 
			int b = Integer.parseInt(st.nextToken()); // 도착 도시 
			int c = Integer.parseInt(st.nextToken()); // 한번 타는데 필요한 비용 1~100000
			
			distance[a][b] = Math.min(distance[a][b], c);
		}
		
		for(int k=1; k<=n; k++) { // 중간  
			for(int i=1; i<=n; i++) { // 시작 
				if(i == k) continue; 
				for(int j=1; j<=n; j++) { // 끝 
					if(j==i || j==k) continue;  
					
					if(distance[i][k]!=Long.MAX_VALUE && distance[k][j]!=Long.MAX_VALUE && distance[i][j] > distance[i][k]+distance[k][j]) {
						distance[i][j] = distance[i][k]+distance[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(distance[i][j] == Long.MAX_VALUE) sb.append("0 ");
				else {
					sb.append(distance[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

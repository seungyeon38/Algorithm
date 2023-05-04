package class4_2;

import java.util.*;
import java.io.*;

public class boj1149_RGB거리_S1_140ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 집의 수 2~1000
		int[][] cost = new int[N][3]; 
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<N; i++) {
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
		}
		
		int result = Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2]));
		
		System.out.println(result);
	}
}

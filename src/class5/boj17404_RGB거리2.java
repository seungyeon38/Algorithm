package class5;

import java.util.*;
import java.io.*;

public class boj17404_RGB거리2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 2~1000
				
		int[][] cost = new int[N][3];
		StringTokenizer st; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] result = new int[N][3];
		int min = 1000001;
				
		for(int s=0; s<3; s++) { // 시작점 
			result = new int[N][3];
			
			for(int i=0; i<3; i++) {
				if(s == i) {
					result[0][i] = cost[0][i];
				} else {
					result[0][i] = 1001;
				}
			}
						
			for(int i=1; i<N; i++) {
				result[i][0] = Math.min(result[i-1][1], result[i-1][2])+cost[i][0];
				result[i][1] = Math.min(result[i-1][0], result[i-1][2])+cost[i][1];
				result[i][2] = Math.min(result[i-1][0], result[i-1][1])+cost[i][2];
			}
			
			for(int i=0; i<3; i++) {
				if(s != i) {
					min = Math.min(min, result[N-1][i]);
				}
			}
		}
		
		System.out.println(min);
	}
}



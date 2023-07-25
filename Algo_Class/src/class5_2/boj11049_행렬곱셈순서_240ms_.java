package class5_2;

import java.util.*;
import java.io.*;

public class boj11049_행렬곱셈순서_240ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 행렬의 개수 1~500
		int[] value = new int[N+1];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 행렬의 크기 1~500
			int c = Integer.parseInt(st.nextToken());
			value[i] = r;
			value[i+1] = c;
		}
				
		// 모든 행렬을 곱하는데 필요한 곱셈 연산 횟수의 최솟값 
		
		int[][] dp = new int[N][N];
		for(int i=1; i<N; i++) { // 곱셈 개수
			for(int j=0, e=N-i; j<e; j++) { // 시작점
				int temp = Integer.MAX_VALUE;
				for(int k=j, e2=j+i; k<e2; k++) { // 중간 지점
					temp = Math.min(temp, dp[j][k]+dp[k+1][j+i]+value[j]*value[k+1]*value[j+i+1]);
				} 
				
				dp[j][j+i] = temp; 
			}
		}
		
		System.out.println(dp[0][N-1]);
	}
}

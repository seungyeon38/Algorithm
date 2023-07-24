package class5_2;

import java.util.*;
import java.io.*;

public class boj7579_앱_164ms_ {
	static int N, M;
	static int[] m, c;
			
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 앱의 비활성화 문제를 스마트하게 해결하기 위한 프로그램 작성 
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~100
		M = Integer.parseInt(st.nextToken()); // 1~10000000
		
		m = new int[N+1]; // 메모리의 바이트 수 
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			m[i] = Integer.parseInt(st.nextToken()); // 1~10000000
		}
		
		c = new int[N+1]; // 비활성화 했을 경우의 비용 
		st = new StringTokenizer(br.readLine()); 
		for(int i=1; i<=N; i++) {
			c[i] = Integer.parseInt(st.nextToken()); // 0~100
		}
		
		// 필요한 메모리 M 바이트를 확보하기 위한 앱 비활성화의 최소의 비용 계산 
		// 비활성화 했을 경우의 비용의 합을 최소화하여 필요한 메모리 M 바이트를 확보하는 방법 
		
		// m에서 몇개 골라서 비활성화 
		// c의 합이 최소가 되도록 
		int[][] dp = new int[N+1][10001]; // [앱, 비용] // 최소 메모리 저장 
		for(int i=1; i<=N; i++) {
			int cost = c[i];
			for(int j=0; j<10001; j++) {
				if(cost <= j) {
					dp[i][j] = Math.max(dp[i-1][j-cost]+m[i], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		boolean done = false; 
		int result = 0; 
		for(int i=0; i<10001; i++) {
			for(int j=1; j<=N; j++) {
				if(dp[j][i] >= M) {
					done = true; 
					result = i;
					break; 
				}
			}
			
			if(done) break;
		}
		
		System.out.println(result);
	}
}

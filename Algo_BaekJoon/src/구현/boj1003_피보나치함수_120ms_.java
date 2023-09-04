package 구현;

import java.io.*;
import java.util.*;

public class boj1003_피보나치함수_120ms_ {
	static int[][] dp; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dp = new int[41][2]; // 0개수, 1개수 
		for(int i=0; i<41; i++) {
			for(int j=0; j<2; j++) {
				dp[i][j] = -1;
			}
		}
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1; 
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] result = fibo(n);
			
			sb.append(result[0]).append(" ").append(result[1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int[] fibo(int n) {
		if(dp[n][0] != -1 || dp[n][1] != -1) {
			return dp[n];
		}
		
		int[] arr1 = fibo(n-1);
		int[] arr2 = fibo(n-2);
		
		dp[n][0] = arr1[0]+arr2[0];
		dp[n][1] = arr1[1]+arr2[1];
		
		return dp[n];
	}
}

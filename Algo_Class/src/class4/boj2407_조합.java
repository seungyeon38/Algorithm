package class4;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class boj2407_조합 {
	static int n, m;
	static boolean[] selected; 
	static BigInteger result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 5~100
		m = Integer.parseInt(st.nextToken()); // 5~100 
		
		// n개 중에서 m개 뽑기. 순서 상관 X 
		BigInteger[][] dp = new BigInteger[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			dp[i][0] = BigInteger.valueOf(1);
			dp[i][i] = BigInteger.valueOf(1);
			
			for(int j=1; j<i; j++) {
				dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}

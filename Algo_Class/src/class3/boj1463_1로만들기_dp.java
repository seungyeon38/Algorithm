package class3;

import java.util.*;
import java.io.*;

public class boj1463_1로만들기_dp {
	static int[] dp; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1000000
		
		dp = new int[N+1];
		
		System.out.println(recur(N));
	}
	
	public static int recur(int n) {
		if(n == 1) return 0; 
		
		if(dp[n] == 0) {
			if(n%6 == 0) {
				dp[n] = Math.min(recur(n-1), Math.min(recur(n/3), recur(n/2)))+1;
			} else if(n%3 == 0) {
				dp[n] = Math.min(recur(n/3), recur(n-1))+1;
			} else if(n%2 == 0) {
				dp[n] = Math.min(recur(n/2), recur(n-1))+1;
			} else {
				dp[n] = recur(n-1)+1;
			}
		}
		
		return dp[n];
	}
}

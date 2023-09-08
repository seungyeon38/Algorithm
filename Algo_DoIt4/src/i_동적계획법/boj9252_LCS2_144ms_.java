package i_동적계획법;

import java.util.*;
import java.io.*;

public class boj9252_LCS2_144ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		int str1_length = str1.length;
		int str2_length = str2.length;
		
		int[][] dp = new int[str1_length+1][str2_length+1];
		
		for(int i=1; i<=str1_length; i++) {
			for(int j=1; j<=str2_length; j++) {
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		int p1 = str1_length;
		int p2 = str2_length;
		
		StringBuilder sb = new StringBuilder();
		
		while(p1>0 && p2>0) {
			if(dp[p1][p2] == dp[p1][p2-1]) {
				p2--;
			} else if(dp[p1][p2] == dp[p1-1][p2]) {
				p1--;
			} else {
				sb.append(str1[p1-1]);
				p1--; p2--; 
			}
		}
		
		System.out.println(dp[str1_length][str2_length]);
		System.out.println(sb.reverse());
	}
}

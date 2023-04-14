package 동적계획법;

import java.util.*;
import java.io.*; 

public class q090_boj9252_LCS2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray(); 
		
		int[][] dp = new int[str1.length+1][str2.length+1];
		
		for(int i=1; i<=str1.length; i++) {
			for(int j=1; j<=str2.length; j++) {
				if(str1[i-1] == str2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[str1.length][str2.length]);
		
		StringBuilder sb = new StringBuilder(); 
			
		int idx1 = str1.length;
		int idx2 = str2.length;
		
		while(idx1>0 && idx2>0) {
			if(str1[idx1-1] == str2[idx2-1]) {
				sb.append(str1[idx1-1]);
				idx1--;
				idx2--;
			} else {
				if(dp[idx1-1][idx2] > dp[idx1][idx2-1]) {
					idx1--;
				} else {
					idx2--;
				}
			}
		}
		
		sb = sb.reverse();
		System.out.println(sb.toString());
	}
}

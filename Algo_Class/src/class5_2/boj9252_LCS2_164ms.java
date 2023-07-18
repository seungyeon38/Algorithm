package class5_2;

import java.util.*;
import java.io.*;

public class boj9252_LCS2_164ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		int[][] result = new int[str1.length+1][str2.length+1];
		
		// 최장 공통 부분 수열 
		for(int i=0; i<str1.length; i++) {
			for(int j=0; j<str2.length; j++) {
				result[i+1][j+1] = Math.max(result[i][j+1], result[i+1][j]);
				
				if(str1[i] == str2[j]) {
					if(result[i+1][j+1] < result[i][j]+1) {
						result[i+1][j+1] = result[i][j]+1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();		

		int p1 = str1.length;
		int p2 = str2.length;
		while(p1>0 && p2>0) {
			if(result[p1][p2] == result[p1-1][p2]) {
				p1--;
			} else if(result[p1][p2] == result[p1][p2-1]) {
				p2--;
			} else {
				p1--; p2--; 
				sb.append(str1[p1]);
			}
		}
		
		System.out.println(result[str1.length][str2.length]);
		System.out.println(sb.reverse().toString());
	}
}

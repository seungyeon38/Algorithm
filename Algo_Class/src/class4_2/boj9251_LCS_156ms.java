package class4_2;

import java.util.*;
import java.io.*; 

public class boj9251_LCS_156ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int length1 = str1.length;
		int length2 = str2.length;
		
		int[][] result = new int[length1+1][length2+1];
		
		for(int i=1; i<=length1; i++) {
			for(int j=1; j<=length2; j++) {
				if(str1[i-1] == str2[j-1]) { // 같으면 
					result[i][j] = Math.max(Math.max(result[i][j-1], result[i-1][j]), result[i-1][j-1]+1);
				} else { // 다르면 
					result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
				}
			}
		}
		
		System.out.println(result[length1][length2]);
	}
}

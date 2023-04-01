package class4;

import java.util.*;
import java.io.*;

public class boj9251_LCS {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		
		int[][] result = new int[arr2.length][arr1.length];
		
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr1.length; j++) {
				if(arr1[j] == arr2[i]) { // 같을 때 
					if(i>=1 && j>=1) result[i][j] = result[i-1][j-1]+1;
					else result[i][j] = 1;
				} else { // 다를 때 
					if(i>=1 && j>=1) result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
					else if(i>=1) result[i][j] = result[i-1][j];
					else if(j>=1) result[i][j] = result[i][j-1];
				}
			}
		}
		
		System.out.println(result[arr2.length-1][arr1.length-1]);
	}
}	

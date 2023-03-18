package class5;

import java.util.*;
import java.io.*;

public class boj9252_LCS2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr1 = br.readLine().toCharArray(); // 1000
		char[] arr2 = br.readLine().toCharArray(); // 1000
		
		int[][] result = new int[arr1.length+1][arr2.length+1];
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=arr1.length; i++) {
			for(int j=1; j<=arr2.length; j++) {
				int max = Math.max(result[i-1][j], result[i][j-1]);
				
				if(arr1[i-1] == arr2[j-1]) {
					result[i][j] = Math.max(result[i-1][j-1]+1, max);
				} else {
					result[i][j] = max;
				}
			}
		}

		Stack<Character> stack = new Stack<Character>();
		int i = arr1.length;
		int j = arr2.length; 
		
		while(i>0 && j>0) {
			if(result[i][j] == result[i-1][j]) {
				i--; 
			} else if(result[i][j] == result[i][j-1]) {
				j--;
			} else {
				stack.push(arr1[i-1]);
				i--;
				j--;
			}
		}
		
		for(int c=0, size=stack.size(); c<size; c++) {
			sb.append(stack.pop());
		}
		
		System.out.println(result[arr1.length][arr2.length]);
		System.out.println(sb.toString());
	}
}

package DP;

import java.util.*;
import java.io.*;

public class boj1932_정수삼각형_280ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 삼각형의 크기 1~500
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j == 0) arr[i][j] += arr[i-1][j];
				else arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
			}
		}
		
		int result = 0;
		for(int i=0; i<n; i++) {
			result = Math.max(result, arr[n-1][i]);
		}
		
		System.out.println(result);
	}
}

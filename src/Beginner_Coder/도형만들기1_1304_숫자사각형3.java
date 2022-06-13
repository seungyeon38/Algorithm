package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기1_1304_숫자사각형3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int num = 1;
		
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[j][i] = num++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

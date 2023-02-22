package class4;

import java.util.*;
import java.io.*;

public class boj1932_정수삼각형 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 500
		
		int[][] arr = new int[n][n];
		
		StringTokenizer st; 
		
		arr[0][0] = Integer.parseInt(br.readLine()); 
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<=i; j++) {
				int j_1 = j-1; 
				
				if(j_1 >= 0) arr[i][j] = Integer.parseInt(st.nextToken()) + Math.max(arr[i-1][j-1], arr[i-1][j]); 
				else arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i-1][j]; 
			}
		}
		
		int max = 0; 
		
		for(int i=0; i<n; i++) {
			max = Math.max(max, arr[n-1][i]);
		}
		
		System.out.println(max);
	}
}

package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도형만들기2_1337_달팽이삼각형_다시 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 0
		// 4 1
		// 3 5 2
		// 2 0 6 3
		// 1 9 8 7 4
		// 0 9 8 7 6 5
		
		// 5 0 1 
		// 4 1 3
		
		// 0
		// 7 1
		// 6 8 2
		// 5 6 9 3
		// 4 5 7 0 4
		// 3 4 3 2 1 5
		// 2 1 0 9 8 7 6
		
		// 6 0 1
		// 5 1 3
		// 4
		
		int[][] result = new int[n][n];
//		for(int i=0; i<n; i++) {
//			Arrays.fill(result[i], -1);
//		}
		
		// n = 6
		
		// 00 11 22 33 44 55
		// 54 53 52 51 50
		// 40 30 20 10 
		// 21 32 43 
		// 42 41 
		// 31
		
		int d1_r = n-1;
		int d2_c = 0;
		int d3_r = 1;
		int sr = 0; 
		int sc = 0;
		
		int num = 0;
		for(int i=0, size=n*(n+1)/2; i<size;) {
			while(sr <= d1_r) {
				sr++;
				sc++;
				if(num == 10) num = 0;
				result[sr][sc] = num++;
				i++;
			}
			sr--;
			sc--;
			sc--;
			while(sc >= d2_c) {
				if(num == 10) num = 0;
				result[sr][sc--] = num++;
				i++;
			}
			sc++;
			sr--;
			while(sr >= d3_r) {
				if(num == 10) num = 0;
				result[sr--][sc] = num++;
				i++;
			}
			sr++;
			sr++;
			sc++;
			
			d1_r--;
			d2_c++;
			d3_r += 2;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}

package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 도형만들기2_1331_문자마름모_다시 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 03 12 21 
		// 30 41 52 
		// 63 54 45 
		// 36 25 14 
		
		// 13 22 
		// 31 42 
		// 53 44 
		// 35 24
		
		// 23
		// 32
		// 43
		// 34
		
		// 33
		
		int n = 2*N-1;
		char[][] arr = new char[n][n];
		int alpha = 'A';
		int cnt;
		int cur_r = 0; 
		int cur_c = N-1;
		for(int i=N; i>0; i--) {
			cnt = i-1;
			for(int j=0; j<cnt; j++) {
				arr[cur_r++][cur_c--] = (char)alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
			for(int j=0; j<cnt; j++) {
				arr[cur_r++][cur_c++] = (char)alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
			for(int j=0; j<cnt; j++) {
				arr[cur_r--][cur_c++] = (char)alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
			for(int j=0; j<cnt; j++) {
				arr[cur_r--][cur_c--] = (char)alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
			cur_r++;
		}
		
//		      A
//		    B M L
//		  C N U T K
//		D O V Y X S J
//	  D D O V Y X S J D
//		D O V Y X S J
//		  E P W R I
//		    F Q H
//		      G
		
		arr[N-1][N-1] = (char)alpha;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == '\0') {
					sb.append("  ");
				} else {
					sb.append(arr[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

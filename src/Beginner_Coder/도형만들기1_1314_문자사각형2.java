package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기1_1314_문자사각형2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int c = 'A';
		int max = 'Z'+1;
		
		char[][] c_arr = new char[n][n];
				
		for(int i=0; i<n; i++) {
			if(i%2 == 0) {
				for(int j=0; j<n; j++) {
					if(c == max) c = 'A';
					c_arr[j][i] = (char)c++;
				}				
			} else {
				for(int j=n-1; j>=0; j--) {
					if(c == max) c = 'A';
					c_arr[j][i] = (char)c++;
				}								
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(c_arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

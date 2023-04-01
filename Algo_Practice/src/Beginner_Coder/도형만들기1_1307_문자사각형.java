package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기1_1307_문자사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[][] c_arr = new char[n][n];
		char c = 'A';
		int max = 'Z'+1;
		for(int i=n-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				if((int)c == max) c = 'A';
				c_arr[j][i] = (char)c++;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(c_arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

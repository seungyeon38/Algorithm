package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 도형만들기1_1338_문자삼각형1 {
	public static void main(String[] args) throws IOException {
//		        A	8 1 
//		      B F	6 2 
//		    C G J	4 3 
//		  D H K M   2 4 
//		E I L N O	0 5 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int c = 'A';
		int max = 'Z'+1;

//		1,5	2,4	3,3	4,2	5,1 
//		2,5 3,4 4,3 5,2 
		char[][] c_arr = new char[n][n];
		for(int i=0; i<n; i++) Arrays.fill(c_arr[i], '0');
		int n_1 = n-1; 
		for(int i=n-1, size=2*n_1; i<=size; i++) { // 합
			for(int j=i+1-n, k=i-j; j<n; j++, k--) {
				if(c == max) c = 'A';
				c_arr[j][k] = (char)c++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(c_arr[i][j] == '0') sb.append("  ");
				else sb.append(c_arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

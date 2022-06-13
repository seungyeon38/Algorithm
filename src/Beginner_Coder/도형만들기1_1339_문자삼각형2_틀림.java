package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 도형만들기1_1339_문자삼각형2_틀림 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		if(n<1 || n>100 || n%2==0) System.out.println("INPUT ERROR");
		else {
			int c = 'A';
			int max = 'Z'+1;
			int col;
			int c_size = n/2+1;
			char[][] c_arr = new char[n][c_size];
			for(int i=0, size=n/2; i<=size; i++) {
				col = size-i;
				for(int j=size-i, size1=j+2*i+1; j<size1; j++) {
//					if(c == max) {
//						System.out.println("INPUT ERROR");
//						System.exit(0);
//					}
					if(c == max) c = 'A';
					c_arr[j][col] = (char)c++;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; i++) {
				for(int j=0; j<c_size; j++) {
					sb.append(c_arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());			
		}
	}
}

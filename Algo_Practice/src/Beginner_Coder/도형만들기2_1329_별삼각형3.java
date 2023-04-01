package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도형만들기2_1329_별삼각형3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// n = 7
		// *			0	0 1
		//  ***			1	1 3
		//   *****		2	2 5
		//    *******	3	3 7
		//   *****		4	2 5
		//  ***			5	1 3
		// *			6	0 1
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		if(n<0 || n>100 || n%2==0) {
			System.out.println("INPUT ERROR!");
		} else {
			int half = n/2;
			int b;
			int m;
			for(int i=0; i<n; i++) {
				if(i<half) b = i;
				else b = n-1-i;
				
				m = 2*b+1;
				
				for(int j=0; j<b; j++) {
					sb.append(' ');
				}
				for(int j=0; j<m; j++) {
					sb.append('*');
				}
				sb.append('\n');
			}
			
			System.out.println(sb.toString());
		}
	}
}

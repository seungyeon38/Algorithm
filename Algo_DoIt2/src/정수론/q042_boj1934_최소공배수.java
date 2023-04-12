package 정수론;

import java.util.*;
import java.io.*;

public class q042_boj1934_최소공배수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 1~1000
		
		StringBuilder sb = new StringBuilder(); 
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken()); // 1~45000
			int B = Integer.parseInt(st.nextToken()); // 1~45000
		
			if(A > B) {
				int temp = A;
				A = B; 
				B = temp; 
			}
			
			int gcd = A;
			int remainder = B%A;
			
			while(remainder > 0) {
				int temp = gcd; 
				gcd = remainder; 
				remainder = temp%remainder; 
			}
			
			int quot_A = A/gcd; 
			int quot_B = B/gcd; 

			sb.append(quot_A*quot_B*gcd).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

package Algorithm;

import java.util.*;
import java.io.*;

public class q042_boj1934 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 1000
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 45000
			int B = Integer.parseInt(st.nextToken()); // 45000
			
			sb.append(A*B/gcd(A, B)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int gcd(int n1, int n2) {
		while(n1!=0 && n2!=0) {
			if(n1 > n2) {
				n1 %= n2; 
			} else {
				n2 %= n1;
			}
		}
		
		if(n1 != 0) return n1; 
		else return n2;
	}
}

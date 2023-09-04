package Algorithm;

import java.util.*;
import java.io.*;

public class q043_boj1850 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A_n = Long.parseLong(st.nextToken());
		long B_n = Long.parseLong(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		long gcd = A_n > B_n ? gcd(B_n, A_n) : gcd(A_n, B_n);
		
		for(int i=0; i<gcd; i++) {
			sb.append("1");
		}
		
		System.out.println(sb.toString());
	}
	
	public static long gcd(long n1, long n2) {
		if(n1 == 0) return n2;
		else return gcd(n2%n1, n1);
	}
}

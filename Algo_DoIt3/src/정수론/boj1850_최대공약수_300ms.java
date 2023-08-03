package 정수론;

import java.util.*;
import java.io.*;

public class boj1850_최대공약수_300ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A_digit = Long.parseLong(st.nextToken()); // 자릿수 
		long B_digit = Long.parseLong(st.nextToken());
		long result = 0;
		
		if(A_digit < B_digit) {
			result = gcd(A_digit, B_digit);
		} else {
			result = gcd(B_digit, A_digit);
		}
		
		StringBuilder sb = new StringBuilder();
		for(long i=0; i<result; i++) {
			sb.append("1");
		}
		
		System.out.println(sb.toString());
	}
	
	public static long gcd(long n1, long n2) { // 자릿수 
		// n1 < n2
		if(n1 == 0) {
			return n2;
		}
		else return gcd(n2%n1, n1);
	}
}

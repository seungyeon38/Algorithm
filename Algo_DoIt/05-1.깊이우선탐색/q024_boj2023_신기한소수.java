package Algorithm;

import java.util.*;
import java.io.*;

public class q024_boj2023 {
	public static StringBuilder sb = new StringBuilder();
	public static int max_digit;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		max_digit = Integer.parseInt(br.readLine()); // 8
		
		for(int i=1; i<10; i++) {
			recur(i, 1);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void recur(int n, int digit) {
		if(digit == max_digit) {
			if(isPrime(n)) {
				sb.append(n).append("\n");
			}
			return; 
		}
		
		if(isPrime(n)) {
			for(int i=0; i<10; i++) {
				int num = n*10 + i;
				recur(num, digit+1);
			}
		}
	}
	
	public static boolean isPrime(int n) {
		 if(n == 0 || n == 1) return false; 
		 if(n == 2) return true; 

		 boolean result = true; 
		 int sqrt_n = (int)Math.sqrt(n);
		 
		 for(int i=2; i<= sqrt_n; i++) {
			 if(n%i == 0) {
				 result = false; 
				 break; 
			 }
		 }
		 
		 return result;
	}
}

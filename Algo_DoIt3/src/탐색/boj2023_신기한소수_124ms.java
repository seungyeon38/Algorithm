package 탐색;

import java.util.*;
import java.io.*;

public class boj2023_신기한소수_124ms {
	static int N;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 자리수 1~8 
		sb = new StringBuilder();
		
		calc(1, 2);
		calc(1, 3);
		calc(1, 5);
		calc(1, 7);
		
		System.out.println(sb.toString());
	}
	
	public static void calc(int digit, int cur_n) { // 자릿수, 현재
		if(digit == N) {
			sb.append(cur_n).append("\n");
			return; 
		}
		
		// cur_n은 이미 소수 
		for(int i=1; i<=9; i+=2) { // 맨 뒷자리 0, 2, 4, 6, 8 X
			int num = cur_n*10 + i;
			// num이 소수인지 따지기 
			if(isPrime(num)) calc(digit+1, num);
		}
	}
	
	public static boolean isPrime(int n) {
		int max = (int)Math.sqrt(n);
		
		if(n == 1) return false; 
		for(int i=2; i<=max; i++) {
			if(n%i == 0) {
				return false; 
			}
		}
		
		return true; 
	}
}

package 자료구조;

import java.util.*;
import java.io.*;

public class q024_boj2023_신기한소수 {
	static int N; 
	static StringBuilder sb; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 1~8
		sb = new StringBuilder();
		
		dfs(0, 0);
		
		System.out.println(sb.toString());
	}
	
	public static boolean isPrime(int n) {
		int sqrt = (int)Math.sqrt(n);
		
		if(n == 1) return false; 
		
		for(int i=2; i<=sqrt; i++) {
			if(n%i == 0) return false; 
		}
		
		return true;
	}
	
	public static void dfs(int n, int digit) {
		if(digit == N) { 
			sb.append(n).append("\n");
			return; 
		}
		
		for(int i=1; i<10; i++) {
			int next_n = n*10 + i;
			if(isPrime(next_n)) {
				dfs(next_n, digit+1);
			}
		}
	}
}

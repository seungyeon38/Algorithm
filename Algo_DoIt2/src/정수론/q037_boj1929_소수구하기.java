package 정수론;

import java.util.*;
import java.io.*;

public class q037_boj1929_소수구하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int M = Integer.parseInt(st.nextToken()); // 1~1000000
		int N = Integer.parseInt(st.nextToken()); // 1~1000000
		
		StringBuilder sb = new StringBuilder();
		
		// M이상 N이하의 소수
		for(int i=M; i<=N; i++) {
			if(isPrime(i)) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean isPrime(int n) {
		if(n == 1) return false; 
		
		for(int i=2, size=(int)Math.sqrt(n); i<=size; i++) {
			if(n%i == 0) return false; 
		}
		
		return true; 
	}
}

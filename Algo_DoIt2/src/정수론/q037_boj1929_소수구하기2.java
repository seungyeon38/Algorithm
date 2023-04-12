package 정수론;

import java.util.*;
import java.io.*;

public class q037_boj1929_소수구하기2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int M = Integer.parseInt(st.nextToken()); // 1~1000000
		int N = Integer.parseInt(st.nextToken()); // 1~1000000
		
		StringBuilder sb = new StringBuilder();
		
		boolean[] isNotPrime = new boolean[N+1];
		
		isNotPrime[1] = true; 
		
		for(int i=2, size=(int)Math.sqrt(N); i<=size; i++) {
			if(!isNotPrime[i]) {
				for(int n=i*2; n<=N; n+=i) {
					isNotPrime[n] = true; 
				}
			}
		}
		
		// M이상 N이하의 소수
		for(int i=M; i<=N; i++) {
			if(!isNotPrime[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}

package e_정수론;

import java.util.*;
import java.io.*;

public class boj1929_소수구하기_280ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // 1~N
		int N = Integer.parseInt(st.nextToken()); // M~1000000
		
		boolean[] isNotPrime = new boolean[N+1];
		isNotPrime[1] = true; 
		
		int max = (int)Math.sqrt(N);
		
		for(int i=2; i<=max; i++) {
			for(int j=i*2; j<=N; j+=i) {
				isNotPrime[j] = true; 
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=M; i<=N; i++) {
			if(!isNotPrime[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

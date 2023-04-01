package Algorithm;

import java.util.*;
import java.io.*;

public class q037_boj1929 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // 1000000
		int N = Integer.parseInt(st.nextToken()); // 1000000
		
		int[] n_arr = new int[N+1];
		
		for(int i=2; i<=N; i++) { // M부터 N까지의 수만 초기화
			n_arr[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=2; i<=Math.sqrt(N); i++) { // 가장 작은 소수인 2부터 최고 수의 제곱근까지 
			if(n_arr[i] == 0) continue;
			
			for(int num = 2*i; num<=N; num+=i) { // 배수 지우기 
				n_arr[num] = 0;
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(n_arr[i] != 0) sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

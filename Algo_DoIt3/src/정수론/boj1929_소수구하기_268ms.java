package 정수론;

import java.util.*;
import java.io.*;

public class boj1929_소수구하기_268ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 1~1000000
		int N = Integer.parseInt(st.nextToken());
		
		int max = (int)Math.sqrt(N);
		boolean[] nums = new boolean[N+1]; // index가 수 
		nums[1] = true; 
		
		for(int i=2; i<=max; i++) {
			for(int j=i*2; j<=N; j+=i) {
				nums[j] = true; 
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=M; i<=N; i++) {
			if(!nums[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}

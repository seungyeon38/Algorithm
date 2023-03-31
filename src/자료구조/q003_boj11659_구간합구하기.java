package 자료구조;

import java.util.*;
import java.io.*;

public class q003_boj11659_구간합구하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 1~100000
		int M = Integer.parseInt(st.nextToken()); // 1~100000
		
		st = new StringTokenizer(br.readLine());
		int[] sum = new int[N+1];
		sum[1] = Integer.parseInt(st.nextToken());
		
		for(int i=2; i<=N; i++) {
			sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(sum[e]-sum[s-1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

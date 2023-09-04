package 자료구조;

import java.util.*;
import java.io.*;

public class boj11659_구간합구하기4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수의 개수 1~100000
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 1~100000 
		int[] sum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sum[i] += sum[i-1] + Integer.parseInt(st.nextToken()); // 수는 1~1000
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int sp = Integer.parseInt(st.nextToken());
			int ep = Integer.parseInt(st.nextToken());
			
			sb.append(sum[ep]-sum[sp-1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

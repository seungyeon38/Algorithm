package a_자료구조;

import java.util.*;
import java.io.*;

public class boj11659_구간합구하기4_664ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수의 개수 1~100000
		int M = Integer.parseInt(st.nextToken()); // 합 구하는 횟수 1~100000 
		
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N+1];
		for(int i=1; i<=N; i++) {
			nums[i] += nums[i-1] + Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(nums[j]-nums[i-1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

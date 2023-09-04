package a_자료구조;

import java.util.*;
import java.io.*;

public class boj10986_나머지합_504ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~1000000
		int M = Integer.parseInt(st.nextToken()); // 1~1000
		
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N+1];
		for(int i=1; i<=N; i++) {
			nums[i] += nums[i-1]+Integer.parseInt(st.nextToken());
			nums[i] %= M;
		}
		
		long result = 0;
		
		int[] cnt = new int[M];
		
		for(int i=1; i<=N; i++) {
			if(nums[i] == 0) result++;
			cnt[nums[i]]++;
		}

		for(int i=0; i<M; i++) {
			result += (long)cnt[i]*(cnt[i]-1)/2;
		}
		
		System.out.println(result);
	}
}

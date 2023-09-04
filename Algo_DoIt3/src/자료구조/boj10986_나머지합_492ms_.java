package 자료구조;

import java.util.*;
import java.io.*;

public class boj10986_나머지합_492ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~1000000
		int M = Integer.parseInt(st.nextToken()); // 1~1000
		
		int[] sum = new int[N+1]; // 구간합 
		long[] remainder = new long[M]; // 나머지 개수 
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sum[i] = (sum[i-1]+Integer.parseInt(st.nextToken()))%M;
			remainder[sum[i]]++;
		}
		
		long result = remainder[0];
		for(int i=0; i<M; i++) {
			result += (remainder[i]*(remainder[i]-1))/2;
		}
	
		System.out.println(result);
	}
}

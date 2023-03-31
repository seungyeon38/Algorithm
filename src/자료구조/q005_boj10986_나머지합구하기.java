package 자료구조;

import java.util.*;
import java.io.*;

public class q005_boj10986_나머지합구하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 1~1000000
		int M = Integer.parseInt(st.nextToken()); // 2~1000
		
		long result = 0;
		int[] sum = new int[N]; // 1~index까지의 구간합
		long[] remainder = new long[M]; // M으로 나누었을 때 나머지로 나오는 개수 
		st = new StringTokenizer(br.readLine());

		sum[0] = Integer.parseInt(st.nextToken())%M;
		if(sum[0] == 0) result++;
		remainder[sum[0]]++;

		for(int i=1; i<N; i++) {
			sum[i] = (sum[i-1]+Integer.parseInt(st.nextToken()))%M;
			if(sum[i] == 0) result++;
			remainder[sum[i]]++;
		}
		
		for(int i=0; i<M; i++) {
			if(remainder[i] > 0) {
				result += remainder[i]*(remainder[i]-1)/2;
			}
		}
		
		System.out.println(result);
	}
}

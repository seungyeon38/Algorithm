package 그리디;

import java.util.*;
import java.io.*;

public class boj11047_동전0_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~10
		int K = Integer.parseInt(st.nextToken()); // 1~100000000
		
		int[] A = new int[N]; // 동전의 가치 
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		for(int i=N-1; i>=0; i--) {
			if(A[i] > K) continue; 
			
			int cnt = K/A[i];
			result += cnt;
			K -= cnt*A[i];
		}
		
		System.out.println(result);
	}
}

package 그리디;

import java.util.*;
import java.io.*;

public class q032_boj11047_동전0 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); // 동전 종류 1~10
		int K = Integer.parseInt(st.nextToken()); // 가치 합 1~100000000
		int[] price = new int[N]; // 오름차순 
		for(int i=0; i<N; i++) {
			price[i] = Integer.parseInt(br.readLine()); // 1~1000000
		}
		
		int result = 0; 
		for(int i=N-1; i>=0; i--) {
			result += K/price[i];
			K %= price[i];
			
			if(K == 0) break; 
		}
		
		System.out.println(result);
	}
}

package 구현;

import java.util.*;
import java.io.*;

public class boj1421_나무꾼이다솜_144ms_실수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 가지고 있는 나무 개수 1~50
		int C = Integer.parseInt(st.nextToken()); // 나무 자를 때 비용 1~10000
		int W = Integer.parseInt(st.nextToken()); // 나무 한 단위의 가격 1~10000
		
		// 벌 수 있는 가장 큰 돈 구하기 
		int[] length = new int[N]; // 나무의 길이 1~10000
		int length_max = 0;
		for(int i=0; i<N; i++) {
			length[i] = Integer.parseInt(br.readLine());
			length_max = Math.max(length[i], length_max);
		}
		
		long max = 0;

		for(int i=1; i<=length_max; i++) { // 나무를 자를 길이 단위
			long temp = 0;
			for(int l : length) {
				if(l < i) continue; 
				int piece_cnt = l/i; // 조각 수 
				int cut_cnt = 0; // 자르는 횟수 

				if(l%i == 0) cut_cnt = piece_cnt-1; 
				else cut_cnt = piece_cnt;	
				
				long result = piece_cnt*i*W - cut_cnt*C;
				if(result > 0) temp += result;
			}

			if(temp > max) max = temp;
		}

		System.out.println(max);
	}
}

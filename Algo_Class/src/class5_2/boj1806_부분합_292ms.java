package class5_2;

import java.util.*;
import java.io.*;

public class boj1806_부분합_292ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수열 길이 
		int S = Integer.parseInt(st.nextToken()); // 합 
		
		int[] num_sum = new int[N+1]; // index까지의 합 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num_sum[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연속된 수들의 부분합이 S 이상인 것 중 길이 가장 짧은 것 
		int sp = 0;
		int ep = 0;
		int cur_sum = num_sum[0]; // 현재 부분합 
		int min_length = 100001; // 길이  
		
		while(ep < N) {
			// S보다 크면 길이 최소인지 확인
			if(cur_sum >= S) { // S보다 크면 sp++; 
				min_length = Math.min(min_length, ep-sp+1);
				cur_sum -= num_sum[sp];
				sp++;
			} else { // S보다 작으면 ep++;
				ep++;
				cur_sum += num_sum[ep];
			}
		}
		
		if(min_length < 100001) {
			System.out.println(min_length);
		} else System.out.println("0");
	}
}

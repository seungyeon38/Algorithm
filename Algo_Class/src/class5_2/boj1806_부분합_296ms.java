package class5_2;

import java.util.*;
import java.io.*;

public class boj1806_부분합_296ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수열의 길이 10~100000
		int S = Integer.parseInt(st.nextToken()); // 합 0~100000000
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 합이 S이상인 것 중 가장 짧은 것 
		int sp = 0; 
		int ep = 0;
		int temp_sum = nums[0]; 
		int result = 100001; 
		
		while(ep < N) {
			// 작으면 ep++;
			// 크면 sp++;
			// 같으면 sp++; ep++; 
			if(temp_sum < S) {
				if(ep == N-1) break;
				ep++;
				temp_sum += nums[ep];
			} else if(temp_sum > S) {
				result = Math.min(ep-sp+1, result);
				temp_sum -= nums[sp];
				sp++;
			} else {
				result = Math.min(ep-sp+1, result);
				temp_sum -= nums[sp];
				sp++;
				if(ep == N-1) break;
				ep++;
				temp_sum += nums[ep];
			}
		}
		
		if(result == 100001) System.out.println("0");
		else System.out.println(result);
	}
}

package 조합;

import java.util.*;
import java.io.*;

public class q080_boj13251_조약돌꺼내기 {
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine()); // 색상 1~50
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[M+1]; // 각 색상별 조약돌 개수 1~50
		int total = 0;
		for(int i=1; i<=M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			total += nums[i];
		}
		
		int K = Integer.parseInt(br.readLine()); // 뽑는 조약돌 개수 
		double result = 0;
		
		for(int i=1; i<=M; i++) {
			if(nums[i] < K) continue; 
			
			double p = 1.0;
			for(int j=0; j<K; j++) {
				p *= (double)(nums[i]-j)/(total-j);
			}
			
			result += p;
		}
		
		System.out.println(result);
	}
}

package day1;

import java.util.*;
import java.io.*;

public class boj15486_퇴사2_G5_852ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~1500000
		
		int[][] consults = new int[N][2]; // [시간, 금액]
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			consults[i][0] = Integer.parseInt(st.nextToken()); // 상담 기간 1~50
			consults[i][1] = Integer.parseInt(st.nextToken()); // 상담 금액 1~1000
		}
		
		int[] results = new int[N+1];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			max = Math.max(max, results[i]);
			
			int next = i+consults[i][0];
			
			if(next <= N) {
				results[next] = Math.max(results[next], max+consults[i][1]);
			}
		}
		
		max = Math.max(max, results[N]);
		
		System.out.println(max);
	}
}

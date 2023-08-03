package 탐색;

import java.util.*;
import java.io.*;

public class boj2343_기타레슨 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); // 강의의 수 1~100000
		int M = Integer.parseInt(st.nextToken()); // 블루레이 수 
		
		st = new StringTokenizer(br.readLine());
		int[] lectures = new int[N]; // 강의의 길이 
		int max = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, lectures[i]);
			sum += lectures[i];
		}
		
		// 블루레이의 크기 
		// 최솟값 : 강의 길이 최댓값 
		// 최댓값 : sum 
		int sp = max; 
		int ep = sum;
		while(sp <= ep) {
			int mid = (sp+ep)/2; // 블루레이의 크기 
			
			int temp_sum = 0;
			int cnt = 0;
			for(int i=0; i<N; i++) {
				temp_sum += lectures[i]; // 강의 길이 합 
				if(temp_sum > mid) {
					cnt++;
					i--;
					temp_sum = 0;
				} else if(temp_sum == mid) {
					cnt++;
					temp_sum = 0;
				}
			}
			if(temp_sum != 0) cnt++; 
			
			if(cnt > M) { // 블루레이 크기가 커져야 함. 
				sp = mid+1;
			} else { // 블루레이 크기가 작아져야 함. 
				ep = mid-1;
			}
		}
		
		System.out.println(sp);
	}
}

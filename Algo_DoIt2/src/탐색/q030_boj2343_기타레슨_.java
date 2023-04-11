package 탐색;

import java.util.*;
import java.io.*;

public class q030_boj2343_기타레슨_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 레슨 수 1~100000
		int M = Integer.parseInt(st.nextToken()); 
		
		int[] lectures = new int[N];
		st = new StringTokenizer(br.readLine()); 
		int max = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, lectures[i]);
			sum += lectures[i];
		}
				
		// 이진탐색 : 블루레이 크기  
		// 최소: 가장 긴 기타 레슨 or 다 더해서 개수로 나누기 중 큰거 
		int s = max;
		int e = sum;
		
		while(s <= e) {
			int mid = (s+e)/2; // 블루레이 크기 
		
			// mid가 블루레이 크기일 때 필요한 블루레이의 개수 구하기 
			int temp_sum = 0; // 레슨 길이 합
			int temp_cnt = 0; // 블루레이 개수 
			for(int n=0; n<N; n++) {
				if(temp_sum + lectures[n] > mid) {
					temp_sum = 0;
					temp_cnt++;
				}
				
				temp_sum += lectures[n];
			}
			
			if(temp_sum > 0) temp_cnt++;
			
			// 결론 
			if(temp_cnt <= M) { // 블루레이 개수랑 같거나 보다 작으면 -> 블루레이 크기 
				e = mid-1;
			} else {
				s = mid+1; 
			} 
		}
		
		System.out.println(s);
	}
}

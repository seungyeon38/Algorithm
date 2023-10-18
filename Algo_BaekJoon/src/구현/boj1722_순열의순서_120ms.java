package 구현;

import java.util.*;
import java.io.*;

public class boj1722_순열의순서_120ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~20
		long[] digit_cnt = new long[N]; // 자릿수 별 카운트 
		digit_cnt[0] = 1;
		for(int i=1; i<N; i++) {
			digit_cnt[i] = digit_cnt[i-1]*i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int type = Integer.parseInt(st.nextToken());
		
		if(type == 1) {
			long k = Long.parseLong(st.nextToken()); // k번째 수열 구하기 
			boolean[] select = new boolean[N+1];
			int[] num_list = new int[N];
			for(int i=N-1; i>=0; i--) { // 자릿수 수 구하기 
				int cnt = 1;
				while(k > digit_cnt[i]) {
					cnt++;
					k -= digit_cnt[i];
				}
				
				for(int j=1; j<=N; j++) {
					if(!select[j]) {
						cnt--;
						if(cnt == 0) {
							select[j] = true; 
							num_list[i] = j;
							break; 
						}
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=N-1; i>=0; i--) {
				sb.append(num_list[i]).append(" ");
			}
			System.out.println(sb.toString());
			
		} else { 
			int[] num_list = new int[N+1]; // 해당 순열이 몇번째 순열인지 구하기 
			for(int i=1; i<=N; i++) {
				num_list[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] select = new boolean[N+1];
			long result = 1;
			
			for(int i=1; i<=N; i++) { // 자릿수 별로 
				int cnt = 0;
				for(int j=1; j<=N; j++) { // 몇 번째 숫자인지 카운트 
					if(select[j]) continue; 
					if(num_list[i] == j) {
						select[j] = true; 
						break;
					}
					
					cnt++;
				}
				
				result += digit_cnt[N-i]*cnt;
			}
			
			System.out.println(result);
		}
	}
}

package Practice;

import java.util.*;
import java.io.*;

public class boj2776_암기왕_1872ms_이분탐색 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine()); // 1~1000000
			
			int[] nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			int M = Integer.parseInt(br.readLine()); // 1~1000000
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				int n = Integer.parseInt(st.nextToken()); 
				
				int lp = 0;
				int rp = N-1; 
				boolean find = false; 
				
				while(lp <= rp) {
					int mid = (lp+rp)/2;
					
					if(nums[mid] < n) {
						lp = mid+1;
					} else if(nums[mid] > n) {
						rp = mid-1;
					} else {
						find = true; 
						break;
					}
				}
				
				if(find) sb.append("1\n");
				else sb.append("0\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}

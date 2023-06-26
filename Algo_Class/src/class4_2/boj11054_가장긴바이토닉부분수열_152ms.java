package class4_2;

import java.util.*;
import java.io.*; 

public class boj11054_가장긴바이토닉부분수열_152ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수열 크기 1~1000
		int[] nums = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] f = new int[N+1];
		int[] b = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=i-1; j>=0; j--) {
				if(nums[j]<nums[i] && f[j]+1>f[i]) {
					f[i] = f[j]+1;
				}
			}
		}
		
		for(int i=N; i>0; i--) {
			for(int j=i+1; j<=N; j++) {
				if(nums[j]<nums[i] && b[j]+1>b[i]) {
					b[i] = b[j]+1;
				}
			}
		}
		
		int max = 0; 
		
		for(int i=1; i<=N; i++) { // 기준 수 인덱스 
			max = Math.max(f[i]+b[i], max);
		}
		
		System.out.println(max);
	}
}

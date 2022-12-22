package Algorithm;

import java.io.*;
import java.util.*;

public class q008_boj1253 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int result = 0;
				
		for(int k=0; k<N; k++) {
			long n = arr[k];
			int sp = 0;
			int fp = N-1;
			
			while(sp < fp) {
				if(arr[sp]+arr[fp] == n) {
					if(sp != k && fp != k) {
						result++;
						break;
					} else if(sp == k) {
						sp++;
					} else if(fp == k) {
						fp--;
					}
				} else if(arr[sp]+arr[fp] > n) {
					fp--;
				} else if(arr[sp]+arr[fp] < n) {
					sp++;
				}
			}
		}
		
		System.out.println(result);
	}
}

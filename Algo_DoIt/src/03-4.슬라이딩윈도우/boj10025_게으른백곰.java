package Algorithm;

import java.util.*;
import java.io.*;

public class boj10025 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 얼음 양동이 개수 100000 
		int K = Integer.parseInt(st.nextToken()); // 좌우로 K 2000000
		
		int[] arr = new int[1000001];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			int n = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			arr[idx] = n;
		}
		
		long max = 0; 
		long temp = 0;
		
		int n = 2*K+1;
		for(int i=0; i<n && i<=1000000; i++) {
			temp += arr[i];
		}
		
		max = temp;
		
		for(int i=0, j=n; j <= 1000000; i++, j++) {
			temp -= arr[i];
			temp += arr[j];
			if(temp > max) {
				max = temp;
			}
		}
		
//		int idx_max = 1000000-n;
//		
//		for(int i=0; i<=idx_max; i++) {
//			int nxt = i+n;
//			if(nxt < 1000000) {
//				temp -= arr[i];
//				temp += arr[nxt];
//				
//				if(temp > max) {
//					max = temp;
//				}
//			}
//		}
		
		System.out.println(max);
	}
}

package 자료구조;

import java.util.*;
import java.io.*;

public class boj1253_좋다_184ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // N개의 수 1~2000
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // -1000000000~1000000000
		}
		
		Arrays.sort(A);
		
		// 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있으면 
		int result = 0;
		for(int i=0; i<N; i++) {
			int sp = 0;
			int ep = N-1; 
			
			while(sp < ep) {
				if(sp == i) {
					sp++;
					continue; 
				}
				if(ep == i) {
					ep--;
					continue; 
				}
				
				int sum = A[sp]+A[ep];
				
				if(sum < A[i]) {
					sp++;
				} else if(sum > A[i]) {
					ep--;
				} else {
					result++;
					break;
				}
			}
		}
		
		System.out.println(result);
	}
}

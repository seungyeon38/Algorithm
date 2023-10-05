package 이진탐색;

import java.util.*;
import java.io.*;

public class boj1920_수찾기_612ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~100000
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
	
		int M = Integer.parseInt(br.readLine()); // 1~100000
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int find = Integer.parseInt(st.nextToken());
			int sp = 0;
			int ep = N-1;
			boolean exist = false; 
			
			while(sp <= ep) {
				int mid = (sp+ep)/2;
				
				if(A[mid] == find) {
					exist = true; 
					break; 
				} else if(A[mid] > find) {
					ep = mid-1;
				} else {
					sp = mid+1;
				}
			}
			
			if(exist) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb.toString());
	}
}

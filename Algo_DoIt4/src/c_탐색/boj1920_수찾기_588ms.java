package c_탐색;

import java.util.*;
import java.io.*;

public class boj1920_수찾기_588ms {
	static int N;
	static int[] A;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 1~100000
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine()); // 1~100000
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		for(int m=0; m<M; m++) {
			int find_n = Integer.parseInt(st.nextToken());
			
			sb.append(find(find_n)?"1":"0").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean find(int n) {
		int sp = 0;
		int ep = N-1; 
		
		while(sp <= ep) {
			int mid = (sp+ep)/2;
			if(A[mid] < n){ // 찾는 수가 더 크면 
				sp = mid+1;
			} else if(A[mid] > n) { // 찾는 수가 더 작으면 
				ep = mid-1;
			} else {
				return true; 
			}
		}
		
		return false; 
	}
}

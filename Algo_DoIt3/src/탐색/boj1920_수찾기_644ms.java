package 탐색;

import java.util.*;
import java.io.*;

public class boj1920_수찾기_644ms {
	static int N; 
	static int[] A;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 1~100000
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine()); // 1~100000
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int n = Integer.parseInt(st.nextToken()); // 찾아야하는 수 
			sb.append(isExist(n)?1:0).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean isExist(int n) {
		int sp = 0;
		int ep = N-1;
		
		while(sp <= ep) {
			int mid = (sp+ep)/2;
			
			if(A[mid] < n) { // 작으면 
				sp = mid+1;
			} else if(A[mid] > n) { // 크면 
				ep = mid-1; 
			} else {
				return true; 
			}
		}
		
		return false; 
	}
}

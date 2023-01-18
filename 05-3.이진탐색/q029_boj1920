package Algorithm;

import java.util.*;
import java.io.*;

public class q029_boj1920 {
	static int N; 
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 100000
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine()); // 100000
		
		st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			sb.append(search(num)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int search(int n) {
		int sp = 0; 
		int ep = N-1; 
		
		while(sp <= ep) {
			int mid = (sp+ep)/2; 
			if(arr[mid] == n) {
				return 1; 
			} else if(arr[mid] < n) {
				sp = mid+1; 
			} else {
				ep = mid-1; 
			}
		}
		
		return 0; 
	}
}

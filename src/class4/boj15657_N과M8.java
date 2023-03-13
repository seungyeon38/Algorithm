package class4;

import java.util.*;
import java.io.*;

public class boj15657_N과M8 {	
	static int N, M;
	static int[] nums; 
	static int[] result; 
	static StringBuilder sb; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		result = new int[M];
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		comb(0, 0);
		
		System.out.println(sb.toString());
	}
	
	public static void comb(int idx, int s) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(nums[result[i]]).append(" ");
			}
			sb.append("\n");
			
			return; 
		}
		
		for(int i=s; i<N; i++) {
			result[idx] = i;
			comb(idx+1, i);
		}
	}
}

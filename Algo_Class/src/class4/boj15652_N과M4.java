package class4;

import java.util.*;
import java.io.*;

public class boj15652_N과M4 {
	public static int N, M;
	public static StringBuilder sb;
	public static int[] result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~8
		M = Integer.parseInt(st.nextToken()); // 1~8
		
		sb = new StringBuilder();
		result = new int[M];
		
		comb(0, 1);
		
		System.out.println(sb.toString());
	}
	
	public static void comb(int idx, int s) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return; 
		}
		
		for(int i=s; i<=N; i++) {
			result[idx] = i; 
			comb(idx+1, i);
		}
	}
}

package class4_2;

import java.util.*;
import java.io.*;

public class boj15652_N과M4_771ms {
	static int N, M; 
	static StringBuilder sb = new StringBuilder();
	static int[] arr; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 1~8
		M = Integer.parseInt(st.nextToken()); // 1~N
		
		arr = new int[M];
		calc(0, 0, 1);
		
		System.out.println(sb.toString());
	}
	
	public static void calc(int cnt, int idx, int s) {
		if(cnt == M) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return; 
		}
		
		for(int i=s; i<=N; i++) {
			arr[idx] = i;
			calc(cnt+1, idx+1, i);
		}
	}
}

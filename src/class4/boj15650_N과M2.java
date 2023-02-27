package class4;

import java.util.*;
import java.io.*;

public class boj15650_N과M2 {
	static int N, M;
	static boolean[] selected;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~8
		M = Integer.parseInt(st.nextToken()); // 1~8
		
		selected = new boolean[N+1];
		sb = new StringBuilder();
		
		combination(1, 0);
		
		System.out.println(sb.toString()); 
	}
	
	public static void combination(int s, int n) {
		if(n == M) {
			for(int i=1; i<=N; i++) {
				if(selected[i]) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
		}
		
		for(int i=s; i<=N; i++) {
			if(!selected[i]) {
				selected[i] = true; 
				combination(i+1, n+1);				
			}
			selected[i] = false; 
		}
	}
}

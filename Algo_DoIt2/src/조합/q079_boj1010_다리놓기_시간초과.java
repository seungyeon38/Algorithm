package 조합;

import java.util.*;
import java.io.*;

public class q079_boj1010_다리놓기_시간초과 {
	static int N, M;
	static int cnt; 
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 0~30
			M = Integer.parseInt(st.nextToken()); // 0~30
			
			// M개 중 N개 고르기 
			cnt = 0; 
			pick(0, 0);
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void pick(int s, int n) {
		if(n == N) {
			cnt++;
			return; 
		}
		
		for(int i=s; i<M; i++) {
			pick(i+1, n+1);
		}
	}
}

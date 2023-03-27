package class5;

import java.util.*;
import java.io.*;

public class boj1005_ACMCraft {
	static int[] time;
	static List<Integer>[] list;
	static int W;
	static long[] dp; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 건물의 개수 2~1000
			int K = Integer.parseInt(st.nextToken()); // 건설순서 규칙 1~100000
			
			st = new StringTokenizer(br.readLine());
			time = new int[N];
			
			for(int i=0; i<N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			list = new ArrayList[N];
			
			for(int i=0; i<N; i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<K; i++){
				st = new StringTokenizer(br.readLine());
				
				int sp = Integer.parseInt(st.nextToken())-1;
				int fp = Integer.parseInt(st.nextToken())-1;
				
				list[fp].add(sp);
			}
			
			W = Integer.parseInt(br.readLine())-1; // 건설해야 할 건물 번호 
			dp = new long[N];
			
			for(int i=0; i<N; i++) {
				dp[i] = -1;
			}
			
			dfs(W);
			
			sb.append(dp[W]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static long dfs(int s) {
		if(dp[s] != -1) return dp[s];
		long max = 0;
		
		for(int n : list[s]) { // s를 가기위해 가야 하는 애들 
			max = Math.max(max, dfs(n));
		}
		
		return dp[s] = max+time[s];
	}
}

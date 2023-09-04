package 그래프;

import java.util.*;
import java.io.*;

public class boj1325_효율적인해킹_시간초과 {
	static ArrayList<Integer>[] adj_list;
	static boolean[] visited;
	static int cnt; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~10000
		int M = Integer.parseInt(st.nextToken()); // 1~100000
		adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// B를 해킹하면 A도 해킹할 수 있다. 
			adj_list[B].add(A);
		}
		
		// 최장거리 구하기 
		int[] distance = new int[N+1];
		for(int i=1; i<=N; i++) { // 시작점 
			visited = new boolean[N+1];
			cnt = 0;
			dfs(i);
			distance[i] = cnt;
		}
		
		int max = 0; 
		for(int i=1; i<=N; i++) {
			max = Math.max(max, distance[i]);
		}
		
		StringBuilder sb = new StringBuilder();

		for(int i=1; i<=N; i++) {
			if(distance[i] == max) sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n) {
		if(visited[n]) return; 
		
		visited[n] = true; 
		cnt++;
		
		for(int next : adj_list[n]) {
			if(visited[next]) continue; 
			dfs(next);
		}
	}
}

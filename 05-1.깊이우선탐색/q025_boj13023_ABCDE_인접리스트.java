package Algorithm;

import java.util.*;
import java.io.*;

public class q025_boj13023_인접리스트 {
	public static ArrayList<Integer>[] relation; 
	public static boolean[] visited; 
	public static int N, M;
	public static boolean result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 노드 2000 
		M = Integer.parseInt(st.nextToken()); // 간선 2000
		
		relation = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			relation[i] = new ArrayList<>();
		}
		
		visited = new boolean[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			relation[s].add(e);
			relation[e].add(s);
		}
		
		for(int i=0; i<N; i++) {
			dfs(i, 1);
			if(result) break;
		}
		
		if(result) System.out.println("1");
		else System.out.println("0");
	}
	
	public static void dfs(int n, int idx) {
		if(idx >= 5) {
			result = true; 
			return; 
		}
		
		visited[n] = true;
		
		for(int i : relation[n]) {
			if(!visited[i]) {
				dfs(i, idx+1);
				if(result) return;
			}
		}
		
		visited[n] = false; 
	}
}

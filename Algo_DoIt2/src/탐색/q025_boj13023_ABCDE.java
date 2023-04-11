package 탐색;

import java.util.*;
import java.io.*;

public class q025_boj13023_ABCDE {
	static int N; 
	static ArrayList<Integer>[] adj_list;
	static boolean[] visited; 
	static boolean flag; 
 	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 5~2000
		int M = Integer.parseInt(st.nextToken()); // 1~2000
		visited = new boolean[N];
		adj_list = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj_list[a].add(b);
			adj_list[b].add(a);
		}
		
		for(int i=0; i<N; i++) {
			dfs(i, 0);
			if(flag) break;
		}
		
		if(flag) System.out.println("1");
		else System.out.println("0");
	}
	
	public static void dfs(int n, int cnt) {
		if(cnt == 4) {
			flag = true;
			return; 
		}
		
		visited[n] = true;
		
		for(int i : adj_list[n]) {
			if(!visited[i]) {
				dfs(i, cnt+1);
			}
		}
		
		visited[n] = false; 
	}
}

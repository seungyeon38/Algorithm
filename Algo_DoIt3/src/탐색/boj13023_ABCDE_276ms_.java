package 탐색;

import java.util.*;
import java.io.*;

public class boj13023_ABCDE_276ms_ {
	static ArrayList<Integer>[] adj_list;
	static boolean[] visited; 
	static boolean isPossible; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람의 수 5~2000
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수 1~2000
		
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
			visited = new boolean[N];
			calc(i, 1);
			if(isPossible) {
				System.out.println("1");
				return; 
			}
		}
		
		System.out.println("0");
	}
	
	public static void calc(int n, int cnt) {
		if(isPossible) return; 

		if(cnt == 5) {
			isPossible = true; 
			return; 
		} 
		
		visited[n] = true; 
		for(int next : adj_list[n]) {
			if(visited[next]) continue; 
			calc(next, cnt+1);
		}
		visited[n] = false; 
	}
}

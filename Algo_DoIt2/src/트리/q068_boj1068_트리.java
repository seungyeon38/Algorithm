package 트리;

import java.util.*;
import java.io.*;

public class q068_boj1068_트리 {
	static boolean[] visited; 
	static ArrayList<Integer>[] adj_list;
	static int result; 
	static int erase;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 트리의 노드 개수 1~50
		adj_list = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		int[] parents = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int root = 0;
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(n == -1) {
				root = i;
				continue; 
			}
			adj_list[i].add(n);
			adj_list[n].add(i);
			parents[i] = n;
		}
		
		erase = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		
		if(root == erase) {
			System.out.println("0");
			return; 
		}
		
		dfs(root);
		
		System.out.println(result);
	}
	
	public static void dfs(int n) {
		visited[n] = true; 
		int cnt = 0;
		
		for(int next : adj_list[n]) {
			if(visited[next]) continue; 
			if(next == erase) continue;
			
			visited[next] = true; 
			cnt++; 
			dfs(next);
		}
		
		if(cnt == 0) result++;
	}
}

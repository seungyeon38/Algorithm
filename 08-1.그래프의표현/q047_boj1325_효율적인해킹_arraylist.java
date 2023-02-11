package Algorithm;

import java.util.*;
import java.io.*;

public class q047_boj1325_arraylist {
	static ArrayList<Integer>[] grid; 
	static boolean[] visited;
	static int[] result; 
	static int N; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 10000
		int M = Integer.parseInt(st.nextToken()); // 100000
		
		grid = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			grid[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			
			grid[f].add(s); 
		}
		
		result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			bfs(i);
		}
		
		int max = 0; 
		for(int i=1; i<=N; i++) {
			max = Math.max(max, result[i]);
		}
		
		StringBuilder sb = new StringBuilder(); 
		for(int i=1; i<=N; i++) {
			if(result[i] == max) sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int sp) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(sp);
		visited = new boolean[N+1];
		visited[sp] = true;
		result[sp]++;

		while(!queue.isEmpty()) {
			int n = queue.poll();
			for(int i : grid[n]) {
				if(!visited[i]) {
					queue.offer(i);
					visited[i] = true;
					result[sp]++;
				}
			}
		}
	}
}

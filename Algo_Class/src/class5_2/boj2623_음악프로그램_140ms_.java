package class5_2;

import java.util.*;
import java.io.*;

public class boj2623_음악프로그램_140ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 가수의 수 1~1000
		int M = Integer.parseInt(st.nextToken()); // 보조PD의 수 1~100
		
		ArrayList<Integer>[] adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		int[] indegree = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int n = Integer.parseInt(st.nextToken());
			int before = Integer.parseInt(st.nextToken());
			for(int j=1; j<n; j++) {
				int cur = Integer.parseInt(st.nextToken());
				adj_list[before].add(cur);
				indegree[cur]++;
				before = cur; 
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append("\n");
			
			for(int next : adj_list[cur]) {
				indegree[next]--;
				
				if(indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		boolean result = true; 
		for(int i=1; i<=N; i++) {
			if(indegree[i] != 0) {
				result = false;
				break; 
			}
		}
		
		if(result) System.out.println(sb.toString());
		else System.out.println("0");
	}
}

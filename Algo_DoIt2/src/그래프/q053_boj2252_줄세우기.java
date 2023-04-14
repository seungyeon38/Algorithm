package 그래프;

import java.util.*;
import java.io.*;

public class q053_boj2252_줄세우기 {
	static int[] parents; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수 1~32000
		int M = Integer.parseInt(st.nextToken()); // 키 비교 회수 1~100000
		
		parents = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			parents[i] = i;
		}
		
		ArrayList<Integer>[] adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		int[] indegree = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// A가 B 앞에 서야 한다. 
			adj_list[A].add(B);
			indegree[B]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int n = queue.poll();
			sb.append(n).append(" ");
			
			for(int next : adj_list[n]) {
				indegree[next]--;
				if(indegree[next] == 0) queue.add(next);
			}
		}
		
		System.out.println(sb.toString());
	}
}

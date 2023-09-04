package Algorithm;

import java.util.*;
import java.io.*;

public class q054_boj1516 {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 건물 종류 500
		
		StringTokenizer st;
		ArrayList<Integer>[] parent = new ArrayList[N+1];
		int[] time = new int[N+1];
		int[] indegree = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			parent[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			time[i] = Integer.parseInt(st.nextToken()); // 시간 100000
			
			int n = Integer.parseInt(st.nextToken());
			int temp_indegree = 0;
			
			while(n != -1) {
				parent[n].add(i);
				n = Integer.parseInt(st.nextToken());
				temp_indegree++;
			}
			
			indegree[i] = temp_indegree;
		}
				
		int[] result = new int[N+1];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for(int num : parent[n]) {
				indegree[num]--;
				
				result[num] = Math.max(result[num], result[n]+time[n]);
				if(indegree[num] == 0) queue.offer(num);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(result[i]+time[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

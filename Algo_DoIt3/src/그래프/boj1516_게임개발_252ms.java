package 그래프;

import java.util.*;
import java.io.*;

public class boj1516_게임개발_252ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 건물 종류 수 1~500
		int[] time = new int[N+1];
		
		int[] indegree = new int[N+1];
		ArrayList<Integer>[] adj_list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken()); // 먼저 지어야하는 건물 
			while(n != -1) {
				indegree[i]++;
				adj_list[n].add(i);
				n = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) queue.add(i);
		}
		
		int[] result = new int[N+1];
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next : adj_list[cur]) {
				indegree[next]--;
				result[next] = Math.max(result[next], result[cur]+time[cur]);
				if(indegree[next] == 0) queue.add(next);
			}
		}
				
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(time[i]+result[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

package 그래프;

import java.util.*;
import java.io.*;

public class q054_boj1516_게임개발_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 건물 종류 수 1~500 
		int[] build_time = new int[N+1]; 
		ArrayList<Integer>[] build_after = new ArrayList[N+1]; // 이후에 지어야 하는 건물 
		int[] indegree = new int[N+1]; // 진입차수 
		
		for(int i=1; i<=N; i++) {
			 build_after[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			build_time[i] = Integer.parseInt(st.nextToken()); // 1~100000
			
			int n = Integer.parseInt(st.nextToken());
			int temp_cnt = 0; 
			while(n != -1) {
				build_after[n].add(i);
				n = Integer.parseInt(st.nextToken());
				temp_cnt++; 
			}
			
			indegree[i] = temp_cnt;
		}
				
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) { // 진입차수가 0인 것을 찾아서 건설
				queue.add(i);
			}
		}
		
		int[] time = new int[N+1]; 
		
		while(!queue.isEmpty()) {
			int build = queue.poll();

			for(int n : build_after[build]) {
				time[n] = Math.max(time[n], time[build]+build_time[build]);
				indegree[n]--; 
				
				if(indegree[n] == 0) queue.add(n);
			}		
		}
		
		StringBuilder sb = new StringBuilder(); 
		for(int i=1; i<=N; i++) {
			sb.append(time[i]+build_time[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

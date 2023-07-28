package class5_2;

import java.util.*;
import java.io.*;

public class boj1005_ACMCraft_796ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 건물의 개수 2~1000
			int K = Integer.parseInt(st.nextToken()); // 건물 간 건설순서 규칙 개수 1~100000
			st = new StringTokenizer(br.readLine());
			int[] D = new int[N+1]; // 건설에 걸리는 시간 0~100000
			for(int i=1; i<=N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<Integer>[] adj_list = new ArrayList[N+1];
			for(int i=0; i<=N; i++) {
				adj_list[i] = new ArrayList<Integer>();
			}
			int[] indegree = new int[N+1];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				adj_list[X].add(Y);
				indegree[Y]++;
			}
			
			int W = Integer.parseInt(br.readLine()); // 건설해야 할 건물의 번호 
			
			Queue<Integer> queue = new LinkedList<Integer>();
			int[] time = new int[N+1]; // 건설하는데 걸리는 최소시간 

			for(int i=1; i<=N; i++) {
				time[i] = D[i];
				if(indegree[i] == 0) queue.add(i);
			}
			
			boolean done = false; 
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				for(int next : adj_list[cur]) {
					time[next] = Math.max(time[next], time[cur]+D[next]);
					indegree[next]--;
					if(indegree[next] == 0) {
						if(next == W) {
							done = true; 
							break; 
						}
						queue.add(next);
					}
				}
				if(done) break; 
			}
			
			sb.append(time[W]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

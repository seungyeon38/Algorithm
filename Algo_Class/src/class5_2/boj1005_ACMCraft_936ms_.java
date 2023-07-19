package class5_2;

import java.util.*;
import java.io.*;

public class boj1005_ACMCraft_936ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수 
		
		// 특정 건물을 가장 빨리 지을 때까지 걸리는 최소시간 
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 건물의 개수 2~1000
			int K = Integer.parseInt(st.nextToken()); // 건물간의 건설순서 규칙 1~100000
			
			int[] D = new int[N+1]; // 각 건물당 건설에 걸리는 시간 
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<Integer>[] adj_list = new ArrayList[N+1];
			for(int i=0; i<=N; i++) {
				adj_list[i] = new ArrayList<Integer>();
			}
			
			int[] indegree = new int[N+1]; // 진입 차수 
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				adj_list[s].add(e);
				indegree[e]++;
			}
			
			int W = Integer.parseInt(br.readLine()); // 건설할 건물 번호 
			
			Queue<Integer> queue = new LinkedList<Integer>();
			int[] result = new int[N+1]; // 건물 건설 소요 시간 
			
			for(int i=1; i<=N; i++) {
				result[i] = D[i];
				if(indegree[i] == 0) queue.add(i);
			}
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();

				for(int next : adj_list[cur]) {
					result[next] = Math.max(result[next], result[cur]+D[next]);
					indegree[next]--;
					
					if(indegree[next] == 0) queue.add(next);
				}
			}
			
			System.out.println(result[W]);
		}
	}
}

package f_그래프;

import java.util.*;
import java.io.*;

public class boj1516_게임개발_272ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 건물 종류 수 1~500
		int[] cnt = new int[N+1];
		int[] time = new int[N+1]; // 건물 짓는데 걸리는 시간 
		ArrayList<Integer>[] adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			time[i] = Integer.parseInt(st.nextToken()); 
			int n = Integer.parseInt(st.nextToken()); // 먼저 지어야 하는 건물 
			
			while(n != -1) {
				cnt[i]++;
				adj_list[n].add(i);
				
				n = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Integer> list = new LinkedList<>();
		int[] result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			if(cnt[i] == 0) {
				list.add(i);
			}
		}
		
		while(!list.isEmpty()) {
			int cur = list.poll();
			
			for(int next : adj_list[cur]) {
				cnt[next]--;
				result[next] = Math.max(result[next], result[cur]+time[cur]);
				if(cnt[next] == 0) list.add(next);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(result[i]+time[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

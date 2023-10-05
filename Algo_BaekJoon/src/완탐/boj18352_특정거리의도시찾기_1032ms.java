package 완탐;

import java.util.*;
import java.io.*;

public class boj18352_특정거리의도시찾기_1032ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수 2~300000
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수 1~1000000
		int K = Integer.parseInt(st.nextToken()); // 거리 정보 1~300000
		int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호 
		
		ArrayList<Integer>[] arr_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			arr_list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr_list[s].add(e);
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {X, 0});
		int[] distance = new int[N+1];
		Arrays.fill(distance,1000001);
		distance[X] = 0;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[1] > K) break; 
			
			for(int next : arr_list[cur[0]]) {
				if(distance[next]!=1000001) continue; // 이미 지나간 곳 
				distance[next] = cur[1]+1;
				queue.add(new int[] {next, distance[next]});
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			if(distance[i] == K) {
				sb.append(i).append("\n");
			}
		}
		
		if(sb.length() == 0) sb.append("-1");
		
		System.out.println(sb.toString());
	}
}

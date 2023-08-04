package 그래프;

import java.util.*;
import java.io.*;

public class boj18352_특정거리의도시찾기_1148ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수 2~300000
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수 1~1000000
		int K = Integer.parseInt(st.nextToken()); // 거리 정보 1~300000
		int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호 
		
		ArrayList<Integer>[] adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj_list[A].add(B);
		}
		
		int[] distance = new int[N+1]; 
		boolean[] visited = new boolean[N+1];
		visited[X] = true; 
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(X);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int next : adj_list[cur]) {
				if(visited[next]) continue; 
				visited[next] = true; 
				distance[next] = distance[cur]+1;
				queue.add(next);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		boolean result = false; 
		for(int i=1; i<=N; i++) {	
			if(distance[i] == K) {
				result = true; 
				sb.append(i).append("\n");
			}
		}
		
		if(!result) {
			System.out.println("-1");
		} else System.out.println(sb.toString());
	}
}

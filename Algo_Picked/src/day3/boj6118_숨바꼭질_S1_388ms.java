package day3;

import java.util.*;
import java.io.*;

public class boj6118_숨바꼭질_S1_388ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 헛간 개수 2~20000
		int M = Integer.parseInt(st.nextToken()); // 길 1~50000
		
		ArrayList<Integer>[] adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		// 1번 헛간에서의 거리가 멀어져야 함 
		// 최장거리 
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			adj_list[n1].add(n2);
			adj_list[n2].add(n1);
		}
		
		// 숨어야 하는 헛간 번호 (거리가 같은 헛간이라면, 가장 작은 헛간 번호)
		// 그 헛간까지의 거리 
		// 그 헛간과 같은 거리를 갖는 헛간의 개수 
		
		// bfs
		Queue<Integer> q = new LinkedList<Integer>(); // [번호, 거리]
		q.add(1);
		boolean[] visited = new boolean[N+1];
		visited[1] = true; 
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : adj_list[cur]) {
				if(visited[next]) continue; 
				if(distance[cur] == Integer.MAX_VALUE) continue; 
				
				if(distance[next] > distance[cur]+1) {
					visited[next] = true; 
					distance[next] = distance[cur]+1;
					q.add(next);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder(); 
		int max = 0;
		for(int i=1; i<=N; i++) {
			if(max < distance[i]) {
				max = distance[i];
			}
		}
		
		boolean found = false; 
		int cnt = 0; 
		for(int i=1; i<=N; i++) {
			if(distance[i] == max) {
				if(!found) sb.append(i).append(" ");
				found = true; 
				cnt++;
			}
		}
		sb.append(max).append(" ");
		sb.append(cnt);
		
		System.out.println(sb.toString());
	}
}

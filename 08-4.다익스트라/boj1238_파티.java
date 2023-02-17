package Algorithm;

import java.util.*;
import java.io.*;

public class boj1238_파티 {
	static int[] distance;
	static boolean[] visited; 
	static int INF = 1000001;
	static int N; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수 1000
		int M = Integer.parseInt(st.nextToken()); // 도로 수 10000
		int K = Integer.parseInt(st.nextToken()); // 파티 마을 
		
		int[] time = new int[N+1]; // 학생들 소요시간. 여기서 최대 시간 뽑으면 됨 
				
		ArrayList<Node>[] graph = new ArrayList[N+1];
		ArrayList<Node>[] r_graph = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Node>();
			r_graph[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[s].add(new Node(e,w));
			r_graph[e].add(new Node(s,w));
		}
		
		// (1~N번에서 K로 가는 최단거리 + K에서 1~N번으로 가는 최단거리) 중 최댓값 구하기 
		distance = new int[N+1];
		visited = new boolean[N+1];
	
		dijkstra(K, graph);
		for(int i=1; i<=N; i++) {
			time[i] = distance[i];
		}
		
		dijkstra(K, r_graph);
		for(int i=1; i<=N; i++) {
			time[i] += distance[i];
		}
		
		// 최댓값 구하기
		int max = 0; 
		for(int i=1; i<=N; i++) {
			if(max < time[i]) max = time[i];
		}
		
		System.out.println(max);
	}
	
	public static void dijkstra(int s, ArrayList<Node>[] graph) {
		Arrays.fill(distance, INF);
		Arrays.fill(visited, false);
		distance[s] = 0;
		
		// 다익스트라 
		for(int i=0; i<N; i++) {
			// 최소
			int min = INF; 
			int sp = 0; 
			for(int j=1; j<=N; j++) {
				if(!visited[j] && distance[j]<min) { // 방문하지 않은 최솟값 
					min = distance[j];
					sp = j;
				}
			}
			
			visited[sp] = true; 
			
			// 업데이트 
			for(Node n : graph[sp]) {
				if(distance[n.e] > distance[sp]+n.w) {
					distance[n.e] = distance[sp]+n.w;
				}
			}
		}
	}
	
	public static class Node{
		int e;
		int w; 
		
		Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}
}

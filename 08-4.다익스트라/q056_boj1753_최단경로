package Algorithm;

import java.util.*;
import java.io.*;

public class q056_boj1753 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점 20000
		int E = Integer.parseInt(st.nextToken()); // 간선 300000
		
		int K = Integer.parseInt(br.readLine()); // 시작 정점번호 
		
		int[] route = new int[V+1]; // 최단경로 
		
		Arrays.fill(route, Integer.MAX_VALUE);
		
		ArrayList<Node>[] graph = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w)); // u->v = w
		}
		
		int[] result = new int[V+1]; // 결과 
		
		Arrays.fill(result, Integer.MAX_VALUE); // 다 최댓값으로 초기화 
		 		
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		pq.offer(new Node(K, 0));
		result[K] = 0; // 시작 지점 0으로 
		
		while(!pq.isEmpty()) {
			Node node = pq.poll(); // 제일 작은거 꺼내기 
			
			if(visited[node.idx]) continue; // 방문한 적 있는 노드면 X
			
			visited[node.idx] = true;
			
			for(Node temp : graph[node.idx]) {
				if(!visited[temp.idx] && result[temp.idx] > temp.w + result[node.idx]) { // 더 작은 거로 업데이트 
//				if(result[temp.idx] > temp.w + result[node.idx]) { // 더 작은 거로 업데이트 
					result[temp.idx] = temp.w + result[node.idx];
					pq.offer(new Node(temp.idx, result[temp.idx]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=V; i++) {
			if(visited[i]) sb.append(result[i]).append("\n");
			else sb.append("INF").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Node implements Comparable<Node>{
		int idx;
		int w;
		
		Node(int index, int w){
			this.idx = index;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node v) {
			if(this.w < v.w) return -1; // 작으면 앞으로 
			else return 1;
		}
	}
}

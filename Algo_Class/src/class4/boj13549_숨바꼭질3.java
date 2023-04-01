package class4;

import java.util.*;
import java.io.*;

public class boj13549_숨바꼭질3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 0~100000
		int K = Integer.parseInt(st.nextToken()); // 0~100000
		int max = 100000;
		boolean[] visited = new boolean[100001];
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(N, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(n.loc == K) {
				System.out.println(n.time);
				return; 
			}
			
			visited[n.loc] = true; 
			
			if(n.loc+1 <= max && !visited[n.loc+1]) {
				pq.offer(new Node(n.loc+1, n.time+1));
			} 
			if(n.loc-1>=0 && n.loc-1<=max && !visited[n.loc-1]) {
				pq.offer(new Node(n.loc-1, n.time+1));
			}
			if(n.loc*2 <= max && !visited[n.loc*2]) {
				pq.offer(new Node(n.loc*2, n.time));
			} 
		}
	}
	
	public static class Node implements Comparable<Node>{
		int loc; 
		int time;
		
		Node(int loc, int time) {
			this.loc = loc;
			this.time = time; 
		}
		
		@Override 
		public int compareTo(Node n) {
			return this.time - n.time;
		}
	}
}

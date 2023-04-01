package class4;

import java.util.*;
import java.io.*;

public class boj11779_최소비용구하기2 {
	static int n;
	static ArrayList<Node>[] graph; 
	static int[] before;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 1~1000
		int m = Integer.parseInt(br.readLine()); // 1~100000
		graph = new ArrayList[n+1];		
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		before = new int[n+1];
		
		StringTokenizer st; 
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s].add(new Node(e, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int sp = Integer.parseInt(st.nextToken());
		int ep = Integer.parseInt(st.nextToken()); 
				
		StringBuilder sb = new StringBuilder();
		sb.append(dijkstra(sp, ep)).append("\n");
		
		int cnt = 0;
		int temp = ep;
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(temp);
		
		while(before[temp] != 0) {
			cnt++;
			stack.push(before[temp]);
			temp = before[temp];
		}
		
		sb.append(cnt+1).append("\n");
		for(int i=0, size=stack.size(); i<size; i++) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int dijkstra(int s, int e) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		pq.offer(new Node(s, 0));
		distance[s] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(n.e == e) break;

			for(Node temp : graph[n.e]) {
				if(distance[n.e]!=Integer.MAX_VALUE && distance[temp.e]>distance[n.e]+temp.w) {
					distance[temp.e] = distance[n.e]+temp.w;
					pq.offer(new Node(temp.e, distance[temp.e]));
					
					before[temp.e] = n.e;
				}
			}
		}
		
		return distance[e];
	}
	
	public static class Node implements Comparable<Node>{
		int e;
		int w;
		
		Node(int e, int w){
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.w-n.w;
		}
	}
}

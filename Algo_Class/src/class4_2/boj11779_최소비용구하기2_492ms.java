package class4_2;

import java.util.*;
import java.io.*;

public class boj11779_최소비용구하기2_492ms {
	static int n;
	static ArrayList<Node>[] city;
	static int[] distance; 
	static int[] route; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 도시의 개수 1~1000
		int m = Integer.parseInt(br.readLine()); // 버스의 개수 1~100000
		
		// 버스 비용 최소화 
		city = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			city[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			city[s].add(new Node(e, c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		dijkstra(s, e);
		
		int next = e;
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(distance[e] + "\n");
		
		Stack<Integer> stack = new Stack<>();
		while(next != s) {
			cnt++;
			stack.push(next);
			next = route[next];
		}
		stack.push(s);
		
		sb.append(cnt + "\n");

		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dijkstra(int s, int e) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s, 0));
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[s] = 0;
		route = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			route[i] = i;
		}
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.n == e) break; 
			
			for(Node next : city[cur.n]) {				
				if(distance[next.n] > distance[cur.n]+next.cost) {
					route[next.n] = cur.n; // 경로 저장 
					distance[next.n] = distance[cur.n]+next.cost;
					pq.add(new Node(next.n, distance[next.n]));
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
		int n;
		int cost;
		
		Node(int n, int cost){
			this.n = n;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}
}

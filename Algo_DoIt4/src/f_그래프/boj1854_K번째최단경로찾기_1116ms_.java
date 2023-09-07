package f_그래프;

import java.util.*;
import java.io.*;

public class boj1854_K번째최단경로찾기_1116ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 도시들의 개수 1~1000
		int m = Integer.parseInt(st.nextToken()); // 도로 수 0~2000000
		int k = Integer.parseInt(st.nextToken()); // k번째 최단경로 1~100
		
		ArrayList<Node>[] adj_list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			// a번 -> b번 : c시간이 걸림 
			int a = Integer.parseInt(st.nextToken()); // 1~n
			int b = Integer.parseInt(st.nextToken()); // 1~n
			int c = Integer.parseInt(st.nextToken()); // 1~1000
			
			adj_list[a].add(new Node(b, c));
		}
		
		// 1번 도시가 시작도시 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));

		PriorityQueue<Integer>[] result = new PriorityQueue[n+1];
		for(int i=0; i<=n; i++) {
			result[i] = new PriorityQueue<>(Collections.reverseOrder());
		}
		result[1].add(0);

		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(Node next : adj_list[cur.n]) {
				if(result[next.n].size() < k) { // 개수가 k보다 작으면 무조건 저장 
					result[next.n].add(cur.w+next.w);
					pq.add(new Node(next.n, cur.w+next.w));
				} else if(result[next.n].peek() > cur.w+next.w){ // 개수가 k와 같거나 크면 비교해서 저장 
					result[next.n].poll();
					result[next.n].add(cur.w+next.w);
					pq.add(new Node(next.n, cur.w+next.w));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(result[i].size() == k) sb.append(result[i].peek()).append("\n");
			else sb.append("-1\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Node implements Comparable<Node>{
		int n;
		int w;
		
		Node(int n, int w){
			this.n = n;
			this.w = w;
		}
		
		@Override 
		public int compareTo(Node n) {
			return this.w - n.w;
		}
	}
}

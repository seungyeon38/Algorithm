package 그래프;

import java.util.*;
import java.io.*;

public class q058_boj1854_K번째최단경로찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int n = Integer.parseInt(st.nextToken()); // 도시 수 1~1000 
		int m = Integer.parseInt(st.nextToken()); // 도시 간 존재하는 도로 수 0~2000000
		int k = Integer.parseInt(st.nextToken()); // 1~100
		
		ArrayList<Node>[] arr = new ArrayList[n+1];
		
		for(int i=0; i<=n; i++) {
			arr[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); 
			
			arr[a].add(new Node(b, c));
		}
		
		PriorityQueue<Integer>[] result = new PriorityQueue[n+1];
//		Comparator<Integer> cp = new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2-o1;
//			}
//		};
		
		for(int i=0; i<=n; i++) {
			result[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(1, 0)); 
		result[1].add(0);

		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for(Node next : arr[node.n]) {
				if(result[next.n].size() < k) {
					result[next.n].add(node.w+next.w);
					pq.add(new Node(next.n, node.w+next.w));
				} else if(result[next.n].peek() > node.w+next.w) {
					result[next.n].poll();
					result[next.n].add(node.w+next.w);
					pq.add(new Node(next.n, node.w+next.w));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			if(result[i].size() == k) {
				sb.append(result[i].peek()).append("\n");
			} else {
				sb.append("-1\n");
			}
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

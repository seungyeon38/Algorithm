package Algorithm;

import java.util.*;
import java.io.*;

public class boj6479_전력난_Prim {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str; 
		StringBuilder sb = new StringBuilder();
		
		while(!(str = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(str);
			int m = Integer.parseInt(st.nextToken()); // 집의 수 200000
			int n = Integer.parseInt(st.nextToken()); // 길의 수 200000
			ArrayList<Node>[] graph = new ArrayList[m];
			for(int i=0; i<m; i++) {
				graph[i] = new ArrayList<Node>();
			}
			
			int total = 0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken()); 
				
				graph[x].add(new Node(y, z));
				graph[y].add(new Node(x, z));

				total += z; 
			}
			
			boolean[] visited = new boolean[m];
			
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.offer(new Node(0, 0));
			int sum = 0; 
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				
				if(visited[node.e]) continue; 
				
				visited[node.e] = true; 
				sum += node.w;
				
				for(Node temp : graph[node.e]) {
					if(visited[temp.e]) continue; 
					pq.add(temp);
				}
			}
			
			sb.append(total-sum).append("\n");
		}
		
		System.out.println(sb.toString());
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

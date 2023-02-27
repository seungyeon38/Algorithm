package class4;

import java.util.*;
import java.io.*;

public class boj13549_숨바꼭질3_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 0~100000
		int K = Integer.parseInt(st.nextToken()); // 0~100000
		int max = 100000;
		boolean[] visited = new boolean[100001];
		
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(N, 0));
		int min = 100001;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			visited[n.loc] = true; 
			
			if(n.loc == K) min = Math.min(min, n.time);
			

			if(n.loc*2 <= max && !visited[n.loc*2]) {
				q.offer(new Node(n.loc*2, n.time));
			}
			if(n.loc+1 <= max && !visited[n.loc+1]) {
				q.offer(new Node(n.loc+1, n.time+1));
			} 
			if(n.loc-1>=0 && n.loc-1<=max && !visited[n.loc-1]) {
				q.offer(new Node(n.loc-1, n.time+1));
			}
		}
		
		System.out.println(min);
	}
	
	public static class Node{
		int loc; 
		int time;
		
		Node(int loc, int time) {
			this.loc = loc;
			this.time = time; 
		}
	}
}

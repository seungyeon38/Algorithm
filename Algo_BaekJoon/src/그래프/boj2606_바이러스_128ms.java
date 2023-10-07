package 그래프;

import java.util.*;
import java.io.*;

public class boj2606_바이러스_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 컴퓨터 수 1~100
		int M = Integer.parseInt(br.readLine()); // 연결되어있는 컴퓨터 쌍의 수 
		
		ArrayList<Integer>[] adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adj_list[n1].add(n2);
			adj_list[n2].add(n1);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		boolean[] visited = new boolean[N+1];
		int cnt = -1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(visited[cur]) continue; 
			visited[cur] = true; 
			cnt++;
			
			for(int next : adj_list[cur]) {
				if(!visited[next]) queue.add(next);
			}
		}
		
		System.out.println(cnt);
	}
}

package Algorithm;

import java.util.*;
import java.io.*;

public class q046_boj18352 {
	static int[] visited;
	static ArrayList<Integer>[] grid; 
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 도시 개수 300000
		int M = Integer.parseInt(st.nextToken()); // 도로 개수 1000000
		int K = Integer.parseInt(st.nextToken()); // 거리 정보 300000
		int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호 
		
		visited = new int[N+1];
		Arrays.fill(visited, -1);
		grid = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			grid[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int sp = Integer.parseInt(st.nextToken());
			int fp = Integer.parseInt(st.nextToken());
			
			grid[sp].add(fp);
		}
				
		sb = new StringBuilder();
		
		bfs(X, K);
				
		boolean result = false; 
		for(int i=1; i<=N; i++) {
			if(visited[i] == K) {
				sb.append(i).append("\n");
				result = true; 
			}
		}

		if(result) System.out.println(sb.toString());
		else System.out.println("-1");
	}
	
	public static void bfs(int sp, int max_depth) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(sp);
		visited[sp] = 0;
				
		while(!queue.isEmpty()) {
			int n = queue.poll();
						
			for(int temp : grid[n]) {
				if(visited[temp] == -1) {
					queue.add(temp);
					visited[temp] = visited[n]+1;
				}
			}
		}
	}
}

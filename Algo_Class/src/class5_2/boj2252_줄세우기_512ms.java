package class5_2;

import java.util.*;
import java.io.*;

public class boj2252_줄세우기_512ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수 1~32000
		int M = Integer.parseInt(st.nextToken()); // 키를 비교한 회수 1~100000
		
		int[] indegree = new int[N+1];
		ArrayList<Integer>[] adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			indegree[B]++;
			adj_list[A].add(B);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");
			for(int next : adj_list[cur]) {
				indegree[next]--;
				if(indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}

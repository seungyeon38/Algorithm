package class5_2;

import java.util.*;
import java.io.*;

public class boj9466_텀프로젝트_1236ms_ {
	static int[] stu;
	static boolean[] done; 
	static boolean[] visited; 
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine()); // 2~100000
			cnt = 0;
			visited = new boolean[n+1]; // dfs
			done = new boolean[n+1]; // 사이클을 이미 뽑아냈는가 
			stu = new int[n+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				stu[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=n; i++) {
				dfs(i);
			}
			sb.append(n-cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int idx) {
		if(visited[idx]) return; 
		
		visited[idx] = true; 
		int next = stu[idx];
		
		if(!visited[next]) {
			dfs(next); 
		} else { // 사이클이 생김 
			if(!done[next]) { // 거친 적 없다면 
				for(int i=next; i!=idx; i=stu[i]) {
					cnt++;
				}
				cnt++;
			}
		}

		done[idx] = true; 
	}
}

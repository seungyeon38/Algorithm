package class5;

import java.util.*;
import java.io.*;

public class boj9466_텀프로젝트 {
	static int[] next;
	static boolean[] selected;
	static boolean[] visited;
	static int cnt; 
			
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine()); // 학생 수 2~100000
			cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			next = new int[n+1];
			selected = new boolean[n+1];
			
			for(int i=1; i<=n; i++) {
				next[i] = Integer.parseInt(st.nextToken());
				
				if(i == next[i]) { 
					selected[i] = true;
					cnt++;
				}
			}
			
			visited = new boolean[n+1];
			
			for(int i=1; i<=n; i++) {
				if(!selected[i]) {
					dfs(i);
				}
			}

			sb.append(n-cnt).append("\n");
			System.out.println();
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int s) {
		if(selected[s]) return; // 이미 선택된 경우 
				
		if(visited[s]) { // 아직 팀에 들어가진 못했고, 방문은 했을 경우 -> 사이클 
			selected[s] = true; 
			cnt++; 
		} 
		
		visited[s] = true; // 방문 
		dfs(next[s]); 
		// 다 체크하고 돌아왔을 때 
		selected[s] = true; 
		visited[s] = false; 
	}
}


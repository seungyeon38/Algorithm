package 구현;

import java.util.*;
import java.io.*;

public class boj1012_유기농배추_168ms {
	static int N, M;
	static boolean[][] baechu;
	static int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로길이 1~50
			N = Integer.parseInt(st.nextToken()); // 세로길이 1~50
			int K = Integer.parseInt(st.nextToken()); // 배추 위치 개수 1~2500 
			ArrayList<int[]> baechu_list = new ArrayList<>();
			baechu = new boolean[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				baechu_list.add(new int[] {c, r});
				baechu[c][r] = true; 
			}
			
			visited = new boolean[N][M];
			int result = 0;
			for(int[] cur : baechu_list) {
				if(visited[cur[0]][cur[1]]) continue; 
				
				dfs(cur[0], cur[1]);
				result++;
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true; 
		
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue; 
			if(visited[nr][nc] || !baechu[nr][nc]) continue; 
			
			dfs(nr, nc);
		}
	}
}

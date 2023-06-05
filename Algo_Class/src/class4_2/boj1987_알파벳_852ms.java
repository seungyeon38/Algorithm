package class4_2;

import java.util.*;
import java.io.*;

public class boj1987_알파벳_852ms {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int R, C;
	static char[][] board;
	static boolean[] visited; 
	static int max_cnt; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 1~20 
		C = Integer.parseInt(st.nextToken()); // 1~20 
		board = new char[R][C];
		for(int i=0; i<R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean['Z'+1];
		// (0, 0)부터 시작 
		visited[board[0][0]] = true; 
		dfs(0, 0, 1);
		System.out.println(max_cnt);
	}
	
	public static void dfs(int sr, int sc, int cnt) {
		max_cnt = Math.max(cnt, max_cnt);
		
		for(int d=0; d<4; d++) {
			int nr = sr + dir[d][0];
			int nc = sc + dir[d][1];
			
			if(nr<0 || nr>=R || nc<0 || nc>=C) continue; 
			if(visited[board[nr][nc]]) continue; 
			
			visited[board[nr][nc]] = true; 
			dfs(nr, nc, cnt+1);
			visited[board[nr][nc]] = false; 
		}
	}
}

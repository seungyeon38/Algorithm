import java.util.*;
import java.io.*;

public class boj14500_테트로미노_776ms {
	static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	static int N, M;
	static int max = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 4~500
		M = Integer.parseInt(st.nextToken()); // 4~500 
		
		int[][] paper = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken()); // 1~1000
			}
		}
		
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(1, paper[i][j], i, j, paper, visited);
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);
	}
	
	public static void dfs(int idx, int sum, int r, int c, int[][] paper, boolean[][] visited) {
		if(idx == 4) {
			max = Math.max(max, sum);
			return; 
		}
		
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) continue; 
			if(visited[nr][nc]) continue; 
			
			if(idx == 2) {
				visited[nr][nc] = true; 
				dfs(idx+1, sum+paper[nr][nc], r, c, paper, visited);
				visited[nr][nc] = false; 
			}
			
			visited[nr][nc] = true; 
			dfs(idx+1, sum+paper[nr][nc], nr, nc, paper, visited);
			visited[nr][nc] = false; 
		}
	}
}

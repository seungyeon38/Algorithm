package 자료구조;

import java.util.*;
import java.io.*;

public class q027_boj2178_미로탐색 {
	static int N, M;
	static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	static char[][] matrix;
	static int[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); // 2~100
		M = Integer.parseInt(st.nextToken()); // 2~100 
		matrix = new char[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		bfs(0, 0);
		
		System.out.println(visited[N-1][M-1]);
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {r, c});
		visited[r][c] = 1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0]==N-1 && cur[1]==M-1) break;
			
			for(int i=0; i<4; i++) {
				int nr = cur[0] + dir[i][0];
				int nc = cur[1] + dir[i][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				
				if(matrix[nr][nc]=='1' && visited[nr][nc]==0) { 
					visited[nr][nc] = visited[cur[0]][cur[1]]+1;
					
					queue.add(new int[] {nr, nc});
				}
			}
		}
	}
}

package 탐색;

import java.util.*;
import java.io.*;

public class boj2178_미로탐색_136ms {
	static char[][] maze;
	static int[][] distance;
	static int N, M;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 2~100
		M = Integer.parseInt(st.nextToken()); // 2~100
		distance = new int[N][M];
		
		maze = new char[N][M];
		for(int i=0; i<N; i++) {
			maze[i] = br.readLine().toCharArray();
		}
		
		// 1: 이동할 수 있는 칸, 0: 이동할 수 없는 칸 
		bfs(0, 0);
		System.out.println(distance[N-1][M-1]);
	}
	
	public static void bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {sr, sc});
		boolean[][] visited = new boolean[N][M];
		visited[sr][sc] = true; 
		distance[sr][sc] = 1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
						
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dir[d][0];
				int nc = cur[1]+dir[d][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue; 
				if(visited[nr][nc] || maze[nr][nc]=='0') continue; 
				distance[nr][nc] = distance[cur[0]][cur[1]]+1;
				if(nr == N-1 && nc == M-1) return;
				visited[nr][nc] = true; 
				queue.add(new int[] {nr, nc});
			}
		}
	}
}

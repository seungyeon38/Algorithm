package day4;

import java.util.*;
import java.io.*;

public class boj5437_불_G4 {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int w, h; 
	static Queue<int[]> fires;
	static char[][] grid;
	static int min; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 1~1000
			h = Integer.parseInt(st.nextToken()); // 1~1000
			
			int[] sang_pos = new int[2]; // 상근이 위치 
			fires = new LinkedList<int[]>();
			grid = new char[h][w];
			
			for(int i=0; i<h; i++) {
				String str = br.readLine();
				for(int j=0; j<w; j++) {
					grid[i][j] = str.charAt(j);
					if(grid[i][j] == '@') sang_pos = new int[] {i, j};
					else if(grid[i][j] == '*') fires.add(new int[] {i, j});
				}
			}
			
//			'.': 빈 공간
//			'#': 벽
//			'@': 상근이의 시작 위치
//			'*': 불
			
			// 매 초마다, 불은 동서남북 방향으로 인접한 빈 공간으로 퍼져나간다. 
			// 상근이는 벽을 통과할 수 없고, 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동할 수 없다.
			// 상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다.
			
			min = Integer.MAX_VALUE;
			bfs(sang_pos[0], sang_pos[1]);
			
			if(min != Integer.MAX_VALUE) {
				sb.append(min).append("\n");
			} else sb.append("IMPOSSIBLE").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int sr, int sc) {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(sr, sc, 0));
		boolean[][] visited = new boolean[h][w];
		visited[sr][sc] = true; 
		
		while(!q.isEmpty()) {
			// 불 퍼짐 
			for(int i=0,size=fires.size(); i<size; i++) {
				int[] p = fires.poll();
				
				for(int d=0; d<4; d++) {
					int nr = p[0]+dir[d][0];
					int nc = p[1]+dir[d][1];
					
					if(isOut(nr, nc)) continue; // 범위를 벗어나면 X
					if(grid[nr][nc]=='#' || grid[nr][nc]=='*') continue; // 벽이면 X 
					
					fires.add(new int[] {nr, nc}); 
					grid[nr][nc] = '*';
				}
			}
			
			for(int i=0,size=q.size(); i<size; i++) {
				Position p = q.poll();
				
				for(int d=0; d<4; d++) {
					int nr = p.r+dir[d][0];
					int nc = p.c+dir[d][1];
					
					if(isOut(nr, nc)) { // 탈출 
						min = Math.min(min, p.distance+1);
						continue; 
					}
					
					if(visited[nr][nc]) continue; // 방문한 곳이면 X 
					if(grid[nr][nc]=='#' || grid[nr][nc]=='*') continue; // 벽이나 불이 있는 곳이면 X

					q.add(new Position(nr, nc, p.distance+1));
					visited[nr][nc] = true; 
					grid[nr][nc] = '@'; // 사람이 있는 곳 
				}
			}
		}
		
	}
	
	public static boolean isOut(int r, int c) {
		boolean result = false;
		
		if(r<0 || r>=h || c<0 || c>=w) {
			result = true; 
		}
		
		return result;
	}
	
	public static class Position{
		int r;
		int c;
		int distance; 
		
		Position(int r, int c, int distance){
			this.r = r;
			this.c = c;
			this.distance = distance; 
		}
	}
}

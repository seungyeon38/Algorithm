package class4_2;

import java.util.*;
import java.io.*;

public class boj2206_벽부수고이동하기_G3_888ms {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N, M;
	static int[][][] distance; 
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~1000
		M = Integer.parseInt(st.nextToken()); // 1~1000
		
		map = new char[N][M];
		distance = new int[N][M][2];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		bfs(0, 0);
		
		if(distance[N-1][M-1][0]==0 && distance[N-1][M-1][1]==0) {
			System.out.println("-1");
		} else if(distance[N-1][M-1][0]==0) {
			System.out.println(distance[N-1][M-1][1]);
		} else if(distance[N-1][M-1][1]==0) {
			System.out.println(distance[N-1][M-1][0]);
		} else {
			System.out.println(Math.min(distance[N-1][M-1][0], distance[N-1][M-1][1]));
		}
	}
	
	public static void bfs(int sx, int sy) {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(sx, sy, false));
		boolean[][][] visited = new boolean[N][M][2];
		visited[sx][sy][0] = true; 
		distance[sx][sy][0] = 1;
		
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = cur.x + dir[d][0];
				int ny = cur.y + dir[d][1];
				
				if(isOut(nx, ny)) continue; 
				if(visited[nx][ny][cur.broke ? 1 : 0]) continue; 
				
				if(cur.broke) { // 벽을 부신 적이 있는 경우 
					// 더이상 벽을 부실 수 없음 
					if(map[nx][ny] == '0') {
						distance[nx][ny][1] = distance[cur.x][cur.y][1]+1; 
						visited[nx][ny][1] = true; 
						queue.add(new Pos(nx, ny, true));
					}
				} else { // 벽을 부신 적이 없는 경우 
					if(map[nx][ny] == '0') {
						distance[nx][ny][0] = distance[cur.x][cur.y][0]+1; 
						visited[nx][ny][0] = true; 
						queue.add(new Pos(nx, ny, false));
					} else { // 벽인 경우 
						distance[nx][ny][1] = distance[cur.x][cur.y][0]+1; 
						visited[nx][ny][1] = true; 
						queue.add(new Pos(nx, ny, true));
					}
				}
			}
		}
	}
	
	public static boolean isOut(int r, int c) {
		if(r<0 || r>=N || c<0 || c>=M) return true;
		
		return false; 
	}
	
	public static class Pos{
		int x;
		int y; 
		boolean broke; 
		
		Pos(int x, int y, boolean broke){
			this.x = x;
			this.y = y;
			this.broke = broke; 
		}
	}
}

package class4;

import java.util.*;
import java.io.*;

public class boj2206_벽부수고이동하기 {
	static char[][] grid; 
	static int N, M;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 1000
		M = Integer.parseInt(st.nextToken()); // 1000
		grid = new char[N][M];
		
		for(int i=0; i<N; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][M][2]; // 0: 벽 부시지X, 1: 벽 부심
		
		bfs();
	}
	
	public static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.offer(new Node(0, 0, 1, false));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.r == N-1 && node.c == M-1) {
				System.out.println(node.cnt);
				return; 
			}
			
			for(int d=0; d<4; d++) {
				int nr = node.r + dir[d][0];
				int nc = node.c + dir[d][1];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				
				if(grid[nr][nc] == '0') { // 벽X
					if(node.broke && !visited[nr][nc][1]) { // 벽을 부신 적이 있을 때 
						queue.offer(new Node(nr, nc, node.cnt+1, true));
						visited[nr][nc][1] = true;
					} else if(!node.broke && !visited[nr][nc][0]) { // 벽을 부신 적이 없을 때
						queue.offer(new Node(nr, nc, node.cnt+1, false));
						visited[nr][nc][0] = true;
					}
				} else if(grid[nr][nc] == '1' && !visited[nr][nc][1]) { // 벽
					if(!node.broke) { // 벽을 부신 적이 없으면 
						queue.offer(new Node(nr, nc, node.cnt+1, true));
						visited[nr][nc][1] = true;
					}
				}
			}
		}
		
		System.out.println("-1");
	}
	
	public static class Node{
		int r; 
		int c; 
		int cnt;		
		boolean broke; 
		
		Node(int r, int c, int cnt, boolean broke){
			this.r = r;
			this.c = c;
			this.cnt = cnt; 
			this.broke = broke;
		}
	}
}

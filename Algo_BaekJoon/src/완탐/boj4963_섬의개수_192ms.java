package 완탐;

import java.util.*;
import java.io.*;

public class boj4963_섬의개수_192ms {
	static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken()); // 1~50
		int h = Integer.parseInt(st.nextToken()); // 1~50
		StringBuilder sb = new StringBuilder();
		
		while(!(w==0 && h==0)) {
			int[][] map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 1:땅, 0:바다 
				}
			}
			
			int cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1) {
						cnt++;
						dfs(map, i, j, h, w);
					}
				}
			}
			
			sb.append(cnt).append("\n");
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int[][] map, int sr, int sc, int h, int w) {
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] {sr, sc});
		
		while(!stack.isEmpty()) {
			int[] cur = stack.pop();
			
			if(map[cur[0]][cur[1]] == 0) continue; 
			map[cur[0]][cur[1]] = 0;
			
			for(int d=0; d<8; d++) {
				int nr = cur[0]+dir[d][0];
				int nc = cur[1]+dir[d][1];
				
				if(nr<0 || nr>=h || nc<0 || nc>=w) continue;
				if(map[nr][nc] == 0) continue; 
				
				stack.add(new int[] {nr, nc});
			}
		}
	}
}

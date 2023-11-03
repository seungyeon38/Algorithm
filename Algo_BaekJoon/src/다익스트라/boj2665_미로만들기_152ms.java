package 다익스트라;

import java.util.*;
import java.io.*;

public class boj2665_미로만들기_152ms {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 1~50
		char[][] rooms = new char[n][n];
		for(int i=0; i<n; i++) {
			rooms[i] = br.readLine().toCharArray();
		}
		
		int[][] change_cnt = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				change_cnt[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs(n, rooms, change_cnt);
		
		System.out.println(change_cnt[n-1][n-1]);
	}
	
	public static void bfs(int n, char[][] rooms, int[][] change_cnt) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		change_cnt[0][0] = 0;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();			
			
			for(int d=0; d<4; d++) {
				int nr = cur[0]+dir[d][0];
				int nc = cur[1]+dir[d][1];
				
				if(nr<0 || nr>=n || nc<0 || nc>=n || change_cnt[nr][nc]<=change_cnt[cur[0]][cur[1]]) continue; 
				if(rooms[nr][nc] == '0') change_cnt[nr][nc] = change_cnt[cur[0]][cur[1]]+1;
				else change_cnt[nr][nc] = change_cnt[cur[0]][cur[1]];
				
				queue.add(new int[] {nr, nc});
			}
		}	
	}
}

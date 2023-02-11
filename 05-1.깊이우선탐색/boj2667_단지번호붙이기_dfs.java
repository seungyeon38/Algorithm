package Algorithm;

import java.util.*;
import java.io.*;

public class boj2667_dfs {
	static int[][] arr;
	static boolean[][] visited; 
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 25
		
		StringTokenizer st;
		
		arr = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];
		
		int N_1 = N+1;
		
		for(int i=0; i<=N_1; i++){
			visited[0][i] = true; 
			visited[N_1][i] = true; 
			visited[i][0] = true; 
			visited[i][N_1] = true; 
		}
		
		for(int i=1; i<=N; i++) {
			char[] line = br.readLine().toCharArray();
			
			for(int j=1; j<=N; j++) {
				arr[i][j] = line[j-1]-'0';
			}
		}
		
		int num = 2; 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(arr[i][j] == 1) {
					dfs(num++, i, j);
				}
			}
		}
		
		int[] result = new int[num];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(arr[i][j] == 0) continue;
				result[arr[i][j]]++;
			}
		}
		
		Arrays.sort(result);
				
		StringBuilder sb = new StringBuilder();
		
		sb.append(num-2).append("\n");
		
		for(int i=0; i<num; i++) {
			if(result[i] == 0) continue; 
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n, int r, int c) {
		arr[r][c] = n;
		visited[r][c] = true; 
		
		for(int d=0; d<4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			
			if(arr[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(n, nr, nc);
			}
		}
	}
}

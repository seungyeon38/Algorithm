package 구현;

import java.util.*;
import java.io.*;

public class boj1388_바닥장식_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로 크기 1~50
		int M = Integer.parseInt(st.nextToken()); // 가로 크기 1~50 
		
		// 나무 판자 개수 
		char[][] grid = new char[N][M];
		for(int i=0; i<N; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(visited[r][c]) continue; 
				
				visited[r][c] = true;
				
				int temp_r = r;
				int temp_c = c;
				if(grid[r][c] == '|') {
					cnt++;
					temp_r++;
					while(temp_r<N && grid[temp_r][c]=='|' && !visited[temp_r][c]) {
						visited[temp_r][c] = true;
						temp_r++;
					}
				} else if(grid[r][c] == '-'){
					cnt++;
					temp_c++;
					while(temp_c<M && grid[r][temp_c]=='-' && !visited[r][temp_c]) {
						visited[r][temp_c] = true;
						temp_c++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}

package 자료구조;

import java.util.*;
import java.io.*;

public class boj11660_구간합구하기5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 표의 크기 1~1024
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 1~100000
		
		int[][] grid = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] sum = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+grid[i][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			sb.append(sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

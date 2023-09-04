package Algorithm;

import java.util.*;
import java.io.*;

public class boj16724_피리부는사나이 {
	static int[] parents; 
	static int[][] dir;
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1000
		M = Integer.parseInt(st.nextToken()); // 1000
		
		char[][] arr = new char[N][M];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U, D, L, R
		
		// 서로소 집합 
		parents = new int[N*M];
		
		// 초기화 
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				parents[r*M + c] = r*M + c;
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				int nr=-1, nc=-1;
				
				switch(arr[r][c]) {
				case 'U': 
					nr = r + dir[0][0];
					nc = c + dir[0][1];
					break; 
				case 'D':
					nr = r + dir[1][0];
					nc = c + dir[1][1];
					break;
				case 'L':
					nr = r + dir[2][0];
					nc = c + dir[2][1];
					break;
				case 'R':
					nr = r + dir[3][0];
					nc = c + dir[3][1];
				}

				union(r*M+c, nr*M+nc);
			}
		}
		
		boolean[] result_arr = new boolean[N*M];
		int result = 0; 

		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				int p = find(parents[r*M+c]);
				if(!result_arr[p]) {
					result++;
					result_arr[p] = true; 
				}
			}
		}

		System.out.println(result);
	}
	
	public static void union(int n1, int n2) {
		int n1_p = find(n1);
		int n2_p = find(n2);
		
		if(n1_p > n2_p) {
			parents[n1_p] = n2_p;
		} else if(n1_p < n2_p) {
			parents[n2_p] = n1_p;
		}
	}
	
	public static int find(int n) {
		if(parents[n] == n) return n;
		
		return parents[n] = find(parents[n]);
	}
}

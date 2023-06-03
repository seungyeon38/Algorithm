package class4_2;

import java.util.*;
import java.io.*;

public class boj17070_파이프옮기기1_564ms {
	static int[][] house; 
	static int N; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 집의 크기 3~16 
		house = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(house[N-1][N-1] == 1) System.out.println("0");
		else {			
			System.out.println(bfs(0, 1, 0));
		}
	}
	
	public static int bfs(int sr, int sc, int d) {
		Queue<Pipe> q = new LinkedList<Pipe>();
		q.add(new Pipe(sr, sc, d));
		int result = 0;
		
		while(!q.isEmpty()) {
			Pipe cur = q.poll();
			
			if(cur.loc_r == N-1 && cur.loc_c == N-1) {
				result++;
				continue; 
			}
			
			if(cur.d == 0) { // 가로 
				if(isPossible(0, cur.loc_r, cur.loc_c)) {
					q.add(new Pipe(cur.loc_r, cur.loc_c+1, 0));
				}
				if(isPossible(2, cur.loc_r, cur.loc_c)) {
					q.add(new Pipe(cur.loc_r+1, cur.loc_c+1, 2));
				}
			} else if(cur.d == 1) { // 세로 
				if(isPossible(1, cur.loc_r, cur.loc_c)) {
					q.add(new Pipe(cur.loc_r+1, cur.loc_c, 1));
				}
				if(isPossible(2, cur.loc_r, cur.loc_c)) {
					q.add(new Pipe(cur.loc_r+1, cur.loc_c+1, 2));
				}
			} else if(cur.d == 2) { // 대각선 
				if(isPossible(0, cur.loc_r, cur.loc_c)) {
					q.add(new Pipe(cur.loc_r, cur.loc_c+1, 0));
				}
				if(isPossible(1, cur.loc_r, cur.loc_c)) {
					q.add(new Pipe(cur.loc_r+1, cur.loc_c, 1));
				}
				if(isPossible(2, cur.loc_r, cur.loc_c)) {
					q.add(new Pipe(cur.loc_r+1, cur.loc_c+1, 2));
				}
			}
		}
		
		return result; 
	}
	
	public static boolean isPossible(int d, int r, int c) {
		if(d == 0) {
			if(c+1 < N && house[r][c+1]==0) return true; 
		} else if(d == 1) {
			 if(r+1 < N && house[r+1][c]==0) return true; 
		} else if(d == 2) {
			if(r+1 < N && c+1 < N && house[r+1][c+1]==0 && house[r][c+1]==0 && house[r+1][c]==0) return true; 
		}
		
		return false; 
	}
	
	public static class Pipe{
		int loc_r;
		int loc_c; 
		int d; // 0: 가로, 1: 세로, 2: 대각선 
		
		Pipe(int r, int c, int d){
			this.loc_r = r;
			this.loc_c = c; 
			this.d = d; 
		}
	}
}

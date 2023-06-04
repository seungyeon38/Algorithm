package class4_2;

import java.io.*;
import java.util.*;

public class boj2448_별찍기11_520ms_ {
	static char[][] grid;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		int temp = N/3; 
		int k = 0;
		while(temp > 1) {
			k++;
			temp /= 2; 
		}
		
		// 3*2^k 
		// k+1번만큼 반복 
		// 5 
		// 5*2+1
		// (5*2+1)*2+1
		
		int c = 5; 
		for(int i=0; i<k; i++) {
			c = c*2+1;
		}
		
		grid = new char[N][c];
		
		draw(0, N-1, N);
		StringBuilder sb = new StringBuilder(); 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<c; j++) {
				if(grid[i][j] == '*') sb.append(grid[i][j]);
				else sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void draw(int r, int c, int N) {
		if(N == 3) {
			grid[r][c] = '*';
			grid[r+1][c-1] = '*';
			grid[r+1][c+1] = '*';
			grid[r+2][c-2] = '*';
			grid[r+2][c-1] = '*';
			grid[r+2][c] = '*';
			grid[r+2][c+1] = '*';
			grid[r+2][c+2] = '*';
		} else {
			int half = N/2; 
			draw(r, c, half);
			draw(r+half, c-half, half);
			draw(r+half, c+half, half);
		}
	}
}

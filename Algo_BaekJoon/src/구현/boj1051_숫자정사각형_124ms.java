package 구현;

import java.util.*;
import java.io.*;

public class boj1051_숫자정사각형_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~50 
		int M = Integer.parseInt(st.nextToken()); // 1~50 
		
		int[][] grid = new int[N][M];
		for(int i=0; i<N; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				grid[i][j] = str[j] - '0';
			}
		}
		
		int size = N<M ? N-1 : M-1; // 변의 길이-1 
		
		boolean done = false; 
		
		while(size > 0) {
			for(int r=0; r+size<N; r++) {
				for(int c=0; c+size<M; c++) {
					if((grid[r][c]==grid[r+size][c]) && (grid[r][c]==grid[r][c+size]) && (grid[r][c]==grid[r+size][c+size])) {
						done = true; 
						break;
					}
				}
				if(done) break; 
			}
			if(done) break;
			size--;
		}
		
		size++;
		System.out.println(size*size);
	}
}

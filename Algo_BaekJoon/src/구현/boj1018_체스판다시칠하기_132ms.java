package 구현;

import java.util.*;
import java.io.*;

public class boj1018_체스판다시칠하기_132ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] grid = new char[N][M];
		for(int i=0; i<N; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		// B, W 개수 차이가 가장 안 나는 곳 찾기 
		int min = 32;
		for(int i=0, max_r=N-7; i<max_r; i++) {
			for(int j=0, max_c=M-7; j<max_c; j++) {
				int temp1 = 0;
				// (0,0) B인 경우 
				for(int r=i, cnt_r=0; cnt_r<8; r++, cnt_r++) {
					for(int c=j, cnt_c=0; cnt_c<8; c++, cnt_c++) {
						if((r+c)%2 == 0) {
							// B여야 
							if(grid[r][c] != 'B') {
								temp1++;
							}
						} else {
							// W여야 
							if(grid[r][c] != 'W') {
								temp1++;
							}
						}
					}
				}
				int temp2 = 0;
				// (0,0) W인 경우 
				for(int r=i, cnt_r=0; cnt_r<8; r++, cnt_r++) {
					for(int c=j, cnt_c=0; cnt_c<8; c++, cnt_c++) {
						if((r+c)%2 == 0) {
							// W여야 
							if(grid[r][c] != 'W') {
								temp2++;
							}
						} else {
							// B여야 
							if(grid[r][c] != 'B') {
								temp2++;
							}
						}
					}
				}
				
				min = Math.min(min, Math.min(temp1, temp2));
			}
		}
		
		System.out.println(min);
	}
}

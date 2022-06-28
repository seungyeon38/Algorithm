package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 여러가지_1733_오목 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] grid = new int[19][19];
		
		for(int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<19; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int winner = 0;
		int result_r = 0;
		int result_c = 0;
	
		for(int r=0; r<19; r++) {
			for(int c=0; c<19; c++) {
				if(grid[r][c] == 1) {
					if(checkWinner(grid, r, c, 1)) {
						winner = 1; 
						result_r = r;
						result_c = c;
						break; 
					};
				}
				if(grid[r][c] == 2) {
					if(checkWinner(grid, r, c, 2)) {
						winner = 2; 
						result_r = r;
						result_c = c;
						break; 
					};
				}
			}
		}
		
		if(winner == 0) {
			System.out.println("0");
		} else {
			result_r++;
			result_c++;
			System.out.println(winner);
			System.out.println(result_r + " " + result_c);
		}
	}
	
	public static boolean checkRange(int r, int c) {
		if(r>-1 && r<19 && c>-1 && c<19) {
			return true;
		}
		return false; 
	}
	
	public static boolean checkWinner(int[][] grid, int r, int c, int p) {
		// 오른쪽 
		int temp_r = r;
		int temp_c = c;
		int cnt = 0;
		if(!checkRange(temp_r, --temp_c) || grid[temp_r][temp_c] != p) {
			temp_c++;
			while(checkRange(temp_r, temp_c) && grid[temp_r][temp_c++] == p) {
				cnt++;
			}
			if(cnt == 5) {
				return true; 
			}
		}
		// 아래쪽 
		temp_r = r; 
		temp_c = c;
		cnt = 0;
		if(!checkRange(--temp_r, temp_c) || grid[temp_r][temp_c] != p) {
			temp_r++;
			while(checkRange(temp_r, temp_c) && grid[temp_r++][temp_c] == p) {
				cnt++;
			}
			if(cnt == 5) {
				return true;
			}
		}
		// 오른쪽아래대각선 
		temp_r = r; 
		temp_c = c;
		cnt = 0;
		if(!checkRange(--temp_r, --temp_c) || grid[temp_r][temp_c] != p) {
			temp_r++;
			temp_c++;
			while(checkRange(temp_r, temp_c) && grid[temp_r++][temp_c++] == p) {
				cnt++;
			}
			if(cnt == 5) {
				return true; 
			}
		}
		// 오른쪽위대각선 
		temp_r = r; 
		temp_c = c;
		cnt = 0;
		if(!checkRange(++temp_r, --temp_c) || grid[temp_r][temp_c] != p) {
			temp_r--;
			temp_c++;
			while(checkRange(temp_r, temp_c) && grid[temp_r--][temp_c++] == p) {
				cnt++;
			}
			if(cnt == 5) {
				return true;
			}
		}
		
		return false; 
	}
}

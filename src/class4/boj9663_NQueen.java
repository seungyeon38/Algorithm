package class4;

import java.util.*;
import java.io.*;

public class boj9663_NQueen {
	static int N; 
	static boolean[][] isPossible; 
	static int[] col;
	static int result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 1~15
		isPossible = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(isPossible[i], true);
		}
		
		col = new int[N];
		
		nQueen(0);
		
		System.out.println(result);
	}
	
	public static void nQueen(int cur_r) {
		if(cur_r == N) {
			result++;
			return; 
		}
		
		for(int i=0; i<N; i++) {
			if(isPossible(cur_r, i)) {
				col[cur_r] = i; 
				nQueen(cur_r+1);
			}
		}
	}
	
	public static boolean isPossible(int r, int c) {
		for(int i=0; i<r; i++) {
			if(col[i] == c) return false; // 같은 열 X
			if(Math.abs(r-i) == Math.abs(c-col[i])) return false; // 대각선 
		}
		
		return true; 
	}
}

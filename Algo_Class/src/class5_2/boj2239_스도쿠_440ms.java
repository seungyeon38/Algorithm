package class5_2;

import java.util.*;
import java.io.*;

public class boj2239_스도쿠_440ms {
	static int[][] board;
	static ArrayList<int[]> empty;
	static boolean done; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		empty = new ArrayList<int[]>(); // 채워야되는 위치 
		
		for(int i=0; i<9; i++) {
			char[] c_arr = br.readLine().toCharArray();
			for(int j=0; j<9; j++) {
				board[i][j] = c_arr[j]-'0';
				if(board[i][j] == 0) empty.add(new int[] {i, j});
			}
		}
		
		calc(0);
	}
	
	public static void calc(int idx) {
		if(done) return; 
		
		if(idx == empty.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			
			done = true; 
			System.out.println(sb.toString());
			
			return; 
		}
		
		boolean[] isPossible = new boolean[10];
		int[] cur = empty.get(idx);
		for(int i=0; i<9; i++) {
			isPossible[board[cur[0]][i]] = true; 
			isPossible[board[i][cur[1]]] = true; 
		}
		
		int r = cur[0]/3*3;
		int c = cur[1]/3*3;
		
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				isPossible[board[i][j]] = true; 
			}
		}
		
		// 채우기 
		for(int i=1; i<10; i++) {
			if(!isPossible[i]) {
				board[cur[0]][cur[1]] = i; 
				calc(idx+1);
			}
		}
		
		board[cur[0]][cur[1]] = 0;
	}
}

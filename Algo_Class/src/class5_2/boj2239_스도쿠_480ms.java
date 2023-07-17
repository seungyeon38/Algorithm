package class5_2;

import java.util.*;
import java.io.*;

public class boj2239_스도쿠_480ms {
	static int[][] grid;
	static ArrayList<int[]> empty;
	static boolean done; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		grid = new int[9][9];
		empty = new ArrayList<int[]>(); // 채워넣어야하는 부분 
		
		for(int i=0; i<9; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<9; j++) {
				grid[i][j] = line[j]-'0';
				if(grid[i][j] == 0) empty.add(new int[] {i, j});
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
					sb.append(grid[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			done = true; 
			
			return; 
		}
			
		int[] cur = empty.get(idx);
		boolean[] num_exist = new boolean[10];
		
		// 가로
		for(int i=0; i<9; i++) {
			if(grid[cur[0]][i] != 0) num_exist[grid[cur[0]][i]] = true;
		}
		// 세로 
		for(int i=0; i<9; i++) {
			if(grid[i][cur[1]] != 0) num_exist[grid[i][cur[1]]] = true; 
		}
		// 9칸 
		int sr = cur[0]/3*3; 
		int sc = cur[1]/3*3; 
		for(int i=sr, cnt1=0; cnt1<3; cnt1++,i++) {
			for(int j=sc, cnt2=0; cnt2<3; cnt2++,j++) {
				if(grid[i][j] != 0) num_exist[grid[i][j]] = true; 
			}	
		}
		
		for(int i=1; i<=9; i++) {
			if(!num_exist[i]) {
				grid[cur[0]][cur[1]] = i;
				calc(idx+1); 
				grid[cur[0]][cur[1]] = 0;
			}
		}
	}
}

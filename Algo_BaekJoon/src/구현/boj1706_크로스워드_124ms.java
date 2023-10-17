package 구현;

import java.util.*;
import java.io.*;

public class boj1706_크로스워드_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); // 2~20
		int C = Integer.parseInt(st.nextToken()); // 2~20
		
		char[][] puzzle = new char[R][C];
		for(int i=0; i<R; i++) {
			puzzle[i] = br.readLine().toCharArray();
		}
		
		ArrayList<String> str_list = new ArrayList<>();
		for(int r=0; r<R; r++) {
			int sc = 0;
			StringBuilder sb = new StringBuilder();
			
			while(sc < C) {
				if(puzzle[r][sc] == '#') {
					if(sb.length() > 1) {
						str_list.add(sb.toString());
					}
					sb = new StringBuilder();
				} else {
					sb.append(puzzle[r][sc]);
				}
				
				sc++;
			}
			
			if(sb.length() > 1) str_list.add(sb.toString()); 
		}
		
		for(int c=0; c<C; c++) {
			int sr = 0;
			StringBuilder sb = new StringBuilder();
			
			while(sr < R) {
				if(puzzle[sr][c] == '#') {
					if(sb.length() > 1) {
						str_list.add(sb.toString());
					}
					sb = new StringBuilder();
				} else {
					sb.append(puzzle[sr][c]);
				}
				
				sr++;
			}
			
			if(sb.length() > 1) str_list.add(sb.toString()); 
		}
		
		Collections.sort(str_list);
		System.out.println(str_list.get(0));
	}
}

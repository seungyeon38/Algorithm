package 구현;

import java.util.*;
import java.io.*;

public class boj1343_폴리오미노_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] board = br.readLine().toCharArray();
		
		int idx = 0; 
		StringBuilder sb = new StringBuilder();
		while(idx < board.length) {
			if(board[idx] == '.') {
				sb.append('.');
				idx++;
				continue; 
			}
			
			// 처음에는 AAAA가 가능한지 
			int cnt = 0;
			while(idx<board.length && board[idx]=='X') {
				cnt++;
				if(cnt == 4) {
					sb.append("AAAA");
					cnt = 0;
				}
				idx++;
			}
			
			if(cnt != 0) {
				if(cnt == 2) {
					sb.append("BB");
				} else {
					System.out.println("-1");
					return; 
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}

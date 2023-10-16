package 구현;

import java.util.*;
import java.io.*;

public class boj1652_누울자리를찾아라_152ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 방 크기 1~100
		char[][] room = new char[N][N];
		
		for(int i=0; i<N; i++) {
			room[i] = br.readLine().toCharArray();
		}
		
		int cnt_r = 0;
		for(int r=0; r<N; r++) {
			for(int c=0, max=N-1; c<max; c++) {
				int temp_cnt = 0;
				boolean isEmpty = (room[r][c] == '.');
				while(c<N && room[r][c] == '.') {
					temp_cnt++; 
					c++;
				}
				if(temp_cnt >= 2) {
					cnt_r++;
				}
				if(isEmpty) c--;
			}
		}
		int cnt_c = 0;

		for(int c=0; c<N; c++) {
			for(int r=0, max=N-1; r<max; r++) {
				int temp_cnt = 0;
				boolean isEmpty = (room[r][c] == '.');
				while(r<N && room[r][c] == '.') {
					temp_cnt++; 
					r++;
				}
				if(temp_cnt >= 2) cnt_c++;
				if(isEmpty) r--;
			}
		}
		
		System.out.println(cnt_r + " " + cnt_c);
	}
}

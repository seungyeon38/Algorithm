package 구현;

import java.io.*;
import java.util.*;

public class boj1002_터렛 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken()); // 조규현 좌표 -10000~10000
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken()); // 1~10000
			int x2 = Integer.parseInt(st.nextToken()); // 류재명 좌표 
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int r_p1 = x1+r1;
			int u_p1 = y1+r1;
			int l_p1 = x1-r1;
			int d_p1 = y1-r1;
			
			// 조규현 기준 류재명이 어디 있는지 판단 
			
		}
	}
}

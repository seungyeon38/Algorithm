package 구현;

import java.util.*;
import java.io.*;

public class boj1531_투명_132ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 불투명한 종이 개수 0~50
		int M = Integer.parseInt(st.nextToken()); // 0~50
		
		int[][] paper_cnt = new int[101][101];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
		
			// 종이 좌표 
			int left = Integer.parseInt(st.nextToken()); // ~100
			int down = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			int up = Integer.parseInt(st.nextToken());	
			
			for(int r=down; r<=up; r++) {
				for(int c=left; c<=right; c++) {
					paper_cnt[r][c]++;
				}
			}
		}
		
		int result = 0;
		for(int r=1; r<=100; r++) {
			for(int c=1; c<=100; c++) {
				if(paper_cnt[r][c] > M) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}

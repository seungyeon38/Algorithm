package class5_2;

import java.util.*;
import java.io.*;

public class boj10942_팰린드롬_812ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수열의 크기 1~2000
		int[] nums = new int[N]; 
		boolean[][] pal = new boolean[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			pal[i][i] = true; 
		}
		
		for(int i=1; i<N; i++) {
			if(nums[i-1] == nums[i]) {
				pal[i-1][i] = true; 
			}
		}
		
		for(int i=2; i<N; i++) { // 길이
			for(int j=0; j<N-i; j++) { // 처음 지점 
				if(pal[j+1][j+i-1] && nums[j]==nums[j+i]) {
					pal[j][j+i] = true; 
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine()); // 질문 개수 
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if(pal[S-1][E-1]) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb.toString());
	}
}

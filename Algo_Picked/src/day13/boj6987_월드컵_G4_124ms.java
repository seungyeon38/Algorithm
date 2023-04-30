package day13;

import java.util.*;
import java.io.*;

public class boj6987_월드컵_G4_124ms {
	public static int[][] arr_result;
	public static int[][] match;
	public static int match_n = 6*5/2;
	public static boolean isPossible; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 각 나라의 승,무,패 합이 5
		// 전체 승의 합 = 전체 패의 합 
		// 무승부는 혼자서 다 X, 한 나라 : 다른 나라 = 1:1
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<4; t++) {
			// 예제처럼 만듦
			arr_result = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<6; i++) {
				for(int j=0; j<3; j++) {
					arr_result[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 각 나라의 승,무,패 합이 5 임을 확인 
			boolean result = true; 
			for(int i=0; i<6; i++) {
				int sum = 0;
				for(int j=0; j<3; j++) {
					sum += arr_result[i][j];
				}
				if(sum != 5) {
					result = false; 
					break; 
				}
			}
			
			if(!result) {
				sb.append("0 ");
				continue; 
			}
			
			// 전체 승의 합 = 전체 패의 합 임을 확인 
			int win_sum = 0; 
			int lose_sum = 0;
			for(int i=0; i<6; i++) {
				win_sum += arr_result[i][0];
				lose_sum += arr_result[i][2];
			}
			if(win_sum != lose_sum) {
				sb.append("0 ");
				continue; 
			}
			
			// 경기 
			match = new int[match_n][2];
			int idx = 0; 
			for(int i=0; i<5; i++) {
				for(int j=i+1; j<6; j++) {
					match[idx][0] = i;
					match[idx][1] = j;
					idx++;
				}
			}
			
			backtracking(0);
			if(isPossible) sb.append("1 ");
			else sb.append("0 ");
			isPossible = false; 
		}
		
		System.out.println(sb.toString());
	}
	
	public static void backtracking(int n) {
		if(isPossible) return; 
		
		if(n == match_n) {
			isPossible = true; 
			return; 
		}
		
		int p1 = match[n][0];
		int p2 = match[n][1];
		
		for(int i=0; i<3; i++) {
			if(arr_result[p1][i]==0 || arr_result[p2][2-i]==0) continue; 
			arr_result[p1][i]--;
			arr_result[p2][2-i]--;
			backtracking(n+1);
			arr_result[p1][i]++;
			arr_result[p2][2-i]++;
		}
	}
}

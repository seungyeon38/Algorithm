package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도형만들기2_1707_달팽이사각형_정리잘돼있음 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int cur_r = 0;
		int cur_c = -1;
		int num = 1;
		int cnt = n;
		
		while(cnt > 0) {
			for(int i=0; i<cnt; i++) {
				arr[cur_r][++cur_c] = num++;
			}
			
			cnt--; 
			
			for(int i=0; i<cnt; i++) {
				arr[++cur_r][cur_c] = num++;
			}
			
			for(int i=0; i<cnt; i++) {
				arr[cur_r][--cur_c] = num++;
			}
			
			cnt--;
			
			for(int i=0; i<cnt; i++) {
				arr[--cur_r][cur_c] = num++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}

package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 도형만들기2_1495_대각선지그재그_다시 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 2*n-1;
		int temp_cnt;
		
		int[][] arr = new int[n][n];
		
		int cur_r = 0; 
		int cur_c = 0;
		int num = 1;
		for(int i=1; i<=cnt; i++) {
			if(i>n) temp_cnt = 2*n-i;
			else temp_cnt = i;
			
			if(i%2 != 0) {
				for(int j=0; j<temp_cnt; j++) {
					arr[cur_r++][cur_c--] = num++;
				}		
				if(i<n) cur_c++;
				else {
					cur_r--;
					cur_c+=2;
				}
			} else {
				for(int j=0; j<temp_cnt; j++) {
					arr[cur_r--][cur_c++] = num++;
				}
				if(i<n) cur_r++;
				else {
					cur_r+=2;
					cur_c--;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 도형만들기2_2074_홀수마방진 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
//		int size = n+2;
//		int[][] arr = new int[size][size];
//		int size_ = n+1;
		
		int[][] arr = new int[n][n];
		
//		for(int i=0; i<size; i++) {
//			arr[0][i] = -1;
//			arr[size_][i] = -1;
//			arr[i][0] = -1;
//			arr[i][size_] = -1;
//		}
		
//		int half = n/2+1;
		int max_arr = n-1;
		
		int num = 1;
		int max_num = n*n;
		int cur_r = 0;
		int cur_c = n/2;
		
		while(num<=max_num) {
			arr[cur_r][cur_c] = num;
			
			if(num%n == 0) {
				cur_r++;
			} else {
				cur_r--;
				cur_c--;
			}
			
			if(cur_c == -1) {
				cur_c = max_arr;
			}
			if(cur_r == -1) {
				cur_r = max_arr;
			} else if(cur_r == n) {
				cur_r = 0;
			}
				
			num++;
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

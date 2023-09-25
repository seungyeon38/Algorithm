package 구현;

import java.util.*;
import java.io.*;

public class boj1347_미로만들기_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~49 
		char[] move = br.readLine().toCharArray();
		
		int cur_d = 2; // 북:0, 동:1, 남:2, 서:3 동:0, 서:1, 남:2, 북:3
		
		// 처음 위치가 0,0 이라고 가정
		int cur_r = 0;
		int cur_c = 0;
		
		int up_min = 0;
		int down_max = 0;
		int left_min = 0;
		int right_max = 0;
		
		// 상하좌우로 어디까지 움직이는지 
		for(char c : move) {
			switch(c) {
			case 'F': // 앞으로 한칸 이동 
				switch(cur_d) {
				case 0: // 북 
					cur_r--;
					up_min = Math.min(up_min, cur_r);
					break;
				case 1: // 동 
					cur_c++;
					right_max = Math.max(right_max, cur_c);
					break;
				case 2: // 남
					cur_r++;
					down_max = Math.max(down_max, cur_r);
					break;
				case 3: // 서 
					cur_c--;
					left_min = Math.min(left_min, cur_c);
					break;
				}
				
				break;
			case 'R': // 오른쪽으로 90도 회전 cur_d를 
				cur_d++;
				cur_d %= 4;
				break;
			case 'L': // 왼쪽으로 90도 회전 
				cur_d--;
				if(cur_d == -1) cur_d = 3;
				break;
			}
		}
		
		int r_cnt = down_max-up_min+1;
		int c_cnt = right_max-left_min+1;
		
		boolean[][] grid = new boolean[r_cnt][c_cnt];
		
		cur_r = up_min*(-1);
		cur_c = left_min*(-1);
		cur_d = 2;
		grid[cur_r][cur_c] = true; 
		
		for(char c : move) {
			switch(c) {
			case 'F': // 앞으로 한칸 이동 
				switch(cur_d) {
				case 0: // 북 
					cur_r--;
					grid[cur_r][cur_c] = true; 
					break;
				case 1: // 동 
					cur_c++;
					grid[cur_r][cur_c] = true; 
					break;
				case 2: // 남
					cur_r++;
					grid[cur_r][cur_c] = true; 
					break;
				case 3: // 서 
					cur_c--;
					grid[cur_r][cur_c] = true; 
					break;
				}
				
				break;
			case 'R': // 오른쪽으로 90도 회전 cur_d를 
				cur_d++;
				cur_d %= 4;
				break;
			case 'L': // 왼쪽으로 90도 회전 
				cur_d--;
				if(cur_d == -1) cur_d = 3;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<r_cnt; i++) {
			for(int j=0; j<c_cnt; j++) {
				if(grid[i][j]) {
					sb.append(".");
				} else sb.append("#");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

package 구현;

import java.util.*;
import java.io.*;

public class boj1089_스타트링크타워 {
	static char[][][] nums = {{{'#','#','#'}, {'#','.','#'}, {'#','.','#'}, {'#','.','#'}, {'#','#','#'}},
							  {{'.','.','#'}, {'.','.','#'}, {'.','.','#'}, {'.','.','#'}, {'.','.','#'}},
							  {{'#','#','#'}, {'.','.','#'}, {'#','#','#'}, {'#','.','.'}, {'#','#','#'}},
							  {{'#','#','#'}, {'.','.','#'}, {'#','#','#'}, {'.','.','#'}, {'#','#','#'}},
							  {{'#','.','#'}, {'#','.','#'}, {'#','#','#'}, {'.','.','#'}, {'.','.','#'}},
							  {{'#','#','#'}, {'#','.','.'}, {'#','#','#'}, {'.','.','#'}, {'#','#','#'}},
							  {{'#','#','#'}, {'#','.','.'}, {'#','#','#'}, {'#','.','#'}, {'#','#','#'}},
							  {{'#','#','#'}, {'.','.','#'}, {'.','.','#'}, {'.','.','#'}, {'.','.','#'}},
							  {{'#','#','#'}, {'#','.','#'}, {'#','#','#'}, {'#','.','#'}, {'#','#','#'}},
							  {{'#','#','#'}, {'#','.','#'}, {'#','#','#'}, {'.','.','#'}, {'#','#','#'}},
							  };
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~9
		int width = 4*N-1;
		char[][] num = new char[5][width];
		
		for(int i=0; i<5; i++) {
			num[i] = br.readLine().toCharArray();
		}
		
		ArrayList<Integer>[] possible = new ArrayList[N];
		for(int i=0; i<N; i++) {
			possible[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++) {
			char[][] n = new char[5][3]; // 안내판 숫자 
			int start_c = 4*i;
			
			for(int r=0; r<5; r++) {
				for(int c=0; c<3; c++) {
					n[r][c] = num[r][start_c+c];
				}
			}
			possible[i] = isPossible(n);
		}

		int[] digit_cnt = new int[N];
		int[] digit_sum = new int[N];
		int total_cnt = 1;

		for(int i=N-1; i>=0; i--) {
			int digit = (int)Math.pow(10, N-i-1);
			
			int temp_cnt = 0;
			int temp_sum = 0;
			
			for(int n : possible[i]) {
				System.out.print(n+" ");
				temp_cnt++;
				temp_sum += n;
			}
			System.out.println();
			digit_sum[i] = temp_sum*digit;
			digit_cnt[i] = temp_cnt;
			total_cnt *= temp_cnt;
		}
		
		int total_sum = 0; 
		for(int i=0; i<N; i++) {
			int sum = digit_sum[i];
			int cnt = 1;
			for(int j=0; j<N; j++) {
				if(i == j) continue; 
				cnt *= digit_cnt[i];
			}
			
			total_sum += sum*cnt;
		}
		
		if(total_cnt == 0) System.out.println("-1");
		else System.out.println((double)total_sum/total_cnt);
	}
	
	public static ArrayList<Integer> isPossible(char[][] num) {
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			boolean temp = true;
			// 가능한지 확인 
			for(int r=0; r<5; r++) {
				for(int c=0; c<3; c++) {
					if(nums[i][r][c]=='.' && num[r][c]=='#') {
						temp = false; 
						break;
					}
				}
				if(!temp) break;
			}
			if(temp) result.add(i);
		}
		
		return result;
	}
}

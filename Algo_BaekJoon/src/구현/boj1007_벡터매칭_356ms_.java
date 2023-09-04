package 구현;

import java.util.*;
import java.io.*;

public class boj1007_벡터매칭_356ms_ {
	static int N;
	static int[][] matrix;
	static boolean[] selected;
	static double min;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine()); // 점의 개수 1~20
			matrix = new int[N][2];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				matrix[i][0] = Integer.parseInt(st.nextToken());
				matrix[i][1] = Integer.parseInt(st.nextToken());
			}
			
			min = Double.MAX_VALUE;
			selected = new boolean[N];
			calc(0, 0);
			
			System.out.println(min);
		}
	}
	
	public static void calc(int idx, int cnt) {
		if(cnt == N/2) {
			int result_x = 0;
			int result_y = 0;

			for(int i=0; i<N; i++) {
				if(selected[i]) {
					result_x += matrix[i][0];
					result_y += matrix[i][1];
				}
				else {
					result_x -= matrix[i][0];
					result_y -= matrix[i][1];
				}
			}
			
			double result = Math.sqrt(Math.pow(result_x, 2) + Math.pow(result_y, 2));
			
			if(min > result)  {
				min = result;
			}

			return;
		}
		
		for(int i=idx; i<N; i++) {
			selected[i] = true;
			calc(i+1, cnt+1);
			selected[i] = false;
		}
	}
}

package 구현;

import java.util.*;
import java.io.*;

public class boj1569_정사각형으로가리기_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N개의 점 모두를 가릴 수 있는 정사각형 구하기
		// 그 정사각형의 변의 길이 출력 
		int N = Integer.parseInt(br.readLine()); // 점 개수 
		
		int[][] points = new int[N][2];
		int up = -1001;
		int down = 1001;
		int right = -1001;
		int left = 1001;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken()); // x
			points[i][1] = Integer.parseInt(st.nextToken()); // y
			
			up = Math.max(up, points[i][1]);
			down = Math.min(down, points[i][1]);
			right = Math.max(right, points[i][0]);
			left = Math.min(left, points[i][0]);
		}
		
		int len = Math.max(up-down, right-left);
		
		if(calc(N, points, right, up, -len, -len) || calc(N, points, left, up, len, -len) || calc(N, points, right, down, -len, len) || calc(N, points, left, down, len, len)) {
			System.out.println(len);
		} else System.out.println("-1");
	}
	
	public static boolean calc(int N, int[][] points, int x, int y, int len_x, int len_y) {
		boolean result = true; 
		
		int calc_x = x+len_x;
		int calc_y = y+len_y;
		
		int right = 0;
		int left = 0;
		int up = 0;
		int down = 0;
		
		if(calc_x > x) {
			right = calc_x;
			left = x;
		} else {
			right = x;
			left = calc_x;
		}
		
		if(calc_y > y) {
			up = calc_y;
			down = y;
		} else {
			up = y;
			down = calc_y;
		}
	
		for(int i=0; i<N; i++) {
			int[] point = points[i];
			
			if(point[0]!=right && point[0]!=left && point[1]!=up && point[1]!=down) {
				result = false;
				break;
			}
		}
		
		return result;
	}
}

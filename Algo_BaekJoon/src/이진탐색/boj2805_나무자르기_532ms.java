package 이진탐색;

import java.util.*;
import java.io.*;

public class boj2805_나무자르기_532ms {
	static int[] height_list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); // 나무의 수 1~1000000
		int M = Integer.parseInt(st.nextToken()); // 나무의 길이 1~2000000000
		
		// 절단기 높이의 최댓값 구하기 
		height_list = new int[N];
		st = new StringTokenizer(br.readLine());
		int height_max = 0;
		for(int i=0; i<N; i++) {
			height_list[i] = Integer.parseInt(st.nextToken());
			height_max = Math.max(height_max, height_list[i]);
		}
		
		int sp = 0;
		int ep = height_max;
		int result = 0;
		while(sp <= ep) {
			int mid = (sp+ep)/2;
			
			long temp = cut(mid);
			
			if(temp < M) {
				ep = mid-1; 
			} else {
				result = Math.max(result, mid);
				sp = mid+1;
			}
		}
		
		System.out.println(result);
	}
	
	public static long cut(int h) {
		long result = 0;
		
		for(int tree_h : height_list) {
			if(tree_h-h > 0) result += tree_h-h;
		}
		
		return result;
	}
}

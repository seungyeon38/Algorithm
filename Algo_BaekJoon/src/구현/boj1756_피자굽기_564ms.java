package 구현;

import java.util.*;
import java.io.*;

public class boj1756_피자굽기_564ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken()); // 오븐의 깊이 1~300000
		int N = Integer.parseInt(st.nextToken()); // 피자 반죽의 개수 1~300000
		
		int[] depth = new int[D]; // 오븐 깊이 
		st = new StringTokenizer(br.readLine());
		depth[D-1] = Integer.parseInt(st.nextToken());
		for(int i=D-2; i>=0; i--) {
			depth[i] = Math.min(Integer.parseInt(st.nextToken()), depth[i+1]);
		}
						
		st = new StringTokenizer(br.readLine());
		int left = 0;

		for(int i=0; i<N; i++) {
			int size = Integer.parseInt(st.nextToken()); // 피자 반죽 
			int idx = search(left, depth, size);
			if(idx == -1) {
				System.out.println("0");
				return;
			}
			
			left = idx+1;
		}
		
		System.out.println(D-left+1);
	}
	
	public static int search(int left, int[] depth, int size) {
		int right = depth.length-1; // right 
		boolean hasResult = false; 
		
		while(left <= right) {
			int mid = (left+right)/2;

			if(depth[mid] > size) {
				right = mid-1;
				hasResult = true; 
			} else if(depth[mid] == size) {
				right--;
				hasResult = true; 
			} else {
				left = mid+1;
			}
		}
		
		if(hasResult) return left; 
		
		return -1;
	}
}

package 정렬;

import java.util.*;
import java.io.*; 

public class boj1427_소트인사이드_128ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine(); // 1~1000000000
		int length = str.length();
		int[] nums = new int[length];
		for(int i=0; i<length; i++) {
			nums[i] = str.charAt(i)-'0';
		}
	
		// 각 자리수를 내림차순으로 정렬 
		// 선택 정렬 
		// 최댓값 찾아서 정렬 
		for(int i=0; i<length; i++) { // 시작점 
			int max = -1;
			int max_idx = -1;
			for(int j=i; j<length; j++) {
				if(max < nums[j]) {
					max = nums[j];
					max_idx = j;
				}
			}
			
			int temp = nums[i];
			nums[i] = nums[max_idx];
			nums[max_idx] = temp; 
		}
		
		StringBuilder sb = new StringBuilder(); 
		for(int i=0; i<length; i++) {
			sb.append(nums[i]);
		}
		
		System.out.println(sb.toString());
	}
}

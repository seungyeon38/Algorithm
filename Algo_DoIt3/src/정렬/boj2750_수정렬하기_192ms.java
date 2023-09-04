package 정렬;

import java.util.*;
import java.io.*; 

public class boj2750_수정렬하기_192ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수의 개수 1~1000
		
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=N; i>0; i--) { // 어디까지 
			for(int j=1; j<i; j++) {
				// j부터 i까지 
				if(nums[j-1] > nums[j]) { // 바꾸기 
					int temp = nums[j-1];
					nums[j-1] = nums[j];
					nums[j] = temp; 
				}
			}
		}
		
		for(int i=0; i<N; i++) System.out.println(nums[i]);
	}
}

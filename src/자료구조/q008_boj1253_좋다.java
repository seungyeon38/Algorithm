package 자료구조;

import java.util.*;
import java.io.*;

public class q008_boj1253_좋다 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~2000
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(nums);
		int result = 0;
		
		for(int i=N-1; i>=0; i--) {
//			0~i-1 인덱스의 수를 가지고 더해서 나오나 확인 
			int num = nums[i];
			int p1 = 0; 
			int p2 = N-1;
			
			while(p1 < p2) {
				if(p1==i) {
					p1++;
				} else if(p2==i) {
					p2--;
				}
				
				if(p1 >= p2) break; 
				
//				안 나오면 계속하기 
//				나오면 그만 
				int sum = nums[p1]+nums[p2];
				if(sum == num) {
					result++;
					break; 
				} else if(sum < num) {
					p1++;
				} else {
					p2--;
				}
			}
		}
		
		System.out.println(result);
	}
}

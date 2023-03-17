package class5;

import java.util.*;
import java.io.*;

public class boj2467_용액 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 2~100000
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		
		int turn_idx = N; // - -> + 가 되는 지점 (마지막 -인 idx)
		boolean flag = false; 
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(!flag && nums[i] > 0) {
				flag = true; 
				turn_idx = i-1; 
			}
		}
	
		if(turn_idx == -1) { // turn_idx == -1 이면, 다 +
			System.out.println(nums[0]+" "+nums[1]);
		} else if(turn_idx == N) { // turn_idx == N 이면, 다 -
			System.out.println(nums[N-2]+" "+nums[N-1]);
		} else { // 이 경우가 아니면, 0~turn_idx : - , (turn_idx+1)~(N-1) : +
			int p1 = 0;
			int p2 = N-1;
			int temp = 2000000001;
			int result1 = 0;
			int result2 = N;
			
			while(p1<=turn_idx && p2>turn_idx) {
				int sum = nums[p1]+nums[p2]; 
				if(Math.abs(sum) < temp) {
					temp = Math.abs(sum);
					result1 = p1;
					result2 = p2; 
				}
				
				if(sum < 0) {
					p1++;
				} else if(sum > 0) {
					p2--;
				} else {
					System.out.println(nums[p1] + " " + nums[p2]);
					return;
				}
			}
			
			// 가장 큰 음수 두개, 가장 작은 양수 두개 따져보기 
			int m_result = 2000000001;
			int p_result = 2000000001; 
			
			if(turn_idx >= 1) {
				m_result = Math.abs(nums[turn_idx]+nums[turn_idx-1]);
			} else if(turn_idx < N-2) {
				p_result = Math.abs(nums[turn_idx+1]+nums[turn_idx+2]);
			}
			
			if(Math.abs(m_result) <= Math.abs(p_result)) {
				if(Math.abs(m_result) < Math.abs(nums[result1]+nums[result2])) {
					System.out.println(nums[turn_idx-1] + " " + nums[turn_idx]);
				} else {
					System.out.println(nums[result1] + " " + nums[result2]);
				}
			} else {
				if(Math.abs(p_result) < Math.abs(nums[result1]+nums[result2])) {
					System.out.println(nums[turn_idx+1] + " " + nums[turn_idx+2]);
				} else {
					System.out.println(nums[result1] + " " + nums[result2]);
				}
			}
		}
	}
}

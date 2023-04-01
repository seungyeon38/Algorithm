package class5;

import java.util.*;
import java.io.*;

public class boj2467_용액_2 {
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
			
			while(p1 < p2) {
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
					return;
				}
			}
			
			System.out.println(nums[result1] + " " + nums[result2]);
		}
	}
}

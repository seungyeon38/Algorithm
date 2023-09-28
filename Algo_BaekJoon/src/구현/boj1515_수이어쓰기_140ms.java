package 구현;

import java.util.*;
import java.io.*;

public class boj1515_수이어쓰기_140ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] nums = br.readLine().toCharArray(); // 이어붙인 수 1~3000자리 
		
		// N의 최솟값 
		int cur_n = 1;
		int cur_idx = 0;
		while(cur_idx < nums.length) {
			// 현재 숫자에 현재 인덱스의 수가 포함되면 넘기기 
			// 여러자리 수 일 경우, 비교하면서 넘기기 
			char[] cur = Integer.toString(cur_n).toCharArray();
			int idx = 0;
			while(idx < cur.length) {
				if(nums[cur_idx] == cur[idx]) {
					idx++;
					cur_idx++;
					if(cur_idx == nums.length) break;
				} else {
					idx++;
				}
			}
			cur_n++;
		}
			
		System.out.println(cur_n-1);
	}
}

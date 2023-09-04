package a_자료구조;

import java.util.*;
import java.io.*;

public class boj1253_좋다_168ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수의 개수 1~2000
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); // -1000000000~1000000000
		}
		
		Arrays.sort(nums);
		
		int result = 0;
		for(int i=0; i<N; i++) {
			int p1 = 0;
			int p2 = N-1; 
			while(p1 < p2) {
				int sum = nums[p1]+nums[p2];
				if(sum < nums[i]) p1++;
				else if(sum > nums[i]) p2--;
				else {
					if(p1 == i) p1++;
					else if(p2 == i) p2--;
					else {
						result++;
						break;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}

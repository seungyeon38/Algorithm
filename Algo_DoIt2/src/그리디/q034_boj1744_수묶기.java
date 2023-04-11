package 그리디;

import java.util.*;
import java.io.*;

public class q034_boj1744_수묶기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수열의 크기 1~50
		int[] nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine()); // -1000~1000
		}
		
		Arrays.sort(nums);
		
		if(N == 1) {
			System.out.println(nums[0]); 
			return; 
		}
		
		boolean[] visited = new boolean[N];
		int result = 0; 
		int n1 = N-1;
		int n2 = N-2;
		
		while(n1>=0 && n2>=0 && nums[n1]>1 && nums[n2]>1) {
			result += nums[n1]*nums[n2];
			visited[n1] = true; 
			visited[n2] = true; 
			
			n1 -= 2;
			n2 -= 2;
		}

		n1 = 0; 
		n2 = 1;
		
		while(n1<N && n2<N && nums[n1]<0 && nums[n2]<0 && !visited[n1] && !visited[n2]) {
			result += nums[n1]*nums[n2];
			visited[n1] = true; 
			visited[n2] = true; 
			
			n1 += 2;
			n2 += 2;
		}
		
		if(n1<N && n2<N && nums[n1]<0 && nums[n2]==0) {
			visited[n1] = true; 
			visited[n2] = true;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				result += nums[i];
			}
		}
		
		System.out.println(result);
	}
}

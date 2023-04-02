package 자료구조;

import java.util.*;
import java.io.*;

public class q011_boj1874_스택수열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 1~100000
		int[] nums = new int[n];
		
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(br.readLine()); 
		}
		
		int temp_n = 1;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack();
		boolean flag = true; 
		
		for(int i=0; i<n; i++) {
			if(temp_n <= nums[i]) {  // 1 2 3 4 
				while(temp_n <= nums[i]) {
					stack.push(temp_n);
					sb.append("+\n");
					temp_n++;
				}
				stack.pop();
				sb.append("-\n");
			} else {
				if(stack.peek() == nums[i]) {
					stack.pop();
					sb.append("-\n");
				} else {
					System.out.println("NO");
					flag = false; 
					break;
				}
			}
		}
		
		if(flag) System.out.println(sb.toString());
	}
}

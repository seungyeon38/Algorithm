package 자료구조;

import java.util.*;
import java.io.*;

public class q012_boj17298_오큰수구하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~1000000
		
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int[] result = new int[N];
		
		for(int i=0; i<N; i++) {
			if(stack.isEmpty()) stack.push(i);
			else {
				while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) { // stack top이 더 작으면 
					result[stack.pop()] = nums[i];
				}
				stack.push(i);
			}
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder(); 
		
		for(int i=0; i<N; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}

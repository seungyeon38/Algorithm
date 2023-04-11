package 그리디;

import java.util.*;
import java.io.*;

public class q036_boj1541_잃어버린괄호 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine(); 
		
		int length = str.length();
		int idx = 0;
		
		Stack<Integer> nums = new Stack<Integer>();
		Stack<Character> signs = new Stack<Character>();

		
		while(idx < length) {
			int n_idx = idx;
			
			while(n_idx<length && str.charAt(n_idx)!='-' && str.charAt(n_idx)!='+') {
				n_idx++;
			}
			
			// idx~n_idx가 수 
			int n = Integer.parseInt(str.substring(idx, n_idx));
			nums.add(n);
			
			if(n_idx<length) signs.add(str.charAt(n_idx));
			
			idx = n_idx+1;
		}

		int result = 0; 
		while(!nums.isEmpty()) {
			int temp = nums.pop();
			while(!signs.isEmpty() && signs.peek()!='-') {
				temp += nums.pop();
				signs.pop();
			}
			if(!signs.isEmpty()) {
				signs.pop();
				temp *= -1;
			} 
			
			result += temp; 
		}
		
		System.out.println(result);
	}
}

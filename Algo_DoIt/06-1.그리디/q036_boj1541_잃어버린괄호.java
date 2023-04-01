package Algorithm;

import java.util.*;
import java.io.*;

public class q036_boj1541 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String st = br.readLine();
		char[] arr = st.toCharArray();
		Stack<Integer> num_stack = new Stack<Integer>();
		Stack<Character> sign_stack = new Stack<Character>();
		int start_idx = 0;
		
		for(int i=0; i<st.length(); i++) {
			if(arr[i] == '-' || arr[i] == '+') {
				num_stack.push(Integer.parseInt(st.substring(start_idx, i))); // 숫자 넣고
				sign_stack.push(arr[i]); // -, + 넣고 
				start_idx = i+1;
			}
		}
		
		num_stack.push(Integer.parseInt(st.substring(start_idx, st.length()))); // 마지막 숫자 넣기 
		
		// 계산 
		int temp_sum = num_stack.pop();
		int result = 0;
		while(!sign_stack.isEmpty()) {
			char sign = sign_stack.pop();
			
			if(sign == '-') { // 지금까지 더했던 얘들 * (-1) 해서 전체 sum에 더하기 
				result -= temp_sum;
				temp_sum = num_stack.pop();
			} else if(sign == '+') {
				temp_sum += num_stack.pop();
			}
		}
		
		result += temp_sum;
		
		System.out.println(result);
	}
}

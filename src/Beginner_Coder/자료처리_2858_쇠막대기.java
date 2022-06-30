package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 자료처리_2858_쇠막대기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			// '('이면 레이저 또는 막대기의 
			if(arr[i] == '(') {
				 if(i+1<arr.length && arr[i+1]==')') { // 레이저 
					 result += stack.size();
					 i++;
				 } else {
					 stack.push('(');
				 }
			} else {
				 result++;
				 stack.pop();
			 }
		}
		
		System.out.println(result);
	}
}

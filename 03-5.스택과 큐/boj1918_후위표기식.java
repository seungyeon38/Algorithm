package Algorithm;

import java.util.*;
import java.io.*;

public class boj1918_후위표기식 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			if(arr[i] >= 'A' && arr[i] <='Z') {
				sb.append(arr[i]);
			} else if(arr[i] == '(') {
				stack.push(arr[i]);
			} else if(arr[i] == ')') {
				while(stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else {
				char c = arr[i];
				while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
			
//			System.out.println(stack);
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}
	
	public static int precedence(char op) {
		if(op=='*' || op=='/') return 2; 
		else if(op=='+' || op=='-') return 1;
		
		return -1;
	}
}

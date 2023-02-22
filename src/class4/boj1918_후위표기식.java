package class4;

import java.util.*;
import java.io.*;

public class boj1918_후위표기식 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<input.length; i++) {
			char c = input[i]; 
			
			if(c>='A' && c<='Z') { // 알파벳일 경우 
				sb.append(c);
			} else if(c == '(') {
				stack.push(c);
			} else if(c == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else { // +, -, *, /
				while(!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
			
		System.out.println(sb.toString());
	}
	
	public static int priority(char c) {
		if(c=='-' || c=='+') {
			return 0;
		} else if(c=='*' || c=='/') {
			return 1; 
		} else { // '('
			return -1; 
		}
	}
}

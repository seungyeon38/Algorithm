package class4_2;

import java.util.*;
import java.io.*; 

public class boj1918_후위표기식_G2_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] c_list = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<Character>(); 
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<c_list.length; i++) {
			char c = c_list[i];
			if(c >= 'A' && c <= 'Z') {
				sb.append(c);
			} else {
				if(stack.isEmpty() || c == '(') stack.add(c);
				else if(c == ')') {
					// '('가 나올 때까지 pop
					while(stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop();
				} else { // +, -, *, /
					while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
						sb.append(stack.pop());
					} 
					
					stack.add(c);
				}
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}
	
	public static int precedence(char c) {
		if(c=='-' || c=='+') {
			return 0; 
		} else if(c=='*' || c=='/') {
			return 1; 
		} 
		
		return -1; 
	}
}

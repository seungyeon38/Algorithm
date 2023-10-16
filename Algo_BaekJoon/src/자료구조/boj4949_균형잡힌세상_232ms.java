package 자료구조;

import java.util.*;
import java.io.*;

public class boj4949_균형잡힌세상_232ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		while(!str.equals(".")) {
			char[] c_list = str.substring(0, str.length()-1).toCharArray();
			Stack<Character> stack = new Stack<>();
			boolean temp_result = true; 
			for(char c : c_list) {
				if(c == '(' || c == '[') {
					stack.add(c);
				} else if(c == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						temp_result = false; 
						break;
					} else {
						stack.pop();
					}
				} else if(c == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						temp_result = false; 
						break;
					} else {
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty()) temp_result = false; 
			
			sb.append(temp_result ? "yes\n" : "no\n");
			str = br.readLine();
		}
		
		System.out.println(sb.toString());
	}
}

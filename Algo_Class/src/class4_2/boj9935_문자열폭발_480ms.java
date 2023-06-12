package class4_2;

import java.util.*;
import java.io.*; 

public class boj9935_문자열폭발_480ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine(); // 문자열 1~1000000
		String explode_str = br.readLine(); // 폭발 문자열 1~36 
		int explode_length = explode_str.length(); // 폭발 문자열 길이 
		 
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0, size=str.length(); i<size; i++) {
			stack.add(str.charAt(i));
			
			if(stack.size() >= explode_length) {
				// 비교
				boolean find = true; 
				for(int j=0; j<explode_length; j++) {
					if(stack.get(stack.size()-explode_length+j) != explode_str.charAt(j)) {
						find = false; 
						break;
					}
				}
				
				if(find) {
					for(int j=0; j<explode_length; j++) {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for(char c : stack) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
	}
}

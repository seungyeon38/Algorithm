package day1;

import java.util.*;
import java.io.*;

public class boj7490_0만들기_G5 {
	static ArrayList<String> str_list; 
	static int N; 
	static StringBuilder sb;
	static char[] op = {' ', '+', '-'};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 1~10
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine()); // 3~9
			
			str_list = new ArrayList<String>();

			// 0이 되는 모든 수식 출력 
			// ' ', '+', '-'  
			// 3^8
			
			// ASCII 순서에 따라 
			// +, - 계산
			dfs(1, "");
			
			for(String str : str_list) {
				if(calc(str)) sb.append(str).append("\n");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n, String str) {
		if(n == N) {
			str += n;
			str_list.add(str);
			return; 
		}
		
		for(int i=0; i<3; i++) {
			dfs(n+1, str+n+op[i]);
		}
	}
	
	public static boolean calc(String str) {
		Stack<Integer> stack_num = new Stack<Integer>();
		Stack<Character> stack_c = new Stack<Character>();
		
		for(int i=str.length()-1; i>=0; i--) {
			char c = str.charAt(i);
			if(c==' ' || c=='+' || c=='-') {
				stack_c.add(c);
			} else {
				stack_num.add(c-'0');
			}
		}

		int result = getNum(stack_num, stack_c);

		while(!stack_c.isEmpty()) {
			int temp;
			
			if(stack_c.peek() == '+') {
				stack_c.pop();
				temp = getNum(stack_num, stack_c);
				result += temp;  
			} else if(stack_c.peek() == '-') {
				stack_c.pop();
				temp = getNum(stack_num, stack_c);
				result -= temp;
			}
		}

		if(result == 0) return true; 
		else return false; 
	}
	
	public static int getNum(Stack<Integer> stack_num, Stack<Character> stack_c) {
		int result = stack_num.pop();

		if(!stack_c.isEmpty() && stack_c.peek() == ' ') {
			while(!stack_c.isEmpty() && stack_c.peek() == ' ') {
				stack_c.pop();

				result *= 10; 
				result += stack_num.pop();
			}
		}
		
		return result; 
	}
}

package Algorithm;

import java.util.*;
import java.io.*;

public class boj1406_에디터 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int str_length = str.length();
		int M = Integer.parseInt(br.readLine());
		Stack stack_f = new Stack<Character>();
		Stack stack_b = new Stack<Character>();
		
		for(int i=0; i<str_length; i++) {
			stack_f.push(str.charAt(i));
		}
		
		for(int i=0; i<M; i++) {
			char[] c_arr = br.readLine().toCharArray();
			
			switch(c_arr[0]) {
			case 'L': // 커서를 왼쪽으로
				if(!stack_f.isEmpty()) stack_b.push(stack_f.pop());
				break;
			case 'D': // 커서를 오른쪽으로
				if(!stack_b.isEmpty()) stack_f.push(stack_b.pop());
				break;
			case 'B': // 커서 왼쪽에 있는 문자를 삭제
				if(!stack_f.isEmpty()){
					stack_f.pop();
				}
				break;
			case 'P': // 문자를 커서 왼쪽에 추가
				char s = c_arr[2];
				stack_f.push(s);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0, size=stack_f.size(); i<size; i++) {
			stack_b.push(stack_f.pop());
		}
		for(int i=0, size=stack_b.size(); i<size; i++) {
			sb.append(stack_b.pop());
		}
		
		System.out.println(sb.toString());
	}
}

package class4_2;

import java.util.*;
import java.io.*; 

public class boj9935_문자열폭발_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray(); // 문자열 1~1000000
		int str_length = str.length;
		Stack<Character> origin_str = new Stack<Character>();
		for(int i=0; i<str_length; i++) {
			origin_str.push(str[i]);
		}
		char[] explode_str = br.readLine().toCharArray(); // 폭발 문자열 1~36 
		int explode_length = explode_str.length;
		
		Stack<Character> temp_str = new Stack<Character>();
		
		// 문자열을 보면서 폭발 문자열 있는지 확인 
			// str에서 temp로 옮기면서 temp에 저장 
		// 만약 찾으면 temp에서 없애고 (폭발 문자열 길이-1)만큼 str로 옮기고 다시 비교 
		// 다 temp로 옮겨지면 끝 
		
		while(!origin_str.isEmpty()) {
			int cnt = explode_length-1; 
			
			boolean find = true; // 문자열 찾았는지 여부 
			while(cnt >= 0) {
				temp_str.push(origin_str.pop());
				
				if(explode_str[cnt] == temp_str.peek()) { // 하나씩 비교해서 맞으면 
					cnt--;
				} else { // 틀리면 
					find = false; 
					break; 
				}
			}
			
			if(find) { // 폭발 문자열 찾은 경우 
				for(int i=0; i<explode_length; i++) {
					temp_str.pop(); 
				}
				
				int pop_length = temp_str.size()<explode_length ? temp_str.size() : explode_length-1;
				for(int i=0; i<pop_length; i++) {
					origin_str.push(temp_str.pop());
				}
			} else { // 못 찾은 경우 
				for(int i=0, size=explode_length-1-cnt; i<size; i++) {
					origin_str.push(temp_str.pop());
				}
			}
		}
		
		StringBuilder sb = new StringBuilder(); 
		
		if(sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			for(char c : temp_str) {
				sb.append(c);
			}
			
			System.out.println(sb.reverse().toString());
		}
	}
}

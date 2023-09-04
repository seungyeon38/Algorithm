package 자료구조;

import java.util.*;
import java.io.*; 

public class boj1874_스택수열_376ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 1~100000
		Stack<Integer> stack = new Stack<>();
		// 수열을 만들 수 있는지, 어떻게 만들 수 있는지 
		
		int cur = 1;
		StringBuilder sb = new StringBuilder(); 
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine()); // 찾을 숫자 
			
			// 작으면 계속 넣어 
			while(cur <= num) {
				stack.push(cur++);
				sb.append("+\n");
			}
			
			if(stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return; 
			}
		}
		
		System.out.println(sb.toString());
	}
}

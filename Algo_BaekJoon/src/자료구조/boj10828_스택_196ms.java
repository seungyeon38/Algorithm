package 자료구조;

import java.util.*;
import java.io.*;

public class boj10828_스택_196ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~10000
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch(order) {
			case "push": // 정수 X를 스택에 넣는 연산 
				int X = Integer.parseInt(st.nextToken());
				stack.push(X);
				
				break;
			case "pop": // 스택에서 가장 위에 있는 정수 빼고, 그 수를 출력 
				if(stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				if(stack.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "top":
				if(stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.peek()).append("\n");
				}
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}

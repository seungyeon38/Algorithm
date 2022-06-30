package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 자료처리_1102_스택Stack {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		String str;
 		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			str = st.nextToken();
			if(str.equals("i")) {
				stack.add(st.nextToken());
			} else if (str.equals("o")) {
				if(stack.size() != 0) {
					sb.append(stack.pop()).append("\n");					
				} else {
					sb.append("empty").append("\n");
				}
			} else { // "c"
				sb.append(stack.size()).append("\n");
			}
		}
 		
 		System.out.println(sb.toString());
	}
}

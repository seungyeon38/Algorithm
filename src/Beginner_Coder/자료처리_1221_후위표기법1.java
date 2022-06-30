package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 자료처리_1221_후위표기법1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String str;
		int n1;
		int n2;
		for(int i=0; i<M; i++) {
			str = st.nextToken();
			if(str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")) {
				n2 = stack.pop();
				n1 = stack.pop();
				switch(str) {
				case "*":
					stack.push(n1*n2);
					break;
				case "/":
					stack.push(n1/n2);
					break;
				case "+":
					stack.push(n1+n2);
					break;
				case "-":
					stack.push(n1-n2);
					break;
				}
			} else {
				stack.push(Integer.parseInt(str));
			}
		}
		
		System.out.println(stack.pop());
	}
}

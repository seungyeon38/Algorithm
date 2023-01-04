package Algorithm;

import java.util.*;
import java.io.*;

public class q012_boj17298 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1000000
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack();
		stack.push(0);
	
		StringBuilder sb = new StringBuilder();
		
		int[] result = new int[N];
		
		for(int i=1; i<N; i++) {
//			if(stack.isEmpty() || arr[stack.peek()] >= arr[i]) {
//				stack.push(i);
//			} else {
//				while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
//					result[stack.peek()] = arr[i];
//					stack.pop();	
//				}
//				stack.push(i);
//			}
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				result[stack.peek()] = arr[i];
				stack.pop();	
			}
			stack.push(i);
		}
				
		for(int i=0; i<N; i++) {
			if(result[i] == 0) {
				sb.append("-1 ");
			} else {
				sb.append(result[i]+" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}

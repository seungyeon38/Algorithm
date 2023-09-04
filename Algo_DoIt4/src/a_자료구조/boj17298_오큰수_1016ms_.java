package a_자료구조;

import java.util.*;
import java.io.*;

public class boj17298_오큰수_1016ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 오큰수 : 오른쪽에 있으면서 큰 수 중에서 가장 왼쪽에 있는 수 
		// 없는 경우 -1 
		
		int N = Integer.parseInt(br.readLine()); // 1~1000000

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Num> stack = new Stack<>();
		int[] result = new int[N];
		for(int i=0; i<N; i++) {
			int cur = Integer.parseInt(st.nextToken()); // 1~1000000
			while(!stack.isEmpty() && stack.peek().n<cur) {
				result[stack.peek().idx] = cur;
				stack.pop();
			}
			
			stack.push(new Num(i, cur));
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop().idx] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : result) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
		
//		왜 안될까? 
//		int[] A = new int[N]; 
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) {
//			A[i] = Integer.parseInt(st.nextToken()); // 1~1000000
//		}
//			
//		// 없으면 -1 출력 후 오른쪽 스택으로 옮기기 
//		// 오른쪽 스택으로 옮길 때 자기보다 작은 애들은 pop한 후에 옮기기 
//		Stack<Integer> stack = new Stack<>();
//		Stack<Integer> result = new Stack<>();
//
//		for(int cur_idx=N-1; cur_idx>=0; cur_idx--) {
//			// 자기보다 큰 수가 나올 때까지 
//			while(!stack.isEmpty() && stack.peek()<A[cur_idx]) {
//				stack.pop();
//			}
//			
//			if(stack.isEmpty()) { // 자기보다 큰 수가 없는 경우 
//				result.add(-1);
//			} else { // 자기보다 큰 수가 있는 경우 
//				result.add(stack.peek());
//			}
//			
//			stack.add(A[cur_idx]);
//		}
//		
//		StringBuilder sb = new StringBuilder();
//
//		for(int i=result.size(); i>0; i--) {
//			sb.append(result.pop()).append(" ");
//		}
//		
//		System.out.println(sb.toString());
	}
	
	public static class Num{
		int n;
		int idx;
		
		Num(int idx, int n){
			this.n = n;
			this.idx = idx; 
		}
	}
}

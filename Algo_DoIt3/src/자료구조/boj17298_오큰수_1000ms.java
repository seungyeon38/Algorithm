package 자료구조;

import java.util.*;
import java.io.*;

public class boj17298_오큰수_1000ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1~1000000
		
		int[] A = new int[N];		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오른쪽에 있으면서 자기보다 큰 수 중에서 가장 왼쪽 
		Stack<Num> stack = new Stack<>();
		int[] result = new int[N];
		
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty() && stack.peek().n < A[i]) {
				Num n = stack.pop();
				result[n.idx] = A[i];
			}
			
			stack.push(new Num(i, A[i]));
		}
		
		while(!stack.isEmpty()) {
			Num n = stack.pop();
			result[n.idx] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Num{
		int idx;
		int n; 
		
		Num(int idx, int n){
			this.idx = idx;
			this.n = n;
		}
	}
}

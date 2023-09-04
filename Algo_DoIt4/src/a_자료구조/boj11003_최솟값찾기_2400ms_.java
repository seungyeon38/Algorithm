package a_자료구조;

import java.util.*;
import java.io.*;

public class boj11003_최솟값찾기_2400ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~5000000
		int L = Integer.parseInt(st.nextToken()); // 1~5000000
		
		Deque<Num> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		dq.add(new Num(0, n));
		sb.append(n).append(" ");
		
		for(int i=1; i<N; i++) {
			n = Integer.parseInt(st.nextToken());
			
			// 자기 자리 확인 (큰수부터) 
			while(!dq.isEmpty() && dq.peekLast().n > n) {
				dq.pollLast();
			}
			
			// 넣기 
			dq.addLast(new Num(i, n));
			
			// 앞에서부터 범위 안 넘는 작은 수 찾기
			while(dq.peekFirst().idx <= i-L) {
				dq.pollFirst();
			}
			
			sb.append(dq.peekFirst().n).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Num implements Comparable<Num>{
		int n;
		int idx;
		
		Num(int idx, int n){
			this.n = n;
			this.idx = idx;
		}
		
		@Override 
		public int compareTo(Num n) {
			return this.n-n.n;
		}
	}
}

package 자료구조;

import java.util.*;
import java.io.*;

public class boj11003_최솟값찾기_pq_시간초과 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 개수 1~5000000
		int L = Integer.parseInt(st.nextToken()); // 1~5000000
		
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Num> pq = new PriorityQueue<Num>();
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N; i++) {
			pq.add(new Num(i, Integer.parseInt(st.nextToken())));
			
			while(true) {
				Num num = pq.peek();
				if(num.idx <= i-L) {
					pq.poll();
				} else {
					sb.append(num.n).append(" ");
					break;
				}
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Num implements Comparable<Num> {
		int idx; 
		int n;
		
		Num(int idx, int n){
			this.idx = idx;
			this.n = n;
		}
		
		@Override 
		public int compareTo(Num n) {
			return this.n-n.n;
		}
	}
}

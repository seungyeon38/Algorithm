package 그리디;

import java.util.*;
import java.io.*;

public class boj1931_회의실배정_520ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 회의의 수 1~100000
		PriorityQueue<Conference> pq = new PriorityQueue<Conference>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 회의 시작 시간 
			int e = Integer.parseInt(st.nextToken()); // 회의 끝 시간 
			
			pq.add(new Conference(s, e));
		}
		
		int result = 0;
		while(!pq.isEmpty()) {
			Conference cur = pq.poll();
			result++;
			while(!pq.isEmpty() && pq.peek().st < cur.et) pq.poll();
		}
		
		System.out.println(result);
	}
	
	public static class Conference implements Comparable<Conference>{
		int st;
		int et;
		
		Conference(int st, int et){
			this.st = st;
			this.et = et; 
		}
		
		@Override
		public int compareTo(Conference c) {
			if(this.et == c.et) {
				return this.st - c.st;
			}
			
			return this.et-c.et;
		}
	}
}

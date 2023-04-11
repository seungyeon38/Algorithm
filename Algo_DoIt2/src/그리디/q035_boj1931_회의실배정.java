package 그리디;

import java.util.*;
import java.io.*;

public class q035_boj1931_회의실배정 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~100000
		Conference[] conferences = new Conference[N]; // 회의 시작, 끝나는 시간 
		StringTokenizer st; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int sp = Integer.parseInt(st.nextToken()); // 시작 시간 
			int ep = Integer.parseInt(st.nextToken()); // 끝나는 시간 
			
			conferences[i] = new Conference(sp, ep);
		}
		
		Arrays.sort(conferences);
		int cnt = 0; 
		
		for(int i=0; i<N;) {
			cnt++;
			int next = i+1; 
			while(next<N && conferences[next].s < conferences[i].e) {
				next++;
			}
			
			i = next; 
		}
		
		System.out.println(cnt);
	}
	
	public static class Conference implements Comparable<Conference>{
		int s; 
		int e; 
		
		Conference(int s, int e){
			this.s = s;
			this.e = e;
		}
		
		@Override
		public int compareTo(Conference c) {
			if(this.e != c.e) {
				return this.e - c.e;
			}
			
			return this.s - c.s;
		}
	}
}

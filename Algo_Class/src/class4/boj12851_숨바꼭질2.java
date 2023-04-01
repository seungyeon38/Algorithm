package class4;

import java.util.*;
import java.io.*;

public class boj12851_숨바꼭질2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 0~100000
		int K = Integer.parseInt(st.nextToken()); // 0~100000
		
		Queue<Loc> queue = new LinkedList<Loc>();
		
		queue.offer(new Loc(N, 0));		
		int min_time = 100001; // 최소 시간 
		int result_cnt = 0;
		
		while(!queue.isEmpty()) {
			Loc cur_l = queue.poll();
			
			if(cur_l.loc == K) {
				// 최소인지 확인 
				if(min_time > cur_l.time) {
					min_time = cur_l.time;
					result_cnt = 0;
				} else if(min_time == cur_l.time){
					result_cnt++;
				}
				
				return;
			}
			
			if(cur_l.time+1 > min_time) continue;
			
			if(cur_l.loc*2 <= 100000) queue.offer(new Loc(cur_l.loc*2, cur_l.time+1));
			else if(cur_l.loc+1 <= 100000) queue.offer(new Loc(cur_l.loc+1, cur_l.time+1));
			else if(0 <= cur_l.loc-1) queue.offer(new Loc(cur_l.loc-1, cur_l.time+1));
		}
		
		System.out.println(min_time);
		System.out.println(result_cnt);
 	}
	
	public static class Loc{
		int loc; 
		int time; 
		
		Loc(int loc, int time){
			this.loc = loc;
			this.time = time;
		}
	}
}

package class4_2;

import java.util.*;
import java.io.*; 

public class boj13549_숨바꼭질3_172ms {
	static int[] t_list; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치 0~100000
		int K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치 0~100000
		
		bfs(N, K);
		System.out.println(t_list[K]);
	}
	
	public static void bfs(int N, int K) {
		t_list = new int[100001];
		Arrays.fill(t_list, Integer.MAX_VALUE);
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(N, 0));
		t_list[N] = 0;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			if(cur.pos+1 <= 100000) {
				if(t_list[cur.pos+1] > cur.t+1) {
					t_list[cur.pos+1] = cur.t+1;
					q.add(new Pos(cur.pos+1, cur.t+1));
				}
			}
			
			if(cur.pos-1 >= 0) {
				if(t_list[cur.pos-1] > cur.t+1) {
					t_list[cur.pos-1] = cur.t+1;
					q.add(new Pos(cur.pos-1, cur.t+1));
				}
			}
			
			if(cur.pos*2 <= 100000) {
				if(t_list[cur.pos*2] > cur.t) { 
					t_list[cur.pos*2] = cur.t;
					q.add(new Pos(cur.pos*2, cur.t));
				}
			}
		}
	}
	
	public static class Pos{
		int pos; 
		int t;
		
		Pos(int p, int t){
			this.pos = p;
			this.t = t;
		}
	}
}

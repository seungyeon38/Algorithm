package 그래프;

import java.util.*;
import java.io.*; 

public class q052_boj1043_거짓말 {
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken()); // 사람의 수 1~50 
		int M = Integer.parseInt(st.nextToken()); // 파티 수 1~50 
		
		st = new StringTokenizer(br.readLine()); 
		
		int truth_cnt = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수 
		int[] truth_p = new int[truth_cnt]; // 진실을 아는 사람 
		for(int i=0; i<truth_cnt; i++) {
			truth_p[i] = Integer.parseInt(st.nextToken());
		}
		
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		int[] party_p = new int[M];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int people_cnt = Integer.parseInt(st.nextToken()); 
			int p = Integer.parseInt(st.nextToken());
			party_p[i] = p;
			for(int j=1; j<people_cnt; j++) {
				union(p, Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=0; i<truth_cnt; i++) {
			truth_p[i] = find(truth_p[i]);
		}

		int cnt = 0; 

		for(int i=0; i<M; i++) { // 파티 수 
			int i_p = find(party_p[i]); 
			for(int j=0; j<truth_cnt; j++) {
				if(i_p == truth_p[j]) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(M-cnt);
	}
	
	public static void union(int n1, int n2) {
		int n1_p = find(n1);
		int n2_p = find(n2);
		
		if(n1_p == n2_p) return;
		
		parents[n1_p] = n2_p;
	}
	
	public static int find(int n) {
		if(parents[n] == n) return n; 
		
		return parents[n] = find(parents[n]);
	}
}

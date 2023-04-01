package Algorithm;

import java.util.*;
import java.io.*;

public class q052_boj1043 {
	static int[] parent; 
	static ArrayList<Integer>[] party;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 사람 수 50
		int M = Integer.parseInt(st.nextToken()); // 파티 수 50
		
		st = new StringTokenizer(br.readLine());
		
		int true_n = Integer.parseInt(st.nextToken());
		
		int[] true_p = new int[true_n]; // 진실을 아는 사람들 
		
		for(int i=0; i<true_n; i++) {
			true_p[i] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		party = new ArrayList[M];
		
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<Integer>();
		}
		
		// 파티원들끼리 union + 파티원들 저장 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int party_n = Integer.parseInt(st.nextToken());

			for(int j=0; j<party_n; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
			
			for(int j=1; j<party_n; j++) {
				union(party[i].get(j), party[i].get(j-1));
			}
		}
		
		int result = 0;
		
		// 진실을 아는 사람들이 파티원에 속해있는지 확인 
		for(int i=0; i<M; i++) {
			boolean temp = true; 
			for(int j=0; j<true_n; j++) {
				if(find(party[i].get(0)) == find(true_p[j])) {
					temp = false;
					break;
				}
			}
			
			if(temp) result++;
		}
		
		System.out.println(result);
	}
	
	public static void union(int n1, int n2) {
		int n1_p = find(n1);
		int n2_p = find(n2);
		
		if(n1_p != n2_p) {
			parent[n1_p] = parent[n2_p];
		}
	}
	
	public static int find(int n) {
		if(parent[n] == n) return n;
		
		return parent[n] = find(parent[n]);
	}
}

package class4_2;

import java.util.*;
import java.io.*;

public class boj1043_거짓말_G4_124ms {
	static int[] parent; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수 1~50
		int M = Integer.parseInt(st.nextToken()); // 파티 수 1~50
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수 0~50
		boolean[] know_truth = new boolean[N+1]; // true면 진실을 아는 사람   
				
		for(int i=0; i<T; i++) {
			know_truth[Integer.parseInt(st.nextToken())] = true; 
		}
		
		ArrayList<Integer>[] party = new ArrayList[M];
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine()); 
			int n = Integer.parseInt(st.nextToken()); // 파티에 오는 사람 수 
			int fp = Integer.parseInt(st.nextToken());
			
			party[i].add(fp);
			for(int j=1; j<n; j++) {
				int p =Integer.parseInt(st.nextToken());
				party[i].add(p);
				if(find(fp) != find(p)) union(fp, p);
			}
		}
		
		boolean[] visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			if(know_truth[i] && !visited[i]) {
				int p = find(i);
				for(int j=1; j<=N; j++) {
					if(i == j) continue;
					if(find(j) == p) {
						visited[j] = true;
						know_truth[j] = true; 
					}
				}
			}
		}
		
		int result = 0; 
		for(int i=0; i<M; i++) {
			boolean canLie = true; 
			for(int p : party[i]) {
				if(know_truth[p]) {
					canLie = false; 
					break;
				}
			}
			if(canLie) result++; 
		}
		
		System.out.println(result);
	}
	
	public static void union(int n1, int n2) {
		int n1_p = find(n1);
		int n2_p = find(n2);
		
		if(n1_p == n2_p) return; 
		
		parent[n1_p] = n2_p;
	}
	
	public static int find(int n) {
		if(n == parent[n]) return n; 
		
		return parent[n] = find(parent[n]);
	}
}

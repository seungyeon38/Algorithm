package 유니온파인드;

import java.util.*;
import java.io.*;

public class boj1976_여행가자_188ms {
	static int[] parents; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 도시의 수 1~200
		int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수 1~1000
		
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		// 여행 경로가 가능한 것인지 
		// 같은 도시를 여러번 방문하는 것도 가능 
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<N; j++) {
				if(st.hasMoreTokens() && st.nextToken().equals("1")) {
					union(i, j);
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] travel_list = new int[M];
		for(int i=0; i<M; i++) {
			travel_list[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean result = true;
		for(int i=1; i<M; i++) {
			if(find(travel_list[i-1]) != find(travel_list[i])) {
				result = false; 
			}
		}
		
		System.out.println(result ? "YES" : "NO");
	}
	
	public static void union(int n1, int n2) {
		int n1_p = find(n1);
		int n2_p = find(n2);
		
		if(n1_p == n2_p) return;
		
		parents[n1_p] = n2_p;
	}
	
	public static int find(int n) {
		if(n == parents[n]) return n;
		
		return parents[n] = find(parents[n]);
	}
}

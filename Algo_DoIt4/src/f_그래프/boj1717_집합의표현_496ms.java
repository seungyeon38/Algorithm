package f_그래프;

import java.util.*;
import java.io.*;

public class boj1717_집합의표현_496ms {
	static int[] parents; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 1~1000000
		int m = Integer.parseInt(st.nextToken()); // 연산의 개수 1~100000
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int q = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(q == 0) { // 합집합 
				union(a, b);
			} else if(q == 1) { // 같은 집합에 포함되어 있는지 
				if(find(a) == find(b)) {
					sb.append("yes\n");
				} else {
					sb.append("no\n");
				}
			}
		}
		
		System.out.println(sb.toString());
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

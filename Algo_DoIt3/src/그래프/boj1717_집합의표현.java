package 그래프;

import java.util.*;
import java.io.*;

public class boj1717_집합의표현 {
	static int[] parents; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 1~1000000
		int m = Integer.parseInt(st.nextToken()); // 1~100000
		
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(type == 0) {
				union(a, b);
			} else if(type == 1) {
				if(find(a) == find(b)) {
					sb.append("YES\n");
				} else sb.append("NO\n");
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

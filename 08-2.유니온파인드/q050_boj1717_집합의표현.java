package Algorithm;

import java.util.*;
import java.io.*;

public class q050_boj1717 {
	static int[] arr; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 1000000
		int m = Integer.parseInt(st.nextToken()); // 100000
		
		arr = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			arr[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			if(type == 0) {
				union(n1, n2);
			} else {
				if(find(n1) == find(n2)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void union(int n1, int n2) {
		int n1_parent = find(n1);
		int n2_parent = find(n2);
		
		if(n1_parent != n2_parent) {
			arr[n2_parent] = n1_parent;
		}
	}
	
	public static int find(int n) {
		if(arr[n] == n) return n;
		
		return arr[n] = find(arr[n]);
	}
}

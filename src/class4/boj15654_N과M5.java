package class4;

import java.util.*;
import java.io.*;

public class boj15654_N과M5 {
	static int N, M;
	static int[] num; 
	static boolean[] visited;
	static int[] selected;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		visited = new boolean[N];
		selected = new int[M];
		sb = new StringBuilder();
		
		permutation(0);
		
		System.out.println(sb.toString());
	}
	
	public static void permutation(int n) {
		if(n == M) {
			for(int i=0; i<M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true; 
				selected[n] = num[i];
				permutation(n+1);
				visited[i] = false;
			}
		}
	}
}

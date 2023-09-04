package 그래프;

import java.util.*;
import java.io.*;

public class boj1707_이분그래프 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine()); // 테케 2~5
		for(int t=0; t<K; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int V = Integer.parseInt(st.nextToken()); // 정점 개수 1~20000 
			int E = Integer.parseInt(st.nextToken()); // 간선 개수 1~200000
			ArrayList<Integer>[] adj_list = new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				adj_list[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
			}
		}
	}
}

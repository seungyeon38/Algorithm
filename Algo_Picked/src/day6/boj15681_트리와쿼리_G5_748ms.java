package day6;

import java.util.*;
import java.io.*;

public class boj15681_트리와쿼리_G5_748ms {
	static ArrayList<Integer>[] adj_list, tree;
	static int[] subtreeNum;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 수 2~100000
		int R = Integer.parseInt(st.nextToken()); // 루트의 번호 1~N
		int Q = Integer.parseInt(st.nextToken()); // 쿼리의 수 1~100000
		
		adj_list = new ArrayList[N+1];
		tree = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			adj_list[U].add(V);
			adj_list[V].add(U);
		}
		
		subtreeNum = new int[N+1];
		
		makeTree(R, -1);
		getSubtreeCnt(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<Q; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(subtreeNum[q]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void makeTree(int cur, int parent) {
		for(int next : adj_list[cur]) {
			if(next == parent) continue; 
			
			tree[cur].add(next);
			makeTree(next, cur);
		}
	}
	
	public static void getSubtreeCnt(int cur) {
		subtreeNum[cur] = 1;
		for(int next : tree[cur]) {
			getSubtreeCnt(next);
			subtreeNum[cur] += subtreeNum[next];
		}
	}
}

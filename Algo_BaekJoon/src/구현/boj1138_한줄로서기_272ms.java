package 구현;

import java.util.*;
import java.io.*;

public class boj1138_한줄로서기_272ms {
	static int N; 
	static int[] taller_cnt;
	static boolean done;
	static int[] result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 사람 수 1~10
		taller_cnt = new int[N+1]; // 키가 idx인 사람보다 큰 사람이 왼쪽에 몇 명이 있는지 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			taller_cnt[i] = Integer.parseInt(st.nextToken());
		}
		
		permu(0, new int[N], new boolean[N+1]);
		
		StringBuilder sb = new StringBuilder();
		for(int i : result) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	// 1~N까지 키를 가진 사람들을 줄 세우기 
	public static void permu(int cur_idx, int[] arr, boolean[] visited) {
		if(cur_idx == N) {
			boolean temp_done = true; 
			for(int i=0; i<N; i++) {
				int cnt = 0;
				for(int j=0; j<i; j++) {
					if(arr[j] > arr[i]) cnt++;
				}
				if(cnt != taller_cnt[arr[i]]) {
					temp_done = false; 
					break;
				}
			}
			
			if(temp_done) {
				done = true; 
				result = arr;
			}
			return; 
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue; 
			
			visited[i] = true; 
			arr[cur_idx] = i;
			permu(cur_idx+1, arr, visited);
			if(done) return; 
			visited[i] = false; 
		}
	}
}

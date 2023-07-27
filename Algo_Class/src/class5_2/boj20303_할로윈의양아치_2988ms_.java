package class5_2;

import java.util.*;
import java.io.*;

public class boj20303_할로윈의양아치_2988ms_ {
	static int[] parents; 

	static ArrayList<Integer>[] adj_list;
	static boolean[] visited; 
	static int temp_child, temp_candy;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 거리에 있는 아이들 수 1~30000
		int M = Integer.parseInt(st.nextToken()); // 아이들의 친구 관계 수 1~100000
		int K = Integer.parseInt(st.nextToken()); // 울음소리가 공명하기 위한 최소 아이의 수 ~3000  
		
		// 한 아이의 사탕을 뺏으면 그 아이 친구들의 사탕도 모조리 뺏는다. 
		// K명 아래의 아이들
		st = new StringTokenizer(br.readLine());
		int[] child_candy = new int[N+1]; // 아이들이 받은 사탕의 수 (1~10000)
		for(int i=1; i<=N; i++) {
			child_candy[i] = Integer.parseInt(st.nextToken());
		}
		
		// 어른들에게 들키지 않고 아이들로부터 뺏을 수 있는 최대 사탕의 수 
		// 친구관계 그룹 
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		ArrayList<int[]> groups = new ArrayList<int[]>(); // 아이수, 사탕수 
		groups.add(new int[] {0, 0});
		int[] child_group = new int[N+1];
		for(int i=1; i<=N; i++) {
			if(child_group[i] != 0) continue;
			int temp_child_num = 1;
			int temp_candy_num = child_candy[i];
			
			for(int j=i+1; j<=N; j++) {
				if(find(i) == find(j)) {
					child_group[j] = i;
					temp_child_num++;
					temp_candy_num += child_candy[j];
				}
			}
			
			groups.add(new int[] {temp_child_num, temp_candy_num});
		}

		int[][] dp = new int[groups.size()][K]; 
		for(int i=1, size=groups.size()-1; i<=size; i++) { // 현재 그룹 인덱스 
			int[] group = groups.get(i); // 현재 그룹
			for(int j=0; j<K; j++) { // 현재 최대 아이수 
				if(group[0] > j) { // 그룹을 선택하지 못하는 경우 
					dp[i][j] = dp[i-1][j];
				} else { // 선택 가능한 경우
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-group[0]]+group[1]);
				}
			}
		}
		
		System.out.println(dp[groups.size()-1][K-1]);
	}
	
	public static boolean union(int n1, int n2) {
		int n1_p = find(n1);
		int n2_p = find(n2);
		
		if(n1_p == n2_p) return false; 
		
		parents[n1_p] = n2_p;
		
		return true; 
	}
	
	public static int find(int n) {
		if(parents[n] == n) return n; 
		
		return parents[n] = find(parents[n]);
	}
}

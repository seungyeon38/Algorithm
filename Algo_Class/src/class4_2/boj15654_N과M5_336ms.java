package class4_2;

import java.util.*;
import java.io.*;

public class boj15654_N과M5_336ms {
	static int N, M; 
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited; 
	static int[] result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~8
		M = Integer.parseInt(st.nextToken()); // 1~N
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		visited = new boolean[N];
		result = new int[M];
		
		calc(0);
		System.out.println(sb.toString());
	}
	
	public static void calc(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return; 
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue; 
			
			visited[i] = true; 
			result[cnt] = nums[i];
			calc(cnt+1);
			visited[i] = false;
		}
	}
}

package class4;

import java.util.*;
import java.io.*;

public class boj15663_N과M9 {
	static int N, M;
	static int[] nums; 
	static int[] result; 
	static boolean[] visited; 
	static Set set;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		set = new LinkedHashSet<String>();

		permu(0);
		StringBuilder sb = new StringBuilder();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			sb.append(it.next()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void permu(int idx) {
		if(idx == M) {
			StringBuilder sb = new StringBuilder(); 
			for(int i=0; i<M; i++) {
				sb.append(nums[result[i]]).append(" ");
			}
			set.add(sb.toString());
			
			return; 
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true; 
				result[idx] = i;
				permu(idx+1);
				visited[i] = false; 
			}
		}
	}
}

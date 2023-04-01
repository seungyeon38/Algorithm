package class4;

import java.util.*;
import java.io.*;

public class boj15666_N과M12 {
	static int N, M; 
	static int[] nums;
	static int[] result; 
	static Set<String> set;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		set = new LinkedHashSet<String>();
		result = new int[M];
		
		permu(0, 0);
		
		Iterator<String> it = set.iterator();
		StringBuilder sb = new StringBuilder();
		
		while(it.hasNext()) {
			sb.append(it.next()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void permu(int idx, int s) {
		if(idx == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			set.add(sb.toString());
			
			return;
		}
		
		for(int i=s; i<N; i++) {
			result[idx] = nums[i];
			permu(idx+1, i);
		}
	}
}

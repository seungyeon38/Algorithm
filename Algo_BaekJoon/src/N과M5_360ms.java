import java.util.*;
import java.io.*;

public class N과M5_360ms {
	static int N, M;
	static int[] nums;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~8
		M = Integer.parseInt(st.nextToken()); // 1~8
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		result = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		
		calc(0);
		System.out.println(sb.toString());
	}
	
	public static void calc(int idx) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(nums[result[i]]).append(" ");
			}
			sb.append("\n");
			return; 
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue; 
			
			visited[i] = true; 
			result[idx] = i;
			calc(idx+1);
			visited[i] = false; 
		}
	}
}

import java.util.*;
import java.io.*; 

public class boj10974_모든순열_264ms {
	static int N;
	static int[] result; 
	static boolean[] visited; 
	static StringBuilder sb; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result = new int[N];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		perm(0);
		System.out.println(sb.toString());
	}
	
	public static void perm(int idx) {
		if(idx == N) {
			for(int i=0; i<N; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return; 
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue; 
			
			visited[i] = true; 
			result[idx] = i;
			perm(idx+1);
			visited[i] = false;
		}
	}
}

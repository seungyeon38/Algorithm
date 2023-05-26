package class4_2;

import java.util.*; 
import java.io.*; 

public class boj15650_N과M2_124ms {
	static StringBuilder sb = new StringBuilder(); 
	static int N, M; 
	static boolean[] visited; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1~8
		M = Integer.parseInt(st.nextToken()); // 1~N
		
		visited = new boolean[N+1];
		calc(0, 1);
		
		System.out.println(sb.toString());
	}
	
	public static void calc(int cnt, int s) { 
		if(cnt == M) {
			for(int i=1; i<=N; i++) {
				if(visited[i]) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
			return; 
		}
		
		for(int i=s; i<=N; i++) {
			if(visited[i]) continue; 
			
			visited[i] = true; 
			calc(cnt+1, i+1);
			visited[i] = false; 
		}
	}
}

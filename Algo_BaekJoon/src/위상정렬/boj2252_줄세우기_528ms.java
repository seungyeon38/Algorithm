package 위상정렬;

import java.util.*;
import java.io.*;

public class boj2252_줄세우기_528ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); // 학생 수 1~32000
		int M = Integer.parseInt(st.nextToken()); // 키 비교 횟수 1~100000
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int[] cnt = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			cnt[B]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(cnt[i] == 0) queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");
			for(int next : list[cur]) {
				cnt[next]--;
				if(cnt[next] == 0) queue.add(next);
			}
		}
		
		System.out.println(sb.toString());
	}
}

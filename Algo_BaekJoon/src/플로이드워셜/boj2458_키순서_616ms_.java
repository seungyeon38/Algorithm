package 플로이드워셜;

import java.util.*;
import java.io.*;

public class boj2458_키순서_616ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수 2~500
		int M = Integer.parseInt(st.nextToken()); // 비교 횟수 0~N*(N-1)/2
		
		boolean[][] connection = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			connection[a][b] = true;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(connection[i][k] && connection[k][j]) {
						connection[i][j] = true;
					}
				}
			}
		}
		
		int[] cnt = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				if(connection[i][j] || connection[j][i]) {
					cnt[i]++;
					cnt[j]++;
				}
			}
		}
		
		int result = 0;
		for(int i=1; i<=N; i++) {
			if(cnt[i] == N-1) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}

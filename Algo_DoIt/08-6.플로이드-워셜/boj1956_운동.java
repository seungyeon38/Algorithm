package Algorithm;

import java.util.*;
import java.io.*;

public class boj1956_운동 {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 400
		int E = Integer.parseInt(st.nextToken());
		int INF = Integer.MAX_VALUE;
		
		int[][] distance = new int[V+1][V+1];
		for(int i=1; i<=V; i++) {
			Arrays.fill(distance[i], INF);
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 10000
			
			distance[a][b] = c; 
		}
		
		for(int k=1; k<=V; k++) {
			for(int s=1; s<=V; s++) {
				for(int e=1; e<=V; e++) {
					if(s == e) continue;
					
					if(distance[s][k]!=INF && distance[k][e]!=INF && distance[s][e] > distance[s][k]+distance[k][e]) {
						distance[s][e] = distance[s][k]+distance[k][e];
					}
				}
			}
		}
		
		int min = INF;
		
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(distance[i][j]!=INF && distance[j][i]!=INF) { // 사이클 존재 
					min = Math.min(min, distance[i][j]+distance[j][i]);
				}
			}
		}
		
		if(min != INF) System.out.println(min);
		else System.out.println("-1");
	}
}

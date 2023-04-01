package class5;

import java.util.*;
import java.io.*;

public class boj12852_1로만들기2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~1000000
		
		int[] pq = new int[N+1];
		int[] before = new int[N+1];
		
		pq[1] = 0;
		
		for(int n=2; n<=N; n++) {
			pq[n] = pq[n-1]+1;
			before[n] = n-1; 
			
			if(n%2==0 && pq[n]>pq[n/2]+1) {
				pq[n] = pq[n/2]+1;
				before[n] = n/2; 
			}
			
			if(n%3==0 && pq[n]>pq[n/3]+1) {
				pq[n] = pq[n/3]+1;
				before[n] = n/3;
			}
		}
				
		StringBuilder sb = new StringBuilder();
		sb.append(pq[N]).append("\n");
		
		int n = N;
		while(n != 1) {
			sb.append(n).append(" ");
			n = before[n];
		}
		
		sb.append("1");
		
		System.out.println(sb.toString());
	}
}

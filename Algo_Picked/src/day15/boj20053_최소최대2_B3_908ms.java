package day15;

import java.util.*;
import java.io.*; 

public class boj20053_최소최대2_B3_908ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 1~10 
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine()); // 1~1000000
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int min = Integer.MAX_VALUE;
			int max = -1000001;
			
			for(int i=0; i<N; i++) {
				int n = Integer.parseInt(st.nextToken());
				min = Math.min(min, n);
				max = Math.max(max, n);
			}

			sb.append(min).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

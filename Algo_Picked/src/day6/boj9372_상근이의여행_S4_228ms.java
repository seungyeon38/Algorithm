package day6;

import java.util.*;
import java.io.*;

public class boj9372_상근이의여행_S4_228ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 1~100
		StringBuilder sb = new StringBuilder(); 
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 국가의 수 2~1000
			int M = Integer.parseInt(st.nextToken()); // 비행기의 종류 1~10000
			
			for(int i=0; i<M; i++) {
				br.readLine();
			}

			sb.append(N-1).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

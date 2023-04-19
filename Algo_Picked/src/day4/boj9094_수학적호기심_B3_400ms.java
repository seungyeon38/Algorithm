package day4;

import java.util.*;
import java.io.*;

public class boj9094_수학적호기심_B3_400ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); // 1~100
			int m = Integer.parseInt(st.nextToken()); // 1~100
			
			int cnt = 0; 
			for(int i=1; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					if(isInteger(i, j, m)) cnt++; 
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean isInteger(int a, int b, int m) {
		int result = ((int)Math.pow(a, 2)+(int)Math.pow(b, 2)+m)%(a*b);
		
		return result!=0 ? false : true;
	}
}

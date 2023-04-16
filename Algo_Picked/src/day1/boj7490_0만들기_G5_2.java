package day1;

import java.util.*;
import java.io.*;

public class boj7490_0만들기_G5_2 {	
	static int N; 
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 1~10
		sb = new StringBuilder();

		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine()); // 3~9
			
			// 0이 되는 모든 수식 출력 
			// ' ', '+', '-'  
			// 3^8
			
			// ASCII 순서에 따라 
			// +, - 계산
			dfs(1, 1, 1, 0, "1");
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n, int num, int sign, int sum, String str) {
		if(n == N) {
			sum += num*sign;
			if(sum == 0) {
				sb.append(str).append("\n");
			}
			return; 
		}
		
		dfs(n+1, num*10+(n+1), sign, sum, str+" "+(n+1));
		dfs(n+1, n+1, 1, sum+(num*sign), str+"+"+(n+1));
		dfs(n+1, n+1, -1, sum+(num*sign), str+"-"+(n+1));
	}
}

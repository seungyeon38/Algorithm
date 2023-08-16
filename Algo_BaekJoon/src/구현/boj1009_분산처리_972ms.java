package 구현;

import java.util.*;
import java.io.*;

public class boj1009_분산처리_972ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 1~100
			int b = Integer.parseInt(st.nextToken()); // 1~1000000
			
			// 10으로 나눠서 
			int result = calc(a, b);
			if(result == 0) result = 10;
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int calc(int a, int b) {
		int result = 1;
		for(int i=0; i<b; i++) {
			result *= a;
			result %= 10;
		}
		
		return result; 
	}
}

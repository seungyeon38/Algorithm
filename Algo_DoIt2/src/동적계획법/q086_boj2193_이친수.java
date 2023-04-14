package 동적계획법;

import java.util.*;
import java.io.*;

public class q086_boj2193_이친수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~90
		
		long[][] result = new long[N+1][2];
		
		result[1][0] = 0;
		result[1][1] = 1; 
		
		for(int i=2; i<=N; i++) {
			result[i][0] = result[i-1][0] + result[i-1][1];
			result[i][1] = result[i-1][0];
		}
		
		System.out.println(result[N][0]+result[N][1]);
	}
}

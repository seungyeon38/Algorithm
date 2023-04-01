package class3;

import java.util.*;
import java.io.*;

public class boj1003_피보나치함수_dp {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 
		StringBuilder sb = new StringBuilder();
		
		int[][] result = new int[41][2];
		
		result[0][0] = 1; 
		result[1][1] = 1; 
		
		for(int i=2; i<41; i++) {
			result[i][0] = result[i-1][0] + result[i-2][0];
			result[i][1] = result[i-1][1] + result[i-2][1];
		}
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine()); // 40
			sb.append(result[N][0]).append(" ").append(result[N][1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

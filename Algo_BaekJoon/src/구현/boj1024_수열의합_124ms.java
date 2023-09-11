package 구현;

import java.util.*;
import java.io.*;

public class boj1024_수열의합_124ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~1000000000
		int L = Integer.parseInt(st.nextToken()); // 2~100
		
		// 길이가 L보다 같거나 큰 연속된 음이 아닌 정수 리스트 
		int result_length = 0;
		int result_s = 0;
		for(int i=L; i<=100; i++) {
			// 길이가 i 
			int num = i*(i-1)/2;
			if(N>=num && (N - num)%i == 0) {
				result_length = i;
				result_s = (N-num)/i;
				break;
			}
		}
		
		if(result_length==0) {
			System.out.println("-1");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<result_length; i++) {
			sb.append(result_s++).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}

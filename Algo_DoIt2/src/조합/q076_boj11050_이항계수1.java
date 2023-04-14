package 조합;

import java.util.*;
import java.io.*;
 
public class q076_boj11050_이항계수1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~10
		int K = Integer.parseInt(st.nextToken());
		int result = 1;
		
		// N개 중에 K개 선택 
		for(int i=K; i>0; i--) {
			result *= N--;
		}
		
		for(int i=K; i>0; i--) {
			result /= i;
		}
		
		System.out.println(result);
	}
}

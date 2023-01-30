package Algorithm;

import java.util.*;
import java.io.*;

public class q041_boj11689 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine()); // 10^12
		
		// 최대공약수가 1인 것을 구하기 -> 서로소 개수 구하기
		long result = n; // 서로소 개수  
		
		for(long i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) {
				result -= result/i;
				
				while(n%i == 0) {
					n /= i;
				}
			}
		}
		
		if(n > 1) result -= result/n;
		
		System.out.println(result);
	}
}

package 정수론;

import java.util.*;
import java.io.*;

public class q041_boj11689_GCD1_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine()); // 1~10^12
		long result = n; 
		
		for(int i=2; i<=(int)Math.sqrt(n); i++) {
			if(n%i == 0) {
				result -= result/i;
				while(n%i == 0) {
					n /= i;
				}
			}
		}
		
		if(n > 1) {
			result -= result/n;
		}
		
		System.out.println(result);
	}
}

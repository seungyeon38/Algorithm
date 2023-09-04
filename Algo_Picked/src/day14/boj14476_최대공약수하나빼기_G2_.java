package day14;

import java.util.*;
import java.io.*;

public class boj14476_최대공약수하나빼기_G2_ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 4~1000000
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); // 20억 넘지 X
		}
		
		// 하나 빼고 최대공약수 구하기 

		// 가장 큰 두 수의 최대공약수 구해서 
		// 가장 작은 수부터 해서 그 수의 약수가 되는지 확인 
		
		// 최대공약수보다 작거나, 빠진수%최대공약수 != 0 가 되는 수가 있다면 OK
		
		// 빠진수%최대공약수 != 0 인지 확인  
		// 그 최대공약수가 가장 작은 수부터 해서 그 수의 약수가 되는지 확인 
	}
	
	public static int gcd(int n1, int n2) {
		if(n1 > n2) {
			int temp = n1; 
			n1 = n2; 
			n2 = temp; 
		}
		
		// n1 < n2
		int result = 1;
		
		for(int i=2; i<n1; i++) {
			if(n1%i == 0 && n2%i == 0) {
				result = i;
			}
		}
		
		return result;
	}
}

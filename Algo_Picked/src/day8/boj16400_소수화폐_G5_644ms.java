package day8;

import java.util.*;
import java.io.*;

public class boj16400_소수화폐_G5_644ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 물건의 값 2~40000
		
		boolean[] isPrime = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			if(isPrime(i)) isPrime[i] = true; 
		}

		int[] result = new int[N+1];
		result[0] = 1;
		for(int i=0; i<=N; i++) {
			if(!isPrime[i]) continue; 
			for(int j=i; j<=N; j++) {
				result[j] += result[j-i];
				if(result[j] > 123456789) result[j] %= 123456789;
			}
		}
		
		System.out.println(result[N]);
	}
	
	public static boolean isPrime(int n) {
		if(n == 1) return false; 
		else if(n == 2) return true; 
		
		for(int i=2, size=(int)Math.sqrt(n); i<=size; i++) {
			if(n%i == 0) {
				return false; 
			}
		}
		
		return true; 
	}
}

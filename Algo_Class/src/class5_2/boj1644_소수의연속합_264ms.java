package class5_2;

import java.util.*;
import java.io.*;

public class boj1644_소수의연속합_264ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~4000000
		
		ArrayList<Integer> primes = new ArrayList<Integer>(); // 소수 

		boolean[] isNotPrime = new boolean[N+1];
		int max = (int) Math.sqrt(N);
		
		for(int i=2; i<=max; i++) {
			for(int j=i*2; j<=N; j+=i) {
				isNotPrime[j] = true; 
			}
		}
		
		for(int i=2; i<=N; i++) {
			if(!isNotPrime[i]) primes.add(i);
		}
		
//		for(int i=2; i<=N; i++) {
//			int max = (int) Math.sqrt(i);
//			boolean isPrime = false; 
//			
//			for(int j=2; j<=max; j++) {
//				if(i%j == 0) { // 나누어지면 소수 아님 
//					isPrime = true; 
//					break; 
//				}
//			}
//			
//			if(!isPrime) primes.add(i);
//		}

		int size = primes.size();
		if(size == 0) {
			System.out.println("0");
			return;
		}
		
		int sp = 0; 
		int ep = 0;
		int temp_sum = primes.get(0);
		int result = 0;
		
		while(ep < size) {
			if(temp_sum < N) {
				ep++;
				if(ep == size) break; 
				temp_sum += primes.get(ep);
			} else if(temp_sum > N) {
				temp_sum -= primes.get(sp);
				sp++;
			} else {
				result++; 
				temp_sum -= primes.get(sp);
				sp++;
				ep++;
				if(ep == size) break; 
				temp_sum += primes.get(ep);
			}
		}
		
		System.out.println(result);
	}
}

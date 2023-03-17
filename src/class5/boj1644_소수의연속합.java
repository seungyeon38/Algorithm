package class5;

import java.util.*;
import java.io.*;

public class boj1644_소수의연속합 {
	static ArrayList<Integer> prime_nums = new ArrayList<Integer>(); 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~4000000
		
		if(N == 1) {
			System.out.println("0");
			return;
		}
		
		// N까지의 소수 구하기 
		calcPrime(N);
				
		// 연속 합 구하기 
		int sp = 0; 
		int fp = 0; 
		int size = prime_nums.size();
		int temp = prime_nums.get(0);
		int cnt = 0;
		
		// 구하는 수보다 더 크면 sp+1, 더 작으면 fp+1, 같으면 sp+1, fp+1
		while(fp < size) {
			if(temp == N) {
				temp -= prime_nums.get(sp);
				cnt++;
				sp++;
				fp++;
				if(fp == size) break; 
				temp += prime_nums.get(fp);
			} else if(temp > N) {
				temp -= prime_nums.get(sp);
				sp++;
			} else {
				fp++; 
				if(fp == size) break; 
				temp += prime_nums.get(fp);
			}
		}
		
		// fp가 끝까지 갔을 때, 구하는 수보다 더 크면 sp+1, 더 작으면 끝내기 
		while(temp > N) {
			temp -= prime_nums.get(sp);
			sp++;
		}
		
		if(temp == N) cnt++;
		
		System.out.println(cnt);
	}
	
	public static void calcPrime(int n) {
		int sqrt = (int)Math.sqrt(n);
		boolean[] isPrime = new boolean[n+1];
		
		for(int i=2; i<=sqrt; i++) {
			if(!isPrime[i]) {
				for(int j=i*2; j<=n; j+=i) {
					isPrime[j] = true; 
				}
			}
		}
		
		for(int i=2; i<=n; i++) {
			if(!isPrime[i]) {
				prime_nums.add(i);
			}
		}
	}
}

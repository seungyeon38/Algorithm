package class5_2;

import java.util.*;
import java.io.*;

public class boj1644_소수의연속합_240ms {
	static ArrayList<Integer> prime; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~4000000
		prime = new ArrayList<Integer>();
		
		getPrime(N);
		
		// 소수  
		int result = 0; 
		int sp = 0; 
		int fp = 0;
		int size = prime.size();
		
		if(size == 0) {
			System.out.println(0);
			return;
		}

		int temp = prime.get(0);
		
		while(sp<size && fp<size) {
			if(temp == N) { // 수가 같으면 sp++, fp++;
				result++;
				temp -= prime.get(sp);
				sp++; fp++;
				if(fp < size) temp += prime.get(fp);
			} else if(temp < N) { // 수가 작으면 fp++;
				fp++;
				if(fp < size) temp += prime.get(fp);
			} else { // 수가 크면 sp++; 
				temp -= prime.get(sp);
				sp++;
			}
		}
		
		System.out.println(result);
	}

	public static void getPrime(int n) {
		boolean[] isNotPrime = new boolean[n+1];
		int f_num = (int)Math.sqrt(n);
		
		for(int i=2; i<=f_num; i++) {
			for(int j=i+i; j<=n; j+=i) {
				isNotPrime[j] = true; 
			}
		}
		
		for(int i=2; i<=n; i++) {
			if(!isNotPrime[i]) {
				prime.add(i);
			}
		}
	}
}

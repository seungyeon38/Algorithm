package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수학2_1740_소수 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int min = 0;
		
		for(int i=M; i<=N; i++) {
			if(isPrime(i)) {
				if(sum == 0) min = i;
				sum += i;
			}
		}
		
		if(sum == 0) {
			System.out.println("-1");
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	
	public static boolean isPrime(int n) {
		if(n < 2) {
			return false; 
		}
		
		for(int i=2, size=(int)Math.sqrt(n); i<=size; i++) {
			if(n%i == 0) {
				return false; 
			}
		}
		
		return true;
	}
}

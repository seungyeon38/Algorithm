package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수학2_1901_소수구하기 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int prime1 = 0; // 해당 수보다 작은 수 중에서 가장 큰 소수 
		int prime2 = 0; // 해당 수보다 큰 수 중에서 가장 작은 소수 
		int diff1;
		int diff2; 
		boolean prime; 
		int n;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=arr[i]; j>1; j--) {
				if(isPrime(j)) {
					prime1 = j;
					break;
				}
			}

			prime = false; 
			n = arr[i];
			while(!prime) {
				n++;
				if(isPrime(n)) {
					prime = true;
					prime2 = n;
				}
			}
			
			if(prime1 == 0) {
				sb.append(prime2).append("\n");
			} else if(prime2 == 0){
				sb.append(prime1).append("\n");
			} else {
				diff1 = arr[i]-prime1;
				diff2 = prime2-arr[i];
				if(diff1 < diff2) {
					sb.append(prime1).append("\n");
				} else if(diff1 > diff2) {
					sb.append(prime2).append("\n");
				} else {
					sb.append(prime1).append(" ").append(prime2).append("\n");
				}				
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean isPrime(int n) {
//		if(n < 2) {
//			return false; 
//		}
		
		for(int i=2, size=(int)Math.sqrt(n); i<=size; i++) {
			if(n%i == 0) {
				return false; 
			}
		}
		
		return true;
	}
}

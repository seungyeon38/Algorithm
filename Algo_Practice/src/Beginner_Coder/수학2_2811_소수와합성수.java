package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학2_2811_소수와합성수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0, size=st.countTokens(); i<size; i++) {
			n = Integer.parseInt(st.nextToken());
			
			if(n == 1) {
				sb.append("number one\n");
			} else if(isPrime(n)) {
				sb.append("prime number\n");
			} else {
				sb.append("composite number\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean isPrime(int n) {
		boolean result = true; 
		
		for(int i=2, size=(int)Math.sqrt(n); i<=size; i++) {
			if(n%i == 0) {
				result = false; 
				break;
			}
		}
		
		return result;
	}
}

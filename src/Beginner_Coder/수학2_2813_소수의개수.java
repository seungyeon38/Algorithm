package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학2_2813_소수의개수 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int result = 0;
		for(int i=M; i<=N; i++) { 
			result += isPrime(i);
		}
		
		System.out.println(result);
	}
	
	public static int isPrime(int n) {
		if(n < 2) return 0; 
		
		for(int i=2, size=(int)Math.sqrt(n); i<=size; i++) {
			if(n%i == 0) return 0;
		}
		
		return 1;
	}
}

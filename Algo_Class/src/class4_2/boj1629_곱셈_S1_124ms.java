package class4_2;

import java.util.*;
import java.io.*; 

public class boj1629_곱셈_S1_124ms {
	static int C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(calc(A, B));
	}
	
	public static long calc(int A, int B) {
		if(B == 0) return 1;
 			
		long temp = calc(A, B/2);
		long result = temp*temp%C; 
 
		if(B%2 == 1) { // 홀수 
			result *= A;
			result %= C;
		}
				
		return result;
	}
}

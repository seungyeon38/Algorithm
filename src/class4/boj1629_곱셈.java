package class4;

import java.util.*;
import java.io.*;

public class boj1629_곱셈 {
	static int C; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken()); 
		
		System.out.println(pow(A, B));
	}
	
	public static long pow(int n, int expo) {
		if(expo == 1) return n%C;
		
		long half = pow(n, expo/2);

		if(expo % 2 == 0) { // 짝수 
			return half*half%C; 
		} else { // 홀수 
			return (half*half%C)*n%C;
		}
	}
}

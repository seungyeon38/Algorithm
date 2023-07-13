package class4_2;

import java.util.*;
import java.io.*;

public class boj11444_피보나치수6_124ms_ {
	static long n; 
	static int divide = 1000000007;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Long.parseLong(br.readLine());
		long[][] result = calc(new long[][]{{1, 1}, {1, 0}}, n-1);
		
		System.out.println(result[0][0]);
	}
	
	public static long[][] calc(long[][] matrix, long exp) {
		if(exp == 0 || exp == 1) {
			return matrix; 
		}
		
		long[][] half = calc(matrix, exp/2);
		long[][] result = multiply(half, half);
		
		if(exp%2 == 1) {
			return multiply(result, matrix);
		}
		
		return result;
	}
	
	public static long[][] multiply(long[][] m1, long[][] m2){
		long[][] result = new long[2][2];
		result[0][0] = (m1[0][0]*m2[0][0]%divide + m1[0][1]*m2[1][0]%divide)%divide;
		result[0][1] = (m1[0][0]*m2[0][1]%divide + m1[0][1]*m2[1][1]%divide)%divide;
		result[1][0] = (m1[1][0]*m2[0][0]%divide + m1[1][1]*m2[1][0]%divide)%divide;
		result[1][1] = (m1[1][0]*m2[0][1]%divide + m1[1][1]*m2[1][1]%divide)%divide;
		
		return result;
	}
}

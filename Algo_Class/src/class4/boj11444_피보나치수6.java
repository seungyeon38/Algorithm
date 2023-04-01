package class4;

import java.util.*;
import java.io.*;

public class boj11444_피보나치수6 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine()); 
		
		long[][] result = recur(n-1, new long[][]{{1, 1}, {1, 0}});
				
		System.out.println(result[0][0]%1000000007);
	}
	
	public static long[][] recur(long n, long[][] m) {
		if(n==1 || n==0) return m;
		
		long[][] half = recur(n/2, m);
		long[][] result = calcMulMatrix(half, half);
		
		if(n%2 == 0) {
			return result;
		} else {
			return calcMulMatrix(result, m);
		}
	}
	
	public static long[][] calcMulMatrix(long[][] m1, long[][] m2) {
		long[][] result = new long[2][2]; 
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<2; k++) {
					result[i][j] += m1[i][k]*m2[k][j]%1000000007;
				}
			}
		}
		
		return result;
	}
}

package 자료구조;

import java.util.*;
import java.io.*;

public class boj2143_두배열의합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // -10억 ~ 10억 
		int n = Integer.parseInt(br.readLine()); // 1~1000
		
		int[] A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] B = new int[n];
		st = new StringTokenizer(br.readLine()); 
		
		for(int i=0; i<n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}

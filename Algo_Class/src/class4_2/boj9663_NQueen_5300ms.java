package class4_2;

import java.util.*;
import java.io.*;

public class boj9663_NQueen_5300ms {
	static int N; 
	static int[] arr;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 1~15
		arr = new int[N];
		
		calc(0);
		System.out.println(result);
	}
	
	public static void calc(int r_idx) {
		if(r_idx == N) {
			result++;
			return; 
		}
		
		for(int c=0; c<N; c++) {
			if(isPossible(r_idx, c)) {
				arr[r_idx] = c;
				calc(r_idx+1);
			}
		}
	}
	
	public static boolean isPossible(int r, int c) {
		boolean result = true; 
		
		for(int i=0; i<r; i++) {
			if(arr[i] == c) { // 같은 열 
				result = false; 
				break;
			} else if(Math.abs(i-r) == Math.abs(arr[i]-c)) { // 대각선 
				result = false; 
				break; 
			}
		}
		
		return result; 
	}
}

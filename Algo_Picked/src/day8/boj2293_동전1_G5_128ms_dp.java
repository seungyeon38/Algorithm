package day8;

import java.util.*;
import java.io.*;

public class boj2293_동전1_G5_128ms_dp {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 동전 종류 1~100
		int k = Integer.parseInt(st.nextToken()); // 가칭의 합 1~10000
		
		int[] value = new int[n];
		for(int i=0; i<n; i++) {
			value[i] = Integer.parseInt(br.readLine()); // 100000보다 작음 
		}
		
		int[] result = new int[k+1];
		result[0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=value[i]; j<=k; j++) {
				result[j] += result[j-value[i]];
			}
		}
		
		System.out.println(result[k]);
	}
}

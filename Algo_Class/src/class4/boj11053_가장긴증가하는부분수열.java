package class4;

import java.util.*;
import java.io.*;

public class boj11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[n];
		
		for(int i=0; i<n; i++) {
			result[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j] && result[i]<result[j]+1) {
					result[i] = result[j]+1;
				}
			}
		}
		
		int max = 0; 
		for(int i=0; i<n; i++) {
			max = Math.max(max, result[i]);
		}
		
		System.out.println(max);
	}
}

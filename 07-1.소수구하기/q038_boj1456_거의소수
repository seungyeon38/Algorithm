package Algorithm;

import java.util.*;
import java.io.*;

public class q038_boj1456 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		// 1~10000001에서 소수 구하기 
		int[] arr = new int[10000001];
		
		for(int i=2; i<=10000000; i++) {
			arr[i] = i;
		}
		
		int max = (int)Math.sqrt(10000000);
		
		for(int i=2; i<=max; i++) {
			if(arr[i] == 0) continue;
			
			for(int num=2*i; num<=10000000; num+=i) { // 배수 없애기 
				arr[num] = 0;
			}
		}
		
		long result = 0; 
		for(int i=2; i<=10000000; i++) {
			if(arr[i] != 0) { // 소수에 대해
				long n = arr[i];

				while((double)arr[i] <= (double)B/n) {
					if((double)arr[i] >= (double)A/n) {
						result++; 
					}
					
					n *= arr[i];
				}
			}
		}
		
		System.out.println(result);
	}
}

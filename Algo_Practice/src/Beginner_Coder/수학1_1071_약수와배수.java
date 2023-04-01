package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학1_1071_약수와배수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		
		int sum_bae = 0;
		int sum_yak = 0;
		
		for(int i=0; i<n; i++) {
			if(arr[i]%m == 0) { // 배수 
				sum_bae += arr[i];
			} 
			if(m%arr[i] == 0){ // 약수 
				sum_yak += arr[i];
			}
		}
		
		System.out.println(sum_yak);
		System.out.println(sum_bae);
	}
}

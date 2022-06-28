package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여러가지_1836_연속부분합찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr[0] = Integer.parseInt(st.nextToken());
		int n;
		
		for(int i=1; i<N; i++) {
			n = Integer.parseInt(st.nextToken());
			if(arr[i-1]>0) arr[i] = arr[i-1]+n;
			else arr[i] = n;
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			if(max<arr[i]) max = arr[i];
		}
		
		System.out.println(max);
	}
}

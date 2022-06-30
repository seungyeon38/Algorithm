package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 자료처리_1146_선택정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		int min_idx;
		int temp; 
		
		for(int i=0, size=N-1; i<size; i++) {
			min_idx = i;
			// 최솟값 찾기 
			for(int j=i; j<N; j++) {
				if(arr[min_idx]>arr[j]) {
					min_idx = j;
				}
			}
			// 맨 앞 자리랑 바꾸기 
			temp = arr[i];
			arr[i] = arr[min_idx]; 
			arr[min_idx] = temp;
			
			for(int idx=0; idx<N; idx++) {
				sb.append(arr[idx]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

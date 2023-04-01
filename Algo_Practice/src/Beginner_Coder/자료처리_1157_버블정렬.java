package Beginner_Coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 자료처리_1157_버블정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int n;
		int temp;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N; i++) {
			for(int j=1, size=N-i; j<=size; j++) {
				n = j-1; 
				if(arr[j] < arr[n]) {
					temp = arr[j];
					arr[j] = arr[n];
					arr[n] = temp;
				}
			}
			// 프린트
			for(int idx=0; idx<N; idx++) {
				sb.append(arr[idx]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

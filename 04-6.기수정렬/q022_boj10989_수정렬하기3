package Algorithm;

import java.util.*;
import java.io.*;

public class q022_boj10989 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 10000000
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
//		Arrays.sort(arr);
		
		int cnt = 1; 
		int digit = 1;
		
		while(cnt <= 5) {
			int[] bucket = new int[10];
			
			// 개수 세기 
			for(int i=0; i<N; i++) {
				bucket[arr[i]/digit%10]++;
			}
			
			// 인덱스 
			for(int i=1; i<10; i++) {
				bucket[i] += bucket[i-1];
			}
			
			int[] temp = new int[N];
			
			for(int i=N-1; i>=0; i--) {
				temp[bucket[arr[i]/digit%10]-1] = arr[i];
				bucket[arr[i]/digit%10]--;
			}
			
			for(int i=0; i<N; i++) {
				arr[i] = temp[i];
			}
			
			digit *= 10;
			cnt++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

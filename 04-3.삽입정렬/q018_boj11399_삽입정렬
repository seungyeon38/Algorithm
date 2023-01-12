package Algorithm;

import java.util.*;
import java.io.*;

public class q018_boj11399_삽입정렬 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 1000
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int insert_point = -1;
		
		for(int i=1; i<N; i++) {
			insert_point = -1;
			for(int j=0; j<i; j++) {
				if(arr[i]<arr[j]) {
					insert_point = j;
					break;
				} 
			}
			
			if(insert_point == -1) insert_point = i;
				
			int num = arr[i];
			for(int j=i-1; j>=insert_point; j--) {
				arr[j+1] = arr[j];
			}
			
			arr[insert_point] = num;
		}
		
		int[] sum = new int[N];
		
		sum[0] = arr[0];
		
		for(int i=1; i<N; i++) {
			sum[i] = arr[i] + sum[i-1];
		}
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			result += sum[i];
		}
		
		System.out.println(result);
	}
}

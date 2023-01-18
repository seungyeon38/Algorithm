package Algorithm;

import java.util.*;
import java.io.*;

public class q034_boj1744 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 50
		
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		
		int nega_num = 0; // 음수 개수 
		int posi_num = 0; // 양수 개수 
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] <= 0) nega_num++;
			else if(arr[i] > 0) posi_num++;
		}
		
		Arrays.sort(arr);
				
		int idx = 0;
		int result = 0;
		
		while(nega_num > 1) { // 2개 이상이면 곱하기
			int idx1 = idx++; 
			int idx2 = idx++; 
			
			if(idx2 >= N) break; 
			
			result += arr[idx1] * arr[idx2];
			visited[idx1] = true; 
			visited[idx2] = true; 
			
			nega_num -= 2; 
		}
		
		idx = N-1; 
		
		while(posi_num > 1) { // 2개 이상이면 곱하기 
			int idx1 = idx--; 
			int idx2 = idx--; 
			
			if(idx2 < 0) break; 
			if(arr[idx1] == 1 || arr[idx2] == 1) break; 
			
			result += arr[idx1] * arr[idx2];
			visited[idx1] = true; 
			visited[idx2] = true; 
			
			posi_num -= 2; 
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) result += arr[i];
		}
		
		System.out.println(result);
	}
}

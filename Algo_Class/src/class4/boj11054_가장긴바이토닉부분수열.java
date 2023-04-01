package class4;

import java.util.*;
import java.io.*;

public class boj11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] result = new int[N][2];
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i] && result[j][0]+1>result[i][0]) {
					result[i][0] = result[j][0]+1;
				}
			}
		}
		
		for(int i=N-1; i>=0; i--) {
			for(int j=i; j<N; j++) {
				if(arr[j]<arr[i] && result[j][1]+1>result[i][1]) {
					result[i][1] = result[j][1]+1;
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			max = Math.max(max, result[i][0]+result[i][1]);
		}
		
		System.out.println(max+1);
	}
}

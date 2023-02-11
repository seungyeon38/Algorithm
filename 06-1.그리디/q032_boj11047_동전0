package Algorithm;

import java.util.*;
import java.io.*;

public class q032_boj11047 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 10
		int K = Integer.parseInt(st.nextToken()); // 100000000
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = -1; 
		for(int i=N-1; i>=0; i--) {
			if(K >= arr[i]) {
				idx = i;
				break;
			}
		}
		
		int result = 0;
		while(K > 0) {
			int n = K/arr[idx];
			result += n;
			K -= n*arr[idx];
			idx--;
		}
		
		System.out.println(result);
	}
}
